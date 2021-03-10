package com.cybertek;

import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:oracle:thin:@54.236.150.168:1521:XE";

        Connection connection = DriverManager.getConnection(url,"hr","hr");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM EMPLOYEES");

        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

        resultSet.beforeFirst();

        int columnCount = resultSetMetaData.getColumnCount();
/*
        while (resultSet.next()) {
            System.out.print(resultSet.getString(2));
        }

 */
        System.out.println();
        System.out.println("====================================================================");
/*
        for (int column = 1; column <= columnCount; column++) {
            System.out.println("Column "+column+" Name "+ resultSetMetaData.getColumnName(column));
        }

 */
        List<String> columnNames = new ArrayList<>();

        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(resultSetMetaData.getColumnName(column));
        }
        System.out.println(columnNames);












    }
}
