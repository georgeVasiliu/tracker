package command.local;

import command.Command;
import request.ProjectHandler;
import request.RequestHandler;

/**
 * Created by george on 5/29/17.
 */
public class GetLocalProjectsCommand implements Command{

    @Override
    public void execute(RequestHandler requestHandler) {
        ProjectHandler projectHandler = (ProjectHandler) requestHandler;
        projectHandler.localManager.grabProjects();

    }
}
