package Tools;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class JoFrameDesign {

    private final JFrame frame;

    public JoFrameDesign(JFrame frame) {
        this.frame = frame;
    }

    public void removeBackground() {
        frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    }

    public void setMoving(JPanel panel) {
        new JoMoveFrame().Move(frame, panel);
    }

    public void setJoUI() {
        setIconUI(new ImageIcon(getClass().getResource("/Resource/Icon-Logo.png")));     
    }

    public void setIconUI(ImageIcon Icon) {
        frame.setIconImage(Icon.getImage());
    }

}
