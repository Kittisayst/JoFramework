package theme;

import Test.index;
import Tools.JoAlert;
import java.awt.Color;
import javax.swing.UIManager;

public class JoTheme {

    public static Color Primary = new Color(25, 118, 210);

    public static Color Secondary = new Color(25, 118, 210);

    public static Color Warning = MyColor.yellow;

    public static Color Danger = MyColor.red600;

    public static Color HoverColor = new Color(0, 75, 160);

    public static Color colorLine = new Color(102, 102, 102);

    public static Color colorclose = new Color(255, 94, 94);

    public static int grosorLine = 4;

    public static Color colorTitle = new Color(16, 16, 58);

    public void setLookUI() {
        try {
            // Set System L&F
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    private void Nimbus() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
