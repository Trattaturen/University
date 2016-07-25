package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.List;

public class University {

	private String name;
	private List<Faculty> faculties;

	public University(String name) {
		this.name = name;
		faculties = new ArrayList<Faculty>();
	}

	public void addFaculty(Faculty faculty) {
		if (faculty != null & !faculties.contains(faculty)) {
			faculties.add(faculty);
		}
	}

	public void removeFaculty(Faculty faculty) {
		faculties.remove(faculty);
	}

	public void updateFaculty(Faculty faculty) {
		// TODO : Implement
	}

	public List<Faculty> findFaculty(String name) {
		List<Faculty> foundFaculties = new ArrayList<Faculty>();

		for (Faculty currentFaculty : faculties) {

			if (currentFaculty.getName().contains(name)) {

				foundFaculties.add(currentFaculty);
			}
		}
		return foundFaculties;
	}

	public String getName() {
		return name;
	}

}
