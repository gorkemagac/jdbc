package utilities;

import java.sql.*;
import java.util.List;
import java.util.Map;

public class DBUtils {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;


    public static void createConnection()
    {
        String dbUrl = "jdbc:oracle:thin:@54.175.12.121:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        try{
            connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public static void destroy()
    {
        try {
            if(resultSet!=null)
            {
                resultSet.close();
            }
            if(statement != null)
            {
                statement.close();
            }
            if(connection != null)
            {
                connection.close();
            }
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
