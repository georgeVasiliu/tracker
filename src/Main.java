import gui.mainFrame.applicationFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()-> new applicationFrame().setVisible(true));

    }
}
