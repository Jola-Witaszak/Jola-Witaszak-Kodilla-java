package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamedQueries({
        @NamedQuery(
        name = "Task.retrieveLongTasks",
        query = "FROM Task WHERE duration > 10"
        ),
        @NamedQuery(
                name = "Task.retrieveShortTasks",
                query = "from Task where duration <= 10"
        ),
        @NamedQuery(
                name = "Task.retrieveTasksWithDurationLongerThan",
                query = "from Task where duration > :DURATION"
        )
})
@NamedNativeQuery(
        name = "Task.retrieveTasksWithEnoughTime",
        query = "select * from TASKS" +
                " WHERE DATEDIFF(DATE_ADD(CREATED, INTERVAL DURATION DAY), NOW()) > 5",
        resultClass = Task.class
)

@Entity
@Table(name = "TASKS")
public final class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;
    private Task_List task_list;

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name = "CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "TASKLIST_ID")
    public Task_List getTask_list() {
        return task_list;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    public void setTask_list(Task_List task_list) {
        this.task_list = task_list;
    }
}
