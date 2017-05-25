package command.local;

import account.UserAccount;
import command.Command;
import request.NetworkHandler;
import request.RequestHandler;

/**
 * Created by george on 5/22/17.
 */


public class LocalLoginCommand implements Command {

    private final String userName;
    private final String userPassword;


    public LocalLoginCommand(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }


    @Override
    public void execute(RequestHandler requestHandler) {
        ((NetworkHandler)requestHandler).localManager.validateLogin(userName,userPassword);
    }
}
