
package Components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Kittisay
 */
public class JoBarChart extends JPanel {

    private DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    private String BTitle = "ຫົວຂໍ້";
    private String BcatTitle = "ປະເພດລາຍການ";
    private String BvalueTitle = "ລະດັບ";
    private Font BTitleFont = new Font("Phetsarath OT", Font.PLAIN, 18);
    private Font BcatTitleFont = new Font("Phetsarath OT", Font.PLAIN, 14);
    private Font BvalueTitleFont = new Font("Phetsarath OT", Font.PLAIN, 14);
    private PlotOrientation BarDirection = PlotOrientation.VERTICAL;
    private MyDirection BDirection = MyDirection.VERTICAL;
    private Color BColor = new Color(255, 255, 255);

    public JoBarChart() {
        setPreferredSize(new Dimension(300, 300));
        ShowBarChart();
    }

    private void ShowBarChart() {
        JFreeChart barChart = ChartFactory.createBarChart(
                BTitle,
                BcatTitle,
                BvalueTitle,
                dataset,
                BarDirection,
                true, true, false);
        barChart.getTitle().setFont(BTitleFont);
        barChart.getLegend().setItemFont(BcatTitleFont);
        barChart.getPlot().setBackgroundPaint(BColor);

        CategoryPlot plot = (CategoryPlot) barChart.getCategoryPlot();
        CategoryAxis axis = plot.getDomainAxis();
        axis.setTickLabelFont(BcatTitleFont);

        plot.getDomainAxis().setLabelFont(BcatTitleFont);
        plot.getRangeAxis().setLabelFont(BvalueTitleFont);
        plot.setOutlineVisible(false);
        plot.setNoDataMessageFont(BTitleFont);
        plot.setNoDataMessage("ບໍ່ມີຂໍ້ມູນ");

        ChartPanel chartpn = new ChartPanel(barChart);
        chartpn.getChart().setBackgroundPaint(BColor);
        removeAll();
        setLayout(new java.awt.GridLayout());
        add(chartpn);
    }

    public DefaultCategoryDataset getDataset() {
        return dataset;
    }

    public void setDataset(DefaultCategoryDataset dataset) {
        this.dataset = dataset;
    }

    public String getBTitle() {
        return BTitle;
    }

    public void setBTitle(String BTitle) {
        this.BTitle = BTitle;
        ShowBarChart();
    }

    public String getBcatTitle() {
        return BcatTitle;
    }

    public void setBcatTitle(String BcatTitle) {
        this.BcatTitle = BcatTitle;
        ShowBarChart();
    }

    public String getBvalueTitle() {
        return BvalueTitle;
    }

    public void setBvalueTitle(String BvalueTitle) {
        this.BvalueTitle = BvalueTitle;
        ShowBarChart();
    }

    public MyDirection getBDirection() {
        return BDirection;
    }

    public void setBDirection(MyDirection BDirection) {
        if (BDirection == MyDirection.VERTICAL) {
            BarDirection = PlotOrientation.VERTICAL;
            ShowBarChart();
        } else {
            BarDirection = PlotOrientation.HORIZONTAL;
            ShowBarChart();
        }
        this.BDirection = BDirection;
    }

    public Font getBTitleFont() {
        return BTitleFont;
    }

    public void setBTitleFont(Font BTitleFont) {
        this.BTitleFont = BTitleFont;
        ShowBarChart();
    }

    public Font getBcatTitleFont() {
        return BcatTitleFont;
    }

    public void setBcatTitleFont(Font BcatTitleFont) {
        this.BcatTitleFont = BcatTitleFont;
        ShowBarChart();
    }

    public Font getBvalueTitleFont() {
        return BvalueTitleFont;
    }

    public void setBvalueTitleFont(Font BvalueTitleFont) {
        this.BvalueTitleFont = BvalueTitleFont;
        ShowBarChart();
    }

    public enum MyDirection {
        VERTICAL,
        HORIZONTAL
    }

    public Color getBColor() {
        return BColor;
    }

    public void setBColor(Color BColor) {
        this.BColor = BColor;
        ShowBarChart();
    }

}
