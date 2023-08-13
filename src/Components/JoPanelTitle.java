package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;

public class JoPanelTitle extends JPanel {

    private String JoTitle = "Title";
    private Font JoTitleFont = new java.awt.Font("Phetsarath OT", 0, 18);
    private JoTitlePosition joTitlePosition = JoTitlePosition.Left;
    private Color joTitleColor = Color.BLACK;
    private int joTitleBorderSize = 0;

    public JoPanelTitle() {
        CreateTitle(JoTitle);
    }

    private void CreateTitle(String title) {
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(joTitleColor, joTitleBorderSize), title, getPosition(), javax.swing.border.TitledBorder.TOP, JoTitleFont, joTitleColor));
        setPreferredSize(new Dimension(150, 100));
    }

    public enum JoTitlePosition {
        Left,
        Center,
        Right
    }

    //============== Getter ===============
    public String getJoTitle() {
        return JoTitle;
    }

    public void setJoTitle(String JoTitle) {
        this.JoTitle = JoTitle;
        CreateTitle(JoTitle);
    }

    public Font getJoTitleFont() {
        return JoTitleFont;
    }

    public void setJoTitleFont(Font JoTitleFont) {
        this.JoTitleFont = JoTitleFont;
        CreateTitle(JoTitle);
    }

    public Color getJoTitleColor() {
        return joTitleColor;
    }

    public void setJoTitleColor(Color joTitleColor) {
        this.joTitleColor = joTitleColor;
        CreateTitle(JoTitle);
    }

    public JoTitlePosition getJoTitlePosition() {
        return joTitlePosition;
    }

    public void setJoTitlePosition(JoTitlePosition joTitlePosition) {
        this.joTitlePosition = joTitlePosition;
        switch (joTitlePosition) {
            case Left:
                CreateTitle(getJoTitle());
                break;
            case Center:
                CreateTitle(getJoTitle());
                break;
            case Right:
                CreateTitle(getJoTitle());
                break;
            default:
                CreateTitle(getJoTitle());
                break;
        }
    }

    private int getPosition() {
        switch (getJoTitlePosition()) {
            case Left:
                return 1;
            case Center:
                return 2;
            case Right:
                return 3;
            default:
                return 1;
        }
    }

    public int getJoTitleBorderSize() {
        return joTitleBorderSize;
    }

    public void setJoTitleBorderSize(int joTitleBorderSize) {
        this.joTitleBorderSize = joTitleBorderSize;
        CreateTitle(JoTitle);
    }

}
