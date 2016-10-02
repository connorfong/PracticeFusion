package PracticeFusion;
import java.util.*;

// This Comparator is used to sort the sublists of doctors based on their review score
public class MyComparator implements Comparator<Doctor> {
	@Override
	public int compare(Doctor o1, Doctor o2) {
		if (o1.getScore() > o2.getScore()) {
			return -1;
		} else if (o1.getScore() < o2.getScore()) {
			return 1;
		}
		return 0;
	}
}