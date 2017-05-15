package response;

/**
 * Created by george on 5/15/17.
 */
public interface Dispatcher {

    void addReceiver(Receiver receiver);
    void removeReceiver(Receiver receiver);
    void sendResponse(Response response);
    String getTypeOfReceiver();
}
