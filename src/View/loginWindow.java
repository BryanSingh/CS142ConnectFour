package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class loginWindow extends JDialog{

    private JTextField username;
    private JPasswordField password;
    private JLabel prompt_usrname;
    private JLabel prompt_passwd;
    private JButton usrlogin;
    private JButton usercancle;
    JPanel panel;
    GridBagConstraints constraints;
    private boolean correct;

    public loginWindow(Frame parent) {
        super(parent, "Login", true);

        panel = new JPanel(new GridBagLayout());
        constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;

        prompt_usrname = new JLabel("Username: ");

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        panel.add(username, constraints);
    }

}
