package jdbctests;

import java.sql.*;

public class TestConnection {

    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:oracle:thin:@54.175.12.121:1521:XE";
        String dbUsername = "hr";
        String dbPassword = "hr";

        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from regions");

       /* resultSet.next();
       System.out.println(resultSet.getString("region_name"));
        System.out.println(resultSet.getString(2));

        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));

        resultSet.next();

        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        resultSet.next();

        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        resultSet.next();

        System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));*/

        while(resultSet.next())
        {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }


        resultSet.close();
        statement.close();
        connection.close();

    }

}
