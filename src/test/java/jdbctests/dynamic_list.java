package jdbctests;

import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.*;

public class dynamic_list {

    String dbUrl = "jdbc:oracle:thin:@54.144.137.19:1521:XE";
    String dbUsername = "hr";
    String dbPassword = "hr";

    @Test
    public void test2() throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("Select first_name, last_name,salary,job_id from employees where rownum <6");

        ResultSetMetaData rsmd = resultSet.getMetaData();

        List<Map<String, Object>> queryData = new ArrayList<>();

        int colCount = rsmd.getColumnCount();

        while (resultSet.next())
        {
            Map<String, Object> row = new LinkedHashMap<>();

            for (int i = 1; i <=colCount ; i++)
            {
                row.put(rsmd.getColumnName(i),resultSet.getObject(i));
            }
            queryData.add(row);
        }

        for (Map<String, Object> row :queryData)
        {
            System.out.println(row.toString());
        }




        resultSet.close();
        statement.close();
        connection.close();
    }
}
