package com.kapresoft.articles.nodi.service;

import com.kapresoft.articles.nodi.ApplicationContext;
import com.kapresoft.articles.nodi.dao.UserDAO;
import com.kapresoft.articles.nodi.model.User;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static java.util.Optional.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceIntegrationTest {

    @Mock
    private UserDAO userDAOMock;
    @Mock
    private EmailService emailServiceMock;
    @Mock
    private ApplicationContext applicationContextMock;
    @Spy
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        when(applicationContextMock.userDAO()).thenReturn(userDAOMock);
        when(applicationContextMock.emailService()).thenReturn(emailServiceMock);
        doReturn(applicationContextMock).when(userService).applicationContext();
    }

    @Test
    public void testRegisterUser() {
        User newUser = User.builder().email("steve.rogers@gmail.com")
                .first("Steve")
                .last("Rogers")
                .build();
        doNothing().when(userDAOMock).createUser(newUser);
        when(userDAOMock.findUserByEmail(anyString())).thenReturn(of(newUser));

        User registeredUser = userService.registerUser(newUser);

        verify(userDAOMock).createUser(newUser);
        verify(userDAOMock).findUserByEmail(newUser.getEmail());
        verify(emailServiceMock).confirmEmailAddress(newUser);
        assertThat(registeredUser).isNotNull();
        // Additional assertions as needed
    }

}
