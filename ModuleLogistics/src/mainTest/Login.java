/*
 * Created by JFormDesigner on Wed May 17 08:47:52 EEST 2017
 */

package mainTest;

import response.Receiver;
import response.Response;
import response.ResponseManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ResourceBundle;

/**
 * @author Vasiliu George
 */
public class Login extends JFrame implements Receiver {
    private static final String receiverType = "login";
    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vasiliu George
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panelLoginImage;
    private JLabel labelLogin;
    private JPanel panelCentral;
    private JLabel labelUsername;
    private JLabel labelPassword;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JCheckBox checkBoxOfflineAccount;
    private JPanel bottomPanel;
    private JButton okButton;
    private JLabel labelOfflineAccount;

    public Login() {
        ResponseManager.addReceiver(this);
        initComponents();
    }

    private void okButtonMouseClicked(MouseEvent e) {
        // Delegator.getDelegator().sendRequest(RequestHandler.RequestType.LOGIN, new LoginCommand("Ala", "Bala", 2));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vasiliu George
        ResourceBundle bundle = ResourceBundle.getBundle("resources.guiText");
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panelLoginImage = new JPanel();
        labelLogin = new JLabel();
        panelCentral = new JPanel();
        labelUsername = new JLabel();
        labelPassword = new JLabel();
        textFieldUsername = new JTextField();
        textFieldPassword = new JTextField();
        checkBoxOfflineAccount = new JCheckBox();
        bottomPanel = new JPanel();
        okButton = new JButton();
        labelOfflineAccount = new JLabel();

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
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("border".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });


            //======== contentPanel ========
            {

                //======== panelLoginImage ========
                {

                    //---- labelLogin ----
                    labelLogin.setText(bundle.getString("Login.labelLogin.text"));
                    labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
                    labelLogin.setBackground(SystemColor.desktop);

                    GroupLayout panelLoginImageLayout = new GroupLayout(panelLoginImage);
                    panelLoginImage.setLayout(panelLoginImageLayout);
                    panelLoginImageLayout.setHorizontalGroup(
                            panelLoginImageLayout.createParallelGroup()
                                    .addGroup(panelLoginImageLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                    panelLoginImageLayout.setVerticalGroup(
                            panelLoginImageLayout.createParallelGroup()
                                    .addGroup(panelLoginImageLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(labelLogin, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                }

                //======== panelCentral ========
                {

                    //---- labelUsername ----
                    labelUsername.setText(bundle.getString("Login.labelUsername.text"));

                    //---- labelPassword ----
                    labelPassword.setText(bundle.getString("Login.labelPassword.text"));

                    //---- checkBoxOfflineAccount ----
                    checkBoxOfflineAccount.setText(bundle.getString("Login.checkBoxOfflineAccount.text"));

                    GroupLayout panelCentralLayout = new GroupLayout(panelCentral);
                    panelCentral.setLayout(panelCentralLayout);
                    panelCentralLayout.setHorizontalGroup(
                            panelCentralLayout.createParallelGroup()
                                    .addGroup(panelCentralLayout.createSequentialGroup()
                                            .addGap(137, 137, 137)
                                            .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                    .addComponent(checkBoxOfflineAccount)
                                                    .addGroup(panelCentralLayout.createSequentialGroup()
                                                            .addGroup(panelCentralLayout.createParallelGroup()
                                                                    .addComponent(labelPassword)
                                                                    .addComponent(labelUsername))
                                                            .addGap(18, 18, 18)
                                                            .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(textFieldPassword, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                                                    .addComponent(textFieldUsername, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                                            .addContainerGap(212, Short.MAX_VALUE))
                    );
                    panelCentralLayout.setVerticalGroup(
                            panelCentralLayout.createParallelGroup()
                                    .addGroup(panelCentralLayout.createSequentialGroup()
                                            .addGap(14, 14, 14)
                                            .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(labelUsername)
                                                    .addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addGap(26, 26, 26)
                                            .addGroup(panelCentralLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                    .addComponent(labelPassword)
                                                    .addComponent(textFieldPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(checkBoxOfflineAccount)
                                            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                }

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(contentPanelLayout.createParallelGroup()
                                                .addComponent(panelLoginImage, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(panelCentral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                        contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(panelLoginImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(panelCentral, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addContainerGap())
                );
            }

            //======== bottomPanel ========
            {

                //---- okButton ----
                okButton.setText(bundle.getString("Login.okButton.text"));
                okButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        okButtonMouseClicked(e);
                    }
                });

                //---- labelOfflineAccount ----
                labelOfflineAccount.setText(bundle.getString("Login.labelOfflineAccount.text"));
                labelOfflineAccount.setFont(new Font("DejaVu Sans", Font.ITALIC, 12));
                labelOfflineAccount.setForeground(SystemColor.activeCaption);

                GroupLayout bottomPanelLayout = new GroupLayout(bottomPanel);
                bottomPanel.setLayout(bottomPanelLayout);
                bottomPanelLayout.setHorizontalGroup(
                        bottomPanelLayout.createParallelGroup()
                                .addGroup(bottomPanelLayout.createSequentialGroup()
                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labelOfflineAccount)
                                        .addContainerGap())
                                .addGroup(GroupLayout.Alignment.TRAILING, bottomPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(okButton, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
                );
                bottomPanelLayout.setVerticalGroup(
                        bottomPanelLayout.createParallelGroup()
                                .addGroup(bottomPanelLayout.createSequentialGroup()
                                        .addContainerGap(7, Short.MAX_VALUE)
                                        .addComponent(okButton)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(labelOfflineAccount)
                                        .addContainerGap())
                );
            }

            GroupLayout dialogPaneLayout = new GroupLayout(dialogPane);
            dialogPane.setLayout(dialogPaneLayout);
            dialogPaneLayout.setHorizontalGroup(
                    dialogPaneLayout.createParallelGroup()
                            .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(GroupLayout.Alignment.TRAILING, dialogPaneLayout.createSequentialGroup()
                                    .addContainerGap(467, Short.MAX_VALUE)
                                    .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addContainerGap())
            );
            dialogPaneLayout.setVerticalGroup(
                    dialogPaneLayout.createParallelGroup()
                            .addGroup(dialogPaneLayout.createSequentialGroup()
                                    .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(bottomPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            );
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    @Override
    public void update(Response response) {

    }

    @Override
    public String getReceiverType() {
        return null;
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
