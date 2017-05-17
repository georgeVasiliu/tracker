package task;

import history.History;
import member.Member;
import notifier.Notifier;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by george on 5/17/17.
 */
public class Task {
    private String title;
    private String description;
    private ImageIcon imageIcon;
    private String status;
    private List<Task> dependencyList;
    private List<Member> workers;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Task> getDependencyList() {
        return dependencyList;
    }

    public void setDependencyList(List<Task> dependencyList) {
        this.dependencyList = dependencyList;
    }

    public List<Member> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Member> workers) {
        this.workers = workers;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public List<Notifier> getNotifierList() {
        return notifierList;
    }

    public void setNotifierList(List<Notifier> notifierList) {
        this.notifierList = notifierList;
    }

    public List<Task> getChilds() {
        return childs;
    }

    public void setChilds(List<Task> childs) {
        this.childs = childs;
    }

    public Task getParent() {
        return parent;
    }

    public void setParent(Task parent) {
        this.parent = parent;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    private String comments;
    private List<Notifier> notifierList;
    private History history;
    private List<Task> childs;
    private Task parent;
    private Date deadline;

}
