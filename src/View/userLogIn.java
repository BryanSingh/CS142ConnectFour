package View;

class userLogIn {
    // TODO Change hardcode password and username
    static boolean auth(String username, String password) {
        return username.equals("bryan") && password.equals("password");
    }
}
