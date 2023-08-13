package Components;

import Chart.PieChartUI;
import Chart.PieChartUIModel;
import java.awt.Color;

public class JoPieChartUI extends javax.swing.JPanel {

    private String ChartTitle = "Title";

    public JoPieChartUI() {
        initComponents();
        InitUI();
    }

    private void InitUI() {
        lbl_Title.setText(ChartTitle);
        pieChartUI1.setChartType(PieChartUI.PeiChartType.DONUT_CHART);
        pieChartUI1.addData(new PieChartUIModel("ສະແດງ", 150, new Color(23, 126, 238)));
        pieChartUI1.addData(new PieChartUIModel("ABC", 100, new Color(221, 65, 65)));
        pieChartUI1.addData(new PieChartUIModel("Coca", 1, new Color(47, 157, 64)));
        pieChartUI1.addData(new PieChartUIModel("Vita", 60, new Color(196, 151, 58)));
    }

    public String getChartTitle() {
        return ChartTitle;
    }

    public void setChartTitle(String ChartTitle) {
        this.ChartTitle = ChartTitle;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Title = new Components.JoLable();
        pieChartUI1 = new Chart.PieChartUI();

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        lbl_Title.setText("joLable1");
        jPanel1.add(lbl_Title);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
            .addComponent(pieChartUI1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieChartUI1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private Components.JoLable lbl_Title;
    private Chart.PieChartUI pieChartUI1;
    // End of variables declaration//GEN-END:variables

}
