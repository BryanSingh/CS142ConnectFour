//package playground.View;
//
///**
// @author Bryan Singh
// @version 1.0
// */
//
//import javax.swing.*;
//import javax.swing.border.LineBorder;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//
//public class example_view extends JDialog {
//    private JTextField user;
//    private JPasswordField usr_passwd;
//    private JLabel Username;
//    private JLabel User_Passwd;
//    private JButton login_button;
//    private JButton cancle_button;
//    private boolean correct;
//
//    public example_view(Frame parent) {
//        super(parent, "Login", true);
//        //
//        JPanel panel = new JPanel(new GridBagLayout());
//        GridBagConstraints user_auth_design = new GridBagConstraints();
//
//        user_auth_design.fill = GridBagConstraints.HORIZONTAL;
//
//        Username = new JLabel("Username: ");
//        user_auth_design.gridx = 0;
//        user_auth_design.gridy = 0;
//        user_auth_design.gridwidth = 1;
//        panel.add(Username, user_auth_design);
//
//        user = new JTextField(20);
//        user_auth_design.gridx = 1;
//        user_auth_design.gridy = 0;
//        user_auth_design.gridwidth = 2;
//        panel.add(user, user_auth_design);
//
//        User_Passwd = new JLabel("Password: ");
//        user_auth_design.gridx = 0;
//        user_auth_design.gridy = 1;
//        user_auth_design.gridwidth = 1;
//        panel.add(User_Passwd, user_auth_design);
//
//        usr_passwd = new JPasswordField(20);
//        user_auth_design.gridx = 1;
//        user_auth_design.gridy = 1;
//        user_auth_design.gridwidth = 2;
//        panel.add(usr_passwd, user_auth_design);
//        panel.setBorder(new LineBorder(Color.GRAY));
//
//        login_button = new JButton("Login");
//
//        login_button.addActionListener(e -> {
//            if (Login.auth(getUsername(), getPassword())) {
//                JOptionPane.showMessageDialog(example_view.this,
//                        "Hi " + getUsername() + "! You have successfully logged in.",
//                        "Login",
//                        JOptionPane.INFORMATION_MESSAGE);
//                correct = true;
//                dispose();
//            } else {
//                JOptionPane.showMessageDialog(example_view.this,
//                        "Invalid username or password",
//                        "Login",
//                        JOptionPane.ERROR_MESSAGE);
//                // reset username and password
//                user.setText("");
//                usr_passwd.setText("");
//                correct = false;
//
//            }
//        });
//        cancle_button = new JButton("Cancel");
//        cancle_button.addActionListener(e -> dispose());
//        JPanel panel1 = new JPanel();
//        panel1.add(login_button);
//        panel1.add(cancle_button);
//
//        getContentPane().add(panel, BorderLayout.CENTER);
//        getContentPane().add(panel1, BorderLayout.PAGE_END);
//
//        pack();
//        setResizable(false);
//        setLocationRelativeTo(parent);
//    }
//
//    public String getUsername() {
//        return user.getText().trim();
//    }
//
//    private String getPassword() {
//        return new String(usr_passwd.getPassword());
//    }
//
//    public boolean isCorrect() {
//        return correct;
//    }
//
//}
