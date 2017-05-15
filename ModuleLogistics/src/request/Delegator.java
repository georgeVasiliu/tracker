package request;

import command.Command;

/**
 * Created by george on 5/15/17.
 */
public class Delegator extends RequestHandler {
    private static Delegator delegator;

    private Delegator(){
        this.requestType = RequestType.BASE;
        setNextHandler(LoginHandler.getLoginHandler());
    }

    public static Delegator getDelegator(){
        if (delegator == null){
            delegator = new Delegator();
        }
        return delegator;
    }

    @Override
    protected void handleRequest(Command command) {
        System.out.println("Should never have entered here though.");
    }
}
