package View;
/*
  @author Bryan Singh
  @version 1.0
 */

// TODO: NEED TO ADD HIDE/SHOW METHODS FOR OPTIONS
import Model.ComputerPlayer;
import Model.PanelGameView;
import Model.PieceType;
import Model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class GameBoard{




    private JFrame bulkFrame;

    private JButton quickGameButton;
    private JButton newUserButton;
    private JButton logInButton;

    private JLabel mainGameTitle;
    private JLabel quickGameTitle;
    private JLabel newUserTtitle;
    private JLabel userLogIn;

    private JPanel panelMainView;
    private PanelGameView panelGameView;

    private JTextField username;

    public GameBoard() {
        framesetup();
    }

    private void framesetup() {
        bulkFrame = new JFrame("CS142 - Connect Four Game");
        userLogIn object_example = new userLogIn();
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
        bulkFrame.setLocationRelativeTo(null);
        bulkFrame.setVisible(true);
    }

    public int fakeMainMethod() {
        //username = new JTextField();
        quickGameButton = new JButton("Quick Game");

        quickGameButton.addActionListener(e -> quickGame());

        newUserButton = new JButton("Sign Up");
        newUserButton.addActionListener(e -> newUser());

        logInButton = new JButton("Log In");
        logInButton.addActionListener(e -> logIn());

        panelMainView.add(quickGameButton);
        panelMainView.add(newUserButton);
        panelMainView.add(logInButton);
        bulkFrame.setVisible(true);
        return 0;
    }



    private int quickGame() {
        quickGameButton.setText("Quick Game Play");
        Dimension gameDim = new Dimension(1050, 900);
        panelGameView = new PanelGameView(gameDim);
        bulkFrame.remove(panelMainView);
        bulkFrame.setSize(gameDim);
        bulkFrame.add(panelGameView);
        return 0;
    }

    private int newUser(){
        newUserButton.setText("Signing Up");
        return 0;
    }


    private int logIn() {
        logInButton.setText("Please Log In");
        final JFrame frame = new JFrame("Connect Four Login");
        final JButton loginButton = new JButton("Please login.");

        loginButton.addActionListener(
                e -> {
                    loginWindow loginDlg = new loginWindow(frame);
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isCorrect()){
                        loginButton.setText("Hi " + loginDlg.getUsername() + "!");
                    }
                });

        // TODO NEED TO ADD CLOSE WINDOW ONLY CLOSES THE LOGIN WINDOW
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(loginButton);
        frame.setVisible(true);
        return 0;
    }
}
