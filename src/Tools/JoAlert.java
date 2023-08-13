package Tools;

import Components.JoLable;
import Components.JoTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.JoFont;
import theme.MyColor;

public class JoAlert {

    private Color background;
    private Font font;
    private final JPanel messagePanel;
    private final JoLable Title;
    private final JoLable messages;
    private String[] buttonOption;
    private Color titleColor;
    private Color messageColor;
    private final JoFont joFont;
    private final JoTextField textInput;
    public static int INSERT = 0;
    public static int UPDATE = 1;
    private int iconsize = 50;

    public JoAlert() {
        joFont = new JoFont();
        background = new Color(240, 240, 240);
        font = JoFont.font;
        messagePanel = new JPanel(new java.awt.GridLayout(0, 1));
        Title = new JoLable();
        messages = new JoLable();
        buttonOption = new String[]{"OK"};
        titleColor = MyColor.Dark;
        messageColor = MyColor.Dark;
        textInput = new JoTextField();
        initMessages();
    }

    public int messages(String message) {
        messages.setForeground(messageColor);
        messages.setFont(joFont.loadJoFont(JoFont.fs_bold, 18));
        messages.setText(message);
        messages.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        messagePanel.add(messages);
        return JOptionPane.showOptionDialog(null, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public int messages(String title, String message, String icon) {
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        messages.setForeground(messageColor);
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(IconString(icon));
        Title.setText(title);
        messages.setText(message);
        //==========set font ==================
        Title.setFont(joFont.loadJoFont(1, 20));
        messages.setFont(joFont.loadJoFont(0, 14));
        //========== set position ==============
        messageProsition(lbl_icon);
        messageProsition(Title);
        messageProsition(messages);
        //=============setsize=======================
        messages.setPreferredSize(new Dimension(autosize(messages.getPreferredSize().width, messages), messages.getPreferredSize().height));
        //=============add component ==================
        messagePanel.add(lbl_icon);
        messagePanel.add(Title);
        messagePanel.add(messages);
        //============= create Joptionpane =================
        return JOptionPane.showOptionDialog(null, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public int messages(String title, String[] text, Icons icon) {
        iconsize = 35;
        JPanel Layout = new JPanel(new java.awt.GridLayout(0, 1, 0, 0));
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(IconString(icon));
        Title.setText(title);
        Layout.add(lbl_icon);
        Layout.add(Title);

        Title.setFont(joFont.loadJoFont(1, 20));
        for (String data : text) {
            JoLable lbl = new JoLable();
            lbl.setForeground(messageColor);
            lbl.setText(data);
            //==========set font ==================
            lbl.setFont(joFont.loadJoFont(0, 14));
            //========== set position ==============
            messageProsition(lbl_icon);
            messageProsition(Title);
            messageProsition(lbl);
            //=============setsize=======================
            lbl.setPreferredSize(new Dimension(autosize(lbl.getPreferredSize().width, lbl), 0));
            //=============add component ==================
            Layout.add(lbl);
        }
        //============= create Joptionpane =================
        return JOptionPane.showOptionDialog(null, Layout, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public int messages(String title, String message, Icons icons) {
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        messages.setForeground(messageColor);
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(IconString(icons));
        Title.setText(title);
        messages.setText(message);
        //==========set font ==================
        Title.setFont(joFont.loadJoFont(1, 20));
        messages.setFont(joFont.loadJoFont(0, 14));
        //========== set position ==============
        messageProsition(lbl_icon);
        messageProsition(Title);
        messageProsition(messages);
        //=============setsize=======================
        messages.setPreferredSize(new Dimension(autosize(messages.getPreferredSize().width, messages), messages.getPreferredSize().height));
        //=============add component ==================
        messagePanel.add(lbl_icon);
        messagePanel.add(Title);
        messagePanel.add(messages);
        //============= create Joptionpane =================
        return JOptionPane.showOptionDialog(null, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public int messages(String title, String message, Icon icon) {
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        messages.setForeground(messageColor);
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(icon);
        Title.setText(title);
        messages.setText(message);
        //==========set font ==================
        Title.setFont(joFont.loadJoFont(1, 20));
        messages.setFont(joFont.loadJoFont(0, 14));
        //========== set position ==============
        messageProsition(lbl_icon);
        messageProsition(Title);
        messageProsition(messages);
        //=============setsize=======================
        messages.setPreferredSize(new Dimension(autosize(messages.getPreferredSize().width, messages), messages.getPreferredSize().height));
        //=============add component ==================
        messagePanel.add(lbl_icon);
        messagePanel.add(Title);
        messagePanel.add(messages);
        //============= create Joptionpane =================
        return JOptionPane.showOptionDialog(null, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public int messages(JFrame inFrame, String title, String message, String icon) {
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        messages.setForeground(messageColor);
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(IconString(icon));

        Title.setText(title);
        messages.setText(message);
        //==========set font ==================
        Title.setFont(joFont.loadJoFont(1, 20));
        messages.setFont(joFont.loadJoFont(0, 14));
        //========== set position ==============
        messageProsition(lbl_icon);
        messageProsition(Title);
        messageProsition(messages);
        //=============setsize=======================
        messages.setPreferredSize(new Dimension(autosize(messages.getPreferredSize().width, messages), messages.getPreferredSize().height));
        //=============add component ==================
        messagePanel.add(lbl_icon);
        messagePanel.add(Title);
        messagePanel.add(messages);
        //============= create Joptionpane =================
        return JOptionPane.showOptionDialog(inFrame, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
    }

    public String[] messagesInput(String title, String icon) {
        //===========Create component ===================
        JLabel lbl_icon = new JLabel();
        //===========Design===============
        messages.setForeground(messageColor);
        Title.setForeground(titleColor);
        //========== set Data ===================
        lbl_icon.setIcon(IconString(icon));
        Title.setText(title);
        //==========set font ==================
        Title.setFont(joFont.loadJoFont(1, 20));
        //========== set position ==============
        messageProsition(lbl_icon);
        messageProsition(Title);
        //============== Size =============
        JPanel pane = new JPanel();
        pane.add(textInput);
        //=============add component ==================
        messagePanel.add(lbl_icon);
        messagePanel.add(Title);
        messagePanel.add(pane);
        //============= create Joptionpane =================
        int conf = JOptionPane.showOptionDialog(null, messagePanel, "", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttonOption, buttonOption[0]);
        return new String[]{conf + "", textInput.getText()};
    }

    private void initMessages() {
        UIManager.put("OptionPane.messageFont", new Font(font.getFamily(), 0, 14));
        UIManager.put("OptionPane.buttonFont", new Font(font.getFamily(), 0, 12));
        UIManager.put("OptionPane.background", background);
        UIManager.put("Panel.background", background);
        UIManager.put("OptionPane.yesIcon", IconString(Icons.info));
    }

    private Icon IconString(String IconName) {
        JoIconFont iconFont = new JoIconFont();
        int iconsize = 50;
        switch (IconName) {
            case "success":
                return iconFont.setIconFont(FontAwesome.CHECK_CIRCLE_O, iconsize, MyColor.green200);
            case "error":
                return iconFont.setIconFont(GoogleMaterialDesignIcons.HIGHLIGHT_OFF, iconsize, MyColor.red400);
            case "warning":
                return iconFont.setIconFont(GoogleMaterialDesignIcons.ERROR_OUTLINE, iconsize, MyColor.yellow300);
            case "info":
                return iconFont.setIconFont(GoogleMaterialDesignIcons.INFO_OUTLINE, iconsize, MyColor.cyan200);
            case "question":
                return iconFont.setIconFont(GoogleMaterialDesignIcons.HELP_OUTLINE, iconsize, MyColor.indigo200);
            default:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.INFO_OUTLINE, iconsize, MyColor.cyan200);
        }
    }

    private Icon IconString(Icons icons) {
        JoIconFont iconFont = new JoIconFont();
        switch (icons) {
            case success:
                return iconFont.setIconFont(FontAwesome.CHECK_CIRCLE_O, iconsize, MyColor.green200);
            case error:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.HIGHLIGHT_OFF, iconsize, MyColor.red400);
            case warning:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.ERROR_OUTLINE, iconsize, MyColor.yellow300);
            case info:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.INFO_OUTLINE, iconsize, MyColor.cyan200);
            case question:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.HELP_OUTLINE, iconsize, MyColor.indigo200);
            default:
                return iconFont.setIconFont(GoogleMaterialDesignIcons.INFO_OUTLINE, iconsize, MyColor.cyan200);
        }
    }

    private void messageProsition(JLabel lbl) {
        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    }

    private int autosize(int width, JLabel lbl) {
        int scale = width * 2;
        int textLag = lbl.getText().length() * 2 - lbl.getFont().getSize() * 2;
        return scale - textLag;
    }

    public String[] getButton(Option option) {
        switch (option) {
            case YES_NO:
                return new String[]{"Yes", "No"};
            case YES_CANCEL:
                return new String[]{"Yes", "Cancel"};
            case DELETE_CANCEL:
                return new String[]{"Delete", "Cencel"};
            case LAOS_YES_NO:
                return new String[]{"ຕົກລົງ", "ຍົກເລີກ"};
            case LAOS_DELETE_CANCEL:
                return new String[]{"ລົບ", "ຍົກເລີກ"};
            default:
                return new String[]{"ຕົກລົງ"};
        }
    }

    public static enum Option {
        YES_NO,
        YES_CANCEL,
        DELETE_CANCEL,
        LAOS_YES_NO,
        LAOS_DELETE_CANCEL
    }

    public static enum Icons {
        success,
        error,
        warning,
        info,
        question
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

    public static void Error(Exception e, Object Class) {
        JoAlert alert = new JoAlert();
        alert.messages("Error", Class + "ເກີດຂໍ້ຜິດພາດ " + e, "error");
        System.err.print(Class + "ເກີດຂໍ້ຜິດພາດ: " + e);
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public JPanel getMessagePanel() {
        return messagePanel;
    }

    public String[] getButtonOption() {
        return buttonOption;
    }

    public void setButtonOption(String[] buttonOption) {
        this.buttonOption = buttonOption;
    }

    public void setButtonOption(Option option) {
        this.buttonOption = getButton(option);
    }

    public Color getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(Color titleColor) {
        this.titleColor = titleColor;
    }

    public Color getMessageColor() {
        return messageColor;
    }

    public void setMessageColor(Color messageColor) {
        this.messageColor = messageColor;
    }

    public JoLable getTitle() {
        return Title;
    }

    public JoLable getMessages() {
        return messages;
    }

    public JoTextField getTextInput() {
        return textInput;
    }

    public int getIconsize() {
        return iconsize;
    }

    public void setIconsize(int iconsize) {
        this.iconsize = iconsize;
    }

}
