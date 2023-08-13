package TableCustom;

public abstract class TableRowData {

    private boolean editing;

    public boolean isEditing() {
        return this.editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
    }

    public abstract Object[] toTableRow();
}
