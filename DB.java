package com.geekbrains.server;

import java.sql.*;

public class DB {
    Class.forName("org.sqlite.JDBC");


    Connection connection;

    {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:WorkDB.db");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    PreparedStatement preparedStatement;

    {
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO student(name, score) VALUES(?, ?)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



}
