package mainTest;

import command.network.LoginCommand;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by george on 5/15/17.
 */
public class Classic implements Receiver{
    private static final String login = "login";
    private JButton btnLogin;
    private JLabel lblStatus;

    public Classic() {
        ResponseManager.addReceiver(this);
        btnLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Delegator delegator = Delegator.getDelegator();
                delegator.sendRequest(RequestHandler.RequestType.LOGIN, new LoginCommand("username", "pass", 1));

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Classic");
        frame.setContentPane(new Classic().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel mainPanel;

    @Override
    public void update(Response response) {
       int value = response.getInt();
       if (value ==1 ){
           lblStatus.setText("Connected!");
           System.out.println("Value of caught response is : " + value);
       }
    }

    @Override
    public String getType() {
        return login;
    }
}
