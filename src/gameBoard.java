import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.security.*;
import javax.xml.bind.DatatypeConverter;
import java.lang.*;
import java.awt.*;
import javax.swing.*;


/**
 * Created by BryanSingh on 10/10/16.
 */
public class gameBoard {

    private JFrame mainFrame;
    private JLabel window_title;
    private String window_name = ("CS142 Connect Four");

    public gameBoard() {
    }

    void main_window() {
        // Create a window with the title specified
        mainFrame = new JFrame("CS142 Connect Four");
        // TODO check the size for the game. This is just a template
        mainFrame.setSize(400,400);

        // This will create a grid for the game
        mainFrame.setLayout(new GridLayout(3,1));

        // Need to see if the user close the window
        mainFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });

        // Creating the button
        JButton new_game = new JButton("New Game");
        String user_name = JOptionPane.showInputDialog("Enter First Name");
        mainFrame.add(new_game);
        mainFrame.pack();
        mainFrame.setVisible(true);

        new_game.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new_game.setText("Currently In Quic Play Mode");
            }
        });
    }
}
