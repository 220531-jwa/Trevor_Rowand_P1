package dev.rowand.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.rowand.models.Form;
import dev.rowand.repositories.FormDAO;
import dev.rowand.services.FormService;


@ExtendWith(MockitoExtension.class)
public class FormServiceTest {
	@InjectMocks
	private static FormService formService;
	
	@Mock
	private static FormDAO mockFormDao;
	
	
	@Test
	public void Should_GetAllRequests() {
		List<Form> formsMock = new ArrayList<>();
		formsMock.add(new Form(1, "05/07/2006", "12:45 p.m.", "San Antonio, TX", "Howdy Y'all!", 0.5f, 740, "D and above", "soemthing", "mock", "pending"));
		formsMock.add(new Form(2, "09/25/2020", "8:00 a.m.", "San Antonio, TX", "Howdy Y'all!", 0.8f, 540, "D and above", "soemthing", "mock", "pending"));
		formsMock.add(new Form(3, "01/31/2022", "10:30 p.m.", "San Antonio, TX", "Howdy Y'all!", 0.2f, 740, "D and above", "soemthing", "mock", "pending"));
		
		when(mockFormDao.getAllRequests()).thenReturn(formsMock);
		
		// then - it should return all users
		assertEquals(formsMock, formService.getAllRequests());
	}
	
	@Test
	public void Should_RequestReimburse() {
		Form Request = new Form(2, "09/25/2020", "8:00 a.m.", "San Antonio, TX", "Howdy Y'all!", 0.8f, 540, "D and above", "soemthing", "mock", "pending");
when(mockFormDao.reimburseRequest(Request)).thenReturn(Request);
		
		// then - it should return all users
				assertEquals(Request, formService.reimburseRequest(Request));
	}
	
	@Test
	public void Should_UpdateStatus() {
		Form Request = new Form(3, "01/31/2022", "10:30 p.m.", "San Antonio, TX", "Howdy Y'all!", 0.2f, 740, "D and above", "soemthing", "mock", "pending");
		
		when(mockFormDao.updateStatus(3, "rejected")).thenReturn(Request);
		
		// then - it should return all users
				assertEquals(Request, formService.updateStatus(3, "rejected"));
		
	}
	@Test
	public void ShouldNotUpdateStatusWhenNull() {
		Form Request = new Form(3, "01/31/2022", "10:30 p.m.", "San Antonio, TX", "Howdy Y'all!", 0.2f, 740, "D and above", "soemthing", "mock", "pending");
		
		when(mockFormDao.updateStatus(3, null)).thenReturn(null);
		
		// then - it should return all users
				assertEquals(Request, null);
		
	}
	
}
