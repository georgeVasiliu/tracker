package command.local;

import account.UserAccount;
import command.Command;
import local.LocalManager;
import request.NetworkHandler;
import request.RequestHandler;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by g0dzax on 5/25/2017.
 */
public class CreateLocalAccountCommand implements Command {

    @XmlElement(name="userAccount")
    private UserAccount userAccount;
    private NetworkHandler networkHandler;

    public CreateLocalAccountCommand(UserAccount userAccount){
        this.userAccount = userAccount;
    }


    @Override
    public void execute(RequestHandler requestHandler) {
        networkHandler = (NetworkHandler) requestHandler;
        networkHandler.localManager.createLocalAccount(userAccount);

    }
}
