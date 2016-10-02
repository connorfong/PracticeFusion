package PracticeFusion;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.*;

public class DoctorTest {
	private final Doctor John = new Doctor("John", "Surgery", "Anatomy", (float)7.5);
	private final Doctor Jake = new Doctor("Jake", "Surgery", "Anatomy", (float)6.0);
	private final Doctor Lana = new Doctor("Lana", "Surgery", "Anatomy", (float)7.9);
	private final Doctor Jill = new Doctor("Jill", "Medicine", "Anatomy", (float)9.0);
	private final Doctor Fred = new Doctor("Fred", "Medicine", "Anatomy", (float)6.0);
	private final Doctor Phil = new Doctor("Phil", "Surgery", "Cytology", (float)6.8);
	private final Doctor Jane = new Doctor("Jane", "Medicine", "Genetics", (float)5.0);
	
	// Test if the program returns an empty list given an empty list
	@Test
	public void testEmpty() {
		findSimilar doctors = new findSimilar(new ArrayList<Doctor>());
		assertTrue(doctors.findDoctors(John).isEmpty());
	}
	
	// Test if the program works with one entry, which is the same as the given doctor
	@Test
	public void testOne() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctor.add(John);
		findSimilar doctors = new findSimilar(doctor);
		assertTrue(doctors.findDoctors(John).equals(doctor));
	}
	
	// Test if the program returns an empty list if none of the areas match the given doctor
	@Test
	public void testNone() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctor.add(John);
		doctor.add(Jake);
		findSimilar doctors = new findSimilar(doctor);
		assertTrue(doctors.findDoctors(Phil).size() == 0);
	}
	
	// Test if there are no doctors with the same specialty
	@Test
	public void testNoSpecialty() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctor.add(Jill);
		findSimilar doctors = new findSimilar(doctor);
		assertTrue(doctors.findDoctors(John).size() == 1);
	}
	
	// Test if the ordering of entries with differing specialties is correct
	@Test
	public void testSpecialty() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctor.add(Jill);
		doctor.add(John);
		findSimilar doctors = new findSimilar(doctor);
		List<Doctor> testResult = new ArrayList<Doctor>();
		testResult.add(John);
		testResult.add(Jill);
		assertTrue(doctors.findDoctors(Jake).equals(testResult));
	}
	
	// Test the sorting function based on review score 
	// and make sure nonsimilar doctors are not on the list
	@Test
	public void testSort() {
		List<Doctor> doctor = new ArrayList<Doctor>();
		doctor.add(Fred);
		doctor.add(Jill);
		doctor.add(Jake);
		doctor.add(Lana);
		doctor.add(John);
		doctor.add(Phil);
		doctor.add(Jane);
		findSimilar doctors = new findSimilar(doctor);
		List<Doctor> testResult = new ArrayList<Doctor>();
		testResult.add(Lana);
		testResult.add(John);
		testResult.add(Jake);
		testResult.add(Jill);
		testResult.add(Fred);
		assertTrue(doctors.findDoctors(Jake).equals(testResult));
	}
}