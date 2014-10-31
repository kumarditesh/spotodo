package com.self.app.pojo;

/**
 * Created by yash on 30/10/14.
 */
public class TaskPojo {

    public static int HIGH_PRIO = 1;
    public static int MEDIUM_PRIO = 2;
    public static int LOW_PRIO = 3;

    private int id;
    private String label;
    private long createdTime;
    private int prio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public TaskPojo() {}

    public TaskPojo(String label, int prio, long createdTime) {
        this.label = label;
        this.createdTime = createdTime;
        this.prio = prio;
    }

    @Override
    public String toString() {
        return "TaskPojo{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", createdTime=" + createdTime +
                ", prio=" + prio +
                '}';
    }
}
