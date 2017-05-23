package command.network;

import command.Command;
import org.codehaus.jackson.map.ObjectMapper;
import request.RequestHandler;
import secureCommunication.UserAccountInParameters;
import secureCommunication.UserAccountOutParameters;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

/**
 * Created by george on 5/15/17.
 */
public class LoginCommand implements Command {
    private static final String AUTHENTICATE = "/authentification"; //name of the Rest service in the server
    private UserAccountOutParameters userAccountOutParameters;


    public LoginCommand(UserAccountOutParameters userAccountOutParameters) {
        this.userAccountOutParameters = userAccountOutParameters;
    }


    /*
    * Propery way of handling network requests
    * */
    @Override
    public void execute(RequestHandler requestHandler) {
        Client client = ClientBuilder.newClient();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            UserAccountInParameters responseToLogin = objectMapper.readValue(client.target("address")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .post(Entity.entity(objectMapper.writeValueAsString(userAccountOutParameters), MediaType.APPLICATION_JSON_TYPE))
                    .readEntity(String.class), UserAccountInParameters.class);
            //Interpret the response and call a sendReponse through securecommunication
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error occured in execute method of logincommand.");
        }
    }



    /*classic way of sending/getting via https
     try {
            HttpURLConnection connection = (HttpURLConnection) ((NetworkHandler) requestHandler).secureCommunication.getUrlConnection();
            ((NetworkHandler) requestHandler).secureCommunication.initiateConnectionWithSsl(AUTHENTICATE);
            ObjectMapper credentialsMapper = new ObjectMapper();
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            try {
                connection.setRequestMethod("POST");
            } catch (ProtocolException e) {
                e.printStackTrace();
                System.out.println("Encountered error in post setting connection");
            }
            try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()))) {
                out.write(credentialsMapper.writeValueAsString(userAccountOutParameters));
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (connection.getResponseCode() != 200)
                ((NetworkHandler) requestHandler).secureCommunication.sendResponse(new Response("InvalidCredentials!"));
            //here a cast to a useraccountinparameters should be used by credentialsMapper to transform the response into the the object
            // and then interpret it
            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
     */
}
