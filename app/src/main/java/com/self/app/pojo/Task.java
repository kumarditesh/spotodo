package com.self.app.pojo;

/**
 * Created by yash on 30/10/14.
 */
public class Task {

    public enum Priority {
        HIGH(0), MEDIUM(1), LOW(2);

        private final int value;

        private Priority(final int newValue) {
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
    private Long  deadline;
    private Priority prio;
    private taskstatus status;
    private int isPinned = 0;


    public int getIsPinned() {
        return isPinned;
    }

    public void setIsPinned(int isPinned) {
        this.isPinned = isPinned;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public Priority getPrio() {
        return prio;
    }

    public void setPrio(Priority prio) {
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

    public Task(int id, String label, long createdTime, Long deadline, Priority prio, taskstatus status, int isPinned) {
        this.id = id;
        this.label = label;
        this.createdTime = createdTime;
        this.deadline = deadline;
        this.prio = prio;
        this.status = status;
        this.isPinned = isPinned;
    }

    public Task(String label, long createdTime, Long deadline, Priority prio, taskstatus status, int isPinned) {
        this.id = id;
        this.label = label;
        this.createdTime = createdTime;
        this.deadline = deadline;
        this.prio = prio;
        this.status = status;
        this.isPinned = isPinned;
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
