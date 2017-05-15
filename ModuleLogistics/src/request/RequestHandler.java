package request;

import command.Command;

/**
 * Created by george on 5/15/17.
 */
public abstract class RequestHandler {
    public  enum RequestType { BASE, LOGIN, SETTINGS, PROJECT}

    protected RequestType requestType;
    private RequestHandler nextHandler;

    public void setNextHandler(RequestHandler nextHandler){
        this.nextHandler= nextHandler;
    }

    public void sendRequest(RequestType requestType,Command command){
        if (this.requestType == requestType){
            handleRequest(command);
        } else if (nextHandler !=null){
            nextHandler.sendRequest(requestType,command);
        }
    }

    protected abstract void handleRequest(Command command);



}
