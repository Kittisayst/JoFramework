package Components;

import TableCustom.TableCustomCelLEditor;
import TableCustom.TableCustomCell;
import TableCustom.TableRowData;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

public class TableCustom extends JTable {

    private final List<TableRowData> datas = new ArrayList<>();

    private Animator animatorEdit;

    private Animator animatorDelete;

    private Animator animatorInsert;

    private int updateRow;

    private int deleteRow;

    private int insertRow;

    private boolean isEdit;

    private boolean insertAndUpdate;

    private int animateRowHeight = 200;

    public TableCustom() {
        init();
    }

    private void init() {
        setRowHeight(30);
        setDefaultRenderer(Object.class, new TableCustomCellRender());
        initAnimatorEdit();
        initAnimatorDelete();
        initAnimatorInsert();
    }

    private void initAnimatorEdit() {
        TimingTargetAdapter timingTargetAdapter = new TimingTargetAdapter() {
            private boolean show;

            @Override
            public void begin() {
                this.show = TableCustom.this.isEdit;
            }

            @Override
            public void end() {
                if (!TableCustom.this.isEdit) {
                    TableRowData model = TableCustom.this.getModelData(TableCustom.this.updateRow);
                    Object[] data = model.toTableRow();
                    for (int i = 0; i < TableCustom.this.getColumnCount(); i++) {
                        if (i < data.length) {
                            TableCustom.this.setValueAt(data[i], TableCustom.this.updateRow, i);
                        }
                    }
                    model.setEditing(false);
                }
            }

            @Override
            public void timingEvent(float fraction) {
                if (this.show) {
                    int height = (int) (fraction * TableCustom.this.animateRowHeight) + TableCustom.this.getRowHeight();
                    TableCustom.this.setRowHeight(TableCustom.this.updateRow, height);
                } else {
                    int height = (int) ((1.0F - fraction) * TableCustom.this.animateRowHeight) + TableCustom.this.getRowHeight();
                    TableCustom.this.setRowHeight(TableCustom.this.updateRow, height);
                }
            }
        };
        this.animatorEdit = new Animator(300, (TimingTarget) timingTargetAdapter);
        this.animatorEdit.setAcceleration(0.5F);
        this.animatorEdit.setDeceleration(0.5F);
        this.animatorEdit.setResolution(0);
    }

    private void initAnimatorDelete() {
        TimingTargetAdapter timingTargetAdapter = new TimingTargetAdapter() {
            private int rowHeight;

            @Override
            public void begin() {
                this.rowHeight = TableCustom.this.getRowHeight(TableCustom.this.deleteRow);
            }

            @Override
            public void timingEvent(float fraction) {
                int height = (int) ((1.0F - fraction) * this.rowHeight) + 1;
                TableCustom.this.setRowHeight(TableCustom.this.deleteRow, height);
            }

            @Override
            public void end() {
                TableCustom.this.removeRow(TableCustom.this.deleteRow);
            }
        };
        this.animatorDelete = new Animator(300, (TimingTarget) timingTargetAdapter);
        this.animatorDelete.setAcceleration(0.5F);
        this.animatorDelete.setDeceleration(0.5F);
        this.animatorDelete.setResolution(0);
    }

    private void initAnimatorInsert() {
        TimingTargetAdapter timingTargetAdapter = new TimingTargetAdapter() {
            private int rowHeight;

            @Override
            public void begin() {
                if (TableCustom.this.insertAndUpdate) {
                    this.rowHeight = TableCustom.this.animateRowHeight;
                } else {
                    this.rowHeight = TableCustom.this.getRowHeight();
                }
            }

            @Override
            public void end() {
                TableCustom.this.insertAndUpdate = false;
            }

            @Override
            public void timingEvent(float fraction) {
                int height = (int) (fraction * this.rowHeight);
                if (height < 1) {
                    height = 1;
                }
                TableCustom.this.setRowHeight(TableCustom.this.insertRow, height);
            }
        };
        this.animatorInsert = new Animator(300, (TimingTarget) timingTargetAdapter);
        this.animatorInsert.setAcceleration(0.5F);
        this.animatorInsert.setDeceleration(0.5F);
        this.animatorInsert.setResolution(0);
    }

