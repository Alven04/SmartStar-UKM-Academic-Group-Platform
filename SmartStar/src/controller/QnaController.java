package controller;

import java.util.ArrayList;

import model.Answer;
import model.Course;
import model.Downvote;
import model.Lecturer;
import model.Question;
import model.Student;
import model.Upvote;
import model.User;
import model.Vote;
import view.AddAnswer;
import view.AddQuestion;
import view.ViewQuestion;

public class QnaController {

	private ViewQuestion viewQuestion;
	private AddQuestion addQuestion;
	private AddAnswer addAnswer;
	
	private Controller controller;
	
	private Course course;
	private Question currentQuestion;
	private Answer currentAnswer;
	
	public QnaController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public Answer getCurrentAnswer() {
		return currentAnswer;
	}

	public void setCurrentAnswer(Answer currentAnswer) {
		this.currentAnswer = currentAnswer;
	}

	public String[] getQuestionTitles() {
		int size = course.getQuestions().size();
		String[] titles = new String[size];
		for (int i = 0; i < size; i++) {
			titles[i] = course.getQuestions().get(i).getTitle();
		}
		return titles;
	}
	
	public String[] getStarLecturerNames() {
		int size = currentAnswer.getStars().size();
		String[] names = new String[size];
		for (int i = 0; i < size; i++) {
			names[i] = currentAnswer.getStars().get(i).getLecturer().getName();
		}
		return names;
	}
	
	public String displayName(User owner) {
		String displayName = "";
		if (owner instanceof Student) {
			displayName += "Student: ";
		} else if (owner instanceof Lecturer) {
			displayName += "Lecturer: ";
		}
		displayName += owner.getName();
		return displayName;
	}
	
	public String displayDetail(User owner) {
		String displayDetail = "";
		if (owner instanceof Student) {
			Student student = (Student) owner;
			displayDetail += "Year " + student.getYear() + ", " + student.getMajor() + ", " + student.getInstitution() + ", " + student.getRank();
		} else if (owner instanceof Lecturer) {
			Lecturer lecturer = (Lecturer) owner;
			displayDetail += lecturer.getQualification() + ", " + lecturer.getInstitution();
		}
		return displayDetail;
	}
	
	public String starCount() {
		return currentAnswer.getStars().size() + " Stars";
	}
	
	public String downvoteCount() {
		ArrayList<Vote> votes = currentAnswer.getVotes();
		int count = 0;
		for (Vote vote : votes) {
			if (vote instanceof Downvote) {
				count++;
			}
		}
		
		if (count == 1) {
			return count + " Downvote";			
		}
		return count + " Downvotes";
	}

	public String upvoteCount() {
		ArrayList<Vote> votes = currentAnswer.getVotes();
		int count = 0;
		for (Vote vote : votes) {
			if (vote instanceof Upvote) {
				count++;
			}
		}
		
		if (count == 1) {
			return count + " Upvote";			
		}
		return count + " Upvotes";
	}
	
	public String index() {
		int currentIndex = 0;
		int total = currentQuestion.getAnswers().size();
		return "Answer " + currentIndex + " of " + total;
	}
	
	public String answerContent() {
		return currentAnswer.getContent();
	}
	
	public String answererDetail() {
		return displayDetail(currentAnswer.getOwner());
	}
	
	public String answererName() {
		return "Answer by " + displayName(currentAnswer.getOwner());
	}
	public String questionContent() {
		return currentQuestion.getContent();
	}
	
	public String questionTitle() {
		return "Question: " + currentQuestion.getTitle();
	}
	
	public String askerDetail() {
		return displayDetail(currentQuestion.getOwner());
	}
	
	public String askerName() {
		return displayName(currentQuestion.getOwner());
	}

	public void displayViewQuestion(Course course) {
		this.course = course;
		if (viewQuestion == null)
			viewQuestion = new ViewQuestion(this);
		else
			viewQuestion.setVisible(true);
	}
	
	public void displayAddQuestion(Course course) {
		this.course = course;
		if (addQuestion == null)
			addQuestion = new AddQuestion(this);
		else
			addQuestion.setVisible(true);	
	}

	public void displayAddAnswer(Course course) {
		this.course = course;
		if (addAnswer == null)
			addAnswer = new AddAnswer(this);
		else
			addAnswer.setVisible(true);
	}


}
