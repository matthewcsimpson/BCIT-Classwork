package ca.bcit.comp3656.assign.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	public static final Pattern VALID_ID_REGEX = Pattern.compile("(^A{1}|^a{1})\\d{8}");
	
	/**
	 * Method to check if an employee ID is valid. 
	 * If valid return true, if invalid return false. 
	 * 
	 * @param checkID - a String
	 * @return goodID - a boolean
	 */
	public static boolean checkID(final String checkID) {
		boolean goodID = false;
		if(!checkID.isEmpty() && checkID != null ) {
			Matcher rMatcher = VALID_ID_REGEX.matcher(checkID);
			goodID = rMatcher.find();
		}
		return goodID;
		
	}
	
}
