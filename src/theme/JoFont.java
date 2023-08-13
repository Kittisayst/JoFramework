package theme;

import Tools.JoAlert;
import java.awt.Font;
import java.io.InputStream;

public class JoFont {

    public static int fs_6 = 40;
    public static int fs_5 = 32;
    public static int fs_4 = 28;
    public static int fs_3 = 24;
    public static int fs_2 = 20;
    public static int fs_1 = 16;
    public static int fs_default = 12;
    public static int fs_plain = Font.PLAIN;
    public static int fs_italic = Font.ITALIC;
    public static int fs_bold = Font.BOLD;
    public static Font font = new Font("Phetsarath OT", Font.PLAIN, 12);

    public Font loadJoFont(int fontStyle, int fontSize) {
        try {
            String fontLocal = "/Font/Boonhome.otf";
            InputStream is = JoFont.class.getResourceAsStream(fontLocal);
            Font localfont = Font.createFont(Font.TRUETYPE_FONT, is);
            return localfont.deriveFont(fontStyle, fontSize);
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

}
