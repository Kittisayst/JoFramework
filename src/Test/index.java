package Test;

import Components.JoScrollBar;
import Tools.JoAlert;
import Tools.JoFrameDesign;
import theme.JoFont;
import theme.JoTheme;

public class index extends javax.swing.JFrame {

    public index() {
        initComponents();
        new JoAlert().messages("ok");
        JoFrameDesign FrameDesign = new JoFrameDesign(this);
        FrameDesign.removeBackground();
        FrameDesign.setMoving(jPanel2);
        FrameDesign.setJoUI();

        joLable1.setFont(new JoFont().loadJoFont(JoFont.fs_bold, 40));
        joLable2.setFont(new JoFont().loadJoFont(JoFont.fs_bold, 50));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        jScrollPane1.setVerticalScrollBar(new JoScrollBar());
        joPieChart1.getPdata().setValue("Data 1", 10);
        joPieChart1.getPdata().setValue("Data 2", 20);
        joPieChart1.getPdata().setValue("Data 3", 30);
        joPieChart1.getPdata().setValue("Data 4", 40);
        joPieChart1.getPdata().setValue("Data 5", 50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_Content = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        joLable1 = new Components.JoLable();
        joLable2 = new Components.JoLable();
        joLable3 = new Components.JoLable();
        jScrollPane2 = new javax.swing.JScrollPane();
        joTextArea1 = new Components.JoTextArea();
        joCombobox2 = new Components.JoCombobox();
        joCombobox3 = new Components.JoCombobox();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        joLabelImage1 = new Components.JoLabelImage();
        joButtonIconfont2 = new Components.JoButtonIconfont();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        joPanel1 = new Components.JoPanel();
        joButton1 = new Components.JoButton();
        joButtonIconfont1 = new Components.JoButtonIconfont();
        joCombobox1 = new Components.JoCombobox();
        joDateChooser1 = new Components.JoDateChooser();
        joImageAvatar1 = new Components.JoImageAvatar();
        joLabelImage2 = new Components.JoLabelImage();
        joLableIcon1 = new Components.JoLableIcon();
        joLiquidProgress1 = new Components.JoLiquidProgress();
        joPanel2 = new Components.JoPanel();
        joPasswordField1 = new Components.JoPasswordField();
        joTextField1 = new Components.JoTextField();
        joPieChart1 = new Components.JoPieChart();
        jScrollPane3 = new javax.swing.JScrollPane();
        joTable1 = new Components.JoTable();
        joButton2 = new Components.JoButton();
        joButton3 = new Components.JoButton();
        joButton4 = new Components.JoButton();
        joRouter1 = new Components.JoRouter();
        joButton5 = new Components.JoButton();
        joButton6 = new Components.JoButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pn_Content.setBackground(new java.awt.Color(243, 246, 249));
        pn_Content.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 0, new java.awt.Color(0, 0, 0)));
        pn_Content.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        joLable1.setText("JoFrameWork ການອອກແບບ UI ທີ່ງ່າຍ ແລະ ວ່ອງໄວ");

        joLable2.setForeground(new java.awt.Color(0, 122, 245));
        joLable2.setText("UI library you");

        joLable3.setText("always wanted");
        joLable3.setFont(new java.awt.Font("Roboto", 1, 40)); // NOI18N

        jScrollPane2.setBorder(null);

        joTextArea1.setEditable(false);
        joTextArea1.setText("JoFrameWork MUI provides a robust, customizable, and accessible \nlibrary of foundational and advanced components, enabling you to \nbuild your owndesign system and develop React applications faster.");
        joTextArea1.setWrapStyleWord(true);
        jScrollPane2.setViewportView(joTextArea1);

