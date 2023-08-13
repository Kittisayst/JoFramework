
package TableCustom;

import java.awt.LayoutManager;
import javax.swing.GroupLayout;
import net.miginfocom.swing.MigLayout;

public class TableCustomCelLEditor extends Cell {
  public TableCustomCelLEditor(int row) {
    initComponents();
    setLayout((LayoutManager)new MigLayout("wrap, inset 0, fillx", "[fill]", "0[" + row + "::, fill]0"));
  }
  
  private void initComponents() {
    GroupLayout layout = new GroupLayout(this);
    setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 0, 32767));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGap(0, 0, 32767));
  }
}
