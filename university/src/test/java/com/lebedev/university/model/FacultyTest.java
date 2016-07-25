package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class FacultyTest {

	Student rachael = new Student("Jennifer", "Aniston", new GregorianCalendar(1969, 2, 11));
	Student monica = new Student("Courteney", "Cox", new GregorianCalendar(1964, 6, 11));
	Student phoebe = new Student("Lisa", "Kudrow", new GregorianCalendar(1963, 6, 30));
	Student joey = new Student("Matt", "LeBlanc", new GregorianCalendar(1967, 7, 25));
	Student chandler = new Student("Matthew", "Perry", new GregorianCalendar(1969, 8, 19));
	Student ross = new Student("David", "Schwimmer", new GregorianCalendar(1966, 11, 2));

	Lecturer jack = new Lecturer("Gould", "Elliott", new GregorianCalendar(1938, 8, 29), "PhD");
	Lecturer judy = new Lecturer("Pickles", "Christina", new GregorianCalendar(1935, 2, 17), "Professor");

	Group boysGroup = new Group("Boys group");
	Group girlsGroup = new Group("Girls group");

	Auditorium number1 = new Auditorium("1", AuditoriumType.SEMINAR_ROOM, 30);
	Auditorium number2 = new Auditorium("2", AuditoriumType.SEMINAR_ROOM, 12);
	Auditorium number3 = new Auditorium("3", AuditoriumType.LECTURE_HALL, 80);
	Auditorium number4 = new Auditorium("4", AuditoriumType.LECTURE_HALL, 80);

	Course math = new Course("Math", "");
	Course english = new Course("English", "");
	Course physics = new Course("Physics", "");
	Course drawing = new Course("Drawing", "");
	Course db = new Course("Data bases", "");
	Course algo = new Course("Algorithms", "");

	Lesson boysDay1Lesson1 = new Lesson(number1, math, boysGroup, judy, new GregorianCalendar(2016, 7, 25, 10, 0));
	Lesson boysDay1Lesson2 = new Lesson(number2, physics, boysGroup, judy, new GregorianCalendar(2016, 7, 25, 12, 0));
	Lesson boysDay1Lesson3 = new Lesson(number2, algo, boysGroup, judy, new GregorianCalendar(2016, 7, 25, 14, 0));

	Lesson boysDay2Lesson1 = new Lesson(number1, drawing, boysGroup, judy, new GregorianCalendar(2016, 7, 26, 10, 0));
	Lesson boysDay2Lesson2 = new Lesson(number2, english, boysGroup, judy, new GregorianCalendar(2016, 7, 26, 12, 0));
	Lesson boysDay2Lesson3 = new Lesson(number1, math, boysGroup, judy, new GregorianCalendar(2016, 7, 26, 14, 0));

	Lesson girlsDay1Lesson1 = new Lesson(number2, drawing, girlsGroup, jack, new GregorianCalendar(2016, 7, 25, 10, 0));
	Lesson girlsDay1Lesson2 = new Lesson(number1, english, girlsGroup, jack, new GregorianCalendar(2016, 7, 25, 12, 0));
	Lesson girlsDay1Lesson3 = new Lesson(number1, drawing, girlsGroup, jack, new GregorianCalendar(2016, 7, 25, 14, 0));

	Lesson girlsDay2Lesson1 = new Lesson(number2, drawing, girlsGroup, jack, new GregorianCalendar(2016, 7, 26, 10, 0));
	Lesson girlsDay2Lesson2 = new Lesson(number1, english, girlsGroup, jack, new GregorianCalendar(2016, 7, 26, 12, 0));
	Lesson girlsDay2Lesson3 = new Lesson(number2, english, girlsGroup, jack, new GregorianCalendar(2016, 7, 26, 14, 0));

	List<Lesson> lessons = new ArrayList<Lesson>(Arrays.asList(boysDay1Lesson1, boysDay1Lesson2, boysDay1Lesson3,
			boysDay2Lesson1, boysDay2Lesson2, boysDay2Lesson3, girlsDay1Lesson1, girlsDay1Lesson2, girlsDay1Lesson3,
			girlsDay2Lesson1, girlsDay2Lesson2, girlsDay2Lesson3));

	Schedule expectedSchedule = new Schedule(lessons);

	Department biologyDepartment = new Department("Biology Department");
	Department physicsDepartment = new Department("Physics Department");
	Department ITDepartment = new Department("IT Department");

	Faculty scienceFaculty = new Faculty("Science Faculty");
	List<Department> expectedDepartments = new ArrayList<Department>();
	List<Auditorium> expectedAuditoriums = new ArrayList<Auditorium>();

	@Test
	public void testAddDepartment() {
		expectedDepartments.add(ITDepartment);
		expectedDepartments.add(physicsDepartment);
		expectedDepartments.add(biologyDepartment);

		scienceFaculty.addDepartment(ITDepartment);
		scienceFaculty.addDepartment(physicsDepartment);
		scienceFaculty.addDepartment(biologyDepartment);

		Assert.assertEquals(expectedDepartments, scienceFaculty.getDepartments());

	}

	@Test
	public void testAddDepartment_Incorrect_Null() {
		expectedDepartments.add(ITDepartment);

		scienceFaculty.addDepartment(null);
		scienceFaculty.addDepartment(ITDepartment);
		scienceFaculty.addDepartment(ITDepartment);

		Assert.assertEquals(expectedDepartments, scienceFaculty.getDepartments());

	}

	@Test
	public void testRemoveDepartment() {
		expectedDepartments.add(ITDepartment);

		scienceFaculty.addDepartment(ITDepartment);
		scienceFaculty.addDepartment(physicsDepartment);
		scienceFaculty.addDepartment(biologyDepartment);

		scienceFaculty.removeDepartment(biologyDepartment);
		scienceFaculty.removeDepartment(physicsDepartment);

		Assert.assertEquals(expectedDepartments, scienceFaculty.getDepartments());
	}

	@Test
	public void testFindDepartment() {
		expectedDepartments.add(ITDepartment);

		scienceFaculty.addDepartment(ITDepartment);
		scienceFaculty.addDepartment(physicsDepartment);
		scienceFaculty.addDepartment(biologyDepartment);

		Assert.assertEquals(expectedDepartments, scienceFaculty.findDepartment("IT"));
	}

	@Test
	public void testCreateSchedule() {

		scienceFaculty.createSchedule(lessons);

		Assert.assertEquals(expectedSchedule.getLessons(), scienceFaculty.getSchedule().getLessons());
	}

	@Test
	public void testAddAuditorium() {
		expectedAuditoriums.add(number1);
		expectedAuditoriums.add(number2);
		expectedAuditoriums.add(number3);
		expectedAuditoriums.add(number4);

		scienceFaculty.addAuditorium(number1);
		scienceFaculty.addAuditorium(number2);
		scienceFaculty.addAuditorium(number3);
		scienceFaculty.addAuditorium(number4);

		Assert.assertEquals(expectedAuditoriums, scienceFaculty.getAuditoriums());

	}

	@Test
	public void testAddAuditorium_Icorrect_Null() {
		expectedAuditoriums.add(number1);
		expectedAuditoriums.add(number2);

		scienceFaculty.addAuditorium(number1);
		scienceFaculty.addAuditorium(number2);
		scienceFaculty.addAuditorium(null);
		scienceFaculty.addAuditorium(number1);

		Assert.assertEquals(expectedAuditoriums, scienceFaculty.getAuditoriums());

	}

	@Test
	public void testRemoveAuditorium() {
		expectedAuditoriums.add(number2);
		expectedAuditoriums.add(number4);

		scienceFaculty.addAuditorium(number1);
		scienceFaculty.addAuditorium(number2);
		scienceFaculty.addAuditorium(number3);
		scienceFaculty.addAuditorium(number4);

		scienceFaculty.removeAuditorium(number1);
		scienceFaculty.removeAuditorium(number3);

		Assert.assertEquals(expectedAuditoriums, scienceFaculty.getAuditoriums());

	}

	@Test
	public void testFindAuditorium() {
		expectedAuditoriums.add(number4);

		scienceFaculty.addAuditorium(number1);
		scienceFaculty.addAuditorium(number2);
		scienceFaculty.addAuditorium(number3);
		scienceFaculty.addAuditorium(number4);

		Assert.assertEquals(expectedAuditoriums, scienceFaculty.findAuditorium("4"));

	}

}
