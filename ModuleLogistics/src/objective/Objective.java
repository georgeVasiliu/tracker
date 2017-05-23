package objective;

import member.Member;
import task.Task;

import javax.swing.*;
import java.util.List;

/**
 * Created by george on 5/17/17.
 */
public class Objective {
    private String objectiveTitle;
    private String objectiveSummary;
    private ImageIcon objectiveIcon;
    private String[] objectiveComments;
    private Member objectiveSupervisor;
    //    private PercentBar objectivePercentBar;
    private STATUS status;
    private List<Task> objectiveAssociatedTasks;

    public String getObjectiveTitle() {
        return objectiveTitle;
    }

    public void setObjectiveTitle(String objectiveTitle) {
        this.objectiveTitle = objectiveTitle;
    }

    public String getObjectiveSummary() {
        return objectiveSummary;
    }

    public void setObjectiveSummary(String objectiveSummary) {
        this.objectiveSummary = objectiveSummary;
    }

    public ImageIcon getObjectiveIcon() {
        return objectiveIcon;
    }

    public void setObjectiveIcon(ImageIcon objectiveIcon) {
        this.objectiveIcon = objectiveIcon;
    }

    public String[] getObjectiveComments() {
        return objectiveComments;
    }

    public void setObjectiveComments(String[] objectiveComments) {
        this.objectiveComments = objectiveComments;
    }

    public Member getObjectiveSupervisor() {
        return objectiveSupervisor;
    }

    public void setObjectiveSupervisor(Member objectiveSupervisor) {
        this.objectiveSupervisor = objectiveSupervisor;
    }

    public STATUS getStatus() {
        return status;
    }

    public void setStatus(STATUS status) {
        this.status = status;
    }

    public List<Task> getObjectiveAssociatedTasks() {
        return objectiveAssociatedTasks;
    }

    public void setObjectiveAssociatedTasks(List<Task> objectiveAssociatedTasks) {
        this.objectiveAssociatedTasks = objectiveAssociatedTasks;
    }

    private enum STATUS {INREVIEW, INPROGRESS, DONE, ABANDONED}


}
