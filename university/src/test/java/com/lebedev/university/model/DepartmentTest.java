package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class DepartmentTest {

	Course math = new Course("Math", "");
	Course english = new Course("English", "");
	Course physics = new Course("Physics", "");
	Course drawing = new Course("Drawing", "");
	Course db = new Course("Data bases", "");
	Course algo = new Course("Algorithms", "");

	Student rachael = new Student("Jennifer", "Aniston", new GregorianCalendar(1969, 2, 11));
	Student monica = new Student("Courteney", "Cox", new GregorianCalendar(1964, 6, 11));
	Student phoebe = new Student("Lisa", "Kudrow", new GregorianCalendar(1963, 6, 30));
	Student joey = new Student("Matt", "LeBlanc", new GregorianCalendar(1967, 7, 25));
	Student chandler = new Student("Matthew", "Perry", new GregorianCalendar(1969, 8, 19));
	Student ross = new Student("David", "Schwimmer", new GregorianCalendar(1966, 11, 2));

	Group boysGroup = new Group("Boys group");
	Group girlsGroup = new Group("Girls group");

	Lecturer jack = new Lecturer("Elliott", "Gould", new GregorianCalendar(1938, 8, 29), "PhD");
	Lecturer judy = new Lecturer("Christina", "Pickles", new GregorianCalendar(1935, 2, 17), "Professor");

	Department biologyDepartment = new Department("Biology Department");

	List<Course> expectedCourses = new ArrayList<Course>();
	List<Group> expectedGroups = new ArrayList<Group>();
	List<Lecturer> expectedLecturers = new ArrayList<Lecturer>();

	@Test
	public void testAddCourse_1() {
		expectedCourses.add(math);
		expectedCourses.add(english);

		biologyDepartment.addCourse(math);
		biologyDepartment.addCourse(english);

		Assert.assertEquals(expectedCourses, biologyDepartment.getCourses());
	}

	@Test
	public void testAddCourse_2() {
		expectedCourses.add(drawing);

		biologyDepartment.addCourse(drawing);

		Assert.assertEquals(expectedCourses, biologyDepartment.getCourses());
	}

	@Test
	public void testAddCourse_Null() {
		biologyDepartment.addCourse(null);

		Assert.assertEquals(expectedCourses, biologyDepartment.getCourses());
	}

	@Test
	public void testRemoveCourse() {
		expectedCourses.add(english);

		biologyDepartment.addCourse(math);
		biologyDepartment.addCourse(english);
		biologyDepartment.addCourse(physics);
		biologyDepartment.addCourse(drawing);

		Assert.assertEquals(expectedCourses, biologyDepartment.findCourse("English"));
	}

	@Test
	public void testFindCourse() {
		expectedCourses.add(math);
		expectedCourses.add(english);

		biologyDepartment.addCourse(math);
		biologyDepartment.addCourse(english);

		Assert.assertEquals(expectedCourses, biologyDepartment.getCourses());
	}

	@Test
	public void testAddGroup_1() {
		expectedGroups.add(boysGroup);

		biologyDepartment.addGroup(boysGroup);

		Assert.assertEquals(expectedGroups, biologyDepartment.getGroups());
	}

	@Test
	public void testAddGroup_2() {
		expectedGroups.add(girlsGroup);

		biologyDepartment.addGroup(girlsGroup);

		Assert.assertEquals(expectedGroups, biologyDepartment.getGroups());
	}

	@Test
	public void testAddGroup_Null() {
		biologyDepartment.addGroup(null);

		Assert.assertEquals(expectedGroups, biologyDepartment.getGroups());
	}

	@Test
	public void testRemoveGroup() {
		expectedGroups.add(boysGroup);

		biologyDepartment.addGroup(boysGroup);
		biologyDepartment.addGroup(girlsGroup);

		biologyDepartment.removeGroup(girlsGroup);

		Assert.assertEquals(expectedGroups, biologyDepartment.getGroups());
	}

	@Test
	public void testFindGroup() {
		expectedGroups.add(boysGroup);

		biologyDepartment.addGroup(boysGroup);
		biologyDepartment.addGroup(girlsGroup);

		Assert.assertEquals(expectedGroups, biologyDepartment.findGroup("Boys group"));

	}

	@Test
	public void testAddLecturer_1() {
		expectedLecturers.add(jack);

		biologyDepartment.addLecturer(jack);

		Assert.assertEquals(expectedLecturers, biologyDepartment.getLecturers());
	}

	@Test
	public void testAddLecturer_2() {
		expectedLecturers.add(judy);

		biologyDepartment.addLecturer(judy);

		Assert.assertEquals(expectedLecturers, biologyDepartment.getLecturers());
	}

	@Test
	public void testAddLecturer_Null() {
		biologyDepartment.addLecturer(null);

		Assert.assertEquals(expectedLecturers, biologyDepartment.getLecturers());
	}

	@Test
	public void testRemoveLecturer() {
		expectedLecturers.add(judy);

		biologyDepartment.addLecturer(jack);
		biologyDepartment.addLecturer(judy);

		biologyDepartment.removeLecturer(jack);

		Assert.assertEquals(expectedLecturers, biologyDepartment.getLecturers());
	}

	@Test
	public void testFindLecturer() {
		expectedLecturers.add(jack);

		biologyDepartment.addLecturer(jack);
		biologyDepartment.addLecturer(judy);

		Assert.assertEquals(expectedLecturers, biologyDepartment.findLecturer("Gould"));
	}

}
