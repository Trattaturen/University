package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.List;

public class Faculty {

	private String name;
	private List<Department> departments;
	private Schedule schedule;
	private List<Auditorium> auditoriums;

	public Faculty(String name) {
		this.name = name;
		departments = new ArrayList<Department>();
		auditoriums = new ArrayList<Auditorium>();
	}

	public void addDepartment(Department department) {

		if (department != null && !departments.contains(department)) {

			departments.add(department);
		}
	}

	public void removeDepartment(Department department) {
		departments.remove(department);
	}

	public void updateDepartment(Department department) {
		// TODO : Implement
	}

	public List<Department> findDepartment(String name) {

		List<Department> foundDepartments = new ArrayList<Department>();

		for (Department currentDepartment : departments) {

			if (currentDepartment.getName().contains(name)) {

				foundDepartments.add(currentDepartment);
			}
		}
		return foundDepartments;
	}

	public void createSchedule(List<Lesson> lessons) {
		schedule = new Schedule(lessons);
	}

	public void updateSchedule(Schedule schedule) {
		// TODO: Implement
	}

	public void addAuditorium(Auditorium auditorium) {

		if (auditorium != null && !auditoriums.contains(auditorium)) {

			auditoriums.add(auditorium);
		}
	}

	public void removeAuditorium(Auditorium auditorium) {
		auditoriums.remove(auditorium);
	}

	public void updateAuditorium(Auditorium auditorium) {
		// TODO : Implement
	}

	public List<Auditorium> findAuditorium(String name) {
		List<Auditorium> foundAuditoriums = new ArrayList<Auditorium>();

		for (Auditorium currentAuditorium : auditoriums) {

			if (currentAuditorium.getName().contains(name)) {

				foundAuditoriums.add(currentAuditorium);
			}
		}
		return foundAuditoriums;
	}

	public String getName() {
		return name;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	public List<Auditorium> getAuditoriums() {
		return auditoriums;
	}

}
