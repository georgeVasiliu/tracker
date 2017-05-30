package request;

import command.Command;
import local.LocalManager;

/**
 * Created by george on 5/15/17.
 */
public class ProjectHandler extends RequestHandler{
    private static ProjectHandler projectHandler;
    public static LocalManager localManager = LocalManager.getLocalManager();


    private ProjectHandler(){
        this.requestType = RequestType.PROJECT;
        setNextHandler(null);
    }

    public static ProjectHandler getProjectHandler(){
        if (projectHandler == null){
            projectHandler = new ProjectHandler();
        }
        return projectHandler;
    }

    @Override
    protected void handleRequest(Command command) {
        if (command!=null){
            command.execute(this);
        }
    }

}
