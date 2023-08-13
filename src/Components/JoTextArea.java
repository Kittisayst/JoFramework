package Components;

import Tools.JoAlert;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextArea;
import theme.JoFont;
import theme.JoTheme;

public class JoTextArea extends JTextArea {

    private boolean joLineUI = true;
    private int joLineSize = 3;
    private Color joLineColor = JoTheme.Primary;
    private Color joLineHover = JoTheme.HoverColor;

    public JoTextArea() {
        crateLineUI();
        setFont(JoFont.font);
    }

    public boolean TextEmpty() {
        JoAlert alert = new JoAlert();
        if (getText().equals("")) {
            alert.messages("ຂໍ້ມຸນບໍ່ຄົບຖ້ວນ", "ກະລຸນາປ້ອນຂໍ້ມູນໃຫ້ຄົບຖ້ວນ", JoAlert.Icons.info);
            requestFocus();
            if (joLineUI) {
                setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, joLineSize, 0, JoTheme.Danger));
            }
            return false;
        } else {
            return true;
        }
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

    public void setEmpty() {
        this.setText("");
    }

    public void setEmptyFocus() {
        this.setText("");
        this.requestFocus();
    }

    public boolean isJoLineUI() {
        return joLineUI;
    }

    public void setJoLineUI(boolean joLineUI) {
        this.joLineUI = joLineUI;
    }

    public int getJoLineSize() {
        return joLineSize;
    }

    public void setJoLineSize(int joLineSize) {
        this.joLineSize = joLineSize;
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

}
