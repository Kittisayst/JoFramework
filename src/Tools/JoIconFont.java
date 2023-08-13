package Tools;

import java.awt.Color;
import java.awt.Image;
import javax.swing.Icon;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import jiconfont.swing.IconFontSwing;

public class JoIconFont {

    private Color IconColor = Color.WHITE;
    private int IconSize = 30;
    private GoogleMaterialDesignIcons joIcon = GoogleMaterialDesignIcons.ACCESSIBILITY;

    public JoIconFont() {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());
        IconFontSwing.register(FontAwesome.getIconFont());
    }

    public Icon setIconFont(GoogleMaterialDesignIcons Icon, int IconSize) {
        return IconFontSwing.buildIcon(Icon, IconSize);
    }

    public Icon setIconFont(GoogleMaterialDesignIcons Icon, int IconSize, Color color) {
        return IconFontSwing.buildIcon(Icon, IconSize, color);
    }

    public Icon setIconFont(FontAwesome Icon, int IconSize) {
        return IconFontSwing.buildIcon(Icon, IconSize);
    }

    public Icon setIconFont(FontAwesome Icon, int IconSize, Color color) {
        return IconFontSwing.buildIcon(Icon, IconSize, color);
    }
    //==========================Buill Image ========================

    public Image getIconFont(GoogleMaterialDesignIcons Icon, int IconSize) {
        return IconFontSwing.buildImage(Icon, IconSize);
    }

    public Image getIconFont(GoogleMaterialDesignIcons Icon, int IconSize, Color color) {
        return IconFontSwing.buildImage(Icon, IconSize, color);
    }

    public Image getIconFont(FontAwesome Icon, int IconSize) {
        return IconFontSwing.buildImage(Icon, IconSize);
    }

    public Image getIconFont(FontAwesome Icon, int IconSize, Color color) {
        return IconFontSwing.buildImage(Icon, IconSize, color);
    }

    public Color getIconColor() {
        return IconColor;
    }

    public void setIconColor(Color IconColor) {
        this.IconColor = IconColor;
    }

    public int getIconSize() {
        return IconSize;
    }

    public void setIconSize(int IconSize) {
        this.IconSize = IconSize;
    }

    public GoogleMaterialDesignIcons getJoIcon() {
        return joIcon;
    }

    public void setJoIcon(GoogleMaterialDesignIcons joIcon) {
        this.joIcon = joIcon;
    }

}
