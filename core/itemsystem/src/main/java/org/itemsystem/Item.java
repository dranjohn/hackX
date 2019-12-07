package org.itemsystem;

public abstract class Item {
	
	private static int idNumber = 0;
	private String name;
	private String id;
	private float[] location;
	private Description description;
	
	public Item(String name, float[] location, Description description) {
		this.name = name;
		this.location = location;
		this.description = description;
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
	 * @return the location of the collectable item on the map
	 */
	public float[] getLocation() {
		return location;
	}
	
	public Description getDescription() {
		return description;
	}

	public static String makeId(int count, String name) {
		return name + "_" + count;
	}

}
