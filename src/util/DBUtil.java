package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {

    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";

    private static final String USERNAME = "{USERNAME}";

    private static final String PASSWORD = "{PASSWORD}";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void disConnection(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection) {
        try {
            close(preparedStatement);
            close(resultSet);
            close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void disConnection(PreparedStatement preparedStatement, Connection connection) {
        try {
            close(preparedStatement);
            close(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void close(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            if (!preparedStatement.isClosed()) {
                preparedStatement.close();
            }
        }
    }

    private void close(ResultSet resultSet) throws SQLException {
        if (resultSet != null) {
            if (!resultSet.isClosed()) {
                resultSet.close();
            }
        }
    }

    private void close(Connection connection) throws SQLException {
        if (connection != null) {
            if (!connection.isClosed()) {
                connection.close();
            }
        }
    }

}
