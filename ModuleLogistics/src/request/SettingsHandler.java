package request;

import command.Command;

/**
 * Created by george on 5/15/17.
 */
public class SettingsHandler extends RequestHandler{
    private static SettingsHandler settingsHandler;

    private SettingsHandler(){
        this.requestType = RequestType.SETTINGS;
        setNextHandler(ProjectHandler.getProjectHandler());
    }

    public static SettingsHandler getSettingsHandler(){
        if (settingsHandler == null){
            settingsHandler = new SettingsHandler();
        }
        return settingsHandler;
    }

    @Override
    protected void handleRequest(Command command) {
        if (command!=null){
            command.execute(this);
        }
    }
}
