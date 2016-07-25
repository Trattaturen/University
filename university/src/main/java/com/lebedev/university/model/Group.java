package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.List;

public class Group {

	private String name;
	private List<Student> students;

	public Group(String name) {
		this.name = name;
		students = new ArrayList<Student>();
	}

	public void addStudent(Student student) {
		if (student != null && !students.contains(student)) {
			student.setGroup(this);
			students.add(student);
		}
	}

	public boolean removeStudent(Student student) {
		return students.remove(student);
	}

	public List<Student> findStudent(String lastName) {
		List<Student> foundStudents = new ArrayList<Student>();
		for (Student currentStudent : students) {

			if (currentStudent.getLastName().equalsIgnoreCase(lastName)) {
				foundStudents.add(currentStudent);
			}
		}
		return foundStudents;
	}

	public String getName() {
		return name;
	}

	public List<Student> getStudents() {
		return students;
	}

}
