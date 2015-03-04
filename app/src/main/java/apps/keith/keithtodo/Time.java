package apps.keith.keithtodo;

/**
* Created by Keith on 3/4/2015.
*/
public class Time {
    private int hour;
    private int minute;
    private Reminder.Daytime daytime;
    public Time(int hour, int minute, Reminder.Daytime daytime){
        this.daytime = daytime;
        this.hour = hour;
        this.minute = minute;
    }
    public String to12Hour(){ return hour + ":" + minute + " " + daytime.toString(); }
    public String to24Hour() {
        if (this.daytime == Reminder.Daytime.PM) return (hour + 12) + ":" + minute;
        return hour + ":" + minute;
    }
    public int getHour() { return hour; }
    public int getMinute() { return minute; }
    public Reminder.Daytime getDaytime() { return daytime; }
}
