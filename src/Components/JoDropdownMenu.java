package Components;

import com.xzq.osc.JocGroupPane;
import java.awt.Color;
import java.awt.Font;

public class JoDropdownMenu extends javax.swing.JPanel {

    private boolean selected;
    private String Text;
    private Color JoHover;
    private Color JoBackground;
    private Font joFontColor;
    private Alignment TextAlignment;

    public JoDropdownMenu() {
        initComponents();
        JoToggleItem.setExpanded(false);
        selected = false;
        TextAlignment = Alignment.LEFT;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JoToggleItem = new com.xzq.osc.JocGroupPane();
        jPanel1 = new javax.swing.JPanel();
        JoToggleUI = new Components.JoToggleButton();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout(0, 1));

        JoToggleItem.setDrawBorder(false);
        JoToggleItem.setTitleBarVisible(false);
        JoToggleItem.setLayout(new java.awt.GridLayout(0, 1, 0, 1));
        add(JoToggleItem, java.awt.BorderLayout.CENTER);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        JoToggleUI.setText("joToggleButton1");
        JoToggleUI.setBorderPainted(false);
        JoToggleUI.setContentAreaFilled(false);
        JoToggleUI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JoToggleUI.setPreferredSize(new java.awt.Dimension(150, 45));
        JoToggleUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoToggleUIActionPerformed(evt);
            }
        });
        jPanel1.add(JoToggleUI, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void JoToggleUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoToggleUIActionPerformed
        JoToggleItem.setExpanded(JoToggleUI.isSelected());
    }//GEN-LAST:event_JoToggleUIActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.xzq.osc.JocGroupPane JoToggleItem;
    private Components.JoToggleButton JoToggleUI;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean ActiveMenu) {
        this.selected = ActiveMenu;
    }

    public JocGroupPane getJoToggleItem() {
        return JoToggleItem;
    }

    public String getText() {
        return Text;
    }

    public void setText(String Text) {
        this.Text = Text;
        JoToggleUI.setText(Text);
    }

    public Color getJoHover() {
        return JoHover;
    }

    public void setJoHover(Color JoHover) {
        this.JoHover = JoHover;
        JoToggleUI.setJoHoverColor(JoHover);
    }

    public Color getJoBackground() {
        return JoBackground;
    }

    public void setJoBackground(Color JoBackground) {
        this.JoBackground = JoBackground;
        JoToggleUI.setBackground(JoHover);
    }

    public Font getJoFontColor() {
        return joFontColor;
    }

    public void setJoFontColor(Font joFontColor) {
        this.joFontColor = joFontColor;
        JoToggleUI.setForeground(JoHover);

    }

    public Alignment getTextAlignment() {
        return TextAlignment;
    }

    public void setTextAlignment(Alignment TextAlignment) {
        this.TextAlignment = TextAlignment;
        switch (TextAlignment) {
            case LEFT:
                JoToggleUI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                break;
            case RIGHT:
                JoToggleUI.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                break;
            case CENTER:
                JoToggleUI.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                break;
            default:
                JoToggleUI.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                break;
        }
    }

    public enum Alignment {
        LEFT,
        RIGHT,
        CENTER
    }

}
