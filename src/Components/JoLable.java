package Components;

import javax.swing.JLabel;
import theme.JoFont;

public class JoLable extends JLabel {

    @Override
    public void updateUI() {
        setFont(JoFont.font);
        super.updateUI(); 
    }
    
    

}
