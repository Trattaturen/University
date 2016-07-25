package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Schedule {

	private List<Lesson> lessons;

	public Schedule(List<Lesson> schedule) {

		this.lessons = schedule;
	}

	public void addLesson(Lesson lesson) {

		if (lesson != null && !lessons.contains(lesson)
				&& isAuditoriumCapacityEnough(lesson.getAuditorium(), lesson.getGroup())
				&& !isLecturerOccupied(lesson.getLecturer(), lesson.getStartTime())
				&& !isAuditoriumOccupied(lesson.getAuditorium(), lesson.getStartTime())
				&& !isGroupOccupied(lesson.getGroup(), lesson.getStartTime())) {

			lessons.add(lesson);
		}

	}

	public void removeLesson(Lesson lesson) {
		if (lesson != null) {

			lessons.remove(lesson);
		}
	}

	public List<Lesson> findSchedule(Lecturer lecturer, Calendar... dates) {

		List<Lesson> foundLessons = new ArrayList<Lesson>();

		if (dates.length == 1) {
			Calendar requiredDate = dates[0];

			for (Lesson currentLesson : lessons) {

				if (currentLesson.getLecturer().equals(lecturer)
						&& isSameDay(currentLesson.getStartTime(), requiredDate)) {

					foundLessons.add(currentLesson);
				}
			}

		} else if (dates.length > 1 && dates[0].before(dates[1])) {
			Calendar startDate = dates[0];
			Calendar finishDate = dates[1];

			for (Lesson currentLesson : lessons) {

				if (currentLesson.getLecturer().equals(lecturer)
						&& isDayBetween(currentLesson.getStartTime(), startDate, finishDate)) {

					foundLessons.add(currentLesson);

				}
			}

		}
		return foundLessons;

	}

	public List<Lesson> findSchedule(Group group, Calendar... dates) {

		List<Lesson> foundLessons = new ArrayList<Lesson>();

		if (dates.length == 1) {
			Calendar requiredDate = dates[0];

			for (Lesson currentLesson : lessons) {

				if (currentLesson.getGroup().equals(group) && isSameDay(currentLesson.getStartTime(), requiredDate)) {

					foundLessons.add(currentLesson);
				}
			}

		} else if (dates.length > 1 && dates[0].before(dates[1])) {

			Calendar startDate = dates[0];
			Calendar endDate = dates[1];

			for (Lesson currentLesson : lessons) {

				if (currentLesson.getGroup().equals(group)
						&& isDayBetween(currentLesson.getStartTime(), startDate, endDate)) {

					foundLessons.add(currentLesson);
				}
			}

		}
		return foundLessons;

	}

	public boolean isAuditoriumOccupied(Auditorium auditorium, Calendar time) {

		for (Lesson currentLesson : lessons) {

			if (currentLesson.getAuditorium().equals(auditorium) && currentLesson.getStartTime().equals(time)) {

				return true;
			}
		}
		return false;
	}

	public boolean isLecturerOccupied(Lecturer lecturer, Calendar time) {

		for (Lesson currentLesson : lessons) {

			if (currentLesson.getLecturer().equals(lecturer) && currentLesson.getStartTime().equals(time)) {

				return true;
			}
		}

		return false;
	}

	public boolean isGroupOccupied(Group group, Calendar time) {

		for (Lesson currentLesson : lessons) {

			if (currentLesson.getGroup().equals(group) && currentLesson.getStartTime().equals(time)) {

				return true;
			}
		}
		return false;
	}

	public boolean isAuditoriumCapacityEnough(Auditorium auditorium, Group group) {

		return group.getStudents().size() <= auditorium.getCapacity();
	}

	private boolean isDayBetween(Calendar targetDate, Calendar startDate, Calendar finishDate) {

		return targetDate.get(Calendar.YEAR) >= startDate.get(Calendar.YEAR)
				&& targetDate.get(Calendar.YEAR) <= finishDate.get(Calendar.YEAR)
				&& targetDate.get(Calendar.DAY_OF_YEAR) >= startDate.get(Calendar.DAY_OF_YEAR)
				&& targetDate.get(Calendar.DAY_OF_YEAR) <= finishDate.get(Calendar.DAY_OF_YEAR);
	}

	private boolean isSameDay(Calendar firstCalendar, Calendar secondCalendar) {

		return firstCalendar.get(Calendar.YEAR) == secondCalendar.get(Calendar.YEAR)
				&& firstCalendar.get(Calendar.DAY_OF_YEAR) == secondCalendar.get(Calendar.DAY_OF_YEAR);
	}

	public List<Lesson> getLessons() {
		return lessons;
	}

}
