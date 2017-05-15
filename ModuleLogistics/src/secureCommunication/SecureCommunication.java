package secureCommunication;

import response.Dispatcher;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 5/15/17.
 */
public class SecureCommunication implements Dispatcher {

    private List<Receiver> receiverList;
    private int login;

    public SecureCommunication() {
        receiverList = new ArrayList<>();
        ResponseManager.addDispatcher(this, "login");
        login = 0;
    }

    public void tryToLogin() {
        System.out.println("Entered the SC with thread " + Thread.currentThread().getName());
        login = 1;
        sendResponse(new Response(login));
        System.out.println("Sent the response");

    }

    @Override
    public void addReceiver(Receiver receiver) {
        receiverList.add(receiver);
        System.out.println("Added a receiver");
    }

    @Override
    public void removeReceiver(Receiver receiver) {
        for (Receiver r : receiverList) {
            if (r.equals(receiver)) {
                receiverList.remove(r);
            }
        }
    }

    @Override
    public void sendResponse(Response response) {
        System.out.println("Entered sendResponse");

        for (Receiver receiver : receiverList) {
            receiver.update(response);
        }
        System.out.println("Exited sendResponse");
    }

    @Override
    public String getTypeOfReceiver() {
        return "login";
    }
}
