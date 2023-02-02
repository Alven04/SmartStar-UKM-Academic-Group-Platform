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
	
	public QnaController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return controller;
	}
	
	public void displayViewQuestion(Course course) {
		if (viewQuestion == null)
			viewQuestion = new ViewQuestion(this, course);
		else
			viewQuestion.setVisible(true);
	}
	
	public void displayAddQuestion(Course course) {
		if (addQuestion == null)
			addQuestion = new AddQuestion(this, course);
		else
			addQuestion.setVisible(true);	
	}

	public void displayAddAnswer(Course course) {
		if (addAnswer == null)
			addAnswer = new AddAnswer(this, course);
		else
			addAnswer.setVisible(true);
	}

}
