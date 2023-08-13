package ClassUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import theme.JoTheme;

public class EstiloTablaHeader implements TableCellRenderer {

    private Color colorBackgound = JoTheme.Primary;

    private Color colorForeground = new Color(255, 255, 255);

    private int altoHead = 50;

    private int grosorBorde = 1;

    private Color colorBorde = new Color(0, 0, 0);

    private Font fuenteHead = new Font("Phetsarath OT", 1, 15);

    @Override
    public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
        JComponent jcomponent = null;
        if (value instanceof String) {
            jcomponent = new JLabel("" + value);
            ((JLabel) jcomponent).setHorizontalAlignment(0);
            ((JLabel) jcomponent).setSize(this.altoHead, jcomponent.getWidth());
            ((JLabel) jcomponent).setPreferredSize(new Dimension(3, jcomponent.getWidth()));
        }
        jcomponent.setEnabled(true);
        jcomponent.setBorder(BorderFactory.createMatteBorder(this.grosorBorde, this.grosorBorde, this.grosorBorde, this.grosorBorde, this.colorBorde));
        jcomponent.setOpaque(true);
        jcomponent.setBackground(this.colorBackgound);
        jcomponent.setForeground(this.colorForeground);
        jcomponent.setFont(this.fuenteHead);
        return jcomponent;
    }

    public Color getColorBackgound() {
        return this.colorBackgound;
    }

    public void setColorBackgound(Color colorBackgound) {
        this.colorBackgound = colorBackgound;
    }

    public Color getColorForeground() {
        return this.colorForeground;
    }

    public void setColorForeground(Color colorForeground) {
        this.colorForeground = colorForeground;
    }

    public int getGrosorBorde() {
        return this.grosorBorde;
    }

    public void setGrosorBorde(int grosorBorde) {
        this.grosorBorde = grosorBorde;
    }

    public Color getColorBorde() {
        return this.colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
    }

    public Font getFuenteHead() {
        return this.fuenteHead;
    }

    public void setFuenteHead(Font fuenteHead) {
        this.fuenteHead = fuenteHead;
    }

    public int getAltoHead() {
        return this.altoHead;
    }

    public void setAltoHead(int altoHead) {
        this.altoHead = altoHead;
    }
}
