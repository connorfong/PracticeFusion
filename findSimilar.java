package PracticeFusion;
import java.util.*;

// This class has a function that returns a List of similar doctors based primarily on area
// The list is separated into doctors that share the specialty of the given doctor and those that do not
// Each sublist is sorted separately based on review score

// The doctor at the beginning of the list is the doctor with review score that shares 
// the same specialty and area of the given doctor

// The doctor at the end of the list shares the same area as the given doctor,
// but does not have the same specialty and has the lowest review score
public class findSimilar {
	List<Doctor> doctors;
	
	public findSimilar(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	// This function is used to find doctors similar to the given doctor
	// I have assumed that area is the most general classification of similarity
	public List<Doctor> findDoctors(Doctor sample) {
		List<Doctor> result = new ArrayList<Doctor>();
		
		// specialtySize is a counter to track how many doctors share both area and specialty
		int specialtySize = 0;
		
		for (Doctor curr : doctors) {
			if (curr.getArea().equals(sample.getArea())) {
				// If the specialties are the same, add to the front of the list, else add it to the back
				if (curr.getSpecialty().equals(sample.getSpecialty())) {
					specialtySize++;
					result.add(0, curr);
				} else {
					result.add(curr);
				}
			}
		}
		
		// Check if there are too few results to sort
		if (result.size() <= 1) {
			return result;
		}
		
		// Sort the sublist with doctors sharing the specialty based on score
		Collections.sort(result.subList(0,specialtySize), new MyComparator());
		
		// Sort the remaining doctors that only share the same area by score
		Collections.sort(result.subList(specialtySize, result.size()), new MyComparator());
		
		return result;
	}
}