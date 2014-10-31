package com.self.app.pojo;

/**
 * Created by yash on 30/10/14.
 */
public class Task {

    public enum priority{
        HIGH(1), MEDIUM(2), LOW(3);

        private final int value;

        private priority(final int newValue) {
            value = newValue;
        }

        public int getValue() { return value; }
    }

    public enum taskstatus{
        ACTIVE, COMPLETED, DELETED
    }

    private int id;
    private String label;
    private long createdTime;
    private long  deadline;
    private priority prio;
    private taskstatus status;
    private int isPinned;


    public int getIsPinned() {
        return isPinned;
    }

    public void setIsPinned(int isPinned) {
        this.isPinned = isPinned;
    }

    public long getDeadline() {
        return deadline;
    }

    public void setDeadline(long deadline) {
        this.deadline = deadline;
    }

    public priority getPrio() {
        return prio;
    }

    public void setPrio(priority prio) {
        this.prio = prio;
    }

    public taskstatus getStatus() {
        return status;
    }

    public void setStatus(taskstatus status) {
        this.status = status;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Task() {}

    public Task(int id, String label, long createdTime, long deadline, priority prio, taskstatus status) {
        this.id = id;
        this.label = label;
        this.createdTime = createdTime;
        this.deadline = deadline;
        this.prio = prio;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", createdTime=" + createdTime +
                ", deadline=" + deadline +
                ", prio=" + prio +
                ", status=" + status +
                ", isPinned=" + isPinned +
                '}';
    }
}
