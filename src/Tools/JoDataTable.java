package Tools;

import Components.JoCombobox;
import Components.JoLable;
import Components.JoScrollBar;
import Components.JoTable;
import Components.JoTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;

public class JoDataTable {

    private final javax.swing.JPanel PanelFooter;
    private final javax.swing.JPanel PanelHeader;
    private final Components.JoCombobox cb_limit;
    private final Components.JoLable lbl_count;
    private final Components.JoLable lbl_entites;
    private final Components.JoLable lbl_search;
    private final Components.JoLable lbl_show;
    private final Components.JoTextField txt_search;
    private final JPanel PanelTable;
    private Vector originalTableModel;
    private DefaultComboBoxModel limitModel;
    //===================== Design =================
    private boolean info = true;
    private boolean ordering = true;
    private final JoScrollBar scrollBar;
    private Font font;

    public JoDataTable(JPanel PanelTable) {
        PanelHeader = new javax.swing.JPanel();
        txt_search = new Components.JoTextField();
        lbl_show = new Components.JoLable();
        limitModel = new DefaultComboBoxModel();
        cb_limit = new Components.JoCombobox();
        lbl_entites = new Components.JoLable();
        lbl_search = new Components.JoLable();
        PanelFooter = new javax.swing.JPanel();
        lbl_count = new Components.JoLable();
        scrollBar = new JoScrollBar();
        font = new Font("Phetsarath OT", 0, 12);
        this.PanelTable = PanelTable;
        //=============================================================
        originalTableModel = (Vector) ((DefaultTableModel) getTableData().getModel()).getDataVector().clone();
        PanelTable.add(createPanelHeader(), java.awt.BorderLayout.PAGE_START);
        PanelTable.add(createPanelFooter(), java.awt.BorderLayout.PAGE_END);
        BuilderLimit();
        FontDesing();
    }

