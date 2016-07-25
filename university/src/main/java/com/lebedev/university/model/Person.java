package com.lebedev.university.model;

import java.util.Calendar;

public abstract class Person {

	private String firstName;
	private String lastName;
	private Calendar birthDate;

	public Person(String firstName, String lastName, Calendar birthDate) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Calendar getBirthDate() {
		return birthDate;
	}

}
