// John Schmidt
// CS-320
// October 10, 2026


package Appointment;

import java.util.Date;



public class Appointment {
	
	
	private String _apptID;
	private Date _apptDate;
	private String _apptDescription;
	
	public Appointment(String id, Date date, String description) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		
		_apptID = id;
		_apptDate = date;
		_apptDescription = description;
	}
	
	// Setting Getters
	

	public String GetID() {
		return _apptID;
	}
	
	public Date GetApptDate() {
		return _apptDate;
	}
	
	public String GetDescription() {
		return _apptDescription;
	}
	
	
	// Setters with Error Checking
	public void SetApptDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		_apptDate = date;
	}
	
	public void SetApptDescription(String description) {
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Description");
		}
		_apptDescription = description;
	}

}
