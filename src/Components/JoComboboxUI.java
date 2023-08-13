package Components;

import Tools.JoAlert;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import theme.JoTheme;

/**
 *
 * @author Kittisay
 */
public final class JoComboboxUI extends JComboBox {

    private boolean conBorde = false;

    private Color colorBorde = JoTheme.HoverColor;

    private Color colorFondo = JoTheme.Primary;

    private Color colorArrow = JoTheme.Primary;

    private Color colorBoton = new Color(233, 235, 238);

    private Color colorSeleccion = JoTheme.Primary;

    private Color colorListaItems = new Color(255, 255, 255);

    private Color colorSeleccionTXT = new Color(255, 255, 255);

    private Color colorListaItemsTXT = new Color(0, 0, 0);

    private final Dimension dimension = new Dimension(200, 38);

    private final Set<Integer> disableIndex = new HashSet<>();

    private boolean isDisableIndex;

    private String disabledIdex = "-1";

    private Color colorDisabledIndex = new Color(240, 240, 240);

    private Color colorDisabledIndexText = new Color(0, 0, 0);

    private int itemHeight = 25;
    private final ArrayList mylist = new ArrayList();
    private final DefaultComboBoxModel myModel = new DefaultComboBoxModel();

    protected final Action up;

    protected final Action down;

