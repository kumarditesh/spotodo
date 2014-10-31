package com.self.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.self.app.pojo.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yash on 30/10/14.
 */
public class DBAccessHelper extends SQLiteOpenHelper {


    public DBAccessHelper(Context context) {
        super(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create DB If not exists. First time use.
        System.out.println("EXECUTING QUERY: "+Constants.Q_CREATETABLE_TASKS);
        db.execSQL(Constants.Q_CREATETABLE_TASKS);
        System.out.println("CREATED TABLE..");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public List<Task> fetchAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("READABLE DB: "+db);

        Cursor cur = db.rawQuery(Constants.Q_SELECT_ALLTASKS, null);

        if (cur != null) {
            cur.moveToFirst();
            List<Task> tasks = new ArrayList<Task>();
            Task task = null;

            while (cur.isAfterLast() == false) {
                task = new Task();
                task.setId(cur.getInt(0));
                task.setLabel(cur.getString(1));
                task.setPrio(Task.Priority.values()[cur.getInt(2)]);
                task.setCreatedTime(cur.getLong(3));
                task.setDeadline(cur.getLong(4));
                task.setStatus(Task.taskstatus.valueOf(cur.getString(5)));
                task.setIsPinned(cur.getInt(6));

                tasks.add(task);
                cur.moveToNext();
            }

            return tasks;
        }
        else{
            return null;
        }
    }

    public void insertTask(Task task){
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.Q_INSERT_TASK);
        System.out.println("INSERTING: "+task);
        stmt.bindString(1, task.getLabel());
        stmt.bindLong(2, task.getPrio().getValue());
        stmt.bindLong(3, task.getCreatedTime());
        stmt.bindLong(4, task.getDeadline());
        stmt.bindString(5, task.getStatus().name());
        stmt.bindLong(6, task.getIsPinned());
        stmt.executeInsert();
    }

    public boolean completeTask(long taskid){
        return false;
    }


    public boolean deleteTask(long taskid){
        return false;
    }


    public void hardDeleteTasks(String tablename){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(Constants.DATABASE_TABLE,null,null);
        db.close();
    }


}
