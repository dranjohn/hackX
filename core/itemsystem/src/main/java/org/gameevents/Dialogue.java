package org.gameevents;

public class Dialogue {

	private TextNode currentNode;
	
	public Dialogue(TextNode startNode) {
		currentNode = startNode;
	}
	
	public String getText() {
		return currentNode.getText();
	}
	
	public String[] getAnswers() {
		return currentNode.getAnswers();
	}	
	
	public void chosenAnswer(int choice) {
		currentNode = currentNode.chosenAnswer(choice);
	}
}
