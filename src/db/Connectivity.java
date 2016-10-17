package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connectivity {

    static final String jdbc_driver = ("com.mysql.jbc.Driver");

    private static final String db_url = ("jdbc:mysql://localhost/connectfourlogin");

    private static final String user_information = ("root");
    private static final String password_information = ("root");

    public static void main(String args[]) {
        Connection connection = null;

        // how about we try this
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to selected database ...");

            connection = DriverManager.getConnection(db_url, user_information, password_information);

            System.out.println("The connection worked.");
        }
        // could collplase
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("System is closing. Goodbye.");
    }
}
