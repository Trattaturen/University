package com.lebedev.university.model;

import java.util.Calendar;

public class Student extends Person {

	private int id;
	private Group group;

	public Student(String firstName, String lastName, Calendar birthDate) {
		super(firstName, lastName, birthDate);

	}

	public Group getGroup() {
		return group;
	}

	void setGroup(Group group) {
		this.group = group;
	}

}
