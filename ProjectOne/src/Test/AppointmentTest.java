// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Appointment.Appointment;



class AppointmentTest {
	
	@Test
	void testApptConstructor() {
		Calendar c = Calendar.getInstance();
		c.set(2026, 10, 3, 10, 45); 
		Date date = c.getTime();
		
		//Date date = new Date(2026, 10, 1)
		System.out.println("Date set to " + date);
		
		
		// Testing for ID Too Long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("1234567890123", date, "Appointment Description");
		});
		
		// Testing for null ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment(null, date, "Appointment Description");
		});
		
		// Testing for Description Too Long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", date, "Thisisatestthatistestingforthelengthofthedescription" + 
								"thisdescriptioniswaytoolongfortheconstructor");
		});
		
		// Testing for null Description 
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", date, null);
		});
		
		// Testing for null Date
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", null, "Apointment Description");
		});
		
		// Testing for Date Before Today
		date.setTime(0);;
		System.out.println("Date set to " + date);
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Appointment("123456789", date, "Appointment Description");
		});
		
		// Testing if Everything is Correct and Valid
		Date newDate = c.getTime();
		Appointment appt = new Appointment("123456789", newDate, "Appointment Description");
		assertTrue(appt.GetID().equals("123456789"));
		assertTrue(appt.GetApptDate().equals(newDate));
		assertTrue(appt.GetDescription().equals("Appointment Description"));
	}
	
	@Test
	void testSetters() {
		Calendar c = Calendar.getInstance();
		c.set(2026, 10, 3, 10, 45);
		Date date = c.getTime();
		Date newDate = c.getTime();
		Date badDate = new Date();
		badDate.setTime(10000);
		
		
		// Make an Object
		Appointment appt = new Appointment("123456789", date, "Appointment Description");
		
		// Set New Description
		appt.SetApptDescription("This is the Appointment Description");
		
		// null Description Error
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appt.SetApptDescription(null);
		});
		
		// Long Description Error
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appt.SetApptDescription("Thisdescriptionismeanttobetoolongtothrowanerroronpurpos");
		});
		
		// Check to see if Description is Changed
		assertTrue(appt.GetDescription().equals("This is the Appointment Description"));
		
		// Check for Date Before Today
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appt.SetApptDate(badDate);
		});
		
		// null Date Error
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			appt.SetApptDate(null);
		});
		
		// Date is Valid
		appt.SetApptDate(newDate);
		
		// Check that Date is Changed
		assertTrue(appt.GetApptDate().equals(newDate));
	}
	

}
