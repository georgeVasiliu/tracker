package response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 5/15/17.
 */
public class ResponseManager {

    private static final List<Dispatcher> dispatchers = new ArrayList<>();
    private static final List<Receiver> receivers = new ArrayList<>();

    public static final void addDispatcher(Dispatcher dispatcher, String typeOfReceiver) {
        System.out.println("Checking receiver!");

        for (Receiver receiver : receivers) {
            if (receiver.getReceiverType().equalsIgnoreCase(typeOfReceiver)) {
                dispatcher.addReceiver(receiver);
            }
        }
        dispatchers.add(dispatcher);
    }

    public static final void addReceiver(Receiver receiver) {
        System.out.println("Checking dispatcher!");

        for (Dispatcher dispatcher : dispatchers) {
            if (dispatcher.getTypeOfReceiver().equalsIgnoreCase(receiver.getReceiverType())) {
                dispatcher.addReceiver(receiver);
            }
        }
        receivers.add(receiver);
    }
}
