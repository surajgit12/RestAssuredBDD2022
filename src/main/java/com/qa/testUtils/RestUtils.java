package com.qa.testUtils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	

	public static String get_first_name() {

		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Rakul" + generatedString);

	}

	public static String get_last_name() {

		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Preet" + generatedString);

	}

	public static String get_id() {
		String generatedString = RandomStringUtils.randomNumeric(3);
		return (generatedString);
	}

	public static String get_SubjectID() {
		String generatedString = RandomStringUtils.randomNumeric(3);
		return (generatedString);
	}

}


