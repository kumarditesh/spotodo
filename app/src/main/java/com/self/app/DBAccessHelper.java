package com.self.app;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.self.app.pojo.TaskPojo;

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
        db.execSQL(Constants.Q_CREATETABLE_TASKS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor fetchAllTasks() {
        SQLiteDatabase db = this.getReadableDatabase();
        System.out.println("READABLE DB: "+db);

        Cursor mCursor = db.rawQuery(Constants.Q_SELECT_ALLTASKS, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }

    public void insertTask(TaskPojo task){
        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.Q_INSERT_TASK);
        stmt.bindString(1, task.getLabel());
        stmt.bindLong(2, task.getPrio());
        stmt.bindLong(3, task.getCreatedTime());
        stmt.executeInsert();
    }

    public int insertMultipleTasks(List<TaskPojo> tasks){
        // TODO
        return -1;
    }
}
