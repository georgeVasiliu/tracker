package command.network;

import command.Command;
import executor.ExecutorsReference;
import request.LoginHandler;
import request.RequestHandler;
import response.Dispatcher;
import secureCommunication.SecureCommunication;

import java.util.concurrent.TimeUnit;

/**
 * Created by george on 5/15/17.
 */
public class LoginCommand implements Command {
    private String userName;
    private String passwordHash;
    private int accountType;

    public LoginCommand(String userName, String passwordHash, int accountType) {
        this.userName = userName;
        this.passwordHash = passwordHash;
        this.accountType = accountType;
    }

    @Override
    public void execute(RequestHandler requestHandler) {
        System.out.println("Executing login from : " + Thread.currentThread().getName());
        ExecutorsReference.getScheduledExecutor().schedule(() -> {
            System.out.println("Executing the command from : " + Thread.currentThread().getName());
            new SecureCommunication().tryToLogin();
        }, 5, TimeUnit.SECONDS);
    }
}
