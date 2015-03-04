package apps.keith.keithtodo;

import android.content.Context;
import java.util.ArrayList;
import apps.keith.keithtodo.DataBaseHelper.ToDoDatabase;

public class ReminderList {
    private ArrayList<Reminder> list;
    private ToDoDatabase db;
    public ReminderList(Context context) {
        db = new ToDoDatabase(context);
        list = new ArrayList<>();
    }
    public void add(Reminder reminder){
        list.add(reminder);
    }
}
