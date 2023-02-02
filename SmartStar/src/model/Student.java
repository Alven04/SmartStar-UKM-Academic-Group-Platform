package model;

import java.util.ArrayList;

public class Student extends User {

	private int year;
	private String major;
	private ArrayList<Star> stars;
	
	private static final String[] RANKS = {
			"No rank", "BRONZE Rank", "SILVER Rank", "GOLD Rank", "PLATINUM Rank"
	};
	private static final int[] RANK_REQUIREMENTS = {
			0, 5, 10, 15, 20
	};
	
	public Student (String username, String password) {
		super(username, password);
		this.year = 0;
		this.major = "";
	}
	
	public Student (String username, String password, String name, String institution, int year, String major) {
		super(username, password, name, institution);
		this.year = year;
		this.major = major;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public boolean addStar(Star star) {
		if (stars.contains(star)) {
			throw new RuntimeException("Duplicated star");
//			return false;
		}
		return stars.add(star);	
	}

	public String getRank() {
		int starCount = stars.size();
		for (int i = RANKS.length - 1; i >= 0; i--) {
			if (starCount > RANK_REQUIREMENTS[i]) {
				return RANKS[i];
			}
		}
		return "Unranked";
	}
}
