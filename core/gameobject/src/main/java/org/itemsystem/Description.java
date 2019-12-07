package org.itemsystem;

public class Description {

	//age as string if aprox. is needed
	private String age;
	private String text;
	//possiblity to add pictures
	
	public Description(String age, String text) {
		this.age = age;
		this.text = text;
	}

	public String getAge() {
		return age;
	}

	public String getText() {
		return text;
	}
}
