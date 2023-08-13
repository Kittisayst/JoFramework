package Tools;

import Database.JoProperties;
import java.awt.AlphaComposite;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JoFileSystem {

    private int IMG_WIDTH = 512;
    private int IMG_HEIGHT = 512;
    private ImageIcon imageIcon;
    JoProperties properties = new JoProperties("JoConfig/config.properties");
    private String fileName;

    public JoFileSystem() {

    }

    public String getOSName() {
        return System.getProperty("os.name");
    }

    public String getUserPath() {
        return System.getProperty("user.home");
    }

    public String getCurrentPath() {
        return System.getProperty("user.dir").replace("\\", "/");
    }

    public String getOperatingName() {
        return System.getProperty("os.name");
    }

    public String getUserName() {
        return System.getProperty("user.name");
    }

    public String getComputerName() {
        try {
            String computerName;
            computerName = InetAddress.getLocalHost().getHostName();
            return computerName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getIPAddress() {
        try {
            String computerName;
            computerName = InetAddress.getLocalHost().getHostAddress();
            return computerName;
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void OpenFile(String Location) {
        try {
            File file = new File(Location);
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                new JoAlert().messages("ຂໍ້ຜິດພາດ", "Can't find: " + file.getName(), "warning");
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public void OpenFile(File file) {
        try {
            if (file.exists()) {
                Desktop.getDesktop().open(file);
            } else {
                new JoAlert().messages("ຂໍ້ຜິດພາດ", "Can't find: " + file.getName(), "warning");
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public boolean isEmptyFile(String path) {
        File file = new File(path);
        return file.exists();
    }

    public void CreateFolder(String Location, String FolderName) {
        try {
            File file = new File(Location + "/" + FolderName);
            if (!file.exists()) {
                file.mkdirs();
                System.out.println("Create Folder Success");
            } else {
                System.out.println("Create Error");
            }
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public int CreateFile(String File) {
        try {
            File newFile = new File(File);
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return 0;
        }
    }

    public boolean isFile(String FileNameORFolder) {
        try {
            File file = new File(getCurrentPath() + "/" + FileNameORFolder);
            return !file.exists();
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return false;
        }
    }

    public void RenameFolder(String OldFile, String NewFile) {
        try {
            File name = new File(OldFile);
            File rename = new File(NewFile);
            if (name.exists()) {
                name.renameTo(rename);
            }
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }

    }

    public void DeleteFolder(String FolderLocation) {
        try {
            File file = new File(FolderLocation);
            if (file.exists()) {
                ClearFileInDirectory(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }

    }

    private void ClearFileInDirectory(File file) throws IOException {
        try {
            if (file.isDirectory()) {
                if (file.list().length == 0) {
                    file.delete();
                } else {
                    File files[] = file.listFiles();
                    for (File fileDelete : files) {
                        ClearFileInDirectory(fileDelete);
                    }
                    if (file.list().length == 0) {
                        file.delete();
                    }
                }
            } else {
                file.delete();
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    //==============================================Image File ====================================
    public void Resize(String locationFile, int Width, int Height) throws Exception {
        IMG_WIDTH = Width;
        IMG_HEIGHT = Height;
        File file = new File(locationFile);
        BufferedImage originalImage = ImageIO.read(file);
        int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

        BufferedImage resizeImageBmp = resizeImage(originalImage, type);
        ImageIO.write(resizeImageBmp, "png", new File(properties.getValueAt("ImageResizeLocation")));
        resizeImageBmp = resizeImageWithHint(originalImage, type);
        ImageIO.write(resizeImageBmp, "png", new File(properties.getValueAt("ImageResizeLocation")));
    }

    private BufferedImage resizeImage(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        return resizedImage;
    }

    private BufferedImage resizeImageWithHint(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();
        g.setComposite(AlphaComposite.Src);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        return resizedImage;
    }

    //============================== Chooser File ==========================================
    public String chooserFilePath() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG & PNG Images", "jpg", "png");
        chooser.setCurrentDirectory(new java.io.File(properties.getValueAt("chooserLocation")));
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            properties.addValue("chooserLocation", chooser.getSelectedFile().getParent());
            fileName = chooser.getSelectedFile().getName();
            return chooser.getSelectedFile().getAbsolutePath();
        } else {
            return "";
        }
    }

    public InputStream convertFileBlob(String path) {
        try {
            if (isEmptyFile(path)) {
                File file = new File(path);
                InputStream inputStream = new FileInputStream(file);
                return inputStream;
            } else {
                return null;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    private Image fitimage(Image img, int w, int h) {
        BufferedImage resizedimage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = resizedimage.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(img, 0, 0, w, h, null);
        g2.dispose();
        return resizedimage;
    }

    //============================Getter & Setter ============================================
    public String getFileName() {
        return fileName;
    }

}
