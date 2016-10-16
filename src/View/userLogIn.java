package View;

class userLogIn {
    // TODO Change hardcode password and username
    static boolean auth(String username, String password) {
        if (username.equals("bryan") || username.equals("hans") || username.equals("johncena")) {
            if (password.equals("password")) return true;
        }
        return false;
    }
}
