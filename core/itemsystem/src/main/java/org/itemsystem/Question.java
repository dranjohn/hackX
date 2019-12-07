package org.itemsystem;

public class Question {
	
	private String question;
	private String[] answers;
	private boolean[] correct;

	public Question(String question, String[] answers, boolean[] correct) {
		this.question = question;
		this.answers = answers;
		this.correct = correct;
	}

	public String getQuestion() {
		return question;
	}

	public String[] getAnswers() {
		return answers;
	}

	public boolean[] getCorrect() {
		return correct;
	}
	
}
