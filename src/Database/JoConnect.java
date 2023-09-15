package Database;

import Tools.JoAlert;
import java.sql.*;

public class JoConnect {

    private JoProperties prop;
    private Connection con = null;

    public static Connection getConnection() {
        JoProperties properties = new JoProperties("JoConfig/config.properties");
        try {
            Class.forName(properties.getValueAt("db.Driver"));
            String url = properties.getValueAt("db.JDBCHTTP") + properties.getValueAt("db.Server") + "/" + properties.getValueAt("db.database") + properties.getValueAt("db.UTF8");
            String user = properties.getValueAt("db.user");
            String password = properties.getValueAt("db.password");
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            JoAlert alert = new JoAlert();
            alert.setButtonOption(new String[]{"ຕັ້ງຄ່າເຊື່ອມຕໍ່", "ຍົກເລີກ"});
            int conf = alert.messages("ຂໍ້ຜິດພາດ", "ບໍ່ສາມາດເຊື່ອມຕໍ່ກັບຖານຂໍ້ມູນ", "error");
            if (conf == 0) {
                new JoConfigView().setVisible(true);
            } else {
                System.exit(0);
            }
            return null;
        }
    }

    public Connection getConnectionDefault() {
        JoProperties properties = new JoProperties("JoConfig/config.properties");
        try {
            String dirver = properties.getValueAt("db.Driver");
            Class.forName(dirver);
            String database = properties.getValueAt("db.database");
            String utf8 = properties.getValueAt("db.UTF8");
            String url = properties.getValueAt("db.JDBCHTTP") + properties.getValueAt("db.Server") + "/" + database + utf8;
            String user = properties.getValueAt("db.user");
            String password = properties.getValueAt("db.password");
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            return con;
        }
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public JoProperties getProp() {
        JoProperties properties = new JoProperties("JoConfig/config.properties");
        prop = properties;
        return prop;
    }

    public String databaseName() {
        JoProperties properties = new JoProperties("JoConfig/config.properties");
        return properties.getValueAt("db.database");
    }
}
