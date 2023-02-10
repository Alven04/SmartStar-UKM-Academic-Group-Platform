package model;

public class Star {

	private Lecturer lecturer;
	private Answer answer;

	public Star(Lecturer lecturer, Answer answer) {
		this.lecturer = lecturer;
		this.answer = answer;
	}
	
	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}
	
	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public static boolean eligible(User answerOwner, User currentUser) {
		return ((currentUser instanceof Lecturer) && (answerOwner instanceof Student));
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Star)) {
			return false;
		}
		return (lecturer.equals(((Star) obj).lecturer) && answer.equals(((Star) obj).answer));
	}
	
}
