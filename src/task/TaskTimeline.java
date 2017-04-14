package task;

import timer.EstimateTime;

import java.util.Date;

/**
 * Created by george on 4/14/17.
 */
public class TaskTimeline extends Task {
    private Date taskCreationDate;
    private Date taskStartingDate;
    private Date taskDueDate;
    private int taskTotalHoursAssigned;
    private TaskActivity taskWorkLog;
    private EstimateTime taskEstimateTime;

}
