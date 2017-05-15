package response;

import java.util.List;

/**
 * Created by george on 5/15/17.
 */
public class Response {

    private Object contents;

    public Response(Object contents){
        this.contents = contents;
    }

    public String getString(){
        return (String) contents;
    }

    public int getInt(){
        return (int) contents;
    }

    public List<String> getListString(){
        return (List<String>) contents;
    }

    public List<Integer> getListInteger(){
        return (List<Integer>) contents;
    }
}
