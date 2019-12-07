package org.mapsystem;

public class MapSnippet {

	private String id;
	private static int idNumber = 0;
	private boolean isVisible;
	private String name;
	

	public String getName() {
		return name;
	}

	public MapSnippet(String name, boolean isVisible) {
		this.id = makeId(idNumber, name);
		idNumber++;
		this.name = name;
		this.isVisible = isVisible;
	}

	public String getId() {
		return id;
	}

	public boolean getVisibility() {
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	
	public static String makeId(int count, String name) {
		return  name + ":mapsnippet_" + count;
	}
	

}
