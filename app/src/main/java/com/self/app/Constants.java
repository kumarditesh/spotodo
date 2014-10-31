package com.self.app;

/**
 * Created by yash on 30/10/14.
 */
public class Constants {

    public static final String KEY_ROWID = "_id";
    public static final String KEY_LABEL = "label";
    public static final String KEY_CREATIONDATE = "created";
    public static final String KEY_PRIO = "prio";
    public static final String DATABASE_NAME= "db_todoapp";
    public static final String DATABASE_TABLE = "t_tasks";
    public static final int DATABASE_VERSION = 1;

    // Utility Queries
    public static final String Q_CREATETABLE_TASKS = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE
            + "("
            + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_LABEL + " TEXT, "
            + KEY_PRIO + " INTEGER,  " + KEY_CREATIONDATE + " DATE "
            + ")";


    public static final String Q_INSERT_TASK = "INSERT INTO "+DATABASE_TABLE
            + "("+KEY_LABEL+", "+KEY_PRIO+", "+KEY_CREATIONDATE+") " +
            "VALUES (?, ?, ?)";


    public static final String Q_SELECT_ALLTASKS = "SELECT * FROM "+DATABASE_TABLE;


}
