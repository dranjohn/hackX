package org.mapsystem;

import java.util.ArrayList;

import org.gameobject.GameObject;
import org.itemsystem.Item;

public class MapSnippet extends GameObject {
	private boolean isVisible;
	private String name;
	private ArrayList<Item> items;
	private float[] location;

	/**
	 * Part of Map, Contains Item list, ID System with id_name
	 * 
	 * @param name      Name of mapsnippet
	 * @param isVisible Defines if mapsnippet is unlocked
	 */
	public MapSnippet(String id, String name, boolean isVisible, float[] location) {
		super(id, name);
		this.location = location;
		this.name = name;
		this.isVisible = isVisible;
	}

	public float[] getLocation() {
		return new float[] { location[0], location[1] };
	}

	/**
	 * @return Returns Mapsnippet name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param item Exhibit in Museum
	 * @return Returns ArrayList of Items in Mapsnippet
	 */
	public ArrayList<Item> getItems() {
		return items;
	}

	/**
	 * Adds single item to Item ArrayList
	 * 
	 * @param item Exhibit in Museum
	 */
	public void addItem(Item item) {
		items.add(item);
	}

	public void removeItem(Item item) {
		items.remove(item);
	}

	/**
	 * @return Returns if mapsnippet is visible or grayed out
	 */
	public boolean getVisibility() {
		return isVisible;
	}

	/**
	 * Sets the visibility of mapsnippet
	 * 
	 * @param isVisible boolean, defines whether mapsnippet is visible or grayed out
	 */
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