    private Set<Integer> getDisableIndex(String field) {
        try {
            return (Set<Integer>) Arrays.<String>stream(field.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(Integer::valueOf).collect(Collectors.toSet());
        } catch (NumberFormatException ex) {
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(null, "invalid value.\n" + ex.getMessage(), "Error", 0);
            return Collections.emptySet();
        }
    }

    public JoComboboxUI() {
        setColorArrow(new java.awt.Color(0, 0, 0));
        setColorBoton(new java.awt.Color(255, 255, 255));
        setColorFondo(new java.awt.Color(255, 255, 255));
        this.up = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int si = JoComboboxUI.this.getSelectedIndex();
                for (int i = si - 1; i >= 0; i--) {
                    if (!JoComboboxUI.this.disableIndex.contains(i)) {
                        JoComboboxUI.this.setSelectedIndex(i);
                        break;
                    }
                }
            }
        };
        this.down = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int si = JoComboboxUI.this.getSelectedIndex();
                for (int i = si + 1; i < JoComboboxUI.this.getModel().getSize(); i++) {
                    if (!JoComboboxUI.this.disableIndex.contains(i)) {
                        JoComboboxUI.this.setSelectedIndex(i);
                        break;
                    }
                }
            }
        };
        setFont(new java.awt.Font("Phetsarath OT", 0, 12));
        setCursor(new Cursor(12));
        setPreferredSize(this.dimension);
        setSize(this.dimension);
        setForeground(Color.BLACK);
        setUI(new CustomUI());
        setBorder((Border) null);
        setModel(new javax.swing.DefaultComboBoxModel(new String[]{"JOItem 1", "JOItem 2", "JOItem 3", "JOItem 4", "JOItem 5"}));
        setDisableIndex(getDisableIndex(this.disabledIdex));
    }

    public boolean ValueZero() {
        if (getSelectedIndex() == 0) {
            new JoAlert().messages("ຂໍ້ຜິດພາດ", "ກະລຸນາເລືອກ " + getSelectedItem().toString(), "warning");
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void updateUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        super.updateUI();
        if (old != null)
      try {
            UIManager.setLookAndFeel(old);
        } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
        }
    }

    public Color getColorBorde() {
        return this.colorBorde;
    }

    public void setColorBorde(Color colorBorde) {
        this.colorBorde = colorBorde;
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorFondo() {
        return this.colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorArrow() {
        return this.colorArrow;
    }

    public void setColorArrow(Color colorArrow) {
        this.colorArrow = colorArrow;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorBoton() {
        return this.colorBoton;
    }

    public void setColorBoton(Color colorBoton) {
        this.colorBoton = colorBoton;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public boolean isConBorde() {
        return this.conBorde;
    }

    public void setConBorde(boolean conBorde) {
        this.conBorde = conBorde;
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorSeleccion() {
        return this.colorSeleccion;
    }

    public void setColorSeleccion(Color colorSeleccion) {
        this.colorSeleccion = colorSeleccion;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorListaItems() {
        return this.colorListaItems;
    }

    public void setColorListaItems(Color colorListaItems) {
        this.colorListaItems = colorListaItems;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorSeleccionTXT() {
        return this.colorSeleccionTXT;
    }

    public void setColorSeleccionTXT(Color colorSeleccionTXT) {
        this.colorSeleccionTXT = colorSeleccionTXT;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public Color getColorListaItemsTXT() {
        return this.colorListaItemsTXT;
    }

    public void setColorListaItemsTXT(Color colorListaItemsTXT) {
        this.colorListaItemsTXT = colorListaItemsTXT;
        setUI(new CustomUI());
        if (isConBorde()) {
            setBorder(BorderFactory.createLineBorder(this.colorBorde, 1));
        } else {
            setBorder((Border) null);
        }
    }

    public class CustomUI extends BasicComboBoxUI {

        @Override
        protected JButton createArrowButton() {
            BasicArrowButton basicArrowButton = new BasicArrowButton(5, JoComboboxUI.this.colorBoton, JoComboboxUI.this.colorArrow, JoComboboxUI.this.colorArrow, JoComboboxUI.this.colorBoton);
            basicArrowButton.setBorder(BorderFactory.createLineBorder(JoComboboxUI.this.colorBoton, 1));
            basicArrowButton.setContentAreaFilled(false);
          
            return basicArrowButton;
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.setColor(JoComboboxUI.this.colorFondo);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        Border padding = BorderFactory.createEmptyBorder(0, 7, 0, 0);

        private int cheight;

        @Override
        protected ListCellRenderer createRenderer() {
            return new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    list.setSelectionBackground(JoComboboxUI.this.colorFondo);
                    list.setSelectionForeground(getForeground());
                    setBorder(JoComboboxUI.CustomUI.this.padding);
                    if (value instanceof javax.swing.JSeparator) {
                        return (Component) value;
                    }
                    if (isSelected) {
                        setBackground(JoComboboxUI.this.colorSeleccion);
                        setForeground(JoComboboxUI.this.colorSeleccionTXT);
                    } else {
                        setBackground(JoComboboxUI.this.colorListaItems);
                        setForeground(JoComboboxUI.this.colorListaItemsTXT);
                    }
                    if (JoComboboxUI.this.disableIndex.contains(index)) {
                        setBackground(JoComboboxUI.this.colorDisabledIndex);
                        setForeground(JoComboboxUI.this.colorDisabledIndexText);
                    }
                    Dimension d = super.getPreferredSize();
                    JoComboboxUI.CustomUI.this.cheight = (index < 0) ? d.height : JoComboboxUI.this.itemHeight;
                    return this;
                }

                @Override
                public Dimension getPreferredSize() {
                    Dimension d = super.getPreferredSize();
                    d.height = JoComboboxUI.CustomUI.this.cheight;
                    return d;
                }
            };
        }
    }

    private void setDisableIndex(Set<Integer> set) {
        this.disableIndex.clear();
        set.forEach(i -> {
            this.disableIndex.add(i);
        });
    }

    @Override
    public void setPopupVisible(boolean v) {
        if (!v && this.isDisableIndex) {
            this.isDisableIndex = false;
        } else {
            super.setPopupVisible(v);
        }
    }

    @Override
    public void setSelectedIndex(int index) {
        if (this.disableIndex.contains(index)) {
            this.isDisableIndex = true;
        } else {
            super.setSelectedIndex(index);
        }
    }

    public String getDisabledIdex() {
        return this.disabledIdex;
    }

    public void setDisabledIdex(String disabledIdex) {
        this.disabledIdex = disabledIdex;
        setDisableIndex(getDisableIndex(disabledIdex));
    }

    public void JoClearData() {
        getMylist().clear();
        getMyModel().removeAllElements();
    }

    public void JoAddModel(String ID, String Name) {
        getMylist().add(ID);
        getMyModel().addElement(Name);
        setModel(getMyModel());
    }

    public String getKey() {
        if (getSelectedIndex() > -1) {
            return getMylist().get(getSelectedIndex()).toString();
        } else {
            return "Empty Key";
        }
    }

    public String getValue() {
        if (getSelectedIndex() > -1) {
            return getSelectedItem().toString();
        } else {
            return "Empty Value";
        }
    }

    public int getItemHeight() {
        return this.itemHeight;
    }

    public void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
        repaint();
    }

    public Color getColorDisabledIndex() {
        return this.colorDisabledIndex;
    }

    public void setColorDisabledIndex(Color colorDisabledIndex) {
        this.colorDisabledIndex = colorDisabledIndex;
    }

    public Color getColorDisabledIndexText() {
        return this.colorDisabledIndexText;
    }

    public void setColorDisabledIndexText(Color colorDisabledIndexText) {
        this.colorDisabledIndexText = colorDisabledIndexText;
    }

    public ArrayList getMylist() {
        return mylist;
    }

    public DefaultComboBoxModel getMyModel() {
        return myModel;
    }
}
