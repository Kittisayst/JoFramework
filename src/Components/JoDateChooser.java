package Components;

import ClassUI.JoDateScrollBar;
import Tools.JoAlert;
import javax.swing.JPanel;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.plaf.ScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import jiconfont.icons.google_material_design_icons.GoogleMaterialDesignIcons;
import theme.JoTheme;

public final class JoDateChooser extends JPanel {

    private Language language = Language.LAOS;

    int PosicionMouse;

    private String formatdate = "dd/MM/yyyy";

    private String datenull = "";

    private String placeholder = "ເລືອກວັນທີ່";

    private Date dateData = null;

    public int realYear;

    public int realMonth;

    public int realDay;

    public int currentYear;

    public int currentMonth;

    private final String[] monthsLao = new String[]{"ມັງກອນ", "ກຸມພາ", "ມີນາ", "ເມສາ", "ພຶດສະພາ", "ມິຖຸນາ", "ກໍລະກົດ", "ສິງຫາ", "ກັນຍາ", "ຕຸລາ", "ພະຈິກ", "ທັນວາ"};

    private final String[] monthsLaoMax = new String[]{"ມັງກອນ", "ກຸມພາ", "ມີນາ", "ເມສາ", "ພຶດສະພາ", "ມິຖຸນາ", "ກໍລະກົດ", "ສິງຫາ", "ກັນຍາ", "ຕຸລາ", "ພະຈິກ", "ທັນວາ"};

    private final String LaoChange = "ເລືອກປີ";

    private final String changeYearMin = "Change year1";