        joCombobox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ໄກ", "ຫຽນ", "ໂອ", "ອານ" }));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(joCombobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(joCombobox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(joLable2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(joLable3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joCombobox2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joCombobox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pn_Content.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        joLabelImage1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resource/Icon-Logo.png"))); // NOI18N
        joLabelImage1.setIconGrap(2);
        jPanel2.add(joLabelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 0, 45, 45));

        joButtonIconfont2.setJoIconSize(25);
        joButtonIconfont2.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOSE);
        joButtonIconfont2.setJoRound(30);
        joButtonIconfont2.setJocolorHover(new java.awt.Color(255, 97, 97));
        joButtonIconfont2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButtonIconfont2ActionPerformed(evt);
            }
        });
        jPanel2.add(joButtonIconfont2, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 6, 30, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(0, 0, 0)));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jPanel4.setBackground(new java.awt.Color(243, 246, 249));

        joButton1.setText("Button");
        joButton1.setJoRound(10);
        joButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton1ActionPerformed(evt);
            }
        });

        joButtonIconfont1.setText("ButtonIcon");

        joCombobox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" }));

        javax.swing.GroupLayout joPanel1Layout = new javax.swing.GroupLayout(joPanel1);
        joPanel1.setLayout(joPanel1Layout);
        joPanel1Layout.setHorizontalGroup(
            joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(joCombobox1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(joPanel1Layout.createSequentialGroup()
                        .addComponent(joButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(joButtonIconfont1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(joDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(54, Short.MAX_VALUE))
        );
        joPanel1Layout.setVerticalGroup(
            joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, joPanel1Layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(joCombobox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(joDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(joPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joButtonIconfont1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        joLableIcon1.setText("joLableIcon1");

        joLiquidProgress1.setBorder(null);
        joLiquidProgress1.setValue(44);

        javax.swing.GroupLayout joPanel2Layout = new javax.swing.GroupLayout(joPanel2);
        joPanel2.setLayout(joPanel2Layout);
        joPanel2Layout.setHorizontalGroup(
            joPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        joPanel2Layout.setVerticalGroup(
            joPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        joTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", null, null, null},
                {"2", null, null, null},
                {"3", null, null, null},
                {"4", null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(joTable1);

        joButton2.setText("show 1");
        joButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton2ActionPerformed(evt);
            }
        });

        joButton3.setText("show 2");
        joButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton3ActionPerformed(evt);
            }
        });

        joButton4.setText("show 3");
        joButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton4ActionPerformed(evt);
            }
        });

        joButton5.setText("joButton5");
        joButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton5ActionPerformed(evt);
            }
        });

        joButton6.setText("joButton6");
        joButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(joButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 20, Short.MAX_VALUE)
                        .addComponent(joButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 21, Short.MAX_VALUE)
                        .addComponent(joButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(joButton6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joButton5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joRouter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joPieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(joImageAvatar1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(joLableIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(joLabelImage2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(joLiquidProgress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(joPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
                            .addComponent(joPasswordField1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(joPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(joPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(joImageAvatar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLabelImage2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joLableIcon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(joLiquidProgress1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(joPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joPieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(joButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(171, 171, 171)
                .addComponent(joRouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(joButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(joButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_Content, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane1))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pn_Content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        setSize(new java.awt.Dimension(938, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void joButtonIconfont2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButtonIconfont2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_joButtonIconfont2ActionPerformed

    private void joButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton2ActionPerformed
//        joRouterPanel1.setRouter(new Panel1(), "1");
//        joRouter1.setRouter(new Panel1(), "A");
    }//GEN-LAST:event_joButton2ActionPerformed

    private void joButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton3ActionPerformed
//        joRouterPanel1.setRouter(new Panel2("router 2"), "2");
//        joRouter1.setRouter(new Panel2("Router 2"), "B");
    }//GEN-LAST:event_joButton3ActionPerformed

    private void joButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton4ActionPerformed
//        joRouterPanel1.setRouter(new Panel3(), "3");
//        joRouter1.setRouter(new Panel3(), "C");
    }//GEN-LAST:event_joButton4ActionPerformed

    private void joButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton5ActionPerformed

    }//GEN-LAST:event_joButton5ActionPerformed

    private void joButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton6ActionPerformed
//        joRouter1.getRouterPrevious();
    }//GEN-LAST:event_joButton6ActionPerformed

    private void joButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton1ActionPerformed
        joDateChooser1.setDateData("2022-01-20");
    }//GEN-LAST:event_joButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new JoTheme().setLookUI();
            new index().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private Components.JoButton joButton1;
    private Components.JoButton joButton2;
    private Components.JoButton joButton3;
    private Components.JoButton joButton4;
    private Components.JoButton joButton5;
    private Components.JoButton joButton6;
    private Components.JoButtonIconfont joButtonIconfont1;
    private Components.JoButtonIconfont joButtonIconfont2;
    private Components.JoCombobox joCombobox1;
    private Components.JoCombobox joCombobox2;
    private Components.JoCombobox joCombobox3;
    private Components.JoDateChooser joDateChooser1;
    private Components.JoImageAvatar joImageAvatar1;
    private Components.JoLabelImage joLabelImage1;
    private Components.JoLabelImage joLabelImage2;
    private Components.JoLable joLable1;
    private Components.JoLable joLable2;
    private Components.JoLable joLable3;
    private Components.JoLableIcon joLableIcon1;
    private Components.JoLiquidProgress joLiquidProgress1;
    private Components.JoPanel joPanel1;
    private Components.JoPanel joPanel2;
    private Components.JoPasswordField joPasswordField1;
    private Components.JoPieChart joPieChart1;
    private Components.JoRouter joRouter1;
    private Components.JoTable joTable1;
    private Components.JoTextArea joTextArea1;
    private Components.JoTextField joTextField1;
    private javax.swing.JPanel pn_Content;
    // End of variables declaration//GEN-END:variables
}
