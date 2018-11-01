package com.revature.string;

import java.util.Arrays;

import org.apache.log4j.Logger;

import com.revature.string.JavaStringAnswers;

public class JavaStringAnswers implements JavaString {

	private static final Logger LOGGER = Logger.getLogger(JavaStringAnswers.class);
	
	public static void main(String[] args) {
		JavaStringAnswers jsa = new JavaStringAnswers();
		LOGGER.info(jsa.parseInteger("+1234"));
		LOGGER.info(jsa.delete("revature", 'e'));
	}
	
	/**
	 * accepts positive numbers in form "993" and "+993" as well as negative num like "-323"
	 */
	@Override
	public int parseInteger(String number) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (number == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		int positive = 1;
		
		char firstChar = number.charAt(0);
		String input;
		if (firstChar == '+') {
			input = number.substring(1, number.length());
			
		} else if (firstChar == '-') {
			input = number.substring(1, number.length());
			positive = -1;
		} else {
			input = number;
		}
		
		
		char[] chrArr = input.toCharArray();
		int output = 0;
		
		
		for (int i = 0; i < input.length(); i++) {
			if (!Character.isDigit(chrArr[i])) {
				throw new IllegalArgumentException("all input must be integer in string form");
			}
			output += (Character.getNumericValue(chrArr[i]) * Math.pow(10, input.length() - i - 1));
		}	
		return output * positive;
	}

	@Override
	public String reverse(String string) throws IllegalArgumentException {
		// TODO Auto-generated method stub		
		
		if (string == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		String output = "";
		
		char[] chars = string.toCharArray();
		for(int i = 0; i < chars.length; i++) {
			output = chars[i] + output;
		}
		
		return output;
	}

	@Override
	public void time(StringBuilder builder, StringBuffer buffer) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (builder == null || buffer == null) {
			throw new IllegalArgumentException("argument cannot be null");
		}
		
		String adder = "Hello";
		
		long start1 = System.currentTimeMillis();
		for (int i = 0; i < 3_000_000; i++) {
			builder.append(adder);
		}
		long end1 = System.currentTimeMillis();
		
		long time1 = end1 - start1;
		
		long start2 = System.currentTimeMillis();
		
		for (int i = 0; i < 3_000_000; i++) {
			buffer.append(adder);
		}
		long end2 = System.currentTimeMillis();
		long time2 = end2 - start2;
		System.out.println(builder.getClass() + " time is " + time1 + "ms, while " + buffer.getClass() + " time is " + time2 + "ms.");
	}

	@Override
	public boolean itContains(String string, String contains) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (string == null || contains == null) {
			throw new IllegalArgumentException("String cannot be null!");
		}
		
		return string.contains(contains) ? true : false;
	}

	@Override
	public String sort(String string) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		
		if (string == null) {
			throw new IllegalArgumentException("input cannot be null");
		}
		char[] chrArr = string.toCharArray();
		
		Arrays.sort(chrArr);
		return Arrays.toString(chrArr);
	}

	/**
	 * Since the direction is to delete a character, which includes more than the alphabet, I implemented so as to be case-sensitive.
	 */
	@Override
	public String delete(String string, char c) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		if (string == null) {
			throw new IllegalArgumentException("String cannot be null");
		}
		
		StringBuilder answer = new StringBuilder("");
		
		char[] chrArr = string.toCharArray();
		
		for (char cha:chrArr) {
			if (cha != c) {
				answer.append(cha);
			}
		}
		String answerString = new String(answer);
		return answerString;
	}

	
	@Override
	public String upperLower(String string) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		int size = string.length();
		
		if (string == null || size % 2 == 1) {
			throw new IllegalArgumentException("String cannot be null or odd number of characters");
		}
		
		int halfPoint = size / 2;
		
		StringBuilder output = new StringBuilder("");
		String substr;
		
		for (int i = 0; i < string.length(); i++) {
			substr = string.substring(i, i+1);
			substr = i < halfPoint ? substr.toLowerCase() : substr.toUpperCase();
			output.append(substr);
		}
		String answer = new String(output);
		
		return answer;
	}

}
