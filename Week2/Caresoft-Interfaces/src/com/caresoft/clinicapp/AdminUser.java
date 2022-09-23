package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
//TO DO: implement HIPAACompliantUser!
//TO DO: implement HIPAACompliantAdmin!
public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin{
//...imports class definition...
	
	// inside class:
	private String role;
	private ArrayList<String> securityIncidents;
	
	//TO DO: implement a constructor that takes an ID and a role
	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
		this.securityIncidents = new ArrayList<String>();
	}
	
	public void newIncident(String notes) {
		String report = String.format("Datetime Submitted: %s \n, Reported By ID: %s\n, Notes: %s \n", new Date(), this.id, notes);
		securityIncidents.add(report);
	}
	
	public void authIncident() {
		String report = String.format("Datetime Submitted: %s \n, ID: %s\n, Notes: %s \n", new Date(), this,id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER");
		securityIncidents.add(report);
	}
	
	// TO DO: getters & setters
	@Override
	public boolean assignPin(int pin) {
		if (pin < 100000 || pin > 999999) {
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TO DO: auto-generate method stub
		if(confirmedAuthID != this.id) {
			this.authIncident();
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<String> reportSecurityIncidents(){
	return this.securityIncidents;
	}

	@Override
	public boolean assignPIN(int pin) {
		// TO DO: auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> newPatientNotes() {
		// TO DO: auto-generated method stub
		return null;
	}
}