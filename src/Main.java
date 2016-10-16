import View.gameBoard;
import playground.View.example_view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class Main {
    public static void main(String args[]) {
        gameBoard object = new gameBoard();
        object.fakeMainMethod();

        final JFrame frame = new JFrame("JDialog Demo");
        final JButton btnLogin = new JButton("Click to login");

        btnLogin.addActionListener(
                e -> {
                    example_view loginDlg = new example_view(frame);
                    loginDlg.setVisible(true);
                    // if logon successfully
                    if(loginDlg.isCorrect()){
                        btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                    }
                });

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(true);
    }
}
