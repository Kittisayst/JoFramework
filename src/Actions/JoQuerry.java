package Actions;

import Tools.JoAlert;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.util.Date;

public class JoQuerry {

    public ResultSet rs;
    public PreparedStatement pre;
    public Connection c;
    private final String tableName;
    public String select;
    ArrayList<String> columns = new ArrayList<>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public JoQuerry() {
        this.tableName = null;
    }

    public JoQuerry(Connection c, String tableName) {
        this.c = c;
        this.tableName = tableName;
    }

    public ResultSet JoSelect() throws Exception {
        select = "";
        select = "SELECT * FROM " + tableName;
        return rs = c.createStatement().executeQuery(select);
    }

    public ResultSet JoSelect(String Columns) throws Exception {
        select = "";
        select = "SELECT " + Columns + " FROM " + tableName;
        System.out.println("Q " + this.tableName + " Select  Columns " + select);
        return rs = c.createStatement().executeQuery(select);
    }

    public ResultSet JoSelect(String Columns, String Condition) throws Exception {
        select = "";
        select = "SELECT " + Columns + " FROM " + tableName + " WHERE " + Condition;
        System.out.println("Q " + this.tableName + " Select  Columns Condition " + select);
        return rs = c.createStatement().executeQuery(select);
    }

    public ResultSet JoSelectJoin(String Column, String Table, String ColumnJoin) throws Exception {
        select = "";
        select = "SELECT " + Column + " FROM " + tableName + "\n"
                + "INNER JOIN " + Table + " ON " + tableName + "." + ColumnJoin + " = " + Table + "." + ColumnJoin + "";
        System.out.println("Q " + this.tableName + " Select  ColumnJoin Condition " + select);
        return rs = c.createStatement().executeQuery(select);
    }

    public String JoLike(String Column, String Value) {
        select = "";
        System.out.println("Q " + this.tableName + " Select JoLike " + select);
        return " " + Column + " LIKE '%" + Value + "%'";
    }

    public ResultSet JoOrderBy(String ORDERBY) throws Exception {

        return rs = c.createStatement().executeQuery(select);
    }

    public PreparedStatement JoSelectQ(String Columns, String Condition) throws Exception {
        select = "SELECT " + Columns + " FROM " + tableName + " WHERE " + Condition;
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoInsert() throws Exception {
        ArrayList<String> question = new ArrayList<>();
        JoStructure().forEach((col) -> {
            question.add("?");
        });
        String str = question.toString();
        str = str.replaceAll("[\\[\\]]", "");
        select = "INSERT INTO " + tableName + " VALUES(" + str + ")";
        System.out.println("Q " + this.tableName + " INSERT " + select);
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoInsert(String Column, String Q) throws Exception {
        select = "INSERT INTO " + tableName + " (" + Column + ") " + " VALUES(" + Q + ")";
        System.out.println("Q " + this.tableName + " INSERT Column " + select);
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoUpdate() throws Exception {
        ArrayList<String> reverseColumn;
        ArrayList<String> ColumnQ = new ArrayList<>();
        reverseColumn = JoStructure();
        Collections.reverse(reverseColumn);
        reverseColumn.forEach((col) -> {
            ColumnQ.add(col + "=?");
        });
        int LastIndex = ColumnQ.size() - 1;
        String ColumnID = ColumnQ.get(LastIndex);
        ColumnQ.remove(LastIndex);
        String str = ColumnQ.toString();
        str = str.replaceAll("[\\[\\]]", "");
        select = "";
        select = "UPDATE " + tableName + " SET " + str + " WHERE " + ColumnID;
        System.out.println("Q " + this.tableName + " UPDATE " + select);
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoUpdate(String Column, String Condition) throws Exception {
        select = "";
        select = "UPDATE " + tableName + " SET " + Column + " WHERE " + Condition;
        System.out.println("Q " + this.tableName + " UPDATE Condition " + select);
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoDelete() throws Exception {
        String ColumnID = JoStructure().get(0) + "=?";
        select = "";
        select = "DELETE FROM " + tableName + " WHERE " + ColumnID;
        System.out.println("Q " + this.tableName + " DELETE " + select);
        return pre = c.prepareStatement(select);
    }

    public PreparedStatement JoDelete(String Condition) throws Exception {
        select = "";
        select = "DELETE FROM " + tableName + " WHERE " + Condition;
        System.out.println("Q " + this.tableName + " DELETE Condition " + select);
        return pre = c.prepareStatement(select);
    }

    public ArrayList<String> JoStructure() {
        try {
            columns.clear();
            String sql = "SHOW COLUMNS FROM " + tableName;
            rs = c.createStatement().executeQuery(sql);
            while (rs.next()) {
                columns.add(rs.getString(1));
            }
            rs.close();
            return columns;
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    public int joColumnCount() throws Exception {
        ResultSetMetaData meta = rs.getMetaData();
        int count = meta.getColumnCount();
        return count;
    }

    public ImageIcon JoLoadIcon(Blob blob) throws Exception {
        if (blob != null) {
            int blobsize = (int) blob.length();
            byte[] blobAsBytes = blob.getBytes(1, blobsize);
            final BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(blobAsBytes));
            return new ImageIcon(bufferedImage);
        } else {
            Image img = new ImageIcon(getClass().getResource("/Resource/Default_Image.png")).getImage();
            return new ImageIcon(ImageToBufferedImage(img));
        }
    }

    public BufferedImage ImageToBufferedImage(Image image) {
        BufferedImage newImage = new BufferedImage(
                image.getWidth(null), image.getHeight(null),
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = newImage.createGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return newImage;
    }

    public BufferedImage JoLoadImageIcon(InputStream BlobDB) throws Exception {
        return ImageIO.read(BlobDB);
    }

    public InputStream JoSaveBlobFile(String imageFile) throws Exception {
        return new FileInputStream(imageFile);
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public enum ORDERBY {
        ASC,
        DESC
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Date setDate(String date) {
        try {
            if (date.isEmpty()) {
                return null;
            } else {
                Date stdate = dateFormat.parse(date);
                return stdate;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String FormatMonney(String Money) {
        if (Money.equals("")) {
            Money = "0";
        } else {
            Money = Money.replace(",", "");
        }
        double amount = Double.parseDouble(Money);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(amount);
    }

    public String UnFormatMonney(String Money) {
        if (Money.equals("")) {
            return "0";
        } else {
            return Money.replace(",", "");
        }
    }

    public boolean JoSubmit(int data, int Action) {
        if (data == 1) {
            new JoAlert().messages(Action == 0 ? "ບັນທຶກ" : "ແກ້ໄຂ", Action == 0 ? "ບັນທຶກຂໍ້ມູນສຳເລັດ" : "ແກ້ໄຂຂໍ້ມູນສຳເລັດ", "success");
            return true;
        } else {
            new JoAlert().messages(Action == 0 ? "ບັນທຶກ" : "ແກ້ໄຂ", Action == 0 ? "ບັນທຶກຂໍ້ມູນບໍ່ສຳເລັດ" : "ແກ້ໄຂຂໍ້ມູນບໍ່ສຳເລັດ", "error");
            return false;
        }
    }

    public boolean JoSubmitDelete() {
        JoAlert alert = new JoAlert();
        alert.setButtonOption(JoAlert.Option.LAOS_DELETE_CANCEL);
        int conf = alert.messages("ລົບ", "ທ່ານຕ້ອງການລົບຂໍ້ມູນນີ້ຫຼືບໍ່?", "warning");
        return conf == 0;
    }

}
