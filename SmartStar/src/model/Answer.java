package model;

import java.util.ArrayList;

public class Answer {

	private int index;
	private String content;
	private Question question;
	private User owner;
	private ArrayList<User> upvotes = new ArrayList<>();
	private ArrayList<User> downvotes = new ArrayList<>();
	private ArrayList<Star> stars = new ArrayList<>();
	
	public Answer(int index, String content, Question question, User owner) {
		this.index = index;
		this.content = content;
		this.question = question;
		this.owner = owner;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Question getQuestion() {
		return question;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public ArrayList<User> getUpvotes() {
		return upvotes;
	}

	public ArrayList<User> getDownvotes() {
		return downvotes;
	}

	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public boolean addUpvote(User user) {
		if (upvotes.contains(user)) {
			throw new RuntimeException("Duplicated upvote");
//			return false;
		}
		return upvotes.add(user);	

	}
	
	public boolean removeUpvote(User user) {

		return upvotes.remove(user);

	}
	
	public boolean addDownvote(User user) {
		if (downvotes.contains(user)) {
			throw new RuntimeException("Duplicated downvote");
//			return false;
		}
		return downvotes.add(user);	

	}
	
	public boolean removeDownvote(User user) {

		return downvotes.remove(user);

	}
	
	public boolean addStar(Star star) {
		if (stars.contains(star)) {
			throw new RuntimeException("Duplicated star");
//			return false;
		}
		return stars.add(star);	

	}
	
	public boolean removeStar(Star star) {
		
		return stars.remove(star);
		
	}
	
	public Star getStarByLecturer(Lecturer lecturer) {
		for (Star star : stars) {
			if (star.getLecturer().equals(lecturer)) {
				return star;
			}
		}
		return null;
	}

}
