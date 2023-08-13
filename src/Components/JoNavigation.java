package Components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.JoFont;

public class JoNavigation extends JPanel {

    private Font navFont;
    private String navGrapText;
    private Color navItemBackground;
    private Color navItemHover;
    private Color navItemColor;
    private boolean navDisibleItem;

    public JoNavigation() {
        navFont = new JoFont().loadJoFont(0, 14);
        navGrapText = " ";
        navDisibleItem = false;
    }

    public void setNavigationItem(String text, MouseAdapter e) {
        JLabel lbl = new JLabel(text);
        if (getComponentCount() > 0) {
            add(new JLabel(navGrapText));
        }
        add(lbl);
        lbl.addMouseListener(e);
    }

    public void setNavigationItem(JoRouter route) {
        navItemBackground = getBackground();
        navItemHover = getBackground().darker();
        navItemColor = new Color(255, 255, 255);
        for (int i = 0; i < route.getRouterName().size(); i++) {
            if (i > 0) {
                JLabel lbl = new JLabel(navGrapText);
                lbl.setFont(new Font(navFont.getFamily(), navFont.getStyle(), navFont.getSize() + 2));
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setForeground(navItemColor);
                add(lbl);
            }
            String name = route.getRouterName().get(i).toString();
            JoButton btn = new JoButton();
            btn.setText(name);
            btn.setFont(navFont);
            btn.setName(i + "");
            btn.setBackground(navItemBackground);
            btn.setJocolorHover(navItemHover);
            btn.setForeground(navItemColor);
            add(btn);
            btn.addActionListener((e) -> {
                route.showRoute(Integer.parseInt(btn.getName()));
            });
        }
        JoButton btn = (JoButton) getComponent(getComponentCount() - 1);
        btn.setEnabled(!isNavDisibleItem());
    }

    public void setNavigationItemIcon(JoRouter route) {
        navItemBackground = getBackground();
        navItemHover = getBackground().darker();
        navItemColor = new Color(255, 255, 255);
        for (int i = 0; i < route.getRouterName().size(); i++) {
            if (i > 0) {
                JLabel lbl = new JLabel(navGrapText);
                lbl.setFont(new Font(navFont.getFamily(), navFont.getStyle(), navFont.getSize() + 2));
                lbl.setHorizontalAlignment(SwingConstants.CENTER);
                lbl.setForeground(navItemColor);
                add(lbl);
            }
            String name = route.getRouterName().get(i).toString();
            JoButtonIconfont btn = new JoButtonIconfont();
            btn.setText(name);
            btn.setFont(navFont);
            btn.setName(i + "");
            btn.setBackground(navItemBackground);
            btn.setJocolorHover(navItemHover);
            btn.setForeground(navItemColor);
            btn.setJoIcons((GoogleMaterialDesignIcons) route.getRouterIcon().get(i));
            add(btn);
            btn.addActionListener((e) -> {
                route.showRoute(Integer.parseInt(btn.getName()));
            });
        }
        System.out.println(getComponentCount());
        JoButtonIconfont btn = (JoButtonIconfont) getComponent(getComponentCount()-1);
        btn.setEnabled(!isNavDisibleItem());
    }

    public Font getNavFont() {
        return navFont;
    }

    public void setNavFont(Font navFont) {
        this.navFont = navFont;
    }

    public String getNavGrapText() {
        return navGrapText;
    }

    public void setNavGrapText(String navGrapText) {
        this.navGrapText = navGrapText;
    }

    public Color getNavItemBackground() {
        return navItemBackground;
    }

    public void setNavItemBackground(Color navItemBackground) {
        this.navItemBackground = navItemBackground;
    }

    public Color getNavItemHover() {
        return navItemHover;
    }

    public void setNavItemHover(Color navItemHover) {
        this.navItemHover = navItemHover;
    }

    public Color getNavItemColor() {
        return navItemColor;
    }

    public void setNavItemColor(Color navItemColor) {
        this.navItemColor = navItemColor;
    }

    public boolean isNavDisibleItem() {
        return navDisibleItem;
    }

    public void setNavDisibleItem(boolean navDisibleItem) {
        this.navDisibleItem = navDisibleItem;
    }

}
