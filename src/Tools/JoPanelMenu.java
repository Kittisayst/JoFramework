package Tools;

import Components.JoButtonIconfont;
import javax.swing.JPanel;

public class JoPanelMenu {

    public JoPanelMenu(JoButtonIconfont buttonMain, JPanel panelMain) {
        panelMain.setOpaque(false);
        panelMain.setVisible(false);
        buttonMain.addActionListener((e) -> {
            panelMain.setVisible(!panelMain.isVisible());
            if (panelMain.isVisible()) {
                buttonMain.setBackground(buttonMain.getBackground().darker());
            } else {
                buttonMain.setBackground(buttonMain.getBackground().brighter());
            }
        });
    }

    public JoPanelMenu() {
    }

    public void SetJoPanelMenu(JoButtonIconfont buttonMain, JPanel panelMain) {
        panelMain.setOpaque(false);
        panelMain.setVisible(false);
        buttonMain.addActionListener((e) -> {
            panelMain.setVisible(!panelMain.isVisible());
            if (panelMain.isVisible()) {
                buttonMain.setBackground(buttonMain.getBackground().darker());
            } else {
                buttonMain.setBackground(buttonMain.getBackground().brighter());
            }
        });
    }

}
