package model;

public class Vote {
	
	private User voter;

	public Vote(User voter) {
		this.voter = voter;
	}
	
	public User getVoter() {
		return voter;
	}

	public void setVoter(User voter) {
		this.voter = voter;
	}
	
	
}
