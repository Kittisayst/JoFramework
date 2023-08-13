/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tools;


import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JToolTip;

/**
 *
 * @author Kittisay
 */
public class JoTooltip extends JToolTip {

    private String theme = "dark";

    @Override
    public void updateUI() {
        setFont(new java.awt.Font("Phetsarath OT", 0, 14));
        setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));
//        setSize(new Dimension(100, 100));
        super.updateUI(); //To change body of generated methods, choose Tools | Templates.
    }

    public JoTooltip(JComponent component, String theme) {
        this.theme = theme;
        setComponent(component);
        switch (this.theme) {
            case "dark":
                setBackground(Color.decode("#FFFFFF"));
                setForeground(Color.decode("#FF0000"));
                break;
            case "light":
                setBackground(Color.decode("#FFFFFF"));
                setForeground(Color.decode("#212121"));
                break;
            case "blue":
                setOpaque(true);
                setBackground(Color.decode("#333333"));
                setForeground(Color.decode("#0000CC"));
                break;
        }

    }

}
