package apps.keith.keithtodo.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import apps.keith.keithtodo.R;
import apps.keith.keithtodo.Reminder;

public class ReminderView extends LinearLayout {
    private Reminder reminder;
    public ReminderView(Context context, AttributeSet attrs) {
        super(context);
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.reminder_view_layout, this);
    }
    public void associateReminder(){

    }
}
