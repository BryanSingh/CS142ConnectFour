import View.gameBoard;

import javax.swing.*;

public class player extends gameBoard {

    private String user_name = null;

    public String get_user_name(){

        user_name = JOptionPane.showInputDialog("Enter First Name");
        return user_name;
    }
}
