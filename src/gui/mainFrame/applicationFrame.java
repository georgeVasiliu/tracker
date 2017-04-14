/*
 * Created by JFormDesigner on Fri Apr 14 14:49:15 EEST 2017
 */

package gui.mainFrame;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author Vasiliu George-Stef
 */
public class applicationFrame extends JFrame {
    public applicationFrame() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Vasiliu George-Stef
        ResourceBundle bundle = ResourceBundle.getBundle("messageBundle");
        menuBar = new JMenuBar();
        projectMenu = new JMenu();
        createProjectMenuItem = new JMenuItem();
        openProjectMenuItem = new JMenuItem();
        manageProjectsMenuItem = new JMenuItem();
        taskMenu = new JMenu();
        createTaskMenuItem = new JMenuItem();
        manageTasksMenuItem = new JMenuItem();
        teamMenu = new JMenu();
        createTeamMenuItem = new JMenuItem();
        manageTeamsMenuItem = new JMenuItem();
        timesheetMenu = new JMenu();
        settingsMenu = new JMenu();
        generalSettingsMenuItem = new JMenuItem();
        networkingSettingsMenuItem = new JMenuItem();
        helpMenu = new JMenu();
        aboutHelpMenuItem = new JMenuItem();
        licenseHelpMenuItem = new JMenuItem();
        developmentHelpMenuItem = new JMenuItem();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();

        //======== menuBar ========
        {

            //======== projectMenu ========
            {
                projectMenu.setText(bundle.getString("applicationFrame.projectMenu.text"));

                //---- createProjectMenuItem ----
                createProjectMenuItem.setText(bundle.getString("applicationFrame.createProjectMenuItem.text"));
                projectMenu.add(createProjectMenuItem);

                //---- openProjectMenuItem ----
                openProjectMenuItem.setText(bundle.getString("applicationFrame.openProjectMenuItem.text"));
                projectMenu.add(openProjectMenuItem);

                //---- manageProjectsMenuItem ----
                manageProjectsMenuItem.setText(bundle.getString("applicationFrame.manageProjectsMenuItem.text"));
                projectMenu.add(manageProjectsMenuItem);
            }
            menuBar.add(projectMenu);

            //======== taskMenu ========
            {
                taskMenu.setText(bundle.getString("applicationFrame.taskMenu.text"));

                //---- createTaskMenuItem ----
                createTaskMenuItem.setText(bundle.getString("applicationFrame.createTaskMenuItem.text"));
                taskMenu.add(createTaskMenuItem);

                //---- manageTasksMenuItem ----
                manageTasksMenuItem.setText(bundle.getString("applicationFrame.manageTasksMenuItem.text"));
                taskMenu.add(manageTasksMenuItem);
            }
            menuBar.add(taskMenu);

            //======== teamMenu ========
            {
                teamMenu.setText(bundle.getString("applicationFrame.teamMenu.text"));

                //---- createTeamMenuItem ----
                createTeamMenuItem.setText(bundle.getString("applicationFrame.createTeamMenuItem.text"));
                teamMenu.add(createTeamMenuItem);

                //---- manageTeamsMenuItem ----
                manageTeamsMenuItem.setText(bundle.getString("applicationFrame.manageTeamsMenuItem.text"));
                teamMenu.add(manageTeamsMenuItem);
            }
            menuBar.add(teamMenu);

            //======== timesheetMenu ========
            {
                timesheetMenu.setText(bundle.getString("applicationFrame.timesheetMenu.text"));
            }
            menuBar.add(timesheetMenu);

            //======== settingsMenu ========
            {
                settingsMenu.setText(bundle.getString("applicationFrame.settingsMenu.text"));

                //---- generalSettingsMenuItem ----
                generalSettingsMenuItem.setText(bundle.getString("applicationFrame.generalSettingsMenuItem.text"));
                settingsMenu.add(generalSettingsMenuItem);

                //---- networkingSettingsMenuItem ----
                networkingSettingsMenuItem.setText(bundle.getString("applicationFrame.networkingSettingsMenuItem.text"));
                settingsMenu.add(networkingSettingsMenuItem);
            }
            menuBar.add(settingsMenu);

            //======== helpMenu ========
            {
                helpMenu.setText(bundle.getString("applicationFrame.helpMenu.text"));

                //---- aboutHelpMenuItem ----
                aboutHelpMenuItem.setText(bundle.getString("applicationFrame.aboutHelpMenuItem.text"));
                helpMenu.add(aboutHelpMenuItem);

                //---- licenseHelpMenuItem ----
                licenseHelpMenuItem.setText(bundle.getString("applicationFrame.licenseHelpMenuItem.text"));
                helpMenu.add(licenseHelpMenuItem);

                //---- developmentHelpMenuItem ----
                developmentHelpMenuItem.setText(bundle.getString("applicationFrame.developmentHelpMenuItem.text"));
                helpMenu.add(developmentHelpMenuItem);
            }
            menuBar.add(helpMenu);
        }
        setJMenuBar(menuBar);

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 963, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGap(0, 529, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Vasiliu George-Stef
    private JMenuBar menuBar;
    private JMenu projectMenu;
    private JMenuItem createProjectMenuItem;
    private JMenuItem openProjectMenuItem;
    private JMenuItem manageProjectsMenuItem;
    private JMenu taskMenu;
    private JMenuItem createTaskMenuItem;
    private JMenuItem manageTasksMenuItem;
    private JMenu teamMenu;
    private JMenuItem createTeamMenuItem;
    private JMenuItem manageTeamsMenuItem;
    private JMenu timesheetMenu;
    private JMenu settingsMenu;
    private JMenuItem generalSettingsMenuItem;
    private JMenuItem networkingSettingsMenuItem;
    private JMenu helpMenu;
    private JMenuItem aboutHelpMenuItem;
    private JMenuItem licenseHelpMenuItem;
    private JMenuItem developmentHelpMenuItem;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
