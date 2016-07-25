package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.List;

public class Department {

	private String name;
	private List<Course> courses;
	private List<Group> groups;
	private List<Lecturer> lecturers;

	public Department(String name) {
		this.name = name;
		courses = new ArrayList<Course>();
		groups = new ArrayList<Group>();
		lecturers = new ArrayList<Lecturer>();
	}

	public void addCourse(Course course) {

		if (course != null && !courses.contains(course)) {

			courses.add(course);
		}
	}

	public void removeCourse(Course course) {
		courses.remove(course);
	}

	public void updateCourse(Course course) {
		// TODO: Implement
	}

	public List<Course> findCourse(String name) {

		List<Course> foundCourses = new ArrayList<Course>();

		for (Course currentCourse : courses) {

			if (currentCourse.getName().contains(name)) {

				foundCourses.add(currentCourse);
			}
		}
		return foundCourses;
	}

	public void addGroup(Group group) {

		if (group != null & !groups.contains(group)) {
			groups.add(group);
		}
	}

	public void removeGroup(Group group) {
		groups.remove(group);
	}

	public void updateGroup(Group group) {
		// TODO: Implement
	}

	public List<Group> findGroup(String name) {

		List<Group> foundGroups = new ArrayList<Group>();

		for (Group currentGroup : groups) {

			if (currentGroup.getName().contains(name)) {

				foundGroups.add(currentGroup);
			}
		}
		return foundGroups;
	}

	public void addLecturer(Lecturer lecturer) {

		if (lecturer != null & !lecturers.contains(lecturer)) {

			lecturers.add(lecturer);
		}
	}

	public void removeLecturer(Lecturer lecturer) {
		lecturers.remove(lecturer);
	}

	public void updateLecturer(Lecturer lecturer) {
		// TODO : Implement
	}

	public List<Lecturer> findLecturer(String name) {
		List<Lecturer> foundLecturers = new ArrayList<Lecturer>();

		for (Lecturer currentLecturer : lecturers) {

			if (currentLecturer.getLastName().contains(name)) {

				foundLecturers.add(currentLecturer);
			}
		}
		return foundLecturers;

	}

	public String getName() {
		return name;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public List<Lecturer> getLecturers() {
		return lecturers;
	}

}
