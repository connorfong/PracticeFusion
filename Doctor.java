package PracticeFusion;

public class Doctor {
	// This is code for a representation of the Doctor class
	// More properties can be added as necessary
	private final String name;
	private final String specialty;
	private final String area;
	private final float score;
	
	public Doctor(String name, String specialty, String area, float score) {
		this.name = name;
		this.specialty = specialty;
		this.area = area;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	
	public String getArea() {
		return area;
	}
	
	public float getScore() {
		return score;
	}
}