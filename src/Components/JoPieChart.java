
package Components;



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Kittisay
 */
public class JoPieChart extends JPanel {

    private DefaultPieDataset Pdata = new DefaultPieDataset();
    private String Ptitle = "Pie Title";
    private Font PTitleFont = new Font("Phetsarath OT", Font.PLAIN, 18);
    private Font PLableFont = new Font("Phetsarath OT", Font.PLAIN, 10);
    private Font PLegendFont = new Font("Phetsarath OT", Font.PLAIN, 10);
    private Color PLineColor = new Color(0, 0, 0);
    private Color PLableColor = new Color(255, 255, 255);
    private Color PColor = new Color(255, 255, 255);
    private boolean PLine = false;

    public JoPieChart() {
        setPreferredSize(new Dimension(300, 300));
        ShowPie();
    }

    private void ShowPie() {
        JFreeChart chart = ChartFactory.createPieChart(
                Ptitle,
                Pdata,
                true, //ຄຳອະທິບາຍ
                true, // tooltips?
                false); // URLs?
        chart.setBackgroundPaint(PColor);
        chart.getPlot().setBackgroundPaint(PColor);
//        chart.getPlot().setOutlineVisible(false);
        chart.setAntiAlias(true);
        chart.getTitle().setFont(PTitleFont);
        chart.getLegend().setItemFont(PLegendFont);
        PiePlot plot = (PiePlot) chart.getPlot();
        if (!PLine) {
            plot.setLabelGenerator(null);
        }
        plot.setLabelFont(PLableFont);
        plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
        plot.setLabelLinkPaint(PLineColor);
        plot.setLabelBackgroundPaint(PLableColor);
        plot.setOutlineVisible(false);
        plot.setShadowPaint(null);
        plot.setNoDataMessageFont(PTitleFont);
        plot.setNoDataMessage("ບໍ່ມີຂໍ້ມູນ");
        ChartPanel chartpn = new ChartPanel(chart);
        chartpn.getChart().setBackgroundPaint(PColor);
        removeAll();
        setLayout(new java.awt.GridLayout());
        add(chartpn);
//        validate();
    }

    public DefaultPieDataset getPdata() {
        return Pdata;
    }

    public void setPdata(DefaultPieDataset Pdata) {
        this.Pdata = Pdata;
    }

    public String getPtitle() {
        return Ptitle;
    }

    public void setPtitle(String Ptitle) {
        this.Ptitle = Ptitle;
        ShowPie();
    }

    public Font getPTitleFont() {
        return PTitleFont;
    }

    public void setPTitleFont(Font PTitleFont) {
        this.PTitleFont = PTitleFont;
        ShowPie();
    }

    public Font getPLableFont() {
        return PLableFont;
    }

    public void setPLableFont(Font PLableFont) {
        this.PLableFont = PLableFont;
        ShowPie();
    }

    public Font getPLegendFont() {
        return PLegendFont;
    }

    public void setPLegendFont(Font PLegendFont) {
        this.PLegendFont = PLegendFont;
        ShowPie();
    }

    public Color getPLineColor() {
        return PLineColor;
    }

    public void setPLineColor(Color PLineColor) {
        this.PLineColor = PLineColor;
        ShowPie();
    }

    public Color getPLableColor() {
        return PLableColor;
    }

    public void setPLableColor(Color PLableColor) {
        this.PLableColor = PLableColor;
        ShowPie();
    }

    public Color getPColor() {
        return PColor;
    }

    public void setPColor(Color PColor) {
        this.PColor = PColor;
        ShowPie();
    }

    public boolean isPLine() {
        return PLine;
    }

    public void setPLine(boolean PLine) {
        this.PLine = PLine;
        ShowPie();
    }

}
