package Components;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.JLabel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;
import theme.JoFont;

public class JoLableIcon extends JLabel {

    private GoogleMaterialDesignIcons JoIcons = GoogleMaterialDesignIcons.ADD_BOX;
    private int JoIconSize = 32;
    private Color JoIconColor = Color.BLUE;

    public JoLableIcon() {
        setFont(JoFont.font);
        init();
    }

    private void init() {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        setJoIcons(JoIcons);
    }

    public GoogleMaterialDesignIcons getJoIcons() {
        return JoIcons;
    }

    public void setJoIcons(GoogleMaterialDesignIcons JoIcons) {
        this.JoIcons = JoIcons;
        Icon icon = IconFontSwing.buildIcon(JoIcons, JoIconSize, JoIconColor);
        setIcon(icon);
    }

    public int getJoIconSize() {
        return JoIconSize;
    }

    public void setJoIconSize(int JoIconSize) {
        this.JoIconSize = JoIconSize;
        init();
    }

    public Color getJoIconColor() {
        return JoIconColor;
    }

    public void setJoIconColor(Color JoIconColor) {
        this.JoIconColor = JoIconColor;
        init();
    }

}
