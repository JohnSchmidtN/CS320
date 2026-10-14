// John Schmidt
// CS-320
// October 10, 2026

package Contact;


public class Contact {
	
	private String contactID;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String contactAddress;
	
	
	public Contact(String id, String fName, String lName, String pNumber, String conAddress) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		if (fName == null || fName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name"); 
		}
		
		if (lName == null || lName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		
		if (pNumber == null || pNumber.length() > 10 || pNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		
		if (conAddress == null || conAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Contact Address");
		}
		
		this.contactID = id;
		this.firstName = fName;
		this.lastName = lName;
		this.phoneNumber = pNumber;
		this.contactAddress = conAddress;
	}
	
	// Getters
	public String getContactID() {
		return this.contactID;
	}
	
	public String getContactName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public String getContactAddress() {
		return this.contactAddress;
	}
	
	
	
	// Setters
	public void setContactID(String newID) {
		if (newID == null || newID.length() > 10) {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		contactID = newID;
	}
	
	public void setFirstName(String newFirstName) {
		if (newFirstName == null || newFirstName.length() > 10) {
			throw new IllegalArgumentException("Invalid First Name");
		}
		firstName = newFirstName;
	}
	
	public void setLastName(String newLastName) {
		if (newLastName == null || newLastName.length() > 10) {
			throw new IllegalArgumentException("Invalid Last Name");
		}
		lastName = newLastName;
	}
	
	public void setPhoneNumber(String newPhoneNumber) {
		if (newPhoneNumber == null || newPhoneNumber.length() > 10 || newPhoneNumber.length() < 10) {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
		phoneNumber = newPhoneNumber;
	}
	
	public void setContactAddress(String newContactAddress) {
		if (newContactAddress == null || newContactAddress.length() > 30) {
			throw new IllegalArgumentException("Invalid Contact Address");
		}
		contactAddress = newContactAddress;
	}

}
