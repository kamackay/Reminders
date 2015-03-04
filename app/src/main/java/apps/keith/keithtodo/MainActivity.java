package apps.keith.keithtodo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import apps.keith.keithtodo.CustomViews.ReminderView;
import apps.keith.keithtodo.Reminder.*;


public class MainActivity extends ActionBarActivity {
    private ReminderList tdal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tdal = new ReminderList(getApplicationContext());

        Reminder testReminder = new Reminder(new Date(5, 7, 2010), new Time(5, 10, Daytime.PM), "This reminder is a test.");

        ReminderView tdv = new ReminderView(getApplicationContext(), testReminder);
        ListView lv = (ListView)findViewById(R.id.main_menu_list);
        lv.addView(tdv);yyayaayayaya
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.main_menu_action_settings) {
            return true;
        } else if (id == R.id.main_menu_action_add_todo) {

        }
        return super.onOptionsItemSelected(item);
    }
}
