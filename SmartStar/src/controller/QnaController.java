package controller;

import model.Answer;
import model.Course;
import model.Lecturer;
import model.Question;
import model.Student;
import model.User;
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

	public void setCurrentAnswer(int answerIndex) {
		this.currentAnswer = currentQuestion.getAnswers().get(answerIndex);
	}
	
	public String[] getQuestionTitles() {
		if (course == null) {
			return new String[0];
		}
		int size = course.getQuestions().size();
		String[] titles = new String[size];
		for (int i = 0; i < size; i++) {
			titles[i] = course.getQuestions().get(i).getTitle();
		}
		return titles;
	}
	
	public String[] getStarLecturerNames() {
		if (currentAnswer == null) {
			return new String[0];
		}
		int size = currentAnswer.getStars().size();
		String[] names = new String[size];
		for (int i = 0; i < size; i++) {
			names[i] = currentAnswer.getStars().get(i).getLecturer().getName();
		}
		return names;
	}
	
	public boolean addQuestion(String title, String content) {
		int index = course.getQuestions().size();
		return course.addQuestion(new Question(index, title, content, course, controller.getCurrentUser()));
	}
	
	public boolean addAnswer(String content) {
		int index = currentQuestion.getAnswers().size();
		return currentQuestion.addAnswer(new Answer(index, content, currentQuestion, controller.getCurrentUser()));
	}
	
	public boolean addUpvote() {
		return currentAnswer.addUpvote(controller.getCurrentUser());
	}

	public boolean addDownvote() {
		return currentAnswer.addDownvote(controller.getCurrentUser());
	}
	
	public boolean removeUpvote() {
		return currentAnswer.removeUpvote(controller.getCurrentUser());
	}

	public boolean removeDownvote() {
		return currentAnswer.removeDownvote(controller.getCurrentUser());
	}
	
	public boolean castedUpvote() {
		if (currentAnswer == null) {
			return false;
		}
		return currentAnswer.getUpvotes().contains(controller.getCurrentUser());
	}
	
	public boolean castedDownvote() {
		if (currentAnswer == null) {
			return false;
		}
		return currentAnswer.getDownvotes().contains(controller.getCurrentUser());
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
		if (currentAnswer == null) {
			return "";
		}
		return currentAnswer.getStars().size() + " Stars";
	}
	
	public String downvoteCount() {
		if (currentAnswer == null) {
			return "";
		}
		int count = currentAnswer.getDownvotes().size();
		
		if (count == 1) {
			return count + " Downvote";			
		}
		return count + " Downvotes";
	}

	public String upvoteCount() {
		if (currentAnswer == null) {
			return "";
		}
		int count = currentAnswer.getUpvotes().size();
		
		if (count == 1) {
			return count + " Upvote";			
		}
		return count + " Upvotes";
	}
	
	public String index(int index) {
		if (currentAnswer == null) {
			return "";
		}
		int total = currentQuestion.getAnswers().size();
		return "Answer " + (index + 1) + " of " + total;
	}
	
	public String answerContent() {
		if (currentAnswer == null) {
			return "No answer available at this time.";
		}
		return currentAnswer.getContent();
	}
	
	public String answererDetail() {
		if (currentAnswer == null) {
			return "";
		}
		return displayDetail(currentAnswer.getOwner());
	}
	
	public String answererName() {
		if (currentAnswer == null) {
			return "";
		}
		return "Answer by " + displayName(currentAnswer.getOwner());
	}
	
	public String answererDetailPreview() {
		if (currentAnswer == null) {
			return "";
		}
		return displayDetail(controller.getCurrentUser());
	}
	
	public String answererNamePreview() {
		if (currentAnswer == null) {
			return "";
		}
		return "Answer by " + displayName(controller.getCurrentUser());
	}

	public String questionContent() {
		if (currentQuestion == null) {
			return "Select a question from the list on the left.\nYou may post your question by clicking the New Question button.";
		}
		return currentQuestion.getContent();
	}
	
	public String questionTitle() {
		if (currentQuestion == null) {
			return "";
		}
		return "Question: " + currentQuestion.getTitle();
	}
	
	public String askerDetail() {
		if (currentQuestion == null) {
			return "";
		}
		return displayDetail(currentQuestion.getOwner());
	}
	
	public String askerName() {
		if (currentQuestion == null) {
			return "";
		}
		return displayName(currentQuestion.getOwner());
	}

	public String askerDetailPreview() {
		if (currentQuestion == null) {
			return "";
		}
		return displayDetail(controller.getCurrentUser());
	}
	
	public String askerNamePreview() {
		if (currentQuestion == null) {
			return "";
		}
		return displayName(controller.getCurrentUser());
	}

	public void displayViewQuestion(Course course) {
		this.course = course;
		displayViewQuestion();
	}
	
	public void displayViewQuestion() {
		if (viewQuestion == null)
			viewQuestion = new ViewQuestion(this);
		else
			viewQuestion.setVisible(true);
		
		viewQuestion.refreshList();
		viewQuestion.refreshContent();
		viewQuestion.refreshStarList();
		viewQuestion.refreshVoteButtonStatus();
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
