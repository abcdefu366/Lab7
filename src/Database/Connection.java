package Database;

import java.sql.*;

public class Connection {
    private static java.sql.Connection connection;
    private synchronized static void getConnect() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", "superuser", "123");
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }
    public static ResultSet executePreparedStatement(String sqlRequest) {
        getConnect();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlRequest);
            return preparedStatement.executeQuery();
        } catch (SQLException sqlException) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException sqlException) {
                System.out.println(sqlException.getMessage());
            }
        }
    }
}