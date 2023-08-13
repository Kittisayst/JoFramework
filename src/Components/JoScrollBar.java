package Components;

import ClassUI.ModernScrollBarUI;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class JoScrollBar extends JScrollBar {

    private int scrollSizeV = 8;
    private int scrollSizeH = 8;
    private int scrollSpeed = 30;
    private Color scrollColor = new Color(48, 144, 216);
    private Color scrollBackground = Color.WHITE;
    private JScrollPane scrollBar;

    public JoScrollBar() {
        setUI(new ModernScrollBarUI());
        init();
    }

    public JoScrollBar(JScrollPane scrollBar) {
        this.scrollBar = scrollBar;
        setUI(new ModernScrollBarUI());
        init();
        scrollBar.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollBar.setVerticalScrollBar(JoScrollBar.this);
    }

    private void init() {
        setPreferredSize(new Dimension(scrollSizeV, scrollSizeH));
        setForeground(scrollColor);
        setBackground(scrollBackground);
        setUnitIncrement(30);
    }

    public int getScrollSizeV() {
        return scrollSizeV;
    }

    public void setScrollSizeV(int scrollSizeV) {
        this.scrollSizeV = scrollSizeV;
        init();
    }

    public int getScrollSizeH() {
        return scrollSizeH;
    }

    public void setScrollSizeH(int scrollSizeH) {
        this.scrollSizeH = scrollSizeH;
        init();
    }

    public int getScrollSpeed() {
        return scrollSpeed;
    }

    public void setScrollSpeed(int scrollSpeed) {
        this.scrollSpeed = scrollSpeed;
        init();
    }

    public Color getScrollColor() {
        return scrollColor;
    }

    public void setScrollColor(Color scrollColor) {
        this.scrollColor = scrollColor;
        init();
    }

    public Color getScrollBackground() {
        return scrollBackground;
    }

    public void setScrollBackground(Color scrollBackground) {
        this.scrollBackground = scrollBackground;
        init();
    }

}