    private JPanel createPanelHeader() {
        txt_search.setPlaceholder("ຄົ້ນຫາ");
        lbl_show.setText("ສະແດງ");
        lbl_entites.setText("ລາຍການ");
        lbl_search.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_search.setText("ຄົ້ນຫາ:");
        createLimitList();
        cb_limit.addItemListener((java.awt.event.ItemEvent evt) -> {
            BuilderLimit();
        });
        txt_search.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (txt_search.getText().equals("")) {
                    BuilderLimit();
                } else {
                    BuilderDataTableSearch(txt_search.getText());
                }
                super.keyReleased(e);
            }
        });
        javax.swing.GroupLayout PanelHeaderLayout = new javax.swing.GroupLayout(PanelHeader);
        PanelHeader.setLayout(PanelHeaderLayout);
        PanelHeaderLayout.setHorizontalGroup(
                PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelHeaderLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbl_show, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cb_limit, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbl_entites, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_search, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE)
                                .addGap(8, 8, 8)
                                .addComponent(txt_search, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        PanelHeaderLayout.setVerticalGroup(
                PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelHeaderLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(PanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(txt_search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_search, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbl_entites, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cb_limit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbl_show, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        return PanelHeader;
    }

    private JPanel createPanelFooter() {
        lbl_count.setText("Showing 1 to 10 of 57 entries");
        javax.swing.GroupLayout PanelFooterLayout = new javax.swing.GroupLayout(PanelFooter);
        PanelFooter.setLayout(PanelFooterLayout);
        PanelFooterLayout.setHorizontalGroup(
                PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFooterLayout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(lbl_count, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelFooterLayout.setVerticalGroup(
                PanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelFooterLayout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lbl_count, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                .addGap(5, 5, 5))
        );
        return PanelFooter;
    }

    private JoTable getTableData() {
        JoTable table;
        JScrollPane pane = (JScrollPane) PanelTable.getComponent(0);
        pane.setVerticalScrollBar(scrollBar);
        JViewport viewport = pane.getViewport();
        table = (JoTable) viewport.getComponent(0);
        return table;
    }

    private void BuilderDataTable(int limit) {
        int countAll;
        DefaultTableModel currtableModel = (DefaultTableModel) getTableData().getModel();
        countAll = originalTableModel.size();
        currtableModel.setRowCount(0);
        originalTableModel.stream().map(rows -> (Vector) rows).forEachOrdered(rowVector -> {
            //content found so adding to table
            currtableModel.addRow((Vector<?>) rowVector);
        });
        currtableModel.setRowCount(limit);
        lbl_count.setText("ກຳລັງສະແດງ " + limit + " ຈາກ " + countAll + " ລາຍການ");
    }

    private void BuilderDataTableSearch(String search) {
        try {
            int countAll = 0;
            DefaultTableModel currtableModel = (DefaultTableModel) getTableData().getModel();
            countAll = originalTableModel.size();
            currtableModel.setRowCount(0);
            for (Object rows : originalTableModel) {
                Vector rowVector = (Vector) rows;
                for (Object column : rowVector) {
                    if (column.toString().contains(search)) {
                        currtableModel.addRow(rowVector);
                        break;
                    }
                }
            }
            lbl_count.setText("ກຳລັງສະແດງ " + currtableModel.getRowCount() + " ຈາກ " + countAll + " ລາຍການ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void BuilderLimit() {
        if (getLimit() >= originalTableModel.size()) {
            BuilderDataTable(originalTableModel.size());
        } else {
            BuilderDataTable(getLimit());
        }
    }

    public void showDataTableAll() {
        cb_limit.setSelectedIndex(4);
    }

    private void createLimitList() {
        limitModel = (DefaultComboBoxModel) cb_limit.getModel();
        limitModel.removeAllElements();
        //========= One list ==============
        limitModel.addElement(5);
        limitModel.addElement(10);
        limitModel.addElement(25);
        limitModel.addElement(50);
        limitModel.addElement("ທັງໝົດ");
        cb_limit.setModel(limitModel);
    }

    private int getLimit() {
        if (cb_limit.getSelectedItem().equals("ທັງໝົດ")) {
            return originalTableModel.size();
        } else {
            return Integer.parseInt(cb_limit.getSelectedItem().toString());
        }
    }

    public void setHiddenColumns(int index) {
        int colCount = getTableData().getColumnModel().getColumnCount();
        if (colCount > 0 && index < colCount) {
            getTableData().getColumnModel().getColumn(index).setMinWidth(0);
            getTableData().getColumnModel().getColumn(index).setPreferredWidth(0);
            getTableData().getColumnModel().getColumn(index).setMaxWidth(0);
        }
    }

    public void setBackground(Color color) {
        PanelTable.setBackground(color);
        PanelHeader.setBackground(color);
        PanelFooter.setBackground(color);
    }

    public JoCombobox getCb_limit() {
        return cb_limit;
    }

    public JoLable getLbl_count() {
        return lbl_count;
    }

    public JoLable getLbl_entites() {
        return lbl_entites;
    }

    public JoLable getLbl_search() {
        return lbl_search;
    }

    public JoLable getLbl_show() {
        return lbl_show;
    }

    public JoTextField getTxt_search() {
        return txt_search;
    }

    public boolean isInfo() {
        return info;
    }

    public void setInfo(boolean info) {
        this.info = info;
        this.PanelFooter.setVisible(info);
    }

    public boolean isOrdering() {
        return ordering;
    }

    public void setOrdering(boolean ordering) {
        this.ordering = ordering;
        lbl_show.setVisible(ordering);
        lbl_entites.setVisible(ordering);
        cb_limit.setVisible(ordering);
        cb_limit.setSelectedItem("ທັງໝົດ");
        BuilderDataTable(originalTableModel.size());
    }

    public JoScrollBar getScrollBar() {
        return scrollBar;
    }

    private void FontDesing() {
        lbl_count.setFont(font);
        lbl_entites.setFont(font);
        lbl_search.setFont(font);
        lbl_show.setFont(font);
        cb_limit.setFont(font);
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
        FontDesing();
    }

}
