package com.lebedev.university.model;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class GroupTest {

	Student rachael = new Student("Jennifer", "Aniston", new GregorianCalendar(1969, 2, 11));
	Student monica = new Student("Courteney", "Cox", new GregorianCalendar(1964, 6, 11));
	Student phoebe = new Student("Lisa", "Kudrow", new GregorianCalendar(1963, 6, 30));
	Student joey = new Student("Matt", "LeBlanc", new GregorianCalendar(1967, 7, 25));
	Student chandler = new Student("Matthew", "Perry", new GregorianCalendar(1969, 8, 19));
	Student ross = new Student("David", "Schwimmer", new GregorianCalendar(1966, 11, 2));

	Group boysGroup = new Group("Boys group");
	Group girlsGroup = new Group("Girls group");

	List<Student> expectedBoys = new ArrayList<Student>();
	List<Student> expectedGirls = new ArrayList<Student>();

	@Test
	public void testAddStudent_1() {
		Assert.assertEquals(expectedBoys, boysGroup.getStudents());
		Assert.assertEquals(expectedGirls, girlsGroup.getStudents());

	}

	@Test
	public void testAddStudent_2() {
		expectedBoys.add(chandler);
		expectedBoys.add(ross);
		expectedGirls.add(monica);
		expectedGirls.add(phoebe);

		boysGroup.addStudent(chandler);
		boysGroup.addStudent(ross);
		girlsGroup.addStudent(monica);
		girlsGroup.addStudent(phoebe);
		Assert.assertEquals(expectedBoys, boysGroup.getStudents());
		Assert.assertEquals(expectedGirls, girlsGroup.getStudents());

	}

	@Test
	public void testAddStudent_Null() {
		boysGroup.addStudent(null);
		girlsGroup.addStudent(null);
		Assert.assertEquals(expectedBoys, boysGroup.getStudents());
		Assert.assertEquals(expectedGirls, girlsGroup.getStudents());

	}

	@Test
	public void testRemoveStudent() {
		expectedBoys.clear();
		expectedGirls.clear();
		expectedGirls.add(phoebe);

		boysGroup.addStudent(chandler);
		boysGroup.addStudent(ross);
		girlsGroup.addStudent(monica);
		girlsGroup.addStudent(phoebe);

		boysGroup.removeStudent(joey);
		boysGroup.removeStudent(chandler);
		boysGroup.removeStudent(ross);

		girlsGroup.removeStudent(rachael);
		girlsGroup.removeStudent(monica);

		Assert.assertEquals(expectedBoys, boysGroup.getStudents());
		Assert.assertEquals(expectedGirls, girlsGroup.getStudents());

	}

	@Test
	public void testFindStudent() {
		expectedBoys.clear();
		expectedGirls.clear();
		expectedBoys.add(ross);
		expectedGirls.add(monica);

		boysGroup.addStudent(chandler);
		boysGroup.addStudent(ross);
		girlsGroup.addStudent(monica);
		girlsGroup.addStudent(phoebe);

		Assert.assertEquals(expectedBoys, boysGroup.findStudent("Schwimmer"));
		Assert.assertEquals(expectedGirls, girlsGroup.findStudent("Cox"));
	}

}
