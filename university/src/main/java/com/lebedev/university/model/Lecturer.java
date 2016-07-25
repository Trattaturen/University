package com.lebedev.university.model;

import java.util.Calendar;

public class Lecturer extends Person {

	private int id;
	private String academicTitle;

	public Lecturer(String firstName, String lastName, Calendar birthDate, String academicTitle) {
		super(firstName, lastName, birthDate);
		this.academicTitle = academicTitle;

	}

	public String getAcademicTitle() {
		return academicTitle;
	}

}
