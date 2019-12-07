package org.itemsystem;

public abstract class Item {
	private static int idNumber = 0;
	private String name;
	private String id;
	private float xLocation = 0;
	private float yLocation = 0;
	
	public Item(String name) {
		this.name = name;
		this.id = makeId(idNumber, name);
		idNumber++;
	}


	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	
	
	/**
	 * 
	 * @return the location of the collectable item on the map
	 */
	public float[] getLocation() {
		return new float[] {xLocation, yLocation};
	}
	
	public static String makeId(int count, String name) {
		return  name + ":artifact_" + count;
	}
	
}
