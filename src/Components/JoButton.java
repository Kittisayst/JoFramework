package Components;

import theme.JoTheme;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import theme.JoFont;

public final class JoButton extends JButton {

    private int JoshadowOpacity = 0;
    private Color JoShadowColor = new Color(0, 0, 0);
    private Color JocolorHover = JoTheme.HoverColor;
    private Color JoEnabledColor = new Color(204, 204, 204);
    private int JoShaowSize = 0;
    private int JoRound = 5;
    private Graphics buttonGraphics;
    Shape shape;
    private boolean isHover = false;

    public JoButton() {
        setBackground(JoTheme.Primary);
        setCursor(new Cursor(12));
        setForeground(new java.awt.Color(255, 255, 255));
        setFont(JoFont.font);
        setPreferredSize(new Dimension(120, 45));
    }

    @Override
    public void setCursor(Cursor cursor) {
        super.setCursor(cursor);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setContentAreaFilled(false);
        setFocusable(true);
        setFocusPainted(false);
        buttonGraphics = g;
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        for (int i = 0; i < this.JoshadowOpacity; i++) {
            g2.setColor(new Color(this.JoShadowColor.getRed(), this.JoShadowColor.getGreen(), this.JoShadowColor.getBlue(), this.JoShaowSize * i));
            g2.fill(new RoundRectangle2D.Float(i, i, (getWidth() - i * 2), (getHeight() - i * 2), this.JoRound, this.JoRound));
        }
        repaint();
        HoverActive();
        super.paintComponent(g);
    }

    public void HoverActive() {
        Graphics2D g2 = (Graphics2D) buttonGraphics;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        int offset_lr = this.JoshadowOpacity + this.JoshadowOpacity;
        int offset_td = this.JoshadowOpacity + this.JoshadowOpacity;
        if (isEnabled()) {
            buttonGraphics.setColor(getBackground());
            if (getModel().isRollover()) {
                g2.setColor(this.JocolorHover);
                this.isHover = true;
            } else {
                g2.setColor(getBackground());
                this.isHover = false;
            }
        } else {
            buttonGraphics.setColor(getJoEnabledColor());
            setJoShadowColor(Color.BLACK);
        }
        g2.fill(new RoundRectangle2D.Float(this.JoshadowOpacity, this.JoshadowOpacity, (getWidth() - offset_lr), (getHeight() - offset_td), this.JoRound, this.JoRound));
        if (this.isHover) {
            g2.setColor(JoTheme.HoverColor);
        } else {
            g2.setColor(getBackground());
        }
    }

    @Override
    public void updateUI() {
        LookAndFeel old = UIManager.getLookAndFeel();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException ex) {
            old = null;
        }
        super.updateUI();
        if (old != null) {
            try {
                UIManager.setLookAndFeel(old);
            } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
            }
        }
    }

    @Override
    public boolean contains(int x, int y) {
        if (this.shape == null
                || !this.shape.getBounds().equals(getBounds())) {
            this.shape = new Ellipse2D.Float(0.0F, 0.0F, getWidth(), getHeight());
        }
        return this.shape.contains(x, y);
    }

    @Override
    public void setEnabled(boolean b) {
        super.setEnabled(b);
    }

    @Override
    protected void processFocusEvent(FocusEvent focusEvent) {
        super.processFocusEvent(focusEvent);
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) {
        super.processMouseEvent(mouseEvent);
    }

    public Color getJoEnabledColor() {
        return JoEnabledColor;
    }

    public void setJoEnabledColor(Color JoEnabledColor) {
        this.JoEnabledColor = JoEnabledColor;
    }

    public int getJoRound() {
        return JoRound;
    }

    public void setJoRound(int JoRound) {
        this.JoRound = JoRound;
    }

    public int getJoShaowSize() {
        return JoShaowSize;
    }

    public void setJoShaowSize(int JoShaowSize) {
        this.JoShaowSize = JoShaowSize;
    }

    public Color getJocolorHover() {
        return JocolorHover;
    }

    public void setJocolorHover(Color JocolorHover) {
        this.JocolorHover = JocolorHover;
    }

    public void setIsHover(boolean isHover) {
        this.isHover = isHover;
    }

    public boolean isIsHover() {
        return isHover;
    }

    public Color getJoShadowColor() {
        return JoShadowColor;
    }

    public void setJoShadowColor(Color JoShadowColor) {
        this.JoShadowColor = JoShadowColor;
    }

    public int getJoshadowOpacity() {
        return JoshadowOpacity;
    }

    public void setJoshadowOpacity(int JoshadowOpacity) {
        this.JoshadowOpacity = JoshadowOpacity;
    }

}