package Components;

import Tools.JoAlert;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

import javax.swing.table.DefaultTableModel;
import theme.JoFont;
import theme.JoTheme;

public class JoTable extends JTable {

    private POSITION_TEXT JopositionText = POSITION_TEXT.CENTER;

    private Color JoBackgoundHead = JoTheme.Primary;

    private Color JoForegroundHead = new Color(255, 255, 255);

    private Border BorderHead = null;

    private int JohighHead = 35;

    private int JowidthBorderHead = 2;

    private Color JocolorBorderHead = new Color(0, 0, 0);

    private Font JofontHead = new Font(JoFont.font.getFamily(), 1, JoFont.fs_default);

    private final EstiloTablaHeader JoestiloHead = new EstiloTablaHeader();

    private Color JocolorPrimary = new Color(255, 255, 255);

    private Color JocolorSecondary = new Color(204, 204, 204);

    private Color JocolorPrimaryText = JoTheme.Primary;

    private Color JocolorSecundaryText = JoTheme.Primary;

    private Border BorderRows = null;

    private int JowidthBorderRows = 1;

    private Color JocolorBorderRows = new Color(0, 0, 0);

    private Font JofontRowSelect = new Font(JoFont.font.getFamily(), 1, JoFont.fs_default);

    EstiloTablaRenderer Joestilorow = new EstiloTablaRenderer();

    private Color JoBackgoundHover = JoTheme.Primary;

    private Color JoForegroundHover = new Color(255, 255, 255);

    private boolean JoeffectHover = false;

    private int rollOverRow = -1;

    private Font JofontRowHover = new Font(JoFont.font.getFamily(), 1, JoFont.fs_default);

    private SELECTION_ROWS modelSelection = SELECTION_ROWS.SINGLE_SELECTION;

    private DefaultTableModel JoModel = new DefaultTableModel();

    public JoTable() {
        getTableHeader().setDefaultRenderer(this.JoestiloHead);
        setDefaultRenderer(Object.class, this.Joestilorow);
        setSelectionMode(0);
        getTableHeader().setReorderingAllowed(false);
        setSelectionBackground(JoTheme.Primary);
        setSelectionForeground(Color.WHITE);
        setFont(this.JofontRowSelect);
        setRowHeight(25);
        setCursor(new Cursor(12));
        setBorderHead(BorderFactory.createMatteBorder(0, 0, getJowidthBorderHead(), 0, getJocolorBorderHead()));
        setBorderRows(BorderFactory.createMatteBorder(0, 0, getJowidthBorderRows(), 0, getJocolorBorderRows()));
        setBorder((Border) null);
        RollOverListener lst = new RollOverListener();
        addMouseMotionListener(lst);
        addMouseListener(lst);
    }

