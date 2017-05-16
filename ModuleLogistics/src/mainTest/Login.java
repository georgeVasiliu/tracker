/*
 * Created by JFormDesigner on Tue May 16 23:07:44 EEST 2017
 */

package mainTest;

import command.network.LoginCommand;
import request.Delegator;
import request.RequestHandler;
import response.Receiver;
import response.Response;
import response.ResponseManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.InvocationTargetException;
import java.util.ResourceBundle;

/**
 * @author Vasiliu George-Stef
 */
public class Login extends JFrame implements Receiver {
    private static final String receiverType = "login";
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vasiliu George
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panelLogin;
    private JLabel labelLogin;
    private JLabel labelUsername;
    private JTextField textFieldUsername;
    private JLabel labelPassword;
    private JTextField textFieldPassword;
    private JCheckBox checkBoxLocalAccount;
    private JPanel panelBottom;
    private JButton buttonLogin;
    private JButton buttonQuit;

    public Login() {
        initComponents();
        setResizable(false);
        ResponseManager.addReceiver(this);
    }

    private void buttonLoginMouseClicked(MouseEvent e) {
        String username = textFieldUsername.getText();
        String password = textFieldPassword.getText();
        int accountType = checkBoxLocalAccount.isSelected() ? 1 : 0;
        Delegator.getDelegator().sendRequest(RequestHandler.RequestType.LOGIN, new LoginCommand(username, password, accountType));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vasiliu George
        ResourceBundle bundle = ResourceBundle.getBundle("resources.guiText");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panelLogin = new JPanel();
        labelLogin = new JLabel();
        labelUsername = new JLabel();
        textFieldUsername = new JTextField();
        labelPassword = new JLabel();
        textFieldPassword = new JTextField();
        checkBoxLocalAccount = new JCheckBox();
        panelBottom = new JPanel();
        buttonLogin = new JButton();
        buttonQuit = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));

            // JFormDesigner evaluation mark
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(
                    new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                            "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                            java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(e -> {
                if ("border".equals(e.getPropertyName())) throw new RuntimeException();
            });

            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //======== panelLogin ========
                {

                    //---- labelLogin ----
                    labelLogin.setText(bundle.getString("Login.labelLogin.text"));
                    labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
                    labelLogin.setBackground(new Color(44, 81, 106));

                    GroupLayout panelLoginLayout = new GroupLayout(panelLogin);
                    panelLogin.setLayout(panelLoginLayout);
                    panelLoginLayout.setHorizontalGroup(
                            panelLoginLayout.createParallelGroup()
                                    .addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    );
                    panelLoginLayout.setVerticalGroup(
                            panelLoginLayout.createParallelGroup()
                                    .addGroup(panelLoginLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                }

                //---- labelUsername ----
                labelUsername.setText(bundle.getString("Login.labelUsername.text"));

                //---- labelPassword ----
                labelPassword.setText(bundle.getString("Login.labelPassword.text"));

                //---- checkBoxLocalAccount ----
                checkBoxLocalAccount.setText(bundle.getString("Login.checkBoxLocalAccount.text"));

                //======== panelBottom ========
                {

                    //---- buttonLogin ----
                    buttonLogin.setText(bundle.getString("Login.buttonLogin.text"));
                    buttonLogin.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            buttonLoginMouseClicked(e);
                        }
                    });

                    //---- buttonQuit ----
                    buttonQuit.setText(bundle.getString("Login.buttonQuit.text"));

                    GroupLayout panelBottomLayout = new GroupLayout(panelBottom);
                    panelBottom.setLayout(panelBottomLayout);
                    panelBottomLayout.setHorizontalGroup(
                            panelBottomLayout.createParallelGroup()
                                    .addGroup(GroupLayout.Alignment.TRAILING, panelBottomLayout.createSequentialGroup()
                                            .addContainerGap(486, Short.MAX_VALUE)
                                            .addComponent(buttonLogin)
                                            .addGap(18, 18, 18)
                                            .addComponent(buttonQuit)
                                            .addGap(187, 187, 187))
                    );
                    panelBottomLayout.setVerticalGroup(
                            panelBottomLayout.createParallelGroup()
                                    .addGroup(panelBottomLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(panelBottomLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(buttonLogin)
                                                    .addComponent(buttonQuit))
                                            .addContainerGap(53, Short.MAX_VALUE))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addGap(245, 245, 245)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(checkBoxLocalAccount)
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                                .addComponent(labelPassword)
                                                                                .addGap(22, 22, 22))
                                                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                                                .addComponent(labelUsername)
                                                                                .addGap(18, 18, 18)))
                                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                                        .addComponent(textFieldUsername)
                                                                        .addComponent(textFieldPassword)))))
                                        .addContainerGap(190, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelBottom, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelUsername))
                                        .addGap(18, 18, 18)
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(textFieldPassword, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelPassword, GroupLayout.Alignment.TRAILING))
                                        .addGap(82, 82, 82)
                                        .addComponent(checkBoxLocalAccount)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(panelBottom, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    @Override
    public void update(Response response) {
        int value = response.getInt();
        if (value == 1) {
            try {
                SwingUtilities.invokeAndWait(() -> JOptionPane.showConfirmDialog(this, "Login successful"));
            } catch (InterruptedException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getReceiverType() {
        return receiverType;
    }


    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
