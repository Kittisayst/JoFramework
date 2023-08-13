package Database;

import Tools.JoFileSystem;
import Tools.JoAlert;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JoProperties {

    private final String PropertiesFile;
    private final Properties properties = new Properties();

    public JoProperties(String PropertiesFile) {
        this.PropertiesFile = PropertiesFile;
    }

    private void LoadProperties() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String file = fileSystem.getCurrentPath() + "/" + PropertiesFile;
            if (fileSystem.isEmptyFile(file)) {
                properties.load(LocalFile());
            } else {
                CreateDefaultProperties();
            }
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public String getValueAt(String propertiesKey) {
        LoadProperties();
        return properties.getProperty(propertiesKey);
    }

    public int addValue(String key, String value) {
        try {
            LoadProperties();
            properties.put(key, value);
            properties.store(SaveLocalFIle(), "Kittsay");
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return 0;
        }
    }

    private InputStream LocalFile() {
        try {
            FileInputStream inputStream;
            inputStream = new FileInputStream(System.getProperty("user.dir").replace("\\", "/") + "/" + PropertiesFile);
            return inputStream;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    private OutputStream SaveLocalFIle() {
        try {
            File file = new File(System.getProperty("user.dir").replace("\\", "/") + "/" + PropertiesFile);
            OutputStream output = new FileOutputStream(file);
            return output;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    public Properties get() {
        LoadProperties();
        return properties;
    }

    private void CreateDefaultProperties() {
        try {
            JoFileSystem fileSystem = new JoFileSystem();
            String propertiesName = "config.properties";
            String DefaultFolder = "JoConfig";
            String AboutFloder = "Info";
            String About = "About.properties";
            String ResizeImageFolder = "ResizeImage";
            fileSystem.CreateFolder(fileSystem.getCurrentPath(), DefaultFolder);
            fileSystem.CreateFolder(fileSystem.getCurrentPath(), AboutFloder);
            fileSystem.CreateFolder(fileSystem.getCurrentPath(), ResizeImageFolder);
            String createpath = fileSystem.getCurrentPath() + "/" + DefaultFolder + "/" + propertiesName;
            String createAbout = fileSystem.getCurrentPath() + "/" + AboutFloder + "/" + About;
            fileSystem.CreateFile(createAbout);
            fileSystem.CreateFile(createpath);
            FileInputStream inputStream;
            inputStream = new FileInputStream(createpath);
            properties.load(inputStream);
            //=================Add==========================
            addValue("db.Server", "localhost");
            addValue("db.UTF8", "?useUnicode=yes&characterEncoding=UTF-8");
            addValue("db.user", "root");
            addValue("db.JDBCHTTP", "jdbc:mysql://");
            addValue("db.Driver", "com.mysql.jdbc.Driver");
            addValue("db.password", "@min2020");
            addValue("db.database", "test");
            addValue("chooserLocation", fileSystem.getCurrentPath());
            addValue("ImageResizeLocation", fileSystem.getCurrentPath() + "/" + ResizeImageFolder);
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public void CreatePropertyFile(String fileName) {
        JoFileSystem fileSystem = new JoFileSystem();
        String createpath = fileSystem.getCurrentPath() + "/" + fileName + ".properties";
        fileSystem.CreateFile(createpath);
        try {
            FileInputStream inputStream;
            inputStream = new FileInputStream(createpath);
            properties.load(inputStream);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JoProperties.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JoProperties.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
