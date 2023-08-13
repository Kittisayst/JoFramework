package Components;

import Tools.JoAlert;
import Tools.JoTooltip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPasswordField;
import javax.swing.JToolTip;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import theme.JoTheme;

/**
 *
 * @author Kittisay
 */
public final class JoPasswordField extends JPasswordField {

    private THEMETOOLTIP themeTooltip = THEMETOOLTIP.DARK;

    private int round = 5;
    private int intensity = 0;
    private int pixels = 0;
    private Color bgShade = new Color(0, 0, 0);
    private Color bgShadeHover = new Color(0, 112, 192);
    private String placeholder = "";
    private Color phColor = JoTheme.Primary;
    private boolean band = true;
    Shape shape;
    private String toolTipTheme;
    private boolean showPassword = false;

    private boolean joLineUI = true;
    private Color joLineColor = JoTheme.Primary;
    private Color joLineHover = JoTheme.HoverColor;
    private int joLineSize = 2;

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
        for (int i = 0; i < this.pixels; i++) {
            if (isFocusOwner()) {
                g2.setColor(new Color(this.bgShadeHover.getRed(), this.bgShadeHover.getGreen(), this.bgShadeHover.getBlue(), this.intensity * i));
            } else {
                g2.setColor(new Color(this.bgShade.getRed(), this.bgShade.getGreen(), this.bgShade.getBlue(), this.intensity * i));
            }
            g2.fill(new RoundRectangle2D.Float(i, i, (getWidth() - i * 2), (getHeight() - i * 2), this.round, this.round));
        }
        repaint();
        int offset_lr = this.pixels + this.pixels;
        int offset_td = this.pixels + this.pixels;
        if (isEnabled()) {
            g.setColor(getBackground());
        } else {
            g.setColor(new Color(204, 204, 204));
            setBgShade(Color.BLACK);
        }
        g2.fill(new RoundRectangle2D.Float(this.pixels, this.pixels, (getWidth() - offset_lr), (getHeight() - offset_td), this.round, this.round));
        g.setColor(new Color(this.phColor.getRed(), this.phColor.getGreen(), this.phColor.getBlue(), 90));
        if (!isFocusOwner()) {
            g.drawString(this.band ? this.placeholder : "", 10,
                    (getSize()).height / 2 + getFont().getSize() / 2);
        }
        super.paintComponent(g);
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

    public boolean TextEmpty() {
        if (getText().equals("")) {
            new JoAlert().messages("ຄຳເຕືອນ", "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບຖ້ວນ", "warning");
            requestFocus();
            if (joLineUI) {
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, JoTheme.Danger));
            }
            return false;
        } else {
            return true;
        }
    }

    public JoPasswordField() {
        this.toolTipTheme = "dark";
        crateLineUI();
        setFont(new java.awt.Font("Segoe UI Emoji", 0, 12)); // NOI18N
        setPreferredSize(new Dimension(200, 40));
        setSize(new Dimension(200, 40));
        setBackground(Color.WHITE);
        setForeground(Color.BLACK);
        setCursor(new Cursor(2));
        setPhColor(getForeground());
        setMargin(new Insets(2, 10, 2, 10));
        setBgShade(new Color(102, 102, 102));
        getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void removeUpdate(DocumentEvent e) {
                JoPasswordField.this.band = (JoPasswordField.this.getText().length() <= 0);
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                JoPasswordField.this.band = false;
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
            }
        });
        setPlaceholder("JoPasswordField");
    }

    @Override
    public JToolTip createToolTip() {
        if (getThemeTooltip() == THEMETOOLTIP.DARK) {
            this.toolTipTheme = "dark";
        }
        if (getThemeTooltip() == THEMETOOLTIP.LIGHT) {
            this.toolTipTheme = "light";
        }
        if (getThemeTooltip() == THEMETOOLTIP.BLUE) {
            this.toolTipTheme = "blue";
        }
        return (JToolTip) new JoTooltip(this, this.toolTipTheme);
    }

    private void crateLineUI() {
        if (joLineUI) {
            setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, joLineColor));
            addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (!getText().equals("")) {
                        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, joLineHover));
                    }
                    super.focusGained(e);
                }

                @Override
                public void focusLost(FocusEvent e) {
                    setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, joLineColor));
                    super.focusLost(e);
                }
            });

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (!getText().equals("")) {
                        setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, joLineHover));
                    }
                    super.keyReleased(e);
                }
            });
        } else {
            setBorder(null);
        }
    }

    public enum THEMETOOLTIP {
        DARK, LIGHT, BLUE;
    }

    public THEMETOOLTIP getThemeTooltip() {
        return this.themeTooltip;
    }

    public void setThemeTooltip(THEMETOOLTIP themeTooltip) {
        this.themeTooltip = themeTooltip;
    }

    public int getRound() {
        return this.round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public Color getBgShade() {
        return this.bgShade;
    }

    public void setBgShade(Color bgShade) {
        this.bgShade = bgShade;
    }

    public int getIntensity() {
        return this.intensity;
    }

    public void setIntensity(int intensity) {
        this.intensity = intensity;
    }

    public int getPixels() {
        return this.pixels;
    }

    public void setPixels(int pixels) {
        this.pixels = pixels;
    }

    public Color getBgShadeHover() {
        return this.bgShadeHover;
    }

    public void setBgShadeHover(Color bgShadeHover) {
        this.bgShadeHover = bgShadeHover;
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Color getPhColor() {
        return this.phColor;
    }

    public void setPhColor(Color phColor) {
        this.phColor = phColor;
    }

    public void setEmpty() {
        this.setText("");
    }

    public void setEmptyFocus() {
        this.setText("");
        this.requestFocus();
    }

    public boolean isShowPassword() {
        return showPassword;
    }

    public void setShowPassword(boolean showPassword) {
        this.showPassword = showPassword;
        if (showPassword) {
            setEchoChar((char) 0);
        } else {
            setEchoChar('\u25cf');
        }
    }

    public boolean isJoLineUI() {
        return joLineUI;
    }

    public void setJoLineUI(boolean joLineUI) {
        this.joLineUI = joLineUI;
        crateLineUI();
    }

    public Color getJoLineColor() {
        return joLineColor;
    }

    public void setJoLineColor(Color joLineColor) {
        this.joLineColor = joLineColor;
        crateLineUI();
    }

    public Color getJoLineHover() {
        return joLineHover;
    }

    public void setJoLineHover(Color joLineHover) {
        this.joLineHover = joLineHover;
        crateLineUI();
    }

    public int getJoLineSize() {
        return joLineSize;
    }

    public void setJoLineSize(int joLineSize) {
        this.joLineSize = joLineSize;
        crateLineUI();
    }

}
