package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LinearGradientPaint;
import java.awt.Paint;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.event.FocusEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Kittisay
 */
public class JoPanel extends JPanel {

    private int joPixels = 2;

    private Color joBorderColor = new Color(0, 0, 0);

    private int joOpacity = 5;

    private int joRound = 8;

    private final boolean band = true;

    protected JoPanel.JoGradiente joGradiente = JoPanel.JoGradiente.HORIZONTAL;

    protected Color JoPrimaryColor = getBackground().brighter();

    protected Color JoSecondaryColor = getBackground().brighter();

    public int getJoRound() {
        return joRound;
    }

    public void setJoRound(int joRound) {
        this.joRound = joRound;
    }

    public int getJoPixels() {
        return joPixels;
    }

    public void setJoPixels(int joPixels) {
        this.joPixels = joPixels;
    }

    public Color getJoBorderColor() {
        return joBorderColor;
    }

    public void setJoBorderColor(Color joBorderColor) {
        this.joBorderColor = joBorderColor;
    }

    public int getJoOpacity() {
        return joOpacity;
    }

    public void setJoOpacity(int joOpacity) {
        this.joOpacity = joOpacity;
    }

    public JoPanel() {
        setPreferredSize(new Dimension(200, 150));
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
    protected void paintComponent(Graphics g) {
        setOpaque(false);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        for (int i = 0; i < this.joPixels; i++) {
            if (isFocusOwner()) {
                g2.setColor(new Color(this.getBackground().getRed(), this.getBackground().getGreen(), this.getBackground().getBlue(), this.joOpacity * i));
            } else {
                g2.setColor(new Color(this.joBorderColor.getRed(), this.joBorderColor.getGreen(), this.joBorderColor.getBlue(), this.joOpacity * i));
            }
            g2.fill(new RoundRectangle2D.Float(i, i, (getWidth() - i * 2), (getHeight() - i * 2), this.joRound, this.joRound));
        }
        repaint();
        int offset_lr = this.joPixels + this.joPixels;
        int offset_td = this.joPixels + this.joPixels;
        if (isEnabled()) {
            g.setColor(getBackground());
        } else {
            g.setColor(new Color(204, 204, 204));
            setJoBorderColor(Color.BLACK);
        }

        //Gradient
        Paint gp = getJoGradientePaint();
        g2.setPaint(gp);
        //end Gradient
        g2.fill(new RoundRectangle2D.Float(this.joPixels, this.joPixels, (getWidth() - offset_lr), (getHeight() - offset_td), this.joRound, this.joRound));
        super.paintComponent(g);
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

    public Color getJoPrimaryColor() {
        return JoPrimaryColor;
    }

    public void setJoPrimaryColor(Color JoPrimaryColor) {
        this.JoPrimaryColor = JoPrimaryColor;
    }

    public Color getJoSecondaryColor() {
        return JoSecondaryColor;
    }

    public void setJoSecondaryColor(Color JoSecondaryColor) {
        this.JoSecondaryColor = JoSecondaryColor;
    }

    public enum JoGradiente {
        HORIZONTAL, VERTICAL, ESQUINA_1, ESQUINA_2, ESQUINA_3, ESQUINA_4, CIRCULAR, CENTRAL, AQUA;
    }

    public JoGradiente getJoGradiente() {
        return joGradiente;
    }

    public void setJoGradiente(JoGradiente joGradiente) {
        this.joGradiente = joGradiente;
    }

    public Paint getJoGradientePaint() {
        int x1 = 0, x2 = getWidth(), y1 = 0, y2 = getHeight();
        switch (this.getJoGradiente()) {
            case HORIZONTAL:
                x1 = getWidth() / 2;
                y1 = 0;
                x2 = getWidth() / 2;
                y2 = getHeight();
                return new GradientPaint(x1, y1, this.JoPrimaryColor, x2, y2, this.JoSecondaryColor);
            case VERTICAL:
                x1 = 0;
                y1 = getHeight() / 2;
                x2 = getWidth();
                y2 = getHeight() / 2;
                return new GradientPaint(x1, y1, this.JoPrimaryColor, x2, y2, this.JoSecondaryColor);
            case ESQUINA_1:
                x1 = 0;
                y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor});
            case ESQUINA_2:
                x1 = getWidth();
                y1 = 0;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor});
            case ESQUINA_3:
                x1 = getWidth();
                y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor});
            case ESQUINA_4:
                x1 = 0;
                y1 = getHeight();
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 1.0F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor});
            case CIRCULAR:
                x1 = getWidth() / 2;
                y1 = getHeight() / 2;
                return new RadialGradientPaint(x1, y1, getWidth(), new float[]{0.0F, 0.5F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor});
            case CENTRAL:
                x1 = getWidth() / 2;
                y1 = 0;
                x2 = getWidth() / 2;
                y2 = getHeight();
                return new LinearGradientPaint(x1, y1, x2, y2, new float[]{0.0F, 0.5F, 1.0F}, new Color[]{this.JoPrimaryColor, this.JoSecondaryColor, this.JoPrimaryColor});
            case AQUA:
                return new LinearGradientPaint(0.0F, 0.0F, 0.0F, getHeight(), new float[]{0.0F, 0.3F, 0.5F, 1.0F}, new Color[]{this.JoPrimaryColor.brighter().brighter(),
                    this.JoPrimaryColor.brighter(), this.JoSecondaryColor.darker().darker(), this.JoSecondaryColor.darker()});
        }
        return new GradientPaint(0.0F, 0.0F, this.JoPrimaryColor, x2, y2, this.JoSecondaryColor);
    }

}
