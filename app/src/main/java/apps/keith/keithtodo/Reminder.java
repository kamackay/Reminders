package apps.keith.keithtodo;

public class Reminder {
    private Date dateDue;
    private Time timeDue;
    private ReminderSettings settings;
    private String text;
    public Reminder(Date date, Time time, String text){
        this.dateDue = date;
        this.timeDue = time;
        this.text = text;
        this.settings = new ReminderSettings();
    }

    public Reminder(Date date, Time time, String text, ReminderSettings settings) {
        this.dateDue = date;
        this.timeDue = time;
        this.text = text;
        this.settings = settings;
    }
    public Date getDateDue() { return dateDue; }
    public Time getTimeDue() { return timeDue; }
    public String getText() { return text; }

    public ReminderSettings getSettings() {
        return settings;
    }

    public class ReminderSettings {
        public ReminderSettings() {

        }

        public String encrypt() {
            return "";
        }
    }
    public static Date decryptDate(String date) {
        final char SLASH = '/';
        int month = 0, day = 0, year = 0, i = 0;
        char temp = date.charAt(i);
        while (temp != SLASH && i < 2) {
            month *= 10;
            month += temp - '0';
            i++;
            temp = date.charAt(i);
        }
        i++;
        temp = date.charAt(i);
        while (temp != SLASH) {
            day *= 10;
            day += temp - '0';
            i++;
            temp = date.charAt(i);
        }
        i++;
        temp = date.charAt(i);
        for (int j = i; j <= i+4; j++){
            year *= 10;
            year += temp - '0';
            i++;
            temp = date.charAt(i);
        }
        return null;
    }
    public static Time decryptTime(String time) {
        return null;
    }
    public static ReminderSettings decryptSettings(String settings){
        return null;
    }
    public enum Daytime {AM, PM};
}
