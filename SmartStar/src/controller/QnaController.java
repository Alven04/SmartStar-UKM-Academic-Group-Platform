package controller;

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

	public void displayViewQuestion() {
		if (viewQuestion == null)
			viewQuestion = new ViewQuestion(this);
		else
			viewQuestion.setVisible(true);
	}
	
	public void displayAddQuestion() {
		if (addQuestion == null)
			addQuestion = new AddQuestion(this);
		else
			addQuestion.setVisible(true);	
	}

	public void displayAddAnswer() {
		if (addAnswer == null)
			addAnswer = new AddAnswer(this);
		else
			addAnswer.setVisible(true);
	}

}
