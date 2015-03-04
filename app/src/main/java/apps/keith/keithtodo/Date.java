package apps.keith.keithtodo;

/**
* Created by Keith on 3/4/2015.
*/
public class Date {
    private int month;
    private int day;
    private int year;
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }
    public int getDay(){ return day; }
    public int getMonth() { return month; }
    public int getYear() { return year; }
    public String toMonthDayYear(){ return month + "/" + day + "/" + year; }
    private static final int JANUARY = 1;
    private static final int FEBRUARY = 2;
    private static final int MARCH = 3;
    private static final int APRIL = 4;
    private static final int MAY = 5;
    private static final int JUNE = 6;
    private static final int JULY = 7;
    private static final int AUGUST = 8;
    private static final int SEPTEMBER = 9;
    private static final int OCTOBER = 10;
    private static final int NOVEMBER = 11;
    private static final int DECEMBER = 12;
}
