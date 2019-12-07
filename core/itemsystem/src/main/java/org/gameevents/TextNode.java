package org.gameevents;

public class TextNode {
	
	private String text;
	private String[] answers;
	private TextNode[] children;
	
	public TextNode(String text, String[] answers, TextNode[] children) {
		this.text = text;
		this.answers = answers;
		this.children = children;
	}

	public String getText() {
		return text;
	}
	
	public String[] getAnswers() {
		return answers;
	}
	
	public TextNode chosenAnswer(int choice) {
		return children[choice];
	}
	
}