    public TableRowData getModelData(int row) {
        return this.datas.get(row);
    }

    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) getModel();
    }

    public void addTableCell(final TableCustomCell cell, int index) {
        getColumnModel().getColumn(index).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int row, int column) {
                Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, row, column);
                TableRowData model = TableCustom.this.getModelData(row);
                if (model.isEditing()) {
                    Component component = TableCustom.this.getEditor(cell.createComponentCellEditor(TableCustom.this, model, o, row, column), TableCustom.this.getModelData(row), com.getBackground(), row, column);
                    return component;
                }
                Component c = cell.createComponentCellRender(TableCustom.this, TableCustom.this.getModelData(row), row, column);
                if (c != null) {
                    c.setBackground(com.getBackground());
                    return c;
                }
                return com;
            }
        });
        getColumnModel().getColumn(index).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
            private TableCustomCell tableCell;

            @Override
            public Component getTableCellEditorComponent(JTable jtable, Object o, boolean bln, int row, int column) {
                DefaultTableCellRenderer com = new DefaultTableCellRenderer();
                com.setOpaque(false);
                TableRowData model = TableCustom.this.getModelData(row);
                if ((model.toTableRow()).length > column) {
                    com.setText(model.toTableRow()[column].toString());
                }
                this.tableCell = cell.createComponentCellEditor(TableCustom.this, model, o, row, column);
                return TableCustom.this.getEditor(this.tableCell, model, jtable.getSelectionBackground(), row, column);
            }

            @Override
            public Object getCellEditorValue() {
                return this.tableCell.getData();
            }
        });
    }

    private Component getEditor(TableCustomCell cellEditor, TableRowData data, Color color, int row, int column) {
        cellEditor.setRowColumn(row, column);
        TableCustomCelLEditor cell = new TableCustomCelLEditor(getRowHeight());
        Component com = cellEditor.createComponentCellRenderOnEditor(this, data, row, column);
        if (com != null) {
            cell.add(com);
            JComponent cc = (JComponent) com;
            cc.setOpaque(false);
        }
        cell.add((Component) cellEditor);
        cell.setBackground(color);
        return (Component) cell;
    }

    private void removeRow(int row) {
        stopCellEditing();
        this.datas.remove(row);
        getTableModel().removeRow(row);
    }

    public void editRowAt(int row) {
        if (!this.animatorEdit.isRunning()) {
            this.updateRow = row;
            this.isEdit = true;
            getModelData(row).setEditing(true);
            this.animatorEdit.start();
        }
    }

    public void cancelEditRowAt(int row) {
        if (!this.animatorEdit.isRunning()) {
            this.isEdit = false;
            this.updateRow = row;
            this.animatorEdit.start();
        }
    }

    public void addRow(TableRowData data, boolean animate) {
        if (!this.animatorInsert.isRunning()) {
            stopCellEditing();
            this.datas.add(data);
            getTableModel().addRow(data.toTableRow());
            this.insertRow = getRowCount() - 1;
            if (animate) {
                setRowHeight(this.insertRow, 1);
                this.animatorInsert.start();
            }
        }
    }

    public void insertRow(TableRowData data, int index, boolean animate) {
        if (!this.animatorInsert.isRunning()) {
            stopCellEditing();
            this.datas.add(index, data);
            getTableModel().insertRow(index, data.toTableRow());
            this.insertRow = index;
            if (animate) {
                setRowHeight(this.insertRow, 1);
                this.animatorInsert.start();
            }
        }
    }

    public void insertRowWithEdit(TableRowData data, int index, boolean animate) {
        if (!this.animatorInsert.isRunning()) {
            stopCellEditing();
            this.datas.add(index, data);
            getTableModel().insertRow(index, data.toTableRow());
            this.insertRow = index;
            if (animate) {
                setRowHeight(this.insertRow, 1);
                this.insertAndUpdate = true;
                getModelData(index).setEditing(true);
                this.animatorInsert.start();
            }
        }
    }

    public void deleteRowAt(int row, boolean animate) {
        if (animate) {
            if (!this.animatorDelete.isRunning()) {
                this.deleteRow = row;
                this.animatorDelete.start();
            }
        } else {
            removeRow(row);
        }
    }

    public void scrollToIndex(int index) {
        getSelectionModel().setSelectionInterval(index, index);
        Rectangle r = new Rectangle(getCellRect(index, 0, true));
        r.setSize(new Dimension(1, getRowHeight()));
        scrollRectToVisible(r);
    }

    public void stopCellEditing() {
        if (isEditing()) {
            getCellEditor().stopCellEditing();
        }
    }

    private class TableCustomCellRender extends DefaultTableCellRenderer {

        private TableCustomCellRender() {
        }

        @Override
        public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
            Component com = super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            setOpaque(false);
            com.setForeground(jtable.getForeground());
            TableCustomCelLEditor cell = new TableCustomCelLEditor(jtable.getRowHeight());
            cell.setBackground(com.getBackground());
            cell.add(com);
            return (Component) cell;
        }

        @Override
        protected void paintBorder(Graphics grphcs) {
        }
    }

    public int getAnimateRowHeight() {
        return this.animateRowHeight + getRowHeight();
    }

    public void setAnimateRowHeight(int animateRowHeight) {
        this.animateRowHeight = animateRowHeight - getRowHeight();
    }
}
