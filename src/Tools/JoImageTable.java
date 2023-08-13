package Tools;

import Components.JoLabelImage;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class JoImageTable extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            JoLabelImage lbl = new JoLabelImage();
            lbl.setIcon((Icon) value);
            return lbl;
        }
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }

    public void setImageTable(JTable table) {
        try {
            table.setDefaultRenderer(Object.class, new JoImageTable());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
