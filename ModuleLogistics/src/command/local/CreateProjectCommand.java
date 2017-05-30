package command.local;

import command.Command;
import project.Project;
import request.ProjectHandler;
import request.RequestHandler;

/**
 * Created by george on 5/30/17.
 */
public class CreateProjectCommand implements Command{
    private Project project;

    public CreateProjectCommand(Project project){
        this.project = project;
    }
    @Override
    public void execute(RequestHandler requestHandler) {
        ProjectHandler projectHandler = (ProjectHandler) requestHandler;
        projectHandler.localManager.storeProject(project);
    }
}
