package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class jdbc_examples {
    String dbUrl = "jdbc:oracle:thin:@54.175.12.121:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test1() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        while(resultSet.next())
        {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2) + " - " + resultSet.getString(3) + " - " + resultSet.getInt(4));
        }

        resultSet = statement.executeQuery("Select * from regions");

        while(resultSet.next())
        {
            System.out.println(resultSet.getInt(1) + " - " + resultSet.getString(2));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        resultSet.last();

        int rowCount = resultSet.getRow();

        System.out.println(rowCount);

        resultSet.first();

        while (resultSet.next())
        {
            System.out.println(resultSet.getString(2));
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
    @Test
    public void test3() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("Select * from departments");

        DatabaseMetaData databaseMetaData = connection.getMetaData();

        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        //Number of columns
        int colCount = resultSetMetaData.getColumnCount();
        System.out.println(colCount);

        // All column names printed dynamically
        for (int i = 1; i <= colCount; i++) {
            System.out.println(resultSetMetaData.getColumnName(i));
        }



        resultSet.close();
        statement.close();
        connection.close();
    }
}
