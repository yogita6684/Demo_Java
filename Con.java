package swiftcash.atm.system;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

//Database Connection class for the Swiftcash ATM System.
public class Con {
    public Connection connection;
    public Statement statement;

    public Con() {
        try {
            //Register JDBC  driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atmsystem","root","Yogi@269");
            statement = connection.createStatement();

        } catch (Exception e) {
            System.out.println("DATABASE CONNECTION ERROR:"+e.getMessage());
              e.printStackTrace();
        }
    }
}