    @Override
    public void updateUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        super.updateUI();
        if (old != null) {
            try {
                UIManager.setLookAndFeel(old);
            } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            }
        }
    }

    class EstiloTablaHeader implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object value, boolean bln, boolean bln1, int row, int column) {
            JComponent jcomponent = null;
            if (value instanceof String) {
                if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.CENTER) {
                    jcomponent = new JLabel((String) value);
                    ((JLabel) jcomponent).setHorizontalAlignment(0);
                }
                if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.LEFT) {
                    jcomponent = new JLabel(" " + value);
                    ((JLabel) jcomponent).setHorizontalAlignment(2);
                }
                if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.RIGHT) {
                    jcomponent = new JLabel((String) value + " ");
                    ((JLabel) jcomponent).setHorizontalAlignment(4);
                }
                ((JLabel) jcomponent).setSize(JoTable.this.getJohighHead(), jcomponent.getWidth());
                ((JLabel) jcomponent).setPreferredSize(new Dimension(JoTable.this.getJohighHead(), jcomponent.getWidth()));
            }
            jcomponent.setEnabled(true);
            jcomponent.setBorder(JoTable.this.getBorderHead());
            jcomponent.setOpaque(true);
            jcomponent.setBackground(JoTable.this.getJoBackgoundHead());
            jcomponent.setForeground(JoTable.this.getJoForegroundHead());
            jcomponent.setFont(JoTable.this.getJofontHead());
            return jcomponent;
        }
    }

    class EstiloTablaRenderer extends DefaultTableCellRenderer {

        private Component componenete;

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            this.componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.CENTER) {
                setHorizontalAlignment(0);
            }
            if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.LEFT) {
                setHorizontalAlignment(2);
            }
            if (JoTable.this.getJopositionText() == JoTable.POSITION_TEXT.RIGHT) {
                setHorizontalAlignment(4);
            }
            setBorder(JoTable.this.getBorderRows());
            this.componenete.setFont(JoTable.this.getFont());
            if (row % 2 == 0) {
                this.componenete.setForeground(JoTable.this.getJocolorPrimaryText());
                this.componenete.setBackground(JoTable.this.getJocolorPrimary());
            } else {
                this.componenete.setForeground(JoTable.this.getJocolorSecundaryText());
                this.componenete.setBackground(JoTable.this.getJocolorSecondary());
            }
            if (isSelected) {
                this.componenete.setForeground(JoTable.this.getSelectionForeground());
                this.componenete.setBackground(JoTable.this.getSelectionBackground());
                this.componenete.setFont(JoTable.this.getJofontRowSelect());
            }
            return this.componenete;
        }
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (row == this.rollOverRow && isJoeffectHover()) {
            c.setForeground(getJoForegroundHover());
            c.setBackground(getJoBackgoundHover());
            c.setFont(getJofontRowHover());
        }
        return c;
    }

    private class RollOverListener extends MouseInputAdapter {

        private RollOverListener() {
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JoTable.this.rollOverRow = -1;
            JoTable.this.repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            int row = JoTable.this.rowAtPoint(e.getPoint());
            if (row != JoTable.this.rollOverRow) {
                JoTable.this.rollOverRow = row;
                JoTable.this.repaint();
            }
        }
    }

    public enum SELECTION_ROWS {
        SINGLE_SELECTION, SINGLE_INTERVAL_SELECTION, MULTIPLE_INTERVAL_SELECTION;
    }

    public SELECTION_ROWS getModelSelection() {
        return this.modelSelection;
    }

    public void setModelSelection(SELECTION_ROWS modelSelection) {
        if (modelSelection != null) {
            this.modelSelection = modelSelection;
            if (getModelSelection() == SELECTION_ROWS.MULTIPLE_INTERVAL_SELECTION) {
                setSelectionMode(2);
            }
            if (getModelSelection() == SELECTION_ROWS.SINGLE_INTERVAL_SELECTION) {
                setSelectionMode(1);
            }
            if (getModelSelection() == SELECTION_ROWS.SINGLE_SELECTION) {
                setSelectionMode(0);
            }
        }
    }

    public DefaultTableModel getJoModel() {
        JoModel = (DefaultTableModel) getModel();
        return JoModel;
    }

    public void AddJoModel(Vector vector) {
        if (!vector.isEmpty()) {
            getJoModel().addRow(vector);
            setModel(JoModel);
        }
    }

    public void AddJoModel(Object[] rows) {
        if (rows != null) {
            getJoModel().addRow(rows);
            setModel(JoModel);
        }
    }

    public void JoClearModel() {
        int row = getRowCount() - 1;
        while (row > -1) {
            JoModel.removeRow(row--);
        }
    }

    public int autoNumber() {
        return getRowCount() + 1;
    }

    public String getValue(int columnIndex) {
        int row = getSelectedRow();
        if (row < 0) {
            new JoAlert().messages("ຄຳເຕືອນ", "ກະລຸນາເລືອກຂໍ້ມູນໃນຕາຕະລາງ", "warning");
            return "NaN";
        } else {
            return getValueAt(row, columnIndex).toString();
        }
    }

    public int getIntValue(int columnIndex) {
        int row = getSelectedRow();
        if (row < 0) {
            new JoAlert().messages("ຄຳເຕືອນ", "ກະລຸນາເລືອກຂໍ້ມູນໃນຕາຕະລາງ", "warning");
            return 0;
        } else {
            return Integer.parseInt(getValueAt(row, columnIndex).toString());
        }
    }

    public boolean isSelected() {
        return getSelectedRow() > -1;
    }

    public Color getJoBackgoundHead() {
        return JoBackgoundHead;
    }

    public void setJoBackgoundHead(Color JoBackgoundHead) {
        this.JoBackgoundHead = JoBackgoundHead;
    }

    public Color getJoForegroundHead() {
        return JoForegroundHead;
    }

    public void setJoForegroundHead(Color JoForegroundHead) {
        this.JoForegroundHead = JoForegroundHead;
    }

    public int getJohighHead() {
        return JohighHead;
    }

    public void setJohighHead(int JohighHead) {
        this.JohighHead = JohighHead;
    }

    public int getJowidthBorderHead() {
        return JowidthBorderHead;
    }

    public void setJowidthBorderHead(int JowidthBorderHead) {
        this.JowidthBorderHead = JowidthBorderHead;
    }

    public Color getJocolorBorderHead() {
        return JocolorBorderHead;
    }

    public void setJocolorBorderHead(Color JocolorBorderHead) {
        this.JocolorBorderHead = JocolorBorderHead;
    }

    public Font getJofontHead() {
        return JofontHead;
    }

    public void setJofontHead(Font JofontHead) {
        this.JofontHead = JofontHead;
    }

    public enum POSITION_TEXT {
        LEFT, RIGHT, CENTER;
    }

    public POSITION_TEXT getJopositionText() {
        return JopositionText;
    }

    public void setJopositionText(POSITION_TEXT JopositionText) {
        this.JopositionText = JopositionText;
    }

    public Border getBorderHead() {
        return this.BorderHead;
    }

    public void setBorderHead(Border BorderHead) {
        this.BorderHead = BorderHead;
    }

    public Color getJocolorPrimary() {
        return JocolorPrimary;
    }

    public void setJocolorPrimary(Color JocolorPrimary) {
        this.JocolorPrimary = JocolorPrimary;
    }

    public Color getJocolorSecondary() {
        return JocolorSecondary;
    }

    public void setJocolorSecondary(Color JocolorSecondary) {
        this.JocolorSecondary = JocolorSecondary;
    }

    public Color getJocolorPrimaryText() {
        return JocolorPrimaryText;
    }

    public void setJocolorPrimaryText(Color JocolorPrimaryText) {
        this.JocolorPrimaryText = JocolorPrimaryText;
    }

    public Color getJocolorSecundaryText() {
        return JocolorSecundaryText;
    }

    public void setJocolorSecundaryText(Color JocolorSecundaryText) {
        this.JocolorSecundaryText = JocolorSecundaryText;
    }

    public int getJowidthBorderRows() {
        return JowidthBorderRows;
    }

    public void setJowidthBorderRows(int JowidthBorderRows) {
        this.JowidthBorderRows = JowidthBorderRows;
    }

    public Color getJocolorBorderRows() {
        return JocolorBorderRows;
    }

    public void setJocolorBorderRows(Color JocolorBorderRows) {
        this.JocolorBorderRows = JocolorBorderRows;
    }

    public Font getJofontRowSelect() {
        return JofontRowSelect;
    }

    public void setJofontRowSelect(Font JofontRowSelect) {
        this.JofontRowSelect = JofontRowSelect;
    }

    public Border getBorderRows() {
        return this.BorderRows;
    }

    public void setBorderRows(Border BorderRows) {
        this.BorderRows = BorderRows;
    }

    public Color getJoBackgoundHover() {
        return JoBackgoundHover;
    }

    public void setJoBackgoundHover(Color JoBackgoundHover) {
        this.JoBackgoundHover = JoBackgoundHover;
    }

    public Color getJoForegroundHover() {
        return JoForegroundHover;
    }

    public void setJoForegroundHover(Color JoForegroundHover) {
        this.JoForegroundHover = JoForegroundHover;
    }

    public boolean isJoeffectHover() {
        return JoeffectHover;
    }

    public void setJoeffectHover(boolean JoeffectHover) {
        this.JoeffectHover = JoeffectHover;
    }

    public Font getJofontRowHover() {
        return JofontRowHover;
    }

    public void setJofontRowHover(Font JofontRowHover) {
        this.JofontRowHover = JofontRowHover;
    }
}
