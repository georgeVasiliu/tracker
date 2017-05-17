package request;

import command.Command;
import secureCommunication.SecureCommunication;

/**
 * Created by george on 5/15/17.
 */
public class NetworkHandler extends RequestHandler {
    private static NetworkHandler networkHandler;
    public SecureCommunication secureCommunication = SecureCommunication.getSecureCommunication();


    private NetworkHandler() {
        this.requestType = RequestType.LOGIN;
        setNextHandler(SettingsHandler.getSettingsHandler());
    }

    public static NetworkHandler getNetworkHandler() {
        if (networkHandler == null) {
            networkHandler = new NetworkHandler();
        }
        return networkHandler;
    }

    @Override
    protected void handleRequest(Command command) {
        if (command != null) {
            command.execute(this);
        }
    }

}
