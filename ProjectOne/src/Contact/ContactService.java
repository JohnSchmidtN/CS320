// John Schmidt
// CS-320
// October 10, 2026


package Contact;


import java.util.Vector;
import java.util.Random;


public class ContactService {
	
	// Creating the Vector to store the contacts
	private Vector<Contact> myContacts = new Vector<Contact>();
	
	// Creating an integer counter for the number of contacts
	private int numContacts = 0;
	
	// Getter for the numContacts
	public int getNumContacts() {
		return numContacts;
	}
	
	// Getter for the full list of contacts
	public Vector<Contact> getContactList() {
		return myContacts;
	}
	
	// Function for adding a contact to the list
	public void addContact(String contactID, String fName, String lName, String phoneNumber, String contactAddress) {
		// Creating the new contact
		Contact newContact = new Contact(contactID, fName, lName, phoneNumber, contactAddress);
		
		// Adding a contact to the current list of contacts
		myContacts.add(newContact);
		
		// Incrementing the number of contacts
		numContacts++;
	}
	
	public void addContact(Contact contact) {
		// Adding the contact to the list of contacts
		myContacts.add(contact);
		
		// Incrementing the number of contacts
		numContacts++;
	}
	
	public void removeContact(String contactID) {
		
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("There are No Contacts in the List");
		}
		
		int index = -1;
		for (Contact c: myContacts) {
			if (c.getContactID().equals(contactID)) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not Found");
			return;
		}
		
		else {
			myContacts.remove(index);
			numContacts--;
			System.out.println("Contact Removed");
		}
	}
	
	public void removeContact(Contact contact) {
		myContacts.remove(contact);
		numContacts --;
	}

	// Updating Contact
	public void updateContact(String ID, String update, int selection) {
		if (ID == null || ID.length() > 10 || update == null || selection < 0) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("The Contact List is Empty, No Contacts to Update");
		}
		
		int index = -1;
		
		for (Contact c: myContacts) {
			if (c.getContactID().equals(ID)) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Nothing Found");
			return;
		}
		
		Contact updatedContact = myContacts.get(index);
		
		switch(selection) {
		case 1:{
			updatedContact.setFirstName(update);
			break;
		}
		
		case 2:{
			updatedContact.setLastName(update);
			break;
		}
		
		case 3:{
			updatedContact.setPhoneNumber(update);;
			break;
		}
		
		case 4:{
			updatedContact.setContactAddress(update);;
			break;
		}
		
		default:{
			removeContact(myContacts.elementAt(index));
			addContact(updatedContact);
		}
		}
	}
	
	public void updatedContact(String ID, String fName, String lName, String pNumber, String contactAddress) {
		if (ID == null || ID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (myContacts.isEmpty()) {
			throw new IllegalArgumentException("There are no Contacts in the list");
		}
		
		int index = -1;
		
		for (Contact c: myContacts) {
			if (c.getContactID().equals(ID)) {
				index = myContacts.indexOf(c);
			}
		}
		
		if (index == -1) {
			System.out.println("Not Found");
			return;
		}
		
		Contact tempContact = myContacts.get(index);
		
		tempContact.setFirstName(fName);
		tempContact.setLastName(lName);
		tempContact.setPhoneNumber(pNumber);
		tempContact.setContactAddress(contactAddress);
		
		myContacts.remove(index);
		myContacts.add(tempContact);
		
	}
	
	public String generateUniqueID() {
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		for (Contact c: myContacts) {
			while(c.getContactID().equals(uniqueID)) {
				newID = rand.nextInt(1000000000);
				uniqueID = Integer.toString(newID);
			}
		}
		
		System.out.println("New Contact ID: " + uniqueID);
		return uniqueID;
	}

}
