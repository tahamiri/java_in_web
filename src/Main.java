import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        dbConnection.openConnection();
        try(Statement statement = dbConnection.getConnection().createStatement();) {
            try(ResultSet resultSet = statement.executeQuery("select MSISDN,\n" +
                    "LENGTH_VALUE,\n" +
                    "RECENCY_VALUE,\n" +
                    "FREQUENCY_VALUE,\n" +
                    "MONETARY_VALUE\n" +
                    "from SUBSCRIBER_LRFM\n");){
                while (resultSet.next()){
                    System.out.println(resultSet.getObject("MSISDN"));
                    System.out.println(resultSet.getObject("LENGTH_VALUE"));
                    System.out.println(resultSet.getObject("RECENCY_VALUE"));
                    System.out.println(resultSet.getObject("FREQUENCY_VALUE"));
                    System.out.println(resultSet.getObject("MONETARY_VALUE"));
                    System.out.println("=================================================");
                }
            }
        }
    }
}

