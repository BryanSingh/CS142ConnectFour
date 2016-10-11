package View;

/**
 * Created by BryanSingh on 10/11/16.
 */
public class userLogIn {
    // TODO Change hardcode password and username
    public static boolean auth(String username, String password) {
        if (username.equals("bryan") && password.equals("password"))
            return true;

        return false;
    }
}
