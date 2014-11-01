package com.self.app.task.row;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.self.app.R;
import com.self.app.pojo.Task;

import java.util.Date;
import java.util.List;

/**
 * Created by ditesh on 1/11/14.
 */
public class RowViewAdapter  extends ArrayAdapter<Task> {

    private final Context context;
    private final List<Task> values;
    private final LayoutInflater inflater;

    public RowViewAdapter(Context context, List<Task> values) {
        super(context, android.R.layout.simple_list_item_1, values);
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = inflater.inflate(R.layout.task_row_brief, parent, false);
        TextView textTitleView = (TextView) rowView.findViewById(R.id.taskTitle);
        String title = values.get(position).getLabel() ;

        textTitleView.setContentDescription(title);
        textTitleView.setText(title);
        textTitleView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                TextView tv= (TextView)v;
                String title = tv.getContentDescription().toString();
                tv.setText(DisplayUtils.getTextOfLength(title, tv.getPaint(),tv.getWidth()));
            }
        });
        TextView textSubtitleView = (TextView) rowView.findViewById(R.id.taskSubtitle);
        textSubtitleView.setText(DisplayUtils.getSubtitleFromDeadline(values.get(position).getDeadline()));

        return rowView;
    }
}
