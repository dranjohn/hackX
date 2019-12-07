package org.gameevents;

public class Quizz {

	private Question[] questions;
	
	public Quizz(Question[] questions) {
		this.questions = questions;
	}
	
	public Question[] getQuestions() {
		return questions;
	}
}
