package org.gameevents;

import org.gameobject.GameObject;

public class TextNode extends GameObject {

	private String text;
	private String[] answers;
	private TextNode[] children;

	public TextNode(String id, String name, String text, String[] answers, TextNode[] children) {
		super(id, name);
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
	
	public int getChildrenAmount() {
		return children != null?children.length:0;
	}

	public TextNode chosenAnswer(int choice) {
		return children[choice];
	}

}
