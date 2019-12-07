package org.mapsystem;

import org.itemsystem;

public class Room {

	private int id;
	private Item[] items;
	private float[] location;
	private boolean isDiscovered;
	private boolean isVisible;
	
	/** 
	 * single room/hallway of museum
	 * @param id room id
	 * @param items list of items room contains
	 * @param location room location as float array
	 */
	public Room (int id, Item[] items, float[] location) {
		this.id = id;
		this.items =  items;
		this.location = location;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public boolean isDiscovered() {
		return isDiscovered;
	}

	public void setDiscovered(boolean isDiscovered) {
		this.isDiscovered = isDiscovered;
	}

	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

	public int getId() {
		return id;
	}

	public float[] getLocation() {
		return location;
	}

}
