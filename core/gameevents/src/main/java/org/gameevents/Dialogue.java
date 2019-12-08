package org.gameevents;

public class Dialogue {

	private TextNode currentNode;
	private boolean isFinished = false;

	public Dialogue(TextNode startNode) {
		currentNode = startNode;
	}

	public String getText() {
		
		// Exception for 1 text only
		if (currentNode.getAnswers().length == 0) {
			isFinished = true;
		}
		
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
		
		TextNode nextNode = currentNode.chosenAnswer(choice);
		
		if (nextNode.getAnswers().length == 0 || nextNode.getChildrenAmount() == 0) {
			isFinished = true;
		}

		currentNode = nextNode;
	}
	
	public boolean isFinished() {
		return isFinished;
	}
}
