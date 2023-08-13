package Notification;

import Tools.JoIconFont;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import theme.MyColor;

public class JoNotification extends javax.swing.JComponent {

    private JDialog dialog;
    private Animator animator;
    private final Frame fram;
    private boolean showing;
    private Thread thread;
    private final int animate = 10;
    private BufferedImage imageShadow;
    private final int shadowSize = 6;
    private final Type type;
    private final Location location;

    public JoNotification(Frame fram, Type type, Location location, String message) {
        this.fram = fram;
        this.type = type;
        this.location = location;
        initComponents();
        init(message);
        initAnimator();
    }

    private void init(String message) {
        JoIconFont iconFont = new JoIconFont();
        int iconsize = 50;
        setBackground(Color.WHITE);
        dialog = new JDialog(fram);
        dialog.setUndecorated(true);
        dialog.setFocusableWindowState(false);
        dialog.setBackground(new Color(0, 0, 0, 0));
        dialog.add(this);
        dialog.setSize(getPreferredSize());
        if (null == type) {
            lbl_icon.setIcon(iconFont.setIconFont(GoogleMaterialDesignIcons.ERROR_OUTLINE, iconsize, MyColor.yellow300));
            lbMessage.setText("Warning");
        } else {
            switch (type) {
                case SUCCESS:
                    lbl_icon.setIcon(iconFont.setIconFont(FontAwesome.CHECK_CIRCLE_O, iconsize, MyColor.green200));
                    lbMessage.setText("Success");
                    break;
                case INFO:
                    lbl_icon.setIcon(iconFont.setIconFont(GoogleMaterialDesignIcons.INFO_OUTLINE, iconsize, MyColor.cyan200));
                    lbMessage.setText("Info");
                    break;
                default:
                    lbl_icon.setIcon(iconFont.setIconFont(GoogleMaterialDesignIcons.ERROR_OUTLINE, iconsize, MyColor.yellow300));
                    lbMessage.setText("Warning");
                    break;
            }
        }
        lbMessageText.setText(message);
    }

