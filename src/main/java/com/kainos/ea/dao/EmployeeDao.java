package com.kainos.ea.dao;

import com.kainos.ea.model.JobRole;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kainos.ea.util.DatabaseConnector.closeConnection;
import static com.kainos.ea.util.DatabaseConnector.getConnection;
public class EmployeeDao {

    public List<JobRole> getjobroles() throws SQLException {

        String s = "SELECT jobName, jobResponsibility, specification, specSummary FROM job";

        List<JobRole> jobrole = new ArrayList<>();

        try {
            Connection c = getConnection();
            PreparedStatement preparedStmt1 = c.prepareStatement(s);

            preparedStmt1.execute();

            ResultSet rs = preparedStmt1.executeQuery();
            while (rs.next()) {
                JobRole jobroles = new JobRole(
                        rs.getString("jobName"),
                        rs.getString("jobResponsibility")
                );
                jobroles.setSpecification(rs.getString("specification"));
                jobroles.setSpecSummary(rs.getString("specSummary"));
                jobrole.add(jobroles);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            closeConnection();
        }

        return jobrole;
    }

    public JobRole getSpec(String jobName) throws SQLException {
        String sql = "select specification from job where jobName=?";

        JobRole jobRole = new JobRole(jobName);

        try {
            Connection c = getConnection();
            PreparedStatement preparedStmt1 = c.prepareStatement(sql);
            System.out.println(jobName);
            preparedStmt1.setString(1, jobName);

            ResultSet rs = preparedStmt1.executeQuery();


            while (rs.next()) {
                jobRole.setSpecification(rs.getString("specification"));
            }
            System.out.println("test");
        } catch (SQLException ex) {
        ex.printStackTrace();
    } finally {
        closeConnection();
    }

        return jobRole;
    }
}