package local;

import account.UserAccount;
import objective.Objective;
import project.Project;
import task.Task;

/**
 * Created by george on 5/17/17.
 */
public class LocalManager {
    private static LocalManager localManager;
    private String installationPath;
    private String projectPath;
    private String objectivePath;
    private String taskPath;

    private LocalManager() {

    }

    public static LocalManager getLocalManager() {
        if (localManager == null) {
            localManager = new LocalManager();
        }
        return localManager;
    }


    public void validateLogin(UserAccount credentials) {

    }

    public void grabProjects(UserAccount userAccount) {

    }

    public void grabObjectives(UserAccount userAccount) {

    }

    public void grabTasks(UserAccount userAccount) {

    }

    public void storeProject(Project project) {

    }

    public void storeObjective(Objective objective) {

    }

    public void storeTask(Task task) {

    }

    public void updateProject(Project project) {

    }

    public void updateObjective(Objective objective) {

    }

    public void updateTask(Task task) {

    }

}
