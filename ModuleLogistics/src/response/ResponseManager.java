package response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by george on 5/15/17.
 */
public class ResponseManager {

    private static final List<Dispatcher> dispatchers = new ArrayList<>();
    private static final List<Receiver> receivers = new ArrayList<>();

    public static final void addDispatcher(Dispatcher dispatcher) {
        for (Receiver receiver : receivers) {
            for (String string : dispatcher.getTypeOfReceiver()){
                if (receiver.getReceiverType().equalsIgnoreCase(string)){
                    dispatcher.addReceiver(receiver);
                }
            }
        }
        dispatchers.add(dispatcher);
    }

    public static final void addReceiver(Receiver receiver) {
        for (Dispatcher dispatcher : dispatchers) {
            for (String string : dispatcher.getTypeOfReceiver()) {
                    if (string.equalsIgnoreCase(receiver.getReceiverType())){
                        dispatcher.addReceiver(receiver);
                    }
            }
        }
        receivers.add(receiver);

    }
}