    private void initAnimator() {
        TimingTarget target = new TimingTargetAdapter() {
            private int x;
            private int top;
            private boolean top_to_bot;

            @Override
            public void timingEvent(float fraction) {
                if (showing) {
                    float alpha = 1f - fraction;
                    int y = (int) ((1f - fraction) * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                } else {
                    float alpha = fraction;
                    int y = (int) (fraction * animate);
                    if (top_to_bot) {
                        dialog.setLocation(x, top + y);
                    } else {
                        dialog.setLocation(x, top - y);
                    }
                    dialog.setOpacity(alpha);
                }
            }

            @Override
            public void begin() {
                if (!showing) {
                    dialog.setOpacity(0f);
                    int margin = 10;
                    int y = 0;
                    if (null == location) {
                        x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                        y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                        top_to_bot = true;
                    } else {
                        switch (location) {
                            case TOP_CENTER:
                                x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                                y = fram.getY();
                                top_to_bot = true;
                                break;
                            case TOP_RIGHT:
                                x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                                y = fram.getY();
                                top_to_bot = true;
                                break;
                            case TOP_LEFT:
                                x = fram.getX() + margin;
                                y = fram.getY();
                                top_to_bot = true;
                                break;
                            case BOTTOM_CENTER:
                                x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                                y = fram.getY() + fram.getHeight() - dialog.getHeight();
                                top_to_bot = false;
                                break;
                            case BOTTOM_RIGHT:
                                x = fram.getX() + fram.getWidth() - dialog.getWidth() - margin;
                                y = fram.getY() + fram.getHeight() - dialog.getHeight();
                                top_to_bot = false;
                                break;
                            case BOTTOM_LEFT:
                                x = fram.getX() + margin;
                                y = fram.getY() + fram.getHeight() - dialog.getHeight();
                                top_to_bot = false;
                                break;
                            default:
                                x = fram.getX() + ((fram.getWidth() - dialog.getWidth()) / 2);
                                y = fram.getY() + ((fram.getHeight() - dialog.getHeight()) / 2);
                                top_to_bot = true;
                                break;
                        }
                    }
                    top = y;
                    dialog.setLocation(x, y);
                    dialog.setVisible(true);
                }
            }

            @Override
            public void end() {
                showing = !showing;
                if (showing) {
                    thread = new Thread(() -> {
                        sleep();
                        closeNotification();
                    });
                    thread.start();
                } else {
                    dialog.dispose();
                }
            }
        };
        animator = new Animator(500, target);
        animator.setResolution(5);
    }

    public void showNotification() {
        animator.start();
    }

    private void closeNotification() {
        if (thread != null && thread.isAlive()) {
            thread.interrupt();
        }
        if (animator.isRunning()) {
            if (!showing) {
                animator.stop();
                showing = true;
                animator.start();
            }
        } else {
            showing = true;
            animator.start();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paint(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawImage(imageShadow, 0, 0, null);
        int x = shadowSize;
        int y = shadowSize;
        int width = getWidth() - shadowSize * 2;
        int height = getHeight() - shadowSize * 2;
        g2.fillRect(x, y, width, height);
        if (null == type) {
            g2.setColor(new Color(241, 196, 15));
        } else {
            switch (type) {
                case SUCCESS:
                    g2.setColor(new Color(18, 163, 24));
                    break;
                case INFO:
                    g2.setColor(new Color(28, 139, 206));
                    break;
                default:
                    g2.setColor(new Color(241, 196, 15));
                    break;
            }
        }
        g2.fillRect(6, 5, 5, getHeight() - shadowSize * 2 + 1);
        g2.dispose();
        super.paint(grphcs);
    }

    @Override
    public void setBounds(int i, int i1, int i2, int i3) {
        super.setBounds(i, i1, i2, i3);
        createImageShadow();
    }

    private void createImageShadow() {
        imageShadow = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
        g2.drawImage(createShadow(), 0, 0, null);
        g2.dispose();
    }

    private BufferedImage createShadow() {
        BufferedImage img = new BufferedImage(getWidth() - shadowSize * 2, getHeight() - shadowSize * 2, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.fillRect(0, 0, img.getWidth(), img.getHeight());
        g2.dispose();
        return new ShadowRenderer(shadowSize, 0.3f, new Color(100, 100, 100)).createShadow(img);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joButtonIconfont1 = new Components.JoButtonIconfont();
        panel = new javax.swing.JPanel();
        lbMessage = new Components.JoLable();
        lbMessageText = new Components.JoLable();
        lbl_icon = new Components.JoLableIcon();
        cmdClose = new Components.JoButtonIconfont();

        joButtonIconfont1.setText("joButtonIconfont1");

        panel.setOpaque(false);

        lbMessage.setText("Message");
        lbMessage.setFont(new java.awt.Font("Phetsarath OT", 1, 14)); // NOI18N

        lbMessageText.setText("Text");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbMessage, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                    .addComponent(lbMessageText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(113, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(lbMessageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        cmdClose.setBackground(getBackground());
        cmdClose.setJoIconColor(new java.awt.Color(102, 102, 102));
        cmdClose.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOSE);
        cmdClose.setJocolorHover(getBackground());
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lbl_icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmdClose, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdClose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        closeNotification();
    }//GEN-LAST:event_cmdCloseActionPerformed

    public static enum Type {
        SUCCESS, INFO, WARNING
    }

    public static enum Location {
        TOP_CENTER, TOP_RIGHT, TOP_LEFT, BOTTOM_CENTER, BOTTOM_RIGHT, BOTTOM_LEFT, CENTER
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButtonIconfont cmdClose;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoLable lbMessage;
    private Components.JoLable lbMessageText;
    private Components.JoLableIcon lbl_icon;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
