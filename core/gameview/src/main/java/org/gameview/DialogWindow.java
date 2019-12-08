package org.gameview;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.gameevents.Dialogue;
import org.gameevents.TextNode;


public class DialogWindow extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Dialogue dialogue;
	private JLabel inputLabel = new JLabel();
	private JButton[] answers = new JButton[] {};
	
	public DialogWindow() {
		this.add(inputLabel);
		inputLabel.setVisible(true);
	}
	
	public void setDialogue(Dialogue dialogue) {
		this.dialogue = dialogue;
		this.setLayout(new GridLayout(4, 1));
		setCurrentContent();
		
	}
	
	private void setCurrentContent() {
		for (JButton b : answers) {
			this.remove(b);
		}
		inputLabel.setText(dialogue.getText());
		if (!dialogue.isFinished()) {
			System.out.println(dialogue + " " + dialogue.getText());
			String[] answersText = dialogue.getAnswers();
			this.answers = new JButton[answersText.length];
			for (int i = 0; i < answers.length; i++) {
				answers[i] = new JButton(answersText[i]);
				this.add(answers[i]);
				
				ActionListenerWithIndex listener = new ActionListenerWithIndex(i) {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogue.chosenAnswer(this.index);
						setCurrentContent();
						remove((JButton) e.getSource());
					}
				};
				answers[i].addActionListener(listener);
			}
		} 
		
	}
	
	private abstract class ActionListenerWithIndex implements ActionListener {
		protected int index;
		public ActionListenerWithIndex(int index) {
			this.index = index;
		} 
		
		
	}
	
	

}
