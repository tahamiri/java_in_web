import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DBConnection {
    private static final Logger LOGGER = Logger.getLogger(DBConnection.class.getName());
    private Connection connection;
    public DBConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.severe(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public Connection openConnection() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:oracle:thin:@192.168.5.84:1501/orcl.bonyansystem.com", "LRFM_USER", "Bonyan123");
        LOGGER.info("connection established successfully.");
        return connection;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
            LOGGER.info("connection closed.");
        }
    }
}
