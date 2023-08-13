package Tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class JoDateTime {

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private Calendar calendar;

    public JoDateTime() {
        calendar = Calendar.getInstance(TimeZone.getTimeZone("ICT"));
    }

    public String getDateNow() {
        try {
            return format.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }
    
       public String getTimeNow() {
        try {
            format = new SimpleDateFormat("hh:mm:ss");
            return format.format(calendar.getTime());
        } catch (Exception e) {
            e.printStackTrace();
            new JoAlert().messages("ຂໍ້ຜິດພາດ", getClass().getName(), "error");
            return null;
        }
    }

    public java.sql.Date getParseDate(Date date) {
        return new java.sql.Date(date.getTime());
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

}
