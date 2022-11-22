package com.kainos.ea.dao;

import com.kainos.ea.model.jobrole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.util.DatabaseConnector.closeConnection;
import static com.kainos.ea.util.DatabaseConnector.getConnection;
public class EmployeeDao {

    public List<jobrole> getjobroles() {

        String s = "SELECT jobName, jobResponsibility FROM job";

        List<jobrole> jobrole = new ArrayList<>();

        try {
            Connection c = getConnection();
            PreparedStatement preparedStmt1 = c.prepareStatement(s);

            preparedStmt1.execute();

            ResultSet rs = preparedStmt1.executeQuery();
            while (rs.next()) {
                jobrole jobroles = new jobrole(
                        rs.getString("jobName"),
                        rs.getString("jobResponsibility")
                );
                jobrole.add(jobroles);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }

        return jobrole;
    }
}
