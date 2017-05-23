package command.local;

import account.UserAccount;
import command.Command;
import request.RequestHandler;

/**
 * Created by george on 5/22/17.
 */


public class LocalLoginCommand implements Command {

    private UserAccount userAccount;


    public LocalLoginCommand(UserAccount userAccount) {
        this.userAccount = userAccount;
    }


    @Override
    public void execute(RequestHandler requestHandler) {

    }
}
