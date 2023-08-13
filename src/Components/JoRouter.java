package Components;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;

public class JoRouter extends JPanel {

    private final Map<String, JPanel> route;
    private final ArrayList routeHistory;
    private final ArrayList routerName;
    private ArrayList<GoogleMaterialDesignIcons> routerIcon;
    private JLabel labelRouter;
    private JLabel label404;

    public JoRouter() {
        route = new HashMap<>();
        routerName = new ArrayList();
        routeHistory = new ArrayList();
        routerIcon = new ArrayList<>();
        labelRouter = new JLabel("JoRouter");
        label404 = new JLabel("Not Found Panel");
        DefaultSetting();
    }

    private void DefaultSetting() {
        setLayout(new BorderLayout());
        setBackground(new Color(255, 255, 255));
        labelRouter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(labelRouter, BorderLayout.CENTER);
    }

    public void showRoute(String path) {
        setRouter(route.get(path) == null ? panel404() : route.get(path));
    }

    public void showRoute(int index) {
        if (index > -1 && index <= route.size() - 1) {
            setRouter((JPanel) routeHistory.get(index));
        } else {
            setRouter(panel404());
        }
    }

    public void setRoute(String path, JPanel home) {
        route.put(path, home);
        routeHistory.add(route.get(path));
    }

    public void setRoute(String path, JPanel home, String Name) {
        route.put(path, home);
        routerName.add(Name);
        routeHistory.add(route.get(path));
    }

    public void setRoute(String path, JPanel home, String Name, GoogleMaterialDesignIcons icon) {
        route.put(path, home);
        routerName.add(Name);
        routeHistory.add(route.get(path));
        routerIcon.add(icon);
    }

    private JPanel panel404() {
        JPanel pn = new JPanel(new BorderLayout());
        label404.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn.add(label404, BorderLayout.CENTER);
        return pn;
    }

    public void setRouter(JPanel pn) {
        removeAll();
        add(pn, BorderLayout.CENTER);
        repaint();
        revalidate();
    }

    public int getRouterSize() {
        return route.size();
    }

    public Map<String, JPanel> getRoute() {
        return route;
    }

    public ArrayList getRouterName() {
        return routerName;
    }

    public ArrayList getRouterIcon() {
        return routerIcon;
    }

    public ArrayList getRouteHistory() {
        return routeHistory;
    }

    public JLabel getLabelRouter() {
        return labelRouter;
    }

    public void setLabelRouter(JLabel labelRouter) {
        this.labelRouter = labelRouter;
    }

    public JLabel getLabel404() {
        return label404;
    }

    public void setLabel404(JLabel label404) {
        this.label404 = label404;
    }

}
