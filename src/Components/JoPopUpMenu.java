package Components;

import Tools.JoAlert;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

/**
 *
 * @author Kittisay
 */
public class JoPopUpMenu extends JPopupMenu {

    private Color colorBackgroud = new Color(255, 255, 255);

    private Color borderColor = new Color(153, 153, 153);

    private int borderSize = 2;

    private final Border border = BorderFactory.createLineBorder(this.borderColor, this.borderSize);

    private boolean mostrarBorde = true;

    private int ItemHight = 30;
    private Font fontMenuItem = new Font("Phetsarath OT", 0, 12);

    public JoPopUpMenu() throws UnsupportedLookAndFeelException, InstantiationException, ClassNotFoundException, IllegalAccessException {
        setBorder(this.border);
    }

    public void showPopupMenu(MouseEvent evt) {
        if (evt.isPopupTrigger()) {
            setCursor(new Cursor(Cursor.HAND_CURSOR));
            int H = ItemHight * getComponentCount();
            setPopupSize(150, H);
            setPropertiesItemMenu();
            this.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void setPropertiesItemMenu() {
        for (int i = 0; i < getComponentCount(); i++) {
            getComponent(i).setFont(fontMenuItem);
        }
    }

    public JMenuItem getMenuItem(int index) {
        if (getComponentCount() > 0) {
            return (JMenuItem) getComponent(index);
        } else {
            new JoAlert().messages("ຂໍ້ຜິດພາດ", "ບໍ່ພົບຂໍ້ມູນ JMenuItem " + getClass().getName(), "error");
            return null;
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        g.setColor(this.colorBackgroud);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public Color getColorBackgroud() {
        return this.colorBackgroud;
    }

    public void setColorBackgroud(Color colorBackgroud) {
        this.colorBackgroud = colorBackgroud;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
        setBorder(BorderFactory.createLineBorder(borderColor, this.borderSize));
    }

    public int getBorderSize() {
        return borderSize;
    }

    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
        setBorder(BorderFactory.createLineBorder(this.borderColor, borderSize));
    }

    public boolean isMostrarBorde() {
        return this.mostrarBorde;
    }

    public void setMostrarBorde(boolean mostrarBorde) {
        this.mostrarBorde = mostrarBorde;
        if (this.mostrarBorde) {
            setBorder(BorderFactory.createLineBorder(this.borderColor, this.borderSize));
        } else {
            setBorder(null);
        }
    }

    public Font getFontMenuItem() {
        return fontMenuItem;
    }

    public void setFontMenuItem(Font fontMenuItem) {
        this.fontMenuItem = fontMenuItem;
    }

    public int getItemHight() {
        return ItemHight;
    }

    public void setItemHight(int ItemHight) {
        this.ItemHight = ItemHight;
    }

}
