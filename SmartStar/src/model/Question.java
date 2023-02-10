package model;

import java.util.ArrayList;

public class Question {

	private int index;
	private String title;
	private String content;
	private Course course;
	private User owner;
	private ArrayList<Answer> answers = new ArrayList<>();
	private ArrayList<Vote> votes = new ArrayList<>();
	
	public Question(int index, String title, String content, Course course, User owner) {
		this.index = index;
		this.title = title;
		this.content = content;
		this.course = course;
		this.owner = owner;
	}
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Course getCourse() {
		return course;
	}
	
	public void setCourse(Course course) {
		this.course = course;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public ArrayList<Answer> getAnswers() {
		return answers;
	}
	
	public boolean addAnswer(Answer answer) {
		if (answers.contains(answer)) {
			throw new RuntimeException("Duplicated answer");
//			return false;
		}
		return answers.add(answer);	

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
	
}
