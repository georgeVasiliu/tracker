package task;

import history.History;
import member.Member;
import notifier.Notifier;
import objective.Objective;

import java.util.Date;
import java.util.List;

/**
 * Created by george on 5/17/17.
 */
public class Task {

    private String taskTitle;
    private String taskDescription;
    private String taskStatus;

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<Task> getRelatedTasks() {
        return relatedTasks;
    }

    public void setRelatedTasks(List<Task> relatedTasks) {
        this.relatedTasks = relatedTasks;
    }

    public Objective getParentObjective() {
        return parentObjective;
    }

    public void setParentObjective(Objective parentObjective) {
        this.parentObjective = parentObjective;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getTaskComments() {
        return taskComments;
    }

    public void setTaskComments(String taskComments) {
        this.taskComments = taskComments;
    }

    public List<Notifier> getTaskNotifications() {
        return taskNotifications;
    }

    public void setTaskNotifications(List<Notifier> taskNotifications) {
        this.taskNotifications = taskNotifications;
    }

    public List<Task> getChildTasks() {
        return childTasks;
    }

    public void setChildTasks(List<Task> childTasks) {
        this.childTasks = childTasks;
    }

    public Task getParentTask() {
        return parentTask;
    }

    public void setParentTask(Task parentTask) {
        this.parentTask = parentTask;
    }

    public Date getTaskDeadline() {
        return taskDeadline;
    }

    public void setTaskDeadline(Date taskDeadline) {
        this.taskDeadline = taskDeadline;
    }

    private List<Task> relatedTasks;
    private Objective parentObjective;
    private List<Member> members;
    private String taskComments;
    private List<Notifier> taskNotifications;
    private History taskHistory;
    private List<Task> childTasks;
    private Task parentTask;
    private Date taskDeadline;

}
