package Components;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Kittisay
 */
public final class JoLabelImage extends JLabel {

    private int iconGrap = 5;

    private Icon icono = new ImageIcon(getClass().getResource("/Resource/Default_Image.png"));

    ImageIcon imagenIcon = (ImageIcon) this.icono;

    private Image image = this.imagenIcon.getImage();

    private final Image image_default = this.image;

    public JoLabelImage() {

    }

    @Override
    public void updateUI() {
        setPreferredSize(new Dimension(100, 100));
        super.updateUI(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIconGrap() {
        return iconGrap;
    }

    public void setIconGrap(int iconGrap) {
        this.iconGrap = iconGrap;
    }

    @Override
    protected void paintComponent(Graphics g) {
        setText("");
        Dimension height = getSize();
        g.drawImage(this.image, getIconGrap(), getIconGrap(), height.width - getIconGrap() - getIconGrap(), height.height - getIconGrap() - getIconGrap(), this);
        setOpaque(false);
        super.paintComponent(g);
    }

    @Override
    public void setIcon(Icon icon) {
        if (icon != null) {
            this.icono = icon;
            this.imagenIcon = (ImageIcon) this.icono;
            this.image = this.imagenIcon.getImage();
        } else {
            this.image = this.image_default;
        }
        repaint();
    }

}