    private final String[] monthsMinE = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private final String[] mesesMay = new String[]{"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

    private final String changeYear = "Change Year";

    private Color colorCurrentDay = JoTheme.Secondary;

    private Color colorText = new Color(255, 255, 255);

    private Color JoThemeColor = JoTheme.Primary;

    private Color JoDayTextSelect = new Color(255, 255, 255);

    private Color colorButtonHover = JoTheme.Secondary;

    private boolean textMayusculas = true;

    private Font JoCalendarFont = new Font("Phetsarath OT", 1, 12);

    private GoogleMaterialDesignIcons dateIcon = GoogleMaterialDesignIcons.EVENT;

    //========================= Component ===================================
    private JoButtonIconfont btn_plus;

    private JoButtonIconfont btn_minus;

    private JoButtonIconfont btnCalendar;

    private JoButtonIconfont btnNext;

    private JoButtonIconfont btnPrev;

    private JPanel calendar;

    private JLabel lblchangeYear;

    private JPanel jPanel2;

    private JScrollPane jScrollPane2;

    private JLabel lblMonthName;

    private JoPopUpMenu menu;

    private JoTableCalendar tblCalendar;

    private JoTextFieldDate txt_showDate;

    private JoTextFieldDate txtYear;

    private Color JoDateForeground = JoTheme.Primary;

    public JoDateChooser() {
        initComponents();
        this.menu.add(this.calendar);
        setSize(new Dimension(240, 40));
        this.tblCalendar.setCursor(new Cursor(12));
        this.jScrollPane2.getVerticalScrollBar().setUI((ScrollBarUI) new JoDateScrollBar());
        GregorianCalendar cal = new GregorianCalendar();
        this.realDay = cal.get(5);
        this.realMonth = cal.get(2);
        this.realYear = cal.get(1);
        this.currentMonth = this.realMonth;
        this.currentYear = this.realYear;
        this.txtYear.setText(String.valueOf(this.realYear));
        refreshCalendar(this.realMonth, this.realYear);
        this.lblchangeYear.setFont(JoCalendarFont);
        this.txt_showDate.setFont(JoCalendarFont);
        this.txt_showDate.setForeground(JoDateForeground);
        this.lblchangeYear.setFont(JoCalendarFont);
    }

    private void initComponents() {
        try {
            this.menu = new JoPopUpMenu();
            this.calendar = new JPanel();
            this.jScrollPane2 = new JScrollPane();
            this.tblCalendar = new JoTableCalendar();
            this.lblchangeYear = new JLabel();
            this.btnPrev = new JoButtonIconfont();
            this.btnNext = new JoButtonIconfont();
            this.lblMonthName = new JLabel();
            this.jPanel2 = new JPanel();
            this.btn_minus = new JoButtonIconfont();
            this.btn_plus = new JoButtonIconfont();
            this.btnCalendar = new JoButtonIconfont();
            ButtonStayle(btnPrev);
            ButtonStayle(btnNext);
            ButtonStayle(btn_minus);
            ButtonStayle(btn_plus);
            ButtonStayle(btnCalendar);
            this.txtYear = new JoTextFieldDate();
            this.txt_showDate = new JoTextFieldDate();
            this.calendar.setBackground(new Color(255, 255, 255));
            this.calendar.setBorder(BorderFactory.createLineBorder(new Color(0, 112, 192), 3));
            this.jScrollPane2.setBorder((Border) null);
            tblCalendar.getTableHeader().setResizingAllowed(false);
            tblCalendar.getTableHeader().setReorderingAllowed(false);
            tblCalendar.setModel(new javax.swing.table.DefaultTableModel(
                    new Object[][]{
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null},
                        {null, null, null, null, null, null, null}},
                    new String[]{"ທິດ", "ຈັນ", "ອັງຄານ", "ພຸດ", "ພະຫັດ", "ສຸກ", "ເສົາ"}) {
                boolean[] canEdit = new boolean[]{false, false, false, false, false, true, true};

                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit[columnIndex];
                }
            });

            this.tblCalendar.setGrosorBordeFilas(0);
            this.tblCalendar.setGrosorBordeHead(0);
            this.tblCalendar.setMultipleSeleccion(false);
            this.tblCalendar.setRowHeight(30);
            this.tblCalendar.getTableHeader().setReorderingAllowed(false);
            this.tblCalendar.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    JoDateChooser.this.tblCalendarMousePressed(evt);
                }
            });
            this.jScrollPane2.setViewportView((Component) this.tblCalendar);
            this.lblchangeYear.setFont(new Font("Phetsarath OT", 1, 16));
            this.lblchangeYear.setText("CHANGE YEAR");
            this.btnPrev.setJoIcons(GoogleMaterialDesignIcons.KEYBOARD_ARROW_LEFT);
            this.btnPrev.addActionListener((ActionEvent evt) -> {
                JoDateChooser.this.btnPrevActionPerformed(evt);
            });
            this.btnNext.setJoIcons(GoogleMaterialDesignIcons.KEYBOARD_ARROW_RIGHT);
            this.btnNext.addActionListener((ActionEvent evt) -> {
                JoDateChooser.this.btnNextActionPerformed(evt);
            });
            this.lblMonthName.setFont(new Font(JoCalendarFont.getFamily(), 1, 14));

            this.lblMonthName.setHorizontalAlignment(0);
            this.lblMonthName.setText("MES");
            this.jPanel2.setOpaque(false);
            this.btn_minus.setJoIcons(GoogleMaterialDesignIcons.EXPAND_MORE);
            this.btn_minus.setJoIconSize(25);
            this.btn_minus.addActionListener((ActionEvent evt) -> {
                JoDateChooser.this.btn2ActionPerformed(evt);
            });
            this.btn_plus.setJoIcons(GoogleMaterialDesignIcons.EXPAND_LESS);
            this.btn_plus.setJoIconSize(25);
            this.btn_plus.addActionListener((ActionEvent evt) -> {
                JoDateChooser.this.btn1ActionPerformed(evt);
            });
            this.txtYear.setFont(JoCalendarFont);
            this.txtYear.setForeground(new Color(0, 60, 143));
            this.txtYear.setHorizontalAlignment(0);
            this.txtYear.setText("0000");
            this.txtYear.setBorder(BorderFactory.createLineBorder(new Color(0, 60, 143), 2));
            this.txtYear.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent evt) {
                    JoDateChooser.this.txtYearKeyReleased(evt);
                }

                @Override
                public void keyTyped(KeyEvent evt) {
                    JoDateChooser.this.txtYearKeyTyped(evt);
                }
            });
            GroupLayout jPanel2Layout = new GroupLayout(this.jPanel2);
            this.jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(jPanel2Layout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(this.txtYear, -1, 87, 32767)
                            .addGap(6, 6, 6)
                            .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent((Component) this.btn_plus, -2, 47, -2)
                                    .addComponent((Component) this.btn_minus, -2, 47, -2))));
            jPanel2Layout.setVerticalGroup(jPanel2Layout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(this.txtYear)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent((Component) this.btn_plus, -2, 0, 32767)
                            .addGap(2, 2, 2)
                            .addComponent((Component) this.btn_minus, -2, 0, 32767)));
            GroupLayout calendarLayout = new GroupLayout(this.calendar);
            this.calendar.setLayout(calendarLayout);
            calendarLayout.setHorizontalGroup(calendarLayout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, calendarLayout.createSequentialGroup()
                            .addGap(0, 0, 0)
                            .addGroup(calendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(this.jScrollPane2, -2, 0, 32767)
                                    .addGroup(calendarLayout.createSequentialGroup()
                                            .addGroup(calendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                    .addGroup(calendarLayout.createSequentialGroup()
                                                            .addGap(6, 6, 6)
                                                            .addComponent((Component) this.btnPrev, -2, 47, -2)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(this.lblMonthName, -1, -1, 32767)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent((Component) this.btnNext, -2, 47, -2))
                                                    .addGroup(calendarLayout.createSequentialGroup()
                                                            .addGap(10, 10, 10)
                                                            .addComponent(this.lblchangeYear, -1, 142, 32767)
                                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(this.jPanel2, -2, -1, -2)))
                                            .addContainerGap()))));
            calendarLayout.setVerticalGroup(calendarLayout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(calendarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(calendarLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                    .addComponent((Component) this.btnNext, -2, 28, -2)
                                    .addGroup(calendarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(this.lblMonthName, -2, 28, -2)
                                            .addComponent((Component) this.btnPrev, -2, 28, -2)))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(this.jScrollPane2, -2, 232, -2)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(calendarLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(this.lblchangeYear, -1, 32, 32767)
                                    .addComponent(this.jPanel2, -1, -1, 32767))
                            .addContainerGap(-1, 32767)));
            setBackground(new Color(255, 255, 255));
            setOpaque(false);
            setPreferredSize(new Dimension(240, 40));
            this.btnCalendar.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent evt) {
                    JoDateChooser.this.btnCalendarioMousePressed(evt);
                }
            });

            btnCalendar.setJoIcons(GoogleMaterialDesignIcons.EVENT);
            btnCalendar.setJoIconSize(28);
            GroupLayout btnCalendarioLayout = new GroupLayout((Container) this.btnCalendar);
            this.btnCalendar.setLayout(btnCalendarioLayout);
            btnCalendarioLayout.setHorizontalGroup(btnCalendarioLayout
                    .createParallelGroup(GroupLayout.Alignment.LEADING));
            btnCalendarioLayout.setVerticalGroup(btnCalendarioLayout
                    .createParallelGroup(GroupLayout.Alignment.LEADING));
