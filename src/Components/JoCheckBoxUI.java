package Components;



import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.UIManager;
import theme.MyColor;

public class JoCheckBoxUI extends JCheckBox {

    private Icon uncheckedIcon;
    private Icon checkedIcon;
    private Color joCheckboxBackground = MyColor.Primary;
    private RoundedCheckIcon roundedCheckIcon = new RoundedCheckIcon(joCheckboxBackground, Color.WHITE, 5);

    public JoCheckBoxUI() {
        setOpaque(false);
        setFont(new Font("Phetsarath OT", 0, 12));
        setForeground(UIManager.getColor("CheckBox.foreground"));
        setBackground(UIManager.getColor("CheckBox.background"));
        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        uncheckedIcon = new RoundedCheckIcon(Color.WHITE, Color.LIGHT_GRAY, 5);;
        checkedIcon = roundedCheckIcon;
        setIcon(uncheckedIcon);
        setPressedIcon(uncheckedIcon);
        setSelectedIcon(checkedIcon);
        setRolloverIcon(uncheckedIcon);
        setDisabledIcon(uncheckedIcon);
    }

    public Color getJoCheckboxBackground() {
        return joCheckboxBackground;
    }

    public void setJoCheckboxBackground(Color joCheckboxBackground) {
        this.joCheckboxBackground = joCheckboxBackground;
        roundedCheckIcon.setFillColor(joCheckboxBackground);
    }

    private class RoundedCheckIcon implements Icon {

        private Color fillColor;
        private Color checkColor;
        private int radius;

        public RoundedCheckIcon(Color fillColor, Color checkColor, int radius) {
            this.fillColor = fillColor;
            this.checkColor = checkColor;
            this.radius = radius;
        }

        @Override
        public void paintIcon(Component c, Graphics g, int x, int y) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setColor(fillColor);
            g2d.fillRoundRect(x, y, getIconWidth(), getIconHeight(), radius, radius);

            if (isSelected()) {
                g2d.setColor(checkColor);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(x + 3, y + 7, x + 6, y + 12);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(x + 6, y + 12, x + 12, y + 4);
            } else {
                g2d.setColor(MyColor.Primary);
                g2d.setStroke(new BasicStroke(1)); // set the stroke to draw the border
                g2d.drawRoundRect(x, y, getIconWidth(), getIconHeight(), radius, radius);
            }
        }

        @Override
        public int getIconWidth() {
            return 16;
        }

        @Override
        public int getIconHeight() {
            return 16;
        }

        public Color getFillColor() {
            return fillColor;
        }

        public void setFillColor(Color fillColor) {
            this.fillColor = fillColor;
        }

        public Color getCheckColor() {
            return checkColor;
        }

        public void setCheckColor(Color checkColor) {
            this.checkColor = checkColor;
        }

        public int getRadius() {
            return radius;
        }

        public void setRadius(int radius) {
            this.radius = radius;
        }

    }
}
