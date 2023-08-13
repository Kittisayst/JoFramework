package Tools;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class JoCreateImage {

    public ImageIcon JoCreateImage(Blob blob) throws Exception {
        if (blob != null) {
            int blobsize = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobsize);
            final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
            return new ImageIcon(bufferedImage);
        } else {
            Image img = new ImageIcon(getClass().getResource("/Resource/Default_Image.png")).getImage();
            return new ImageIcon(ImageToBufferedImage(img));
        }
    }

    private BufferedImage ImageToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }
}