//
            this.txt_showDate.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 0, JoThemeColor));
            this.txt_showDate.setHorizontalAlignment(0);
            this.txt_showDate.setPlaceholder("ເລືອກວັນທີ່");
            this.txt_showDate.setPhColor(JoThemeColor);
            this.txt_showDate.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent evt) {

                }
            });
            GroupLayout layout = new GroupLayout(this);
            setLayout(layout);
            layout.setHorizontalGroup(layout
                    .createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent((Component) this.txt_showDate, -1, -1, 32767)
                            .addGap(0, 0, 0)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent((Component) this.btnCalendar, -2, 30, -2)));
            layout.setVerticalGroup(layout
                    .createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGap(0, 0, 0)
                    .addComponent((Component) this.btnCalendar, 0, 0, this.getPreferredSize().height)
                    .addComponent((Component) this.txt_showDate, -1, -1, 32767));
        } catch (UnsupportedLookAndFeelException | InstantiationException | ClassNotFoundException | IllegalAccessException ex) {
            Logger.getLogger(JoDateChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void btnCalendarioMousePressed(MouseEvent evt) {
        if ((evt.getModifiers() & 0x10) == 16) {
            this.PosicionMouse = evt.getY() / 16;
            this.menu.show(evt.getComponent(), evt.getX(), evt.getY());
        }
    }

    private void tblCalendarMousePressed(MouseEvent evt) {
        refreshCalendar(this.currentMonth, this.currentYear);
        int fila = this.tblCalendar.getSelectedRow();
        int columna = this.tblCalendar.getSelectedColumn();
        if (this.tblCalendar.getValueAt(fila, columna) != null) {
            try {
                String dia = this.tblCalendar.getValueAt(fila, columna).toString();
                String mes = "";
                if (this.language == Language.LAOS) {
                    for (int i = 0; i < this.monthsLaoMax.length; i++) {
                        if ((this.monthsLaoMax[i] == null ? this.lblMonthName.getText() == null : this.monthsLaoMax[i].equals(this.lblMonthName.getText()))
                                || (this.monthsLao[i] == null ? this.lblMonthName.getText() == null : this.monthsLao[i].equals(this.lblMonthName.getText()))) {
                            mes = String.valueOf(i + 1);
                        }
                    }
                }
                if (this.language == Language.ENGLISH) {
                    for (int i = 0; i < this.mesesMay.length; i++) {
                        if ((this.mesesMay[i] == null ? this.lblMonthName.getText() == null : this.mesesMay[i].equals(this.lblMonthName.getText()))
                                || (this.monthsMinE[i] == null ? this.lblMonthName.getText() == null : this.monthsMinE[i].equals(this.lblMonthName.getText()))) {
                            mes = String.valueOf(i + 1);
                        }
                    }
                }
                this.datenull = this.txtYear.getText() + "-" + mes + "-" + dia + " 00:00:00.0";
                SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date dates = dt.parse(this.datenull);
                SimpleDateFormat dt1 = new SimpleDateFormat(this.formatdate);
                setDateData(dates);
                this.menu.setVisible(false);

            } catch (ParseException ex) {
                Logger.getLogger(JoDateChooser.class
                        .getName()).log(Level.SEVERE, (String) null, ex);
            }
        }
    }

    private void btnPrevActionPerformed(ActionEvent evt) {
        if (this.currentMonth == 0) {
            this.currentMonth = 11;
            this.currentYear--;
        } else {
            this.currentMonth--;
        }
        refreshCalendar(this.currentMonth, this.currentYear);
    }

    private void btnNextActionPerformed(ActionEvent evt) {
        if (this.currentMonth == 11) {
            this.currentMonth = 0;
            this.currentYear++;
        } else {
            this.currentMonth++;
        }
        refreshCalendar(this.currentMonth, this.currentYear);
    }

    private void btn2ActionPerformed(ActionEvent evt) {
        if (this.txtYear.getText().length() >= 4 && !this.txtYear.getText().equals("")) {
            int valor = Integer.parseInt(this.txtYear.getText());
            if (valor < 1000) {
                refreshCalendar(this.currentMonth, this.currentYear);
            } else if (valor == 1000) {
                refreshCalendar(this.currentMonth, this.currentYear);
            } else {
                this.currentYear--;
                refreshCalendar(this.currentMonth, this.currentYear);
            }
        } else {
            refreshCalendar(this.currentMonth, this.currentYear);
        }
    }

    private void btn1ActionPerformed(ActionEvent evt) {
        if (this.txtYear.getText().length() >= 4 && !this.txtYear.getText().equals("")) {
            int valor = Integer.parseInt(this.txtYear.getText());
            if (valor < 1000) {
                refreshCalendar(this.currentMonth, this.currentYear);
            } else {
                this.currentYear++;
                refreshCalendar(this.currentMonth, this.currentYear);
            }
        } else {
            refreshCalendar(this.currentMonth, this.currentYear);
        }
    }

    private void txtYearKeyReleased(KeyEvent evt) {
        if (!this.txtYear.getText().equals("")) {
            this.currentYear = Integer.parseInt(this.txtYear.getText());
            refreshCalendar(this.currentMonth, this.currentYear);
        }
    }

    private void txtYearKeyTyped(KeyEvent evt) {
        char car = evt.getKeyChar();
        if (car < '0' || car > '9') {
            evt.consume();
        }
        if (this.txtYear.getText().length() == 4) {
            evt.consume();
        }
    }

    public void refreshCalendar(int month, int year) {
        this.jScrollPane2.getViewport().setBackground(Color.WHITE);
        if (this.language == Language.LAOS) {
            this.btnPrev.setEnabled(true);
            this.btnNext.setEnabled(true);
            if (month == 0 && year <= this.realYear - 10) {
                this.btnPrev.setEnabled(false);
            }
            if (month == 11 && year >= this.realYear + 100) {
                this.btnNext.setEnabled(false);
            }
            if (this.textMayusculas) {
                this.lblMonthName.setText(this.monthsLaoMax[month]);
                this.lblchangeYear.setText(this.LaoChange);
            } else {
                this.lblMonthName.setText(this.monthsLao[month]);
                this.lblchangeYear.setText(this.LaoChange);
            }
            this.txtYear.setText(String.valueOf(year));
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 7; k++) {
                    this.tblCalendar.setValueAt(null, i, k);
                }
            }
            GregorianCalendar cal = new GregorianCalendar(year, month, 1);
            int nod = cal.getActualMaximum(5);
            int som = cal.get(7);
            for (int j = 1; j <= nod; j++) {
                int row = (j + som - 2) / 7;
                int column = (j + som - 2) % 7;
                this.tblCalendar.setValueAt(j, row, column);
            }
        }
        if (this.language == Language.ENGLISH) {
            this.btnPrev.setEnabled(true);
            this.btnNext.setEnabled(true);
            if (month == 0 && year <= this.realYear - 10) {
                this.btnPrev.setEnabled(false);
            }
            if (month == 11 && year >= this.realYear + 100) {
                this.btnNext.setEnabled(false);
            }
            if (this.textMayusculas) {
                this.lblMonthName.setText(this.mesesMay[month]);
                this.lblchangeYear.setText(this.changeYear);
            } else {
                this.lblMonthName.setText(this.monthsMinE[month]);
                this.lblchangeYear.setText(this.changeYearMin);
            }
            this.txtYear.setText(String.valueOf(year));
            for (int i = 0; i < 6; i++) {
                for (int k = 0; k < 7; k++) {
                    this.tblCalendar.setValueAt(null, i, k);
                }
            }
            GregorianCalendar cal = new GregorianCalendar(year, month, 1);
            int nod = cal.getActualMaximum(5);
            int som = cal.get(7);
            for (int j = 1; j <= nod; j++) {
                int row = (j + som - 2) / 7;
                int column = (j + som - 2) % 7;
                this.tblCalendar.setValueAt(j, row, column);

            }
        }
        this.tblCalendar.setDefaultRenderer(Object.class, (TableCellRenderer) new tblCalendarRenderer());

    }

    private void ButtonStayle(JoButtonIconfont btn) {
        btn.setJoShaowSize(0);
        btn.setJoshadowOpacity(0);
        btn.setJoRound(5);
    }

    public class tblCalendarRenderer extends DefaultTableCellRenderer {

        private Component componenete;

        private final Font fontRows = new Font(JoCalendarFont.getFamily(), 1, 14);

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {
            this.componenete = super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            this.componenete.setFont(this.fontRows);
            setHorizontalAlignment(0);
            setBorder((Border) null);
            this.componenete.setForeground(Color.black);
            if (column == 0 || column == 6) {
                this.componenete.setBackground(Color.white);
            } else {
                this.componenete.setBackground(Color.white);
            }
            if (value != null
                    && Integer.parseInt(value.toString()) == JoDateChooser.this.realDay && JoDateChooser.this.currentMonth == JoDateChooser.this.realMonth && JoDateChooser.this.currentYear == JoDateChooser.this.realYear) {
                this.componenete.setBackground(JoDateChooser.this.colorCurrentDay);
                this.componenete.setForeground(JoDateChooser.this.colorText);
            }
            if (row == JoDateChooser.this.tblCalendar.getSelectedRow() && column == JoDateChooser.this.tblCalendar.getSelectedColumn() && value != null) {
                this.componenete.setBackground(JoDateChooser.this.JoThemeColor);
                this.componenete.setForeground(JoDateChooser.this.JoDayTextSelect);
            }
            return this.componenete;
        }
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
        TableColumnModel columnModel = this.tblCalendar.getColumnModel();
        if (language == Language.LAOS) {
            columnModel.getColumn(0).setHeaderValue("ຈັນ");
            columnModel.getColumn(1).setHeaderValue("ຄານ");
            columnModel.getColumn(2).setHeaderValue("ພຸດ");
            columnModel.getColumn(3).setHeaderValue("ພະຫັດ");
            columnModel.getColumn(4).setHeaderValue("ສຸກ");
            columnModel.getColumn(5).setHeaderValue("ເສົາ");
            columnModel.getColumn(6).setHeaderValue("ທິດ");
        }
        if (language == Language.ENGLISH) {
            columnModel.getColumn(0).setHeaderValue("SU");
            columnModel.getColumn(1).setHeaderValue("MO");
            columnModel.getColumn(2).setHeaderValue("TU");
            columnModel.getColumn(3).setHeaderValue("WE");
            columnModel.getColumn(4).setHeaderValue("TH");
            columnModel.getColumn(5).setHeaderValue("FR");
            columnModel.getColumn(6).setHeaderValue("SA");
        }
        refreshCalendar(this.currentMonth, this.currentYear);

    }

    public void setDateData(String dateData) {
        try {
            if (dateData != null || !dateData.equals("")) {
                SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
                Date convert = date.parse(dateData);
                setDateData(convert);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
        }
    }

    public String getDate() {
        try {
            if (checkDate()) {
                return null;
            } else {
                SimpleDateFormat df = new SimpleDateFormat(formatdate);
                System.out.println(df.format(dateValue()));
                return df.format(dateValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    public int getYear() {
        Date mydate = null;
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Paris"));
        cal.setTime(mydate);
        int year = cal.get(Calendar.YEAR);
        return year;
    }

    public boolean DateEmpty() {
        if (checkDate()) {
            new JoAlert().messages("ວ່າງເປົ່າ", "ກະລຸນາເລືອກວັນທີ່", "warning");
            txt_showDate.requestFocus();
            return false;
        } else {
            return formatCheck(txt_showDate.getText());
        }
    }

    private boolean formatCheck(String text) { // ກວດສອບຮູບແບບວັນທີ່ເດືອນປີ
        String dateFormat = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
        if (Pattern.matches(dateFormat, text)) {
            int day = Integer.parseInt(text.substring(0, 2));
            int month = Integer.parseInt(text.substring(3, 5));
            // Check if day is <= 31 and month is <= 12
            if (day <= 31 && month <= 12) {
                return true;
            } else {
                 new JoAlert().messages("ຮູບແບບວັນທີບໍ່ຖືກຕ້ອງ", "ວັນທີ່ ຫຼື  ເດືອນ ບໍ່ຖືກຕ້ອງ", JoAlert.Icons.warning);
                return false;
            }
        } else {
            new JoAlert().messages("ຮູບແບບວັນທີບໍ່ຖືກຕ້ອງ", "ຕົວຢ່າງ: 09/12/2010", JoAlert.Icons.warning);
            txt_showDate.requestFocus();
            return false;
        }
    }

    public String getDateSQL() {
        try {
            if (checkDate()) {
                txt_showDate.requestFocus();
                return null;
            } else {
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                return sf.format(dateValue());
            }
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    private boolean checkDate() {
        return dateData == null && txt_showDate.getText().isEmpty();
    }

    private Date dateValue() throws ParseException {
        SimpleDateFormat sf = new SimpleDateFormat(formatdate);
        if (dateData == null) {
            System.out.println(txt_showDate.getText());
            return sf.parse(txt_showDate.getText());
        } else if (txt_showDate.getText().isEmpty()) {
            return dateData;
        } else {
            return dateData == null ? sf.parse(txt_showDate.getText()) : dateData;
        }
    }

    public enum Language {
        LAOS, ENGLISH;
    }

    // Getter Setter
    public Color getColorButtonHover() {
        return this.colorButtonHover;
    }

    public void setColorButtonHover(Color colorButtonHover) {
        this.colorButtonHover = colorButtonHover;
        this.btnCalendar.setJocolorHover(this.colorButtonHover);
        this.btnNext.setJocolorHover(this.colorButtonHover);
        this.btnPrev.setJocolorHover(this.colorButtonHover);
        this.btn_plus.setJocolorHover(this.colorButtonHover);
        this.btn_minus.setJocolorHover(this.colorButtonHover);
    }

    public boolean isTextMayusculas() {
        return this.textMayusculas;
    }

    public void setTextMayusculas(boolean textMayusculas) {
        this.textMayusculas = textMayusculas;
        refreshCalendar(this.currentMonth, this.currentYear);
    }

    public String getFormatdate() {
        return formatdate;
    }

    public void setFormatdate(String formatdate) {
        this.formatdate = formatdate;
    }

    public Color getJoDayTextSelect() {
        return JoDayTextSelect;
    }

    public void setJoDayTextSelect(Color JoDayTextSelect) {
        this.JoDayTextSelect = JoDayTextSelect;
    }

    public String getPlaceholder() {
        return this.placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
        this.txt_showDate.setPlaceholder(this.placeholder);
    }

    public Font getJoCalendarFont() {
        return JoCalendarFont;
    }

    public void setJoCalendarFont(Font JoCalendarFont) {
        this.JoCalendarFont = JoCalendarFont;
        this.txt_showDate.setFont(this.JoCalendarFont);
    }

    public Date getDateData() {
        if (dateData == null) {
            txt_showDate.requestFocus();
            return null;
        } else {
            return dateData;
        }
    }

    public java.sql.Date getSQLDate() {
        if (dateData == null) {
            txt_showDate.requestFocus();
            return null;
        } else {
            return new java.sql.Date(dateData.getTime());
        }
    }

    public void setDateData(Date dateData) {
        this.dateData = dateData;
        if (dateData == null) {
            this.txt_showDate.setText("");
        } else {
            Date dates = dateData;
            SimpleDateFormat dt1 = new SimpleDateFormat(this.formatdate);
            this.txt_showDate.setText(dt1.format(dates));
        }
    }

    public Color getColorCurrentDay() {
        return colorCurrentDay;
    }

    public void setColorCurrentDay(Color colorCurrentDay) {
        this.colorCurrentDay = colorCurrentDay;
    }

    public Color getColorText() {
        return colorText;
    }

    public void setColorText(Color colorText) {
        this.colorText = colorText;
    }

    public Color getJoThemeColor() {
        return JoThemeColor;
    }

    public void setJoThemeColor(Color JoThemeColor) {
        this.JoThemeColor = JoThemeColor;
        this.btnNext.setBackground(this.JoThemeColor);
        this.btnPrev.setBackground(this.JoThemeColor);
        this.btn_plus.setBackground(this.JoThemeColor);
        this.btn_minus.setBackground(this.JoThemeColor);
        Border border0 = BorderFactory.createMatteBorder(2, 2, 2, 0, this.JoThemeColor);
        this.txt_showDate.setBorder(border0);
        this.txt_showDate.setPhColor(this.JoThemeColor);
        this.btnCalendar.setBackground(this.JoThemeColor);
        Border border1 = BorderFactory.createLineBorder(this.JoThemeColor, 3);
        this.calendar.setBorder(border1);
        this.tblCalendar.setColorBackgoundHead(this.JoThemeColor);
        this.txtYear.setForeground(this.JoThemeColor);
        Border border2 = BorderFactory.createLineBorder(this.JoThemeColor, 2);
        this.txtYear.setBorder(border2);
    }

    public Color getJoDateForeground() {
        return JoDateForeground;
    }

    public void setJoDateForeground(Color JoDateForeground) {
        this.JoDateForeground = JoDateForeground;
        this.txt_showDate.setForeground(this.JoDateForeground);
    }

    public GoogleMaterialDesignIcons getDateIcon() {
        return dateIcon;
    }

    public void setDateIcon(GoogleMaterialDesignIcons dateIcon) {
        this.dateIcon = dateIcon;
        btnCalendar.setJoIcons(dateIcon);
    }

}
