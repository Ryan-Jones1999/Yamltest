package com.kainos.ea.dao;

import com.kainos.ea.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Objects;

import static com.kainos.ea.util.DatabaseConnector.getConnection;

public class UserDao {

    public boolean register(User user) {
        try {
            Connection c = getConnection();
            String insertQuery = "INSERT INTO user (email, password, role) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = Objects.requireNonNull(c).prepareStatement(insertQuery);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getRole());

            if(preparedStatement.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
