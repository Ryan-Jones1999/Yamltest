package com.kainos.ea.validator;

import com.kainos.ea.model.NewRoleRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddNewRole {

    NewJobRoleValidation validator = new NewJobRoleValidation();

    @Test
    public void isValidNewRole_shouldReturnTrue_whenValidRole(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        assertTrue(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobNameLessThan5Characters(){
        NewRoleRequest newrole = new NewRoleRequest(
                "Ths",
                "This is a test",
                "This is also a test",
                1,
                1,
                1
        );

        assertFalse(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobResponsibilityLessThan10Characters(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This",
                "This is also a test",
                1,
                1,
                1
        );

        assertFalse(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenSpecificationSummaryLessThan8Characters(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is test sss",
                "This",
                1,
                1,
                1
        );

        assertFalse(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenBandLevelLessthan1(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                1,
                0,
                1
        );

        assertFalse(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenCapabilityLevelLessThan1(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                1,
                1,
                -1
        );

        assertFalse(validator.isValid(newrole));
    }

    @Test
    public void isValidNewRole_shouldReturnFalse_whenJobFamilyLevelLessThan1(){
        NewRoleRequest newrole = new NewRoleRequest(
                "This is a test",
                "This is test sss",
                "This ist dsfdsfdsdfs",
                -10,
                1,
                1
        );

        assertFalse(validator.isValid(newrole));
    }
}