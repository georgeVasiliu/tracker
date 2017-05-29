package project;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import member.Member;
import objective.Objective;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by george on 5/23/17.
 */
public class Project implements Serializable {

    private String projectName;
    private String projectSummary;
    private Date projectDueDate;
    private List<Objective> projectListOfObjectives;

    public Project(String projectName, String projectSummary, Date projectDueDate) {
        this.projectName = projectName;
        this.projectSummary = projectSummary;
        this.projectDueDate = projectDueDate;
        projectListOfObjectives = new ArrayList<>();
    }


    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectSummary() {
        return projectSummary;
    }

    public void setProjectSummary(String projectSummary) {
        this.projectSummary = projectSummary;
    }

    public Date getProjectDueDate() {
        return projectDueDate;
    }

    public void setProjectDueDate(Date projectDueDate) {
        this.projectDueDate = projectDueDate;
    }

    public List<Objective> getProjectListOfObjectives() {
        return projectListOfObjectives;
    }

    public void setProjectListOfObjectives(List<Objective> projectListOfObjectives) {
        this.projectListOfObjectives = projectListOfObjectives;
    }

    public void addObjective(Objective objective) {
        projectListOfObjectives.add(objective);
    }
}
