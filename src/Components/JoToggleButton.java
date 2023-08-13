package Components;

import Tools.JoIconFont;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JToggleButton;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.JoFont;
import theme.JoTheme;
import theme.MyColor;

public class JoToggleButton extends JToggleButton {

    private int JoRound = 10;
    private int JoIconSize = 18;
    private int JoIconGrap = 5;
    private Color SelectColor = JoTheme.Primary;
    private Color SelectedColor = JoTheme.HoverColor;
    private Color JoHoverColor = MyColor.blue400;
    private Color JoIconColor = Color.WHITE;

    public JoToggleButton() {
        init();
    }

    private void init() {
        setForeground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(150, 40));
        setFont(new JoFont().loadJoFont(0, 12));
    }

    @Override
    protected void paintComponent(Graphics g) {
        setContentAreaFilled(false);
        setFocusable(true);
        setFocusPainted(false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
        if (isEnabled()) {
            if (isSelected()) {
                g.setColor(getSelectedColor());
            } else {
                g.setColor(getSelectColor());
            }
            if (getModel().isRollover()) {
                g.setColor(getJoHoverColor());
            }
        } else {
            g.setColor(new Color(204, 204, 204));
        }
        g2.fill(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), this.JoRound, this.JoRound));
        int space = getJoIconSize() + getJoIconGrap();
        if (isSelected()) {
            g2.drawImage(new JoIconFont().getIconFont(GoogleMaterialDesignIcons.EXPAND_MORE, getJoIconSize(),
                    getJoIconColor()), getWidth() - space, getHeight() / 2 - getJoIconSize() / 2, null);
        } else {
            g2.drawImage(new JoIconFont().getIconFont(GoogleMaterialDesignIcons.CHEVRON_RIGHT, getJoIconSize(),
                    getJoIconColor()), getWidth() - space, getHeight() / 2 - getJoIconSize() / 2, null);
        }
        repaint();
        super.paintComponent(g);
    }

    public int getJoRound() {
        return JoRound;
    }

    public void setJoRound(int JoRound) {
        this.JoRound = JoRound;
    }

    public int getJoIconSize() {
        return JoIconSize;
    }

    public void setJoIconSize(int JoIconSize) {
        this.JoIconSize = JoIconSize;
    }

    public int getJoIconGrap() {
        return JoIconGrap;
    }

    public void setJoIconGrap(int JoIconGrap) {
        this.JoIconGrap = JoIconGrap;
    }

    public Color getSelectColor() {
        return SelectColor;
    }

    public void setSelectColor(Color SelectColor) {
        this.SelectColor = SelectColor;
    }

    public Color getSelectedColor() {
        return SelectedColor;
    }

    public void setSelectedColor(Color SelectedColor) {
        this.SelectedColor = SelectedColor;
    }

    public Color getJoHoverColor() {
        return JoHoverColor;
    }

    public void setJoHoverColor(Color JoHoverColor) {
        this.JoHoverColor = JoHoverColor;
    }

    public Color getJoIconColor() {
        return JoIconColor;
    }

    public void setJoIconColor(Color JoIconColor) {
        this.JoIconColor = JoIconColor;
    }

}
