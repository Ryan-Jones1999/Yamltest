package com.kainos.ea.service;

import com.kainos.ea.dao.JobDao;
import com.kainos.ea.exception.RoleNotAddedException;
import com.kainos.ea.model.Competency;
import com.kainos.ea.model.JobRole;
import com.kainos.ea.model.NewRoleRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class JobServiceTest {

    JobDao jobDao = Mockito.mock(JobDao.class);

    @Test
    void getJobRoles_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.getjobroles()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.getjobroles());
    }

    @Test
    void getViewJobRolesShouldReturnListOfJobRoles_whenDaoReturnsJobRoles() throws SQLException {
        JobRole result = new JobRole("Test");
        JobRole result2 = new JobRole("Test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.getjobroles()).thenReturn(expected);

        List<JobRole> actual;


        actual = jobDao.getjobroles();

        assertEquals(expected.size(),actual.size());

    }

    @Test
    void getSpec_ShouldReturnJobSpec_whenDaoReturnsJob() throws SQLException {
        JobRole result = new JobRole(1);
        result.setSpecification("Test");

        Mockito.when(jobDao.getSpec(1)).thenReturn(result);

        JobRole actual = jobDao.getSpec(1);

        assertEquals(result.getSpecification(),actual.getSpecification());

    }

    @Test
    void getResponsibility_ShouldReturnJobResponsibility_whenDaoReturnsJob() throws SQLException {
        JobRole result = new JobRole(1);
        result.setJobResponsibility("Test");

        Mockito.when(jobDao.getSpec(1)).thenReturn(result);

        JobRole actual = jobDao.getSpec(1);

        assertEquals(result.getJobResponsibility(), actual.getJobResponsibility());

    }

    @Test
    void getJobCapabilities_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.getjobwithcapability()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.getjobwithcapability());
    }

    @Test
    void getViewJobCapabilitiesShouldReturnListOfJobCapabilities_whenDaoReturnsJobCapabilities() throws SQLException {
        JobRole result = new JobRole("test","Test","Summary","Capability", 1,"Trainee");
        JobRole result2 = new JobRole("test","Test","Summary","Capability", 1,"Trainee");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.getjobwithcapability()).thenReturn(expected);

        List<JobRole> actual;


        actual = jobDao.getjobwithcapability();

        assertEquals(expected.size(),actual.size());
    }

    @Test
    void getCompetencey_shouldThrowSqlException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.getCompetency(0)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.getCompetency(0));
    }

    @Test
    void getCompetencey_ShouldReturnCompetencie_whenDaoReturnsListOfCompetenciesForAValidBand() throws SQLException {
        Competency result = new Competency(1,"Test", "This is a test");
        Competency result2 = new Competency(2,"Test2", "This is a test2");
        List<Competency> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.getCompetency(1)).thenReturn(expected);

        List<Competency> actual;


        actual = jobDao.getCompetency(1);

        assertEquals(expected.size(),actual.size());
    }

    @Test
    void getFamily_ShouldReturnFamily_whenDaoReturnsListOfFamilys() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.populateFamilyLists()).thenReturn(expected);

        List<JobRole> actual;
        actual = jobDao.populateFamilyLists();

        assertEquals(expected.get(1).getListName(),actual.get(1).getListName());
    }

    @Test
    void getFamily_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateFamilyLists()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateFamilyLists());
    }

    @Test
    void getBand_ShouldReturnBands_whenDaoReturnsListOfBands() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.populateBandLevelList()).thenReturn(expected);

        List<JobRole> actual;

        actual = jobDao.populateBandLevelList();

        assertEquals(expected.get(0).getListName(),actual.get(0).getListName());
    }

    @Test
    void getBands_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateBandLevelList()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateBandLevelList());
    }

    @Test
    void getCapability_ShouldReturnCapability_whenDaoReturnsListOfCapabilities() throws SQLException {
        JobRole result = new JobRole(1, "This is a test");
        JobRole result2 = new JobRole(2, "This is a test2");
        List<JobRole> expected = new ArrayList<>();

        expected.add(result);
        expected.add(result2);

        Mockito.when(jobDao.getjobwithcapability()).thenReturn(expected);

        List<JobRole> actual;

        actual = jobDao.getjobwithcapability();

        assertEquals(expected.get(0).getListID(),actual.get(0).getListID());
    }

    @Test
    void getCapability_shouldThrowSQLException_whenDaoThrowsSqlException() throws SQLException {
        Mockito.when(jobDao.populateCapabilityList()).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.populateCapabilityList());
    }

    @Test
    void postAddNewRole_ShouldReturnNewRole_whenDaoReturnsNewRole() throws SQLException, RoleNotAddedException {

        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        Mockito.when(jobDao.Addnewjobrole(newrole)).thenReturn(newrole);

        NewRoleRequest actual;

        actual = jobDao.Addnewjobrole(newrole);

        assertEquals(newrole,actual);
    }

    @Test
    void postAddNewRole_ShouldReturnSQLException_whenDaoReturnsSQLException() throws SQLException, RoleNotAddedException {

        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );
        Mockito.when(jobDao.Addnewjobrole(newrole)).thenThrow(SQLException.class);

        assertThrows(SQLException.class,
                () -> jobDao.Addnewjobrole(newrole));
    }

    @Test
    void postAddNewRole_ShouldReturnRoleNotAddedException_whenDaoReturnsRoleNotAddedException() throws SQLException, RoleNotAddedException {

        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );
        Mockito.when(jobDao.Addnewjobrole(newrole)).thenThrow(RoleNotAddedException.class);

        assertThrows(RoleNotAddedException.class,
                () -> jobDao.Addnewjobrole(newrole));
    }
}