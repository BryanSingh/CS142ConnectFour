import View.GameBoard;

import javax.swing.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class player extends GameBoard {

    private String user_name = null;

    public String get_user_name(){


        return user_name;
    }

    // TODO make sure that user can't enter any unwanted characters in username
    private boolean check_user_name() {
        final String test_username = ("Bryan Singh");
        final Pattern pattern = Pattern.compile("^[A-Za-z, ]++$");
        if (!pattern.matcher(test_username).matches()) {
            throw new IllegalArgumentException("Invalid String");
            // System.out.println("Invalid String");
        }
        return true;
    }
}
