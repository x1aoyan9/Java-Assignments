package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;
// TO DO: constructor that takes an ID
// TO DO: implement HIPAACompliantUser!
public class Physician extends User implements HIPAACompliantUser {
//...imports class definition...
	
	// inside class:
	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) {
		super(id);
		// TO DO: auto-generate constructor stub
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
		String report = String.format("Datetime Submitted: %s \n", date);
		report += String.format("Reported By ID: %s\n", this.id);
		report += String.format("Patient Name: %s\n", patientName);
		report += String.format("Notes: %s \n", notes);
		this.patientNotes.add(report);
	}
	
	// TO DO: getters & setters
	
	@Override
	public boolean assignPin(int pin) {
		if (pin < 1000 || pin > 9999) {
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// TO DO: auto-generate method stub
		if (this.id != confirmedAuthID) {
			return false;
		}
		return true;
	}
	
	@Override
	public ArrayList<String> newPatientNotes(){
		return this.newPatientNotes();
	}

	@Override
	public boolean assignPIN(int pin) {
		// TO DO: auto-generated method stub
		return false;
	}
}