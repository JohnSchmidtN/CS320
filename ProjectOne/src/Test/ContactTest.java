// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;


public class ContactTest {
	
	
	@Test
	void testContactNullArguments() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact(null, null, null, null, null);
		});
	}
	
	@Test
	void testContactAndGetters() {
		Contact contact = new Contact("123456", "Emmanuel", "Goldstein","5555555555", "123 This St");
		assertTrue(contact.getContactName().equals("Emmanuel Goldstein"));
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
		assertTrue(contact.getContactAddress().equals("123 This St"));
		assertTrue(contact.getContactID().equals("123456"));	
	}
	
	@Test
	void testSetFirstAndLastName() {
		Contact contact = new Contact("123456", "Emmanuel", "Goldstein","5555555555", "123 This St");
		contact.setFirstName("Emmanuel");
		contact.setLastName("Goldstein");
		assertTrue(contact.getContactName().equals("Emmanuel Goldstein"));
	}
	
	@Test
	void testSetPhoneNumberAndAddress() {
		Contact contact = new Contact("123456", "Emmanuel", "Goldstein","5555555555", "123 This St");
		contact.setPhoneNumber("5555555555");
		contact.setContactAddress("123 This St");
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
		assertTrue(contact.getContactAddress().equals("123 This St"));
		}
	
	@Test
	void testNullSetAttributes() {
		Contact contact = new Contact("123456", "Emmanuel", "Goldstein","5555555555", "123 This St");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setContactAddress(null);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhoneNumber(null);
		});
	}
	
	@Test
	void testAllGetters() {
		Contact contact = new Contact("123456", "Emmanuel", "Goldstein","5555555555", "123 This St");
		
		assertTrue(contact.getContactName().equals("Emmanuel Goldstein"));
		assertTrue(contact.getContactID().equals("123456"));
		assertTrue(contact.getPhoneNumber().equals("5555555555"));
		assertTrue(contact.getContactAddress().equals("123 This St"));
	}

}
