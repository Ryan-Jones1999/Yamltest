package com.kainos.ea.service;

import com.kainos.ea.dao.UserDao;
import com.kainos.ea.model.Token;
import com.kainos.ea.model.User;
import com.kainos.ea.util.DatabaseConnector;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    UserDao userDao = Mockito.mock(UserDao.class);

    @Test
    void registerUser_shouldReturnToken_whenDaoReturnsToken() throws SQLException {

        User user = new User(
                "Something@anything.com",
                "Password!",
                "Admin"
        );

        Token expectedResult = new Token("token");
        Mockito.when(userDao.register(user)).thenReturn(expectedResult);

        Token result = new Token("token");

        assertEquals(result.getToken(), expectedResult.getToken());
    }
}
