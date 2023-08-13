
package Components;


import ClassUI.EstiloTablaHeader;
import ClassUI.EstiloTablaRenderer;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
import theme.JoTheme;

public class JoTableCalendar extends JTable {
  EstiloTablaHeader h = new EstiloTablaHeader();
  
  EstiloTablaRenderer f = new EstiloTablaRenderer();
  
  private Color colorBackgoundHead = JoTheme.Primary;
  
  private Color colorForegroundHead = new Color(255, 255, 255);
  
  private int grosorBordeHead = 1;
  
  private Color colorBordeHead = new Color(0, 0, 0);
  
  private int grosorBordeFilas = 1;
  
  private Color colorBordeFilas = new Color(0, 0, 0);
  
  private Font fuenteHead = new Font("Phetsarath OT", 1, 14);
  
  private int altoHead = 50;
  
  private boolean multipleSeleccion = true;
  
  private Color colorFilasBackgound1 = new Color(255, 255, 255);
  
  private Color colorFilasForeground1 = JoTheme.Primary;
  
  private Color colorFilasBackgound2 = new Color(204, 204, 204);
  
  private Color colorFilasForeground2 = JoTheme.Primary;
  
  private Color colorSelBackgound = JoTheme.Primary;
  
  private Color colorSelForeground = new Color(255, 255, 255);
  
  private Font fuenteFilas = new Font("Phetsarath OT", 1, 12);
  
  private Font fuenteFilasSelect = new Font("Phetsarath OT", 1, 12);
  
  public JoTableCalendar() {
    getTableHeader().setDefaultRenderer((TableCellRenderer)this.h);
    setDefaultRenderer(Object.class, (TableCellRenderer)this.f);
    setFuenteHead(new Font("Phetsarath OT", 1, 14));
    setFuenteFilas(new Font("Phetsarath OT", 1, 14));
    setFuenteFilasSelect(new Font("Phetsarath OT", 1, 14));
  }
  
  public Color getColorBackgoundHead() {
    return this.colorBackgoundHead;
  }
  
  public void setColorBackgoundHead(Color colorBackgoundHead) {
    this.colorBackgoundHead = colorBackgoundHead;
    this.h.setColorBackgound(colorBackgoundHead);
  }
  
  public Color getColorForegroundHead() {
    return this.colorForegroundHead;
  }
  
  public void setColorForegroundHead(Color colorForegroundHead) {
    this.colorForegroundHead = colorForegroundHead;
    this.h.setColorForeground(colorForegroundHead);
  }
  
  public int getGrosorBordeHead() {
    return this.grosorBordeHead;
  }
  
  public void setGrosorBordeHead(int grosorBordeHead) {
    this.grosorBordeHead = grosorBordeHead;
    this.h.setGrosorBorde(grosorBordeHead);
  }
  
  public Color getColorBordeHead() {
    return this.colorBordeHead;
  }
  
  public void setColorBordeHead(Color colorBordeHead) {
    this.colorBordeHead = colorBordeHead;
    this.h.setColorBorde(colorBordeHead);
  }
  
  public Font getFuenteHead() {
    return this.fuenteHead;
  }
  
  public void setFuenteHead(Font fuenteHead) {
    this.fuenteHead = fuenteHead;
    this.h.setFuenteHead(fuenteHead);
  }
  
  public boolean isMultipleSeleccion() {
    return this.multipleSeleccion;
  }
  
  public void setMultipleSeleccion(boolean multipleSeleccion) {
    this.multipleSeleccion = multipleSeleccion;
    if (multipleSeleccion) {
      setSelectionMode(2);
    } else {
      setSelectionMode(0);
    } 
  }
  
  public Color getColorFilasBackgound1() {
    return this.colorFilasBackgound1;
  }
  
  public void setColorFilasBackgound1(Color colorFilasBackgound1) {
    this.colorFilasBackgound1 = colorFilasBackgound1;
    this.f.setColorBackgound1(colorFilasBackgound1);
  }
  
  public Color getColorFilasForeground1() {
    return this.colorFilasForeground1;
  }
  
  public void setColorFilasForeground1(Color colorFilasForeground1) {
    this.colorFilasForeground1 = colorFilasForeground1;
    this.f.setColorForeground1(this.colorFilasForeground1);
  }
  
  public Color getColorFilasBackgound2() {
    return this.colorFilasBackgound2;
  }
  
  public void setColorFilasBackgound2(Color colorFilasBackgound2) {
    this.colorFilasBackgound2 = colorFilasBackgound2;
    this.f.setColorBackgound2(colorFilasBackgound2);
  }
  
  public Color getColorFilasForeground2() {
    return this.colorFilasForeground2;
  }
  
  public void setColorFilasForeground2(Color colorFilasForeground2) {
    this.colorFilasForeground2 = colorFilasForeground2;
    this.f.setColorForeground2(this.colorFilasForeground2);
  }
  
  public Color getColorSelBackgound() {
    return this.colorSelBackgound;
  }
  
  public void setColorSelBackgound(Color colorSelBackgound) {
    this.colorSelBackgound = colorSelBackgound;
    this.f.setColorSelBackgound(colorSelBackgound);
  }
  
  public Color getColorSelForeground() {
    return this.colorSelForeground;
  }
  
  public void setColorSelForeground(Color colorSelForeground) {
    this.colorSelForeground = colorSelForeground;
    this.f.setColorSelForeground(colorSelForeground);
  }
  
  public Font getFuenteFilas() {
    return this.fuenteFilas;
  }
  
  public void setFuenteFilas(Font fuenteFilas) {
    this.fuenteFilas = fuenteFilas;
    this.f.setFuenteFilas(fuenteFilas);
  }
  
  public Font getFuenteFilasSelect() {
    return this.fuenteFilasSelect;
  }
  
  public void setFuenteFilasSelect(Font fuenteFilasSelect) {
    this.fuenteFilasSelect = fuenteFilasSelect;
    this.f.setFuenteFilasSelect(fuenteFilasSelect);
  }
  
  public int getGrosorBordeFilas() {
    return this.grosorBordeFilas;
  }
  
  public void setGrosorBordeFilas(int grosorBordeFilas) {
    this.grosorBordeFilas = grosorBordeFilas;
    this.f.setGrosorBorde(this.grosorBordeFilas);
  }
  
  public Color getColorBordeFilas() {
    return this.colorBordeFilas;
  }
  
  public void setColorBordeFilas(Color colorBordeFilas) {
    this.colorBordeFilas = colorBordeFilas;
    this.f.setColorBorde(this.colorBordeFilas);
  }
  
  public int getAltoHead() {
    return this.altoHead;
  }
  
  public void setAltoHead(int altoHead) {
    this.altoHead = altoHead;
    this.h.setAltoHead(this.altoHead);
  }
}