// John Schmidt
// CS-320
// October 10, 2026

package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

public class ContactServiceTest {
	
	@Test
	void testAddcontactMethod() {
		// Creating the Contact
		ContactService contactService = new ContactService();
		String testID = contactService.generateUniqueID();
		Contact contact = new Contact(testID, "Dade", "Murphey", "5555555555", "31 Grove St");
		
		// Adding Contact to List
		contactService.addContact(contact);;
		
		// Confirms that Contact is in the list
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getContactList().elementAt(0).getContactID().equals(testID));
		assertTrue(contactService.getNumContacts() > 0);
		
		contactService.addContact("999999", "Kate", "Libby", "1231231234", "100 Broadway St");
		assertEquals(2, contactService.getNumContacts());
		assertEquals("999999", contactService.getContactList().elementAt(1).getContactID());
		
		
		String secondID = contactService.generateUniqueID();
		assertNotNull(secondID);
	}
	
	@Test
	void testRemoveContactMethod() {
		ContactService contactService = new ContactService();
		// Creating the Contact
		Contact contact = new Contact("123456", "Dade", "Murphey", "5555555555", "31 Grove St");
		
		// Testing with Null ID
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("");
		});
		
		// Testing with ID that is too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("1234567890123");
		});
		
		// Attempting to remove from empty list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.removeContact("1234567890");
		});
		
		// Adding the contact
		contactService.addContact(contact);
		
		// Removal of contact that does not exist
		contactService.removeContact("123451");
		
		// List is not empty, count is not zero, contact does not exist
		assertTrue(!contactService.getContactList().isEmpty());
		assertTrue(contactService.getNumContacts() != 0);
		
		// Removing correct contact
		contactService.removeContact("123456");
		
		// Empty list, count zero, contact removed successfully
		assertTrue(contactService.getNumContacts() == 0);
		assertTrue(contactService.getContactList().isEmpty());
	}
	
	@Test
	void testUpdateContactMethodErrors() {
		ContactService contactService = new ContactService();
		
		// Empty contact list
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "Michael", 1);
		});
		
		// Create a new Contact and add to list
		Contact contact = new Contact("123456", "Mike", "Joe", "5555555555", "123 That St");
		contactService.addContact(contact);
		
		// Check contact was successfully added
		assertTrue(!contactService.getContactList().isEmpty());
		
		// ID too long
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456789123", "Michael", 1);
		});
		
		// ID is Null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact(null,  "Michael", 1);
		});
		
		// Update is null
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", null, 1);
		});
		
		// Selection value less than zero
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", null, -1);
		});
		
		// Print error for contact not found
		contactService.updateContact("123457", "Michael", 1);
		
		// Print error for contact not updated
		contactService.updateContact("123456", "Michael",5);
	}
	
	@Test
	void testUpdateContactMethod() {
		ContactService contactService = new ContactService();
		Contact contact = new Contact("123456", "Mike", "Joe", "5555555555", "123 That St");
		contactService.addContact(contact);
		assertTrue(!contactService.getContactList().isEmpty());
		
		// Updating first name
		contactService.updateContact("123456", "Michael",1);
		assertTrue(contactService.getContactList().elementAt(0).getContactName().equals("Michael Joe"));
		
		// Updating last name
		contactService.updateContact("123456", "Joseph", 2);
		assertTrue(contactService.getContactList().elementAt(0).getContactName().equals("Michael Joseph"));
		
		// Updating Phone Number
		contactService.updateContact("123456", "4444444444", 3);
		assertTrue(contactService.getContactList().elementAt(0).getPhoneNumber().equals("4444444444"));
		
		// Updating Address
		contactService.updateContact("123456", "456 This St", 4);
		assertTrue(contactService.getContactList().elementAt(0).getContactAddress().equals("456 This St"));
		
		// Update for too long first name
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contactService.updateContact("123456", "MichaelJordan", 1);
		});
		
		// Checking that the list is updated correctly
		assertTrue(contactService.getNumContacts() == 1);
		assertTrue(contactService.getContactList().elementAt(0).getContactName().equals("Michael Joseph"));
	}
	
	

}
