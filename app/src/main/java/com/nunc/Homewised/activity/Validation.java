package com.nunc.Homewised.activity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.webkit.URLUtil;

public class Validation {

	public static boolean isValidEmail(String email) {
		boolean isValid = false;
		String ex = "^([a-zA-Z0-9_\\.\\-])+([+_a-zA-Z0-9])+\\@(([a-zA-Z0-9\\-])+\\.)([a-zA-Z0-9]{2,3})([a-zA-Z0-9.]{3})?$";
		// String expression =
		// "^[\\w\\.-]+[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		CharSequence inputStr = email;

		Pattern pattern = Pattern.compile(ex, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}
		if (email.contains(".com.com") || email.contains(".com.com.com")) {
			isValid = false;
		}
		return isValid;

	}

	public static boolean validatecharinAddress(String address) {

		return address.matches("[^a-zA-Z0-9]");

	}
	public static boolean isValidPassword(String pass) {
		return pass != null && pass.length() >= 6;
	}

	public static boolean isValidDesc(String desc) {
		return desc != null && desc.length() >= 1;
	}

	public static boolean isValidPhoneNumber(String num) {
		return num != null && num.length() == 12;
	}

	public static boolean isValidClinicName(String num) {
		return num != null && num.length() >= 5 && num.length() <= 50;
	}

	public static boolean isValidDoctorName(String num) {
		return num != null && num.length() >= 5 && num.length() <= 50;
	}

	public static boolean isValidZip(String zip) {
		return zip != null && zip.length() == 5;
	}

	public static boolean isValidAddress(String address) {
		return address != null && address.length() >= 5 && address.length() <= 50;
	}

	public static boolean isValidCity(String city) {

		if (!city.toString().matches("[a-zA-Z ]+")) {
			return false;
		}

		return !(city.length() < 3 || city.length() > 40);

	}

	public static boolean isCompanyName(String company) {
		return company != null && company.length() >= 5 && company.length() <= 50;
	}

	public static boolean isWebsiteName(String url) {
		if (url != null) {
			return URLUtil.isValidUrl(url);
		}
		return false;
	}

}
