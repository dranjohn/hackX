package org.mapsystem;

import java.util.ArrayList;

import org.itemsystem.Item;

public class MapSnippet {

	private String id;
	private static int idNumber = 0;
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
	public MapSnippet(String name, boolean isVisible, float[] location) {
		this.location = location;
		this.id = makeId(idNumber, name);
		idNumber++;
		this.name = name;
		this.isVisible = isVisible;
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
	 * @return Returns id of mapsnippet, count_name
	 */
	public String getId() {
		return id;
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

	private static String makeId(int count, String name) {
		return count + "_" + name;
	}

}
