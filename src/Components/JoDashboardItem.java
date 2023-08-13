package Components;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.JoTheme;

public class JoDashboardItem extends javax.swing.JPanel {

    private GoogleMaterialDesignIcons Icon = GoogleMaterialDesignIcons.ACCESSIBILITY;
    private Color itemForeground = Color.WHITE;
    private Color itemBackground = JoTheme.Primary;
    private String itemTitle = "Title";
    private String itemDetail = "Detail";
    private String ItemMore = "More";

    public JoDashboardItem() {
        initComponents();
        lbl_icon.setJoIconColor(pn_Main.getJoPrimaryColor().darker());
        pn_Hover.setBackground(pn_Main.getJoPrimaryColor().darker());
        pn_Hover.setCursor(new Cursor(Cursor.HAND_CURSOR) {
        });
        pn_Hover.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pn_Hover.setBackground(pn_Main.getJoPrimaryColor().brighter());
                lbl_icon.setJoIconSize(lbl_icon.getJoIconSize() + 5);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                pn_Hover.setBackground(pn_Main.getJoPrimaryColor().darker());
                lbl_icon.setJoIconSize(lbl_icon.getJoIconSize() - 5);
                super.mouseExited(e);
            }
        });

        pn_Main.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_icon.setJoIconSize(lbl_icon.getJoIconSize() + 5);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_icon.setJoIconSize(lbl_icon.getJoIconSize() - 5);
                super.mouseExited(e);
            }

        });
    }

    public Color getItemBackground() {
        return itemBackground;
    }

    public void setItemBackground(Color itemBackground) {
        this.itemBackground = itemBackground;
        pn_Main.setJoPrimaryColor(itemBackground);
        pn_Main.setJoSecondaryColor(itemBackground);
        pn_Hover.setBackground(itemBackground.darker());
    }

    public GoogleMaterialDesignIcons getIcon() {
        return Icon;
    }

    public void setIcon(GoogleMaterialDesignIcons Icon) {
        this.Icon = Icon;
        lbl_icon.setJoIcons(Icon);
    }

    public Color getItemForeground() {
        return itemForeground;
    }

    public void setItemForeground(Color itemForeground) {
        this.itemForeground = itemForeground;
        lbl_Title.setForeground(itemForeground);
        lbl_detail.setForeground(itemForeground);
        lbl_more.setJoIconColor(itemForeground);
        lbl_more.setForeground(itemForeground);
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        lbl_Title.setText(itemTitle);
    }

    public String getItemDetail() {
        return itemDetail;
    }

    public void setItemDetail(String itemDetail) {
        this.itemDetail = itemDetail;
        lbl_detail.setText(itemDetail);
    }

    public String getItemMore() {
        return ItemMore;
    }

    public void setItemMore(String ItemMore) {
        this.ItemMore = ItemMore;
        lbl_more.setText(ItemMore);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Main = new Components.JoPanel();
        lbl_Title = new Components.JoLable();
        lbl_icon = new Components.JoLableIcon();
        lbl_detail = new Components.JoLable();
        pn_Hover = new Components.JoPanelRound();
        lbl_more = new Components.JoLableIcon();

        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        pn_Main.setJoOpacity(0);
        pn_Main.setJoPixels(0);
        pn_Main.setJoPrimaryColor(new java.awt.Color(0, 76, 202));
        pn_Main.setJoSecondaryColor(new java.awt.Color(0, 76, 202));

        lbl_Title.setForeground(new java.awt.Color(255, 255, 255));
        lbl_Title.setText("Title");
        lbl_Title.setFont(new java.awt.Font("Phetsarath OT", 0, 24)); // NOI18N

        lbl_icon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_icon.setJoIconColor(new java.awt.Color(255, 255, 255));
        lbl_icon.setJoIconSize(50);

        lbl_detail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_detail.setText("Detail");

        pn_Hover.setBackground(new java.awt.Color(0, 0, 102));
        pn_Hover.setRoundBottomLeft(8);
        pn_Hover.setRoundBottomRight(8);

        lbl_more.setForeground(new java.awt.Color(255, 255, 255));
        lbl_more.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_more.setText("More info");
        lbl_more.setJoIconColor(new java.awt.Color(255, 255, 255));
        lbl_more.setJoIconSize(22);
        lbl_more.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.PLAY_CIRCLE_FILLED);

        javax.swing.GroupLayout pn_HoverLayout = new javax.swing.GroupLayout(pn_Hover);
        pn_Hover.setLayout(pn_HoverLayout);
        pn_HoverLayout.setHorizontalGroup(
            pn_HoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbl_more, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_HoverLayout.setVerticalGroup(
            pn_HoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_HoverLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lbl_more, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout pn_MainLayout = new javax.swing.GroupLayout(pn_Main);
        pn_Main.setLayout(pn_MainLayout);
        pn_MainLayout.setHorizontalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(lbl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(pn_Hover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_MainLayout.setVerticalGroup(
            pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_MainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_MainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pn_MainLayout.createSequentialGroup()
                        .addComponent(lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_detail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbl_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pn_Hover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(pn_Main, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoLable lbl_Title;
    private Components.JoLable lbl_detail;
    private Components.JoLableIcon lbl_icon;
    private Components.JoLableIcon lbl_more;
    private Components.JoPanelRound pn_Hover;
    private Components.JoPanel pn_Main;
    // End of variables declaration//GEN-END:variables
}
