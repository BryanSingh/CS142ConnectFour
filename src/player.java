import javax.swing.*;

/**
 * Created by BryanSingh on 10/10/16.
 */
public class player extends gameBoard {

    String user_name = null;

    public String get_user_name(){

        user_name = JOptionPane.showInputDialog("Enter First Name");
        return user_name;
    }
}
