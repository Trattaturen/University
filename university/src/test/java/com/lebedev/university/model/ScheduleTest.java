package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class ScheduleTest {

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

	List<Lesson> initialLessons = new ArrayList<Lesson>(Arrays.asList(boysDay1Lesson1, girlsDay1Lesson1));
	List<Lesson> expectedLessons = new ArrayList<Lesson>(Arrays.asList(boysDay1Lesson1, girlsDay1Lesson1));

	Schedule schedule = new Schedule(initialLessons);

	@Test
	public void testAddLesson_CorrectLesson_1() {
		expectedLessons.add(boysDay2Lesson1);

		schedule.addLesson(boysDay2Lesson1);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testAddLesson_CorrectLesson_2() {
		expectedLessons.add(boysDay1Lesson2);
		expectedLessons.add(girlsDay1Lesson2);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(girlsDay1Lesson2);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testAddLesson_CorrectLesson_3() {
		expectedLessons.add(boysDay1Lesson2);
		expectedLessons.add(boysDay1Lesson3);
		expectedLessons.add(boysDay2Lesson1);
		expectedLessons.add(boysDay2Lesson2);
		expectedLessons.add(boysDay2Lesson3);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson3);
		schedule.addLesson(boysDay2Lesson1);
		schedule.addLesson(boysDay2Lesson2);
		schedule.addLesson(boysDay2Lesson3);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testAddLesson_NullLesson() {
		schedule.addLesson(null);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testAddLesson_IncorrectLesson_1() {
		schedule.addLesson(boysDay1Lesson1);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testAddLesson_IncorrectLesson_2() {
		expectedLessons.add(boysDay1Lesson2);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson2);

		Assert.assertEquals(expectedLessons, schedule.getLessons());

	}

	@Test
	public void testRemoveLesson_1() {
		expectedLessons.remove(boysDay1Lesson1);

		schedule.removeLesson(boysDay1Lesson1);

		Assert.assertEquals(expectedLessons, schedule.getLessons());
	}

	@Test
	public void testRemoveLesson_2() {
		expectedLessons.remove(girlsDay1Lesson1);

		schedule.removeLesson(girlsDay1Lesson1);

		Assert.assertEquals(expectedLessons, schedule.getLessons());
	}

	@Test
	public void testRemoveLesson_Null() {
		schedule.removeLesson(null);

		Assert.assertEquals(expectedLessons, schedule.getLessons());
	}

	@Test
	public void testFindScheduleLecturerCalendarArray_OneDay() {
		expectedLessons.clear();
		expectedLessons.add(boysDay1Lesson1);
		expectedLessons.add(boysDay1Lesson2);
		expectedLessons.add(boysDay1Lesson3);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson3);
		schedule.addLesson(boysDay2Lesson1);
		schedule.addLesson(boysDay2Lesson2);
		schedule.addLesson(boysDay2Lesson3);
		schedule.addLesson(girlsDay1Lesson2);
		schedule.addLesson(girlsDay1Lesson3);
		schedule.addLesson(girlsDay2Lesson1);
		schedule.addLesson(girlsDay2Lesson2);
		schedule.addLesson(girlsDay2Lesson3);

		Assert.assertEquals(expectedLessons, schedule.findSchedule(judy, new GregorianCalendar(2016, 7, 25)));
	}

	@Test
	public void testFindScheduleLecturerCalendarArray_TwoDays() {
		expectedLessons.clear();
		expectedLessons.add(boysDay1Lesson1);
		expectedLessons.add(boysDay1Lesson2);
		expectedLessons.add(boysDay1Lesson3);
		expectedLessons.add(boysDay2Lesson1);
		expectedLessons.add(boysDay2Lesson2);
		expectedLessons.add(boysDay2Lesson3);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson3);
		schedule.addLesson(boysDay2Lesson1);
		schedule.addLesson(boysDay2Lesson2);
		schedule.addLesson(boysDay2Lesson3);
		schedule.addLesson(girlsDay1Lesson2);
		schedule.addLesson(girlsDay1Lesson3);
		schedule.addLesson(girlsDay2Lesson1);
		schedule.addLesson(girlsDay2Lesson2);
		schedule.addLesson(girlsDay2Lesson3);

		Assert.assertEquals(expectedLessons,
				schedule.findSchedule(judy, new GregorianCalendar(2016, 7, 25), new GregorianCalendar(2016, 7, 26)));
	}

	@Test
	public void testFindScheduleGroupCalendarArray_OneDay() {
		expectedLessons.clear();
		expectedLessons.add(girlsDay2Lesson1);
		expectedLessons.add(girlsDay2Lesson2);
		expectedLessons.add(girlsDay2Lesson3);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson3);
		schedule.addLesson(boysDay2Lesson1);
		schedule.addLesson(boysDay2Lesson2);
		schedule.addLesson(boysDay2Lesson3);
		schedule.addLesson(girlsDay1Lesson2);
		schedule.addLesson(girlsDay1Lesson3);
		schedule.addLesson(girlsDay2Lesson1);
		schedule.addLesson(girlsDay2Lesson2);
		schedule.addLesson(girlsDay2Lesson3);

		Assert.assertEquals(expectedLessons, schedule.findSchedule(girlsGroup, new GregorianCalendar(2016, 7, 26)));
	}

	@Test
	public void testFindScheduleGroupCalendarArray_TwoDays() {
		expectedLessons.clear();
		expectedLessons.add(girlsDay1Lesson1);
		expectedLessons.add(girlsDay1Lesson2);
		expectedLessons.add(girlsDay1Lesson3);
		expectedLessons.add(girlsDay2Lesson1);
		expectedLessons.add(girlsDay2Lesson2);
		expectedLessons.add(girlsDay2Lesson3);

		schedule.addLesson(boysDay1Lesson2);
		schedule.addLesson(boysDay1Lesson3);
		schedule.addLesson(boysDay2Lesson1);
		schedule.addLesson(boysDay2Lesson2);
		schedule.addLesson(boysDay2Lesson3);
		schedule.addLesson(girlsDay1Lesson2);
		schedule.addLesson(girlsDay1Lesson3);
		schedule.addLesson(girlsDay2Lesson1);
		schedule.addLesson(girlsDay2Lesson2);
		schedule.addLesson(girlsDay2Lesson3);

		Assert.assertEquals(expectedLessons, schedule.findSchedule(girlsGroup, new GregorianCalendar(2016, 7, 25),
				new GregorianCalendar(2016, 7, 26)));
	}

}
