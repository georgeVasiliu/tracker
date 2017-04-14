package task;

import java.util.ArrayList;

/**
 * Created by george on 4/14/17.
 */
public class Task {
    private String taskID;
    private String taskSummary;
    private String taskName;
    private TaskDetails taskDetails;
    private ArrayList<Object> taskComponentsHolder;

    public Task(){
        taskID= "Must be set automatically.";
        taskSummary = "";
        taskName="";
        taskComponentsHolder = new ArrayList<>();
    }
    public Task(String taskName,String taskSummary){
        taskID = "Must be set automatically.";
        this.taskSummary = taskSummary;
        this.taskName = taskName;
    }

    public void setTaskID(String taskID){
        this.taskID=taskID;
    }
    public void setTaskSummary(String taskSummary){
        this.taskSummary = taskSummary;
    }
    public void setTaskName(String taskName){
        this.taskName=taskName;
    }
    public void updateTaskComponents(Object object){
       //verify stuff before adding it to the components holder
        taskComponentsHolder.add(object);
    }

    // possible idea : set it as abstract so that
    // each other implementation has to implement it and thus it will assure that step by step
    // each sub-component shall delete itself and release it's resources;
    public  void deleteThisTask(){

    };


}
