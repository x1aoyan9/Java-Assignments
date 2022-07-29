package com.caresoft.clinicapp;

import java.util.ArrayList;

public interface HIPAACompliantUser {
	abstract boolean assignPIN(int pin);
	
	abstract boolean accessAuthorized(Integer confirmedAuthID);
	
	boolean assignPin(int pin);
	
	ArrayList<String> newPatientNotes();
}