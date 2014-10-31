package com.self.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.self.app.R;
import com.self.app.pojo.TaskPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShowTasks extends Activity {

    private ListView listview;
    private Button btnAddTask;
    private Context context;
    private EditText result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tasks);
        context = this;
        listview = (ListView) findViewById(R.id.tasks_list);
        btnAddTask  = (Button) findViewById(R.id.add_task);

        btnAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                // get prompts.xml view
                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.dialog_add_task, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                final EditText userInput = (EditText) promptsView
                        .findViewById(R.id.label);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("DONE",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        // TODO: Insert values to db here
                                        System.out.println("LABEL INPUT: "+userInput.getText());
                                        result.setText(userInput.getText());
                                    }
                                });


                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });



                System.out.println("INITIATING...");

                // Fetch sample records if they exist
                DBAccessHelper dbhelper = new DBAccessHelper(this);

                //INSERT Sample record, For testing only
                System.out.println("SAMPLE INSERT...");
       TaskPojo t1 = new TaskPojo("Some shitty task", TaskPojo.LOW_PRIO, System.currentTimeMillis());
        dbhelper.insertTask(t1);

                System.out.println("FETCH INITIATED..");
                Cursor cur = dbhelper.fetchAllTasks();

                System.out.println("UI DISPLAY..");
                List<String> tasks = new ArrayList<String>();
                List<Integer> prio = new ArrayList<Integer>();
                TaskPojo task = null;

                while (cur.isAfterLast() == false) {
                    task = new TaskPojo();
                    task.setId(cur.getInt(0));
                    task.setLabel(cur.getString(1));
                    task.setPrio(cur.getInt(2));
                    task.setCreatedTime(cur.getLong(3));

                    System.out.println(task);
                    tasks.add(task.getLabel());
                    prio.add(task.getPrio());
                    cur.moveToNext();
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ShowTasks.this, android.R.layout.simple_list_item_1, tasks);
                listview.setAdapter(adapter);
            }


            @Override
            public boolean onCreateOptionsMenu(Menu menu) {
                // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.show_tasks, menu);
                return true;
            }

            @Override
            public boolean onOptionsItemSelected(MenuItem item) {
                // Handle action bar item clicks here. The action bar will
                // automatically handle clicks on the Home/Up button, so long
                // as you specify a parent activity in AndroidManifest.xml.
                int id = item.getItemId();
                if (id == R.id.action_settings) {
                    return true;
                }
                return super.onOptionsItemSelected(item);
            }
        }
