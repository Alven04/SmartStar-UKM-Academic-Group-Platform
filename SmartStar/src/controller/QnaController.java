package controller;

import model.Course;
import view.AddAnswer;
import view.AddQuestion;
import view.ViewQuestion;

public class QnaController {

	private ViewQuestion viewQuestion;
	private AddQuestion addQuestion;
	private AddAnswer addAnswer;
	
	private Controller controller;
	
	private Course course;
	
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
