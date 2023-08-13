package Components;

import javax.swing.JCheckBox;
import theme.JoFont;

public class JoCheckBox extends JCheckBox {

    public JoCheckBox() {
        setFont(JoFont.font);
        setOpaque(false);
        setFocusable(false);
    }

}
