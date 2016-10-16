package playground.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_view {
    public static void main(String args[]) {
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
