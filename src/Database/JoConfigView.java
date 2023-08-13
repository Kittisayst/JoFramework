package Database;

import Components.JoButtonIconfont;
import Components.JoPanel;
import Components.JoPasswordField;
import Components.JoTextField;
import Tools.JoAlert;
import Tools.JoMoveFrame;
import java.sql.Connection;
import javax.swing.JFrame;
import theme.JoTheme;

public class JoConfigView extends JFrame {

    private final JoProperties properties;
    private final JoButtonIconfont btn_close;
    private final JoButtonIconfont btn_connect;
    private final JoButtonIconfont btn_save;
    private final javax.swing.JLabel lbl_Title;
    private final JoPanel pn_containner;
    private final JoTextField txt_database;
    private final JoTextField txt_host;
    private final JoPasswordField txt_password;
    private final JoTextField txt_user;
    private final JoMoveFrame moveFrame;

    public JoConfigView() {
        properties = new JoProperties("JoConfig/config.properties");
        pn_containner = new JoPanel();
        lbl_Title = new javax.swing.JLabel();
        txt_user = new JoTextField();
        txt_host = new JoTextField();
        txt_database = new JoTextField();
        txt_password = new JoPasswordField();
        btn_connect = new JoButtonIconfont();
        btn_save = new JoButtonIconfont();
        btn_close = new JoButtonIconfont();
        moveFrame = new JoMoveFrame();
        initComponent();
        addEvent();
        addData();
    }

    private void initComponent() {
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        pn_containner.setJoPrimaryColor(new java.awt.Color(255, 255, 255));
        pn_containner.setJoSecondaryColor(new java.awt.Color(240, 240, 240));
        pn_containner.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_user.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        txt_user.setPhColor(new java.awt.Color(0, 112, 192));
        txt_user.setPlaceholder("Server User");
        txt_user.setRound(0);
        pn_containner.add(txt_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 330, -1));

        lbl_Title.setFont(new java.awt.Font("Saysettha OT", 1, 24)); // NOI18N
        lbl_Title.setForeground(new java.awt.Color(0, 0, 255));
        lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_Title.setText("Database Setting");
        pn_containner.add(lbl_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 330, 50));

        txt_host.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        txt_host.setPhColor(new java.awt.Color(0, 112, 192));
        txt_host.setPlaceholder("Host Name");
        txt_host.setRound(0);
        pn_containner.add(txt_host, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 330, -1));

        txt_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        txt_password.setIntensity(0);
        txt_password.setPhColor(new java.awt.Color(0, 112, 192));
        txt_password.setPixels(0);
        txt_password.setPlaceholder("Server Password");
        txt_password.setRound(0);
        pn_containner.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 300, 330, -1));

        txt_database.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 112, 192)));
        txt_database.setPhColor(new java.awt.Color(0, 112, 192));
        txt_database.setPlaceholder("Database Name");
        txt_database.setRound(0);
        pn_containner.add(txt_database, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 330, -1));

        btn_connect.setText("Test Connect");
        btn_connect.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SWAP_VERTICAL_CIRCLE);
        pn_containner.add(btn_connect, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 150, 55));

        btn_save.setText("Save");
        btn_save.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.SAVE);
        pn_containner.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, 150, 55));

        btn_close.setJoIcons(jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons.CLOSE);
        btn_close.setJoRound(50);
        btn_close.setJocolorHover(new java.awt.Color(255, 51, 51));
        pn_containner.add(btn_close, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 10, 40, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_containner, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pn_containner, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(727, 557));
        setLocationRelativeTo(null);
        moveFrame.Move(this, pn_containner);

    }

    private void addEvent() {
        btn_close.addActionListener((e) -> {
            this.dispose();
        });
        btn_save.addActionListener((e) -> {
            if (checkdata()) {
                properties.addValue("db.Server", txt_host.getText());
                properties.addValue("db.database", txt_database.getText());
                properties.addValue("db.user", txt_user.getText());
                if (!txt_password.getText().equals("")) {
                    properties.addValue("db.password", txt_password.getText());
                }
                new JoAlert().messages("ບັນທຶກ", "ບັນທຶກສຳເລັດ", "success");
            }
        });
        btn_connect.addActionListener((e) -> {
            Connection c = JoConnect.getConnection();
            if (c != null) {
                new JoAlert().messages("ບັນທຶກ", "ເຊື່ອມຕໍ່ສຳເລັດ", "success");
            } else {
                new JoAlert().messages("ບັນທຶກ", "ເຊື່ອມຕໍ່ຜິດພາດ", "error");
            }
        });
    }

    private void addData() {
        txt_host.setText(properties.getValueAt("db.Server"));
        txt_database.setText(properties.getValueAt("db.database"));
        txt_user.setText(properties.getValueAt("db.user"));
    }

    private boolean checkdata() {
        return txt_host.TextEmpty() && txt_database.TextEmpty() && txt_user.TextEmpty();
    }

    public JoProperties getProperties() {
        return properties;
    }

}
