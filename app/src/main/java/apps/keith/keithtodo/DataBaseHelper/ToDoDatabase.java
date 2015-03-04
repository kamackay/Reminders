package apps.keith.keithtodo.DataBaseHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Scanner;

import apps.keith.keithtodo.Reminder;
import apps.keith.keithtodo.Time;

public class ToDoDatabase {
    private DbHelper helper;
    private SQLiteDatabase db;
    private final Context context;
    public static final String TABLE_NAME = "entry";
    public static final String TODO_VALUE = "todo_value";
    public static final String KEY_NAME = "todo_name";
    public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String ROW_ID = "_id";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    ROW_ID + " INTEGER PRIMARY KEY," +
                    TODO_VALUE + TEXT_TYPE + COMMA_SEP +
                    KEY_NAME + TEXT_TYPE + COMMA_SEP + ")";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + TABLE_NAME;
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ToDoStorage.db";

    public ToDoDatabase(Context context) {
        this.context = context;
    }
    public ToDoDatabase open() {
        helper = new DbHelper(this.context);
        db = helper.getWritableDatabase();
        return this;
    }
    public void close() {
        helper.close();
    }
    public long createEntry(Reminder reminder) {
        String toDoString = ToDoEncryption.encryptToDo(reminder);
        ContentValues cv = new ContentValues();
        cv.put(reminder.getText(), toDoString);
        return db.insert(DATABASE_NAME, null, cv);
    }
    public String getData() {
        String[] columns = { ROW_ID, TODO_VALUE, KEY_NAME };
        Cursor cursor = db.query(DATABASE_NAME, columns, null, null, null, null, null);
        String result = "";

        return "";
    }
    private static class DbHelper extends SQLiteOpenHelper {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
    public static final class ToDoEncryption {
        private ToDoEncryption() {}
        public static String encryptToDo(Reminder reminder){
            StringBuilder builder = new StringBuilder();
            Time time = reminder.getTimeDue();
            builder.append(reminder.getDateDue().toMonthDayYear() + delim);
            builder.append(reminder.getTimeDue().to12Hour() + delim);
            builder.append(reminder.getText() + delim);
            builder.append(reminder.getSettings().encrypt());
            return builder.toString();
        }
        public Reminder decryptToDo(String toDo) {
            Scanner in = new Scanner(toDo);
            in.useDelimiter(delim);
            String dateString = in.next();
            String timeString = in.next();
            String text = in.next();
            String settingsString = in.next();

            return new Reminder(Reminder.decryptDate(dateString), Reminder.decryptTime(timeString), text, Reminder.decryptSettings(settingsString));
        }
        private static final String delim = "!";
    }
}
