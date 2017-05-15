package command;

import request.RequestHandler;

/**
 * Created by george on 5/15/17.
 */
public interface Command {

    void execute(RequestHandler requestHandler);
}
