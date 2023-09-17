package Database;

import Tools.JoAlert;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JoSQL {

    private final Connection c;
    private final String TableName;
    private final String SQL_SELECT_ALL;
    private final String SQL_CREATE;
    private final String SQL_UPDATE;
    private final String SQL_DELETE;
    private ArrayList Columns;

    private final String ColumnID;

    public JoSQL(Connection c, String TableName) {
        this.c = c;
        this.TableName = TableName;
        Columns = new ArrayList();
        SQL_SELECT_ALL = "SELECT * FROM " + TableName;
        ColumnID = SQLColumnID();
        SQL_CREATE = SQLCreate();
        SQL_UPDATE = SQLUpdate();
        SQL_DELETE = "DELETE FROM " + TableName + " WHERE " + ColumnID + "=?";
    }

    public DatabaseMetaData getMetaData() {
        try {
            return c.getMetaData();
        } catch (SQLException ex) {
            Logger.getLogger(JoSQL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public PreparedStatement setPrepared(PreparedStatement pre, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pre.setObject(i + 1, params[i]);
        }
        return pre;
    }

    public ResultSet getSelectAll() throws Exception {
        PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getSelectAll(ORDER order) throws Exception {
        PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL+" ORDER BY "+ColumnID+" "+getORDER(order));
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public ResultSet getSelectById(int Value) throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_SELECT_ALL + " WHERE " + ColumnID + "=?");
        pre.setInt(1, Value);
        ResultSet rs = pre.executeQuery();
        return rs;
    }

    public ResultSet getSelectByIndex(int ColumnIndex, Object Value) throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_SELECT_ALL + " WHERE " + getColumn(ColumnIndex) + "=?");
        pre.setString(1, Value.toString());
        ResultSet rs = pre.executeQuery();
        return rs;
    }

    public ResultSet getMaxColumn() throws Exception {
        PreparedStatement pre = c.prepareStatement("SELECT MAX(" + ColumnID + ") AS col FROM " + TableName);
        ResultSet rs = pre.executeQuery();
        return rs;
    }

    public PreparedStatement getSelectCustom(String Condition) throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_SELECT_ALL + " WHERE " + Condition);
        return pre;
    }

    public PreparedStatement getCreate() throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_CREATE);
        return pre;
    }

    public PreparedStatement getUpdate() throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_UPDATE);
        return pre;
    }

    public PreparedStatement getUpdateByColumns(String[] arrcolumn) throws SQLException {
        String strCol = "";
        for (String value : arrcolumn) {
            strCol += value + "=?,";
        }
        String sql = "UPDATE " + TableName + " SET " + removeLastChar(strCol) + " WHERE " + ColumnID + "=?";
        PreparedStatement pre = c.prepareStatement(sql);
        return pre;
    }

    public PreparedStatement getDelete() throws SQLException {
        PreparedStatement pre = c.prepareStatement(SQL_DELETE);
        return pre;
    }

    public int getCount() {
        int Count = 0;
        try {
            String sql = "SELECT COUNT(" + ColumnID + ") AS Col FROM " + TableName;
            PreparedStatement pre = c.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return Count;
    }

    public int getCount(int ColumnIndex, String value) {
        int Count = 0;
        try {
            String sql = "SELECT COUNT(" + ColumnID + ") AS Col FROM " + TableName + " WHERE " + getColumn(ColumnIndex) + "=?";
            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, value);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                Count = rs.getInt(1);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
            JoAlert.Error(e, this);
        }
        return Count;
    }

    public void TestQuery() throws Exception {
        System.out.println(getColumn(2));
    }

    //========== Function ==================
    private int getColumnCount() {
        int Count = 0;
        try {
            ResultSet rs = getSelectAll();
            ResultSetMetaData meta = rs.getMetaData();
            Count = meta.getColumnCount();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(JoSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Count;
    }

    private String SQLColumnID() {
        String sql = "";
        try {
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            sql = meta.getColumnName(1);
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    private String getColumn(int columIndex) {
        String str;
        try {
            ResultSet rs = getSelectAll();
            ResultSetMetaData meta = rs.getMetaData();
            str = meta.getColumnName(columIndex);
            rs.close();
            return str;
        } catch (Exception e) {
            JoAlert alert = new JoAlert();
            alert.messages("ຈຳນວນຖັນບໍ່ຖືກຕ້ອງ", "ColumnCount:" + getColumnCount() + " / Your Index: " + columIndex, JoAlert.Icons.info);
            e.printStackTrace();
            return ColumnID;
        }
    }

    private String SQLCreate() {
        ArrayList question = new ArrayList();
        try {
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 0; i < meta.getColumnCount(); i++) {
                question.add("?");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "INSERT INTO " + TableName + " VALUES(" + ArraryToString(question) + ")";
    }

    private String SQLUpdate() {
        String sql = "";
        ArrayList columnName = new ArrayList();
        try {
            PreparedStatement ps = c.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData meta = rs.getMetaData();
            for (int i = 2; i <= meta.getColumnCount(); i++) {
                columnName.add(meta.getColumnName(i) + "=?");
            }
            sql = "UPDATE " + TableName + " SET " + ArraryToString(columnName) + " WHERE " + ColumnID + "=?";
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    private String ArraryToString(ArrayList list) {
        String str = "";
        for (Object object : list) {
            str += object + ",";
        }
        return removeLastChar(str);
    }

    private String removeLastChar(String str) {
        return str.substring(0, str.length() - 1);
    }

    private String getORDER(ORDER order) {
        switch (order) {
            case ASC:
                return "ASC";
            case DESC:
                return "DESC";
            default:
                throw new AssertionError();
        }
    }

    public enum ORDER {
        ASC,
        DESC
    }

    public String getTableName() {
        return TableName;
    }

    public String getSQL_SELECT_ALL() {
        return SQL_SELECT_ALL;
    }

    public String getSQL_CREATE() {
        return SQL_CREATE;
    }

    public String getSQL_UPDATE() {
        return SQL_UPDATE;
    }

    public String getSQL_DELETE() {
        return SQL_DELETE;
    }

    public String getColumnID() {
        return ColumnID;
    }

    public ArrayList getColumns() {
        return Columns;
    }

    public void setColumns(ArrayList Columns) {
        this.Columns = Columns;
    }

    @Override
    public String toString() {
        return "JoCRUD{" + "c=" + c + ", TableName=" + TableName + ", SQL_SELECT_ALL=" + SQL_SELECT_ALL + ", SQL_CREATE=" + SQL_CREATE + ", SQL_UPDATE=" + SQL_UPDATE + ", SQL_DELETE=" + SQL_DELETE + ", ColumnID=" + ColumnID + '}';
    }

}
