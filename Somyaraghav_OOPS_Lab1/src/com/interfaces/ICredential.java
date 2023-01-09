package com.interfaces;

public interface ICredential {

	  String generatePassword();
	  String generateEmailAddress(String lastName, String firstName);
	  String showCredentials(); 
	  String Department();
}
