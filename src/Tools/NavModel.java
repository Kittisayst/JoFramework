package Tools;

import java.awt.Color;
import javax.swing.Icon;

public class NavModel {

    private String Title;
    private Color Color;
    private Color Hover;
    private Icon Icon;

    public NavModel() {
    }

    public NavModel(String Title, Color Color, Color Hover, Icon Icon) {
        this.Title = Title;
        this.Color = Color;
        this.Hover = Hover;
        this.Icon = Icon;
    }

}
