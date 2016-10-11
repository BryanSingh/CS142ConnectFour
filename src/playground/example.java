package playground;

/**
 * @author Bryan Singh
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class example {
    JFrame bulkFrame;

    JButton quickGameButton;
    JButton newUserButton;
    JButton logInButton;

    JLabel mainGameTitle;
    JLabel quickGameTitle;
    JLabel newUserTtitle;
    JLabel userLogIn;

    JPanel panelMainView;

    JTextField username;

    example() {
        framesetup();
    }

    private void framesetup() {
        bulkFrame = new JFrame("CS142 - Connect Four Game");
        // bulkFrame.setSize(400,400);

        // Some reason this is very slow
        bulkFrame.setPreferredSize(new Dimension(400,400));
        bulkFrame.setLayout(new GridLayout(3, 1));
        bulkFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        panelMainView = new JPanel();
        panelMainView.setLayout(new FlowLayout());
        bulkFrame.add(panelMainView);
        bulkFrame.pack();
        bulkFrame.setVisible(true);
    }

    public int fakeMainMethod() {
        //username = new JTextField();
        quickGameButton = new JButton("Quick Game");

        quickGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quickGame();
            }
        });

        newUserButton = new JButton("Sign Up");
        newUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUser();
            }
        });

        logInButton = new JButton("Log In");
        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logIn();
            }
        });

        panelMainView.add(quickGameButton);
        panelMainView.add(newUserButton);
        panelMainView.add(logInButton);
        bulkFrame.setVisible(true);
        return 0;
    }

    public int quickGame() {
        quickGameButton.setText("Quick Game Play");
        return 0;
    }

    public int newUser(){
        newUserButton.setText("Signing Up");
        return 0;
    }

    public int logIn() {
        logInButton.setText("Please Log In");
        return 0;
    }

    public static void main (String args[]) {
        example object = new example();
        object.fakeMainMethod();
    }
}
