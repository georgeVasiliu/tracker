package response;

/**
 * Created by george on 5/15/17.
 */
public interface Receiver {

    void update(Response response);
    String getType();
 }
