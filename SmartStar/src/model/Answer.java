package model;

import java.util.ArrayList;

public class Answer {

	private String content;
	private Question question;
	private User owner;
	private ArrayList<Vote> votes = new ArrayList<>();
	private ArrayList<Star> stars = new ArrayList<>();
	
	public Answer(String content, Question question, User owner) {
		this.content = content;
		this.question = question;
		this.owner = owner;
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
	
	public ArrayList<Vote> getVotes() {
		return votes;
	}
	
	public boolean addVote(Vote vote) {
		if (votes.contains(vote)) {
			throw new RuntimeException("Duplicated vote");
//			return false;
		}
		return votes.add(vote);	

	}
	
	public ArrayList<Star> getStars() {
		return stars;
	}
	
	public boolean addStar(Star star) {
		if (stars.contains(star)) {
			throw new RuntimeException("Duplicated vote");
//			return false;
		}
		return stars.add(star);	

	}

}
