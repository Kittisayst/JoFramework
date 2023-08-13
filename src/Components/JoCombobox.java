package Components;

import Tools.JoAlert;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import theme.JoFont;

/**
 *
 * @author ucer
 */
public class JoCombobox extends JComboBox {

    private final ArrayList mylist = new ArrayList();
    private final DefaultComboBoxModel myModel = new DefaultComboBoxModel();

    public JoCombobox() {
        init();
    }

    public ArrayList getMylist() {
        return mylist;
    }

    public DefaultComboBoxModel getMyModel() {
        return myModel;
    }

    public void JoClearData() {
        getMylist().clear();
        getMyModel().removeAllElements();
    }

    public void setSelectValue(String index) {
        if (mylist.size() > -1) {
            setSelectedIndex(mylist.indexOf(index));
        }
    }

    public void setSelectIntValue(int index) {
        if (mylist.size() > -1) {
            setSelectedIndex(mylist.indexOf(index));
        }
    }

    public void JoAddModel(String ID, String Name) {
        getMylist().add(ID);
        getMyModel().addElement(Name);
        setModel(getMyModel());
    }

    public void JoAddIntModel(int ID, String Name) {
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

    public int getKeyInt() {
        if (getSelectedIndex() > -1) {
            return Integer.parseInt(getMylist().get(getSelectedIndex()).toString());
        } else {
            return 0;
        }
    }

    public String getValue() {
        if (getSelectedIndex() > -1) {
            return getSelectedItem().toString();
        } else {
            return "Empty Value";
        }
    }

    public boolean EmptyItem() {
        if (myModel.getSize() > 0) {
            new JoAlert().messages("ບໍ່ພົບຂໍ້ມູນ", "ກະລຸນາເລືອກຂໍ້ມູນ", JoAlert.Icons.warning);
            return false;
        } else {
            return true;
        }
    }

    private void init() {
        setFocusable(false);
        setFont(JoFont.font);
        JoScrollBar bar = new JoScrollBar();
        bar.setScrollSizeV(3);
        Object popup = this.getUI().getAccessibleChild(this, 0);
        if (popup instanceof Container) {
            Component scrollPane = ((Container) popup).getComponent(0);
            if (scrollPane instanceof JScrollPane) {
                JScrollPane pane = (JScrollPane) scrollPane;
                pane.setVerticalScrollBar(bar);
            }
        }
    }

}
