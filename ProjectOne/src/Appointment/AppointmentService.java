// John Schmidt
// CS-320
// October 10, 2026
package Appointment;

import java.util.Date;
import java.util.Random;
import java.util.Vector;


public class AppointmentService {
	
	private Vector<Appointment> _apptList = new Vector<Appointment>();
	private int _apptCount = 0;
	
	// Getter
	public Vector<Appointment> GetAppointmentList() {
		return _apptList;
	}
	
	public int GetAppointmentCount() {
		return _apptCount;
	}
	
	public void PrintAppointmentList() {
		for (Appointment a : _apptList) {
			System.out.println("Appointment ID: " + a.GetID() + 
					"\nAppointment Date: " + a.GetApptDate().toString() + 
					"\nAppointment Description: " + a.GetDescription());
		}
	}
	
	// Add Appointments and Check for Errors
	public void AddAppointment(Date date, String description) {
		Date today = new Date();
		if (date == null || date.before(today)) {
			throw new IllegalArgumentException("Invalid Appointment Date");
		}
		
		if (description == null || description.length() > 50) {
			throw new IllegalArgumentException("Invalid Appointment Description");
		}
		
		String newID = GenerateUniqueID();
		var newAppt = new Appointment(newID, date, description);
		_apptList.add(newAppt);
		_apptCount = GetAppointmentCount() + 1;
		// Comment Below is for testing
		// System.out.println("Appointment " + description + " created.");
	}
	
	// Removing Appointments and Checking for Errors
	public void RemoveAppointment(String id) {
		if (_apptList.isEmpty()) {
			System.out.println("There are no appointments to remove");
		}
		
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid Appointment ID");
		}
		
		// Search Appointment ID's to see specific Appointment
		int index = -1;
		for (Appointment a : _apptList) {
			if (a.GetID().equals(id)) {
				index = _apptList.indexOf(a);
			}
		}
		
		// Appointment ID Not Found
		if (index == -1) {
			System.out.println("Appointment ID Not Found");
			return;
		}
		// Removing the Appointment
		else {
			_apptList.remove(index);
			_apptCount = GetAppointmentCount() - 1;
			System.out.println("Appointment " + id + " Succesfully Removed");
		}
	}
	
	// Generate a Unique ID for a Created Appointment
	public String GenerateUniqueID(/*int mult*/) {
		// randomize number with 9 - 10 digits
		
		//if (mult < 1) {
		//	mult = 1000000000;
		//}
		int count = 0;
		
		Random rand = new Random();
		int newID = rand.nextInt(1000000000);
		String uniqueID = Integer.toString(newID);
		
		// temporary vector of strings for ids
		Vector<String> idList = new Vector<String>();
		// fill vector with existing ids
		for (Appointment a : _apptList) {
			idList.add(a.GetID());
		}
		
		// compare newly created id to list of existing
		while (idList.contains(uniqueID) || uniqueID.length() > 10) {
			// if match was found, create a new id
			newID = rand.nextInt(1000000000);
			uniqueID = Integer.toString(newID);
			count++;
			if (count > 1000000000) {
				System.out.println("No More ID's Available");
				break;
			}
		}
		// Remove Temporary Vector
		idList = null;
		// Return Created ID
		return uniqueID;
	}
	
	
}

