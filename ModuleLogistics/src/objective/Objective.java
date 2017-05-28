package objective;

import member.Member;
import notifier.Notifier;
import task.Task;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by george on 5/17/17.
 */
public class Objective extends Task {
    private Member supervisor;
    private Notifier synchronizer;

    @Override
    public Task getParent() {
        return null;
    }

    @Override
    public Date getDeadline() {
        return null;
        //may be changed with something that gathers the deadline of all it's tasks
    }

    @Override
    public List<Member> getWorkers() {
        return null;
        //here, we have to make a call to each task and get it's members, and then we will return a
        // list with lists (may be a single list)
    }

}
