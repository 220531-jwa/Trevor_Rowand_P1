package dev.rowand.junit;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.rowand.models.User;
import dev.rowand.repositories.UserDAO;

import dev.rowand.services.UserService;

@ExtendWith(MockitoExtension.class)
public class LoginServiceTest { //how to improve coverage?
	@InjectMocks
	private static UserService userService;
	
	@Mock
	private static UserDAO mockUserDao;
	
	@BeforeEach
	public void setupEach() {
		userService = new UserService(mockUserDao);
	}
	
	
	@Test
	public void should_Login() {
		User usersMock = new User("username", 1, "pass", "Fname", "Lname", 1000, "type");
		when(mockUserDao.getUserByUsername(anyString())).thenReturn(usersMock);
		
		User loggedInUser = userService.loginUser("username", "pass");
		
		assertEquals(usersMock, loggedInUser);
	}
	
	@Test
	public void LoginWithInvalidUsernameShouldBeNull() { //cannot invoke dev.rowand.models.User.getPassword() because u is null
		when(mockUserDao.getUserByUsername(anyString())).thenReturn(null);
		
		User loggedInUser = userService.loginUser("username", "pa$$word");
		
		assertEquals(null, loggedInUser);
	}
	
	@Test
	public void LoginWithValidUsernameButInvalidPassShouldBeNull() {
		User usersMock = new User("username", 1, "pass", "Fname", "Lname", 1000, "type");
		when(mockUserDao.getUserByUsername(anyString())).thenReturn(usersMock);
		
		User loggedInUser = userService.loginUser("username", "pa$$word");
		
		assertEquals(null, loggedInUser);
	}
	
}
