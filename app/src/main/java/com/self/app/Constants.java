package com.self.app;

/**
 * Created by yash on 30/10/14.
 */
public class Constants {

    public static final String DATABASE_TABLE = "t_tasks";
    public static final String KEY_ROWID = "_id";
    public static final String KEY_LABEL = "label";
    public static final String KEY_CREATIONDATE = "created";
    public static final String KEY_DEADLINE = "deadline";
    public static final String KEY_STATUS = "status";
    public static final String KEY_PRIO = "prio";
    public static final String KEY_PINNED = "pinned";

    public static final String DATABASE_NAME= "db_todoapp";
    public static final int DATABASE_VERSION = 1;

    // Utility Queries
    public static final String Q_CREATETABLE_TASKS = "CREATE TABLE IF NOT EXISTS " + DATABASE_TABLE
            + "("
            + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + KEY_LABEL + " TEXT, "
            + KEY_PRIO + " INTEGER,  "
            + KEY_CREATIONDATE + " DATE, "
            + KEY_DEADLINE + " DATE, "
            + KEY_STATUS + " TEXT "
            + KEY_PINNED + " INTEGER "
            + ")";


    public static final String Q_INSERT_TASK = "INSERT INTO "+DATABASE_TABLE
            + "("+KEY_LABEL+", "+KEY_PRIO+", "+KEY_CREATIONDATE+", "+KEY_DEADLINE+", "+KEY_STATUS+", "+KEY_PINNED+") " +
            "VALUES (?, ?, ?, ?, ?)";


    public static final String Q_SELECT_ALLTASKS = "SELECT * FROM "+DATABASE_TABLE;

    public static final String Q_DELETE_TASK = "";
    public static final String Q_COMPLETE_TASK = "";

    public static final String Q_DROPTABLE = "DROP TABLE IF EXISTS ?";
    public static final String Q_HARDDELETE_ALLTASKS = "DELETE FROM ? ";


}
