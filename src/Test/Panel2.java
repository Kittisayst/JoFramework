/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Components.JoButton;

public class Panel2 extends javax.swing.JPanel {

    public Panel2(String tile) {
        initComponents();
        joLable1.setText(tile);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        joLable1 = new Components.JoLable();
        joButton1 = new Components.JoButton();

        setBackground(new java.awt.Color(255, 204, 153));

        joLable1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        joLable1.setText("View 2");

        joButton1.setText("joButton1");
        joButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(joButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(112, Short.MAX_VALUE)
                .addComponent(joLable1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(joButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void joButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joButton1ActionPerformed
        joLable1.setText("OK");
    }//GEN-LAST:event_joButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.JoButton joButton1;
    private Components.JoLable joLable1;
    // End of variables declaration//GEN-END:variables

    public JoButton getJoButton1() {
        return joButton1;
    }

}
