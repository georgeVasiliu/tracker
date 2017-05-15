package request;

import command.Command;
import sun.rmi.runtime.Log;

/**
 * Created by george on 5/15/17.
 */
public class LoginHandler extends RequestHandler{
    private static LoginHandler loginHandler;


    private LoginHandler(){
        this.requestType = RequestType.LOGIN;
        setNextHandler(SettingsHandler.getSettingsHandler());
    }

    public static LoginHandler getLoginHandler(){
        if (loginHandler == null){
            loginHandler = new LoginHandler();
        }
        return loginHandler;
    }

    @Override
    protected void handleRequest(Command command) {
        if (command!=null){
            command.execute(this);
        }
    }
}
