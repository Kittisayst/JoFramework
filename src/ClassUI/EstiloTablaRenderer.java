package ClassUI;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import theme.JoTheme;

public class EstiloTablaRenderer extends DefaultTableCellRenderer {
  private Component componenete;
  
  private Color colorBackgound1 = new Color(255, 255, 255);
  
  private Color colorForeground1 = JoTheme.Primary;
  
  private Color colorBackgound2 = new Color(204, 204, 204);
  
  private Color colorForeground2 = JoTheme.Secondary;
  
  private Color colorSelBackgound = JoTheme.Primary;
  
  private Color colorSelForeground = new Color(255, 255, 255);
  
  private int grosorBorde = 1;
  
  private Color colorBorde = new Color(0, 0, 0);
  
  private Font fuenteFilas = new Font("Phetsarath OT", 1, 12);
  
  private Font fuenteFilasSelect = new Font("Phetsarath OT", 1, 12);
  
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    this.componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    setHorizontalAlignment(0);
    setBorder(null);
    setBorder(BorderFactory.createMatteBorder(this.grosorBorde, this.grosorBorde, this.grosorBorde, this.grosorBorde, this.colorBorde));
    this.componenete.setFont(this.fuenteFilas);
    if (row % 2 == 0) {
      this.componenete.setForeground(this.colorForeground1);
      this.componenete.setBackground(this.colorBackgound1);
    } else {
      this.componenete.setForeground(this.colorForeground2);
      this.componenete.setBackground(this.colorBackgound2);
    } 
    if (isSelected) {
      this.componenete.setForeground(this.colorSelForeground);
      this.componenete.setBackground(this.colorSelBackgound);
      this.componenete.setFont(this.fuenteFilasSelect);
    } 
    return this.componenete;
  }
  
  public Color getColorBackgound1() {
    return this.colorBackgound1;
  }
  
  public void setColorBackgound1(Color colorBackgound1) {
    this.colorBackgound1 = colorBackgound1;
  }
  
  public Color getColorForeground1() {
    return this.colorForeground1;
  }
  
  public void setColorForeground1(Color colorForeground1) {
    this.colorForeground1 = colorForeground1;
  }
  
  public Color getColorBackgound2() {
    return this.colorBackgound2;
  }
  
  public void setColorBackgound2(Color colorBackgound2) {
    this.colorBackgound2 = colorBackgound2;
  }
  
  public Color getColorForeground2() {
    return this.colorForeground2;
  }
  
  public void setColorForeground2(Color colorForeground2) {
    this.colorForeground2 = colorForeground2;
  }
  
  public Color getColorSelBackgound() {
    return this.colorSelBackgound;
  }
  
  public void setColorSelBackgound(Color colorSelBackgound) {
    this.colorSelBackgound = colorSelBackgound;
  }
  
  public Color getColorSelForeground() {
    return this.colorSelForeground;
  }
  
  public void setColorSelForeground(Color colorSelForeground) {
    this.colorSelForeground = colorSelForeground;
  }
  
  public int getGrosorBorde() {
    return this.grosorBorde;
  }
  
  public void setGrosorBorde(int grosorBorde) {
    this.grosorBorde = grosorBorde;
  }
  
  public Color getColorBorde() {
    return this.colorBorde;
  }
  
  public void setColorBorde(Color colorBorde) {
    this.colorBorde = colorBorde;
  }
  
  public Font getFuenteFilas() {
    return this.fuenteFilas;
  }
  
  public void setFuenteFilas(Font fuenteFilas) {
    this.fuenteFilas = fuenteFilas;
  }
  
  public Font getFuenteFilasSelect() {
    return this.fuenteFilasSelect;
  }
  
  public void setFuenteFilasSelect(Font fuenteFilasSelect) {
    this.fuenteFilasSelect = fuenteFilasSelect;
  }
}
