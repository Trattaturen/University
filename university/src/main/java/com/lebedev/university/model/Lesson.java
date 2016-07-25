package com.lebedev.university.model;

import java.util.Calendar;

public class Lesson {

	private Auditorium auditorium;
	private Course course;
	private Group group;
	private Lecturer lecturer;
	private Calendar startTime;

	public Lesson(Auditorium auditorium, Course course, Group group, Lecturer lecturer, Calendar startTime) {

		this.auditorium = auditorium;
		this.course = course;
		this.group = group;
		this.lecturer = lecturer;
		this.startTime = startTime;
	}

	public Auditorium getAuditorium() {
		return auditorium;
	}

	public Course getCourse() {
		return course;
	}

	public Group getGroup() {
		return group;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public Calendar getStartTime() {
		return startTime;
	}

}
