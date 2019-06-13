package sample;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class DBManager implements AutoCloseable {

    private Connection connection;

    public DBManager() throws SQLException {
        this.Connect();

    }

    public Connection getConnection(){
        return this.connection;
    }

    public void Connect() throws SQLException{
        try {
            String url = "jdbc:mysql://localhost:3306/bdboletaje?serverTimezone="+TimeZone.getDefault().getID();
            connection = DriverManager.getConnection(url,
                    "root", "");

        } catch (SQLException ex) {
            connection = null;
            ex.printStackTrace();
            System.out.println("SQLException:␣" + ex.getMessage());
            System.out.println("SQLState:␣" + ex.getSQLState());
            System.out.println("VendorError:␣" + ex.getErrorCode());
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
        connection = null;

    }
}
