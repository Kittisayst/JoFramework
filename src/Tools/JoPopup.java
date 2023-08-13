package Tools;

import Components.JoPopUpMenu;
import Components.JoTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.UnsupportedLookAndFeelException;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.MyColor;

public class JoPopup {

    private final JMenuItem itemshow;
    private final JMenuItem itemEdit;
    private final JMenuItem itemDelete;
    private JoPopUpMenu menu;

    public JoPopup() {
        try {
            menu = new JoPopUpMenu();
        } catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(JoPopup.class.getName()).log(Level.SEVERE, null, ex);
        }
        itemshow = new JMenuItem("ສະແດງ");
        itemEdit = new JMenuItem("ແກ້ໄຂ");
        itemDelete = new JMenuItem("ລຶບ");
        //=================== Icon =========================
        itemshow.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.FIND_IN_PAGE, 20, MyColor.blue600));
        itemEdit.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.BORDER_COLOR, 20, MyColor.green600));
        itemDelete.setIcon(new JoIconFont().setIconFont(GoogleMaterialDesignIcons.DELETE, 20, MyColor.red600));
        addItem();
    }

    public void ShowPopup(MouseEvent e) {
        menu.showPopupMenu(e);
    }

    public void addActionListener(ActionListener e) {
        itemshow.addActionListener(e);
        itemEdit.addActionListener(e);
        itemDelete.addActionListener(e);
    }
    
        public void addActionListener(ActionListener e,JoTable table) {
        itemshow.addActionListener(e);
        itemEdit.addActionListener(e);
        itemDelete.addActionListener(e);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                ShowPopup(e);
                super.mouseReleased(e); 
            }
            
        });
    }

    public JoPopUpMenu getMenu() {
        return menu;
    }

    public JMenuItem getItemshow() {
        return itemshow;
    }

    public JMenuItem getItemEdit() {
        return itemEdit;
    }

    public JMenuItem getItemDelete() {
        return itemDelete;
    }

    private void addItem() {
        //================= Add =============================
        menu.add(itemshow);
        menu.add(itemEdit);
        menu.add(itemDelete);
    }

}
