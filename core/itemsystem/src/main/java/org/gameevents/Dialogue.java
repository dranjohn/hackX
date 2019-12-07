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

	public String getIdOfCurrentNode() {
		return currentNode.getId();
	}

	public String getNameOfCurrentNode() {
		return currentNode.getName();
	}

	public void chosenAnswer(int choice) {
		currentNode = currentNode.chosenAnswer(choice);
	}
}
