// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.AppointmentService;

class AppointmentServiceTest {
	
	// Create a Valid Date
	Date createDate() {
		Calendar c = Calendar.getInstance();
		c.set(2026, 10, 3, 10, 45); 
		Date date = c.getTime();
		return date;
	}
	
	// Create an Invalid Date Before Today
	Date createBadDate() {
		Date date = new Date();
		date.setTime(10000);
		return date;
	}
	
	// Test for AddAppointment Constructor / Initial State
	@Test
	void testConstructor() {
		var apptService = new AppointmentService();
		assertTrue(apptService.GetAppointmentList().isEmpty());
		assertEquals(apptService.GetAppointmentCount(), 0);
		
		apptService.AddAppointment(createDate(), "Description");
		apptService.PrintAppointmentList();
	}
	
	@Test
	void testAddAppointmentMethodNullDate() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(null, "Description");
		});
	}
	
	@Test
	void testAddAppointmentMethodNullDescription() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createDate(), null);
		});
	}
	
	@Test
	void testAddAppointmentMethodBadDate() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createBadDate(), "Description");
		});
	}
	
	@Test
	void testAddAppointmentMethodBadDescription() {
		var apptService = new AppointmentService();
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.AddAppointment(createDate(), "thisisadescriptionthatismeant" + 
					"tobetoolongtobeconsideredinvalidintheprogram");
		});
	}
	
	@Test
	void testAddAppointmentMethodWithValidParameters() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createDate(), "This is a Description");
		assertEquals(apptService.GetAppointmentCount(), 1);
		assertTrue(!apptService.GetAppointmentList().isEmpty());
		apptService.PrintAppointmentList();
	}
	
	@Test
	void testRemoveMethodListEmpty() {
		var apptService = new AppointmentService();
		apptService.RemoveAppointment("1234567");
	}
	
	@Test
	void testRemoveMethodIDNull() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createDate(), "TO REMOVE");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.RemoveAppointment(null);
		});
	}
	
	@Test 
	void testRemoveMethodIDTooLong() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createDate(), "TO REMOVE");
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			apptService.RemoveAppointment("1234567800090123");
		});
	}
	
	@Test
	void testRemoveMethodAppointmentNotInList() {
		var apptService = new AppointmentService();
		apptService.AddAppointment(createDate(), "TO REMOVE");
		apptService.RemoveAppointment("1234567");
		assertTrue(!apptService.GetAppointmentList().isEmpty());
	}
}