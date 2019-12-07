package org.mapsystem;

import java.util.ArrayList;
import org.itemsystem.Item;

public class MapSnippet {

	private String id;
	private static int idNumber = 0;
	private boolean isVisible;
	private String name;
	private ArrayList<Item> items;

	/**
	 * part of map, contains items
	 * @param name			name of map snippet
	 * @param isVisible		defines if map is unlocked
	 */
	public MapSnippet(String name, boolean isVisible ) {
		this.id = makeId(idNumber, name);
		idNumber++;
		this.name = name;
		this.isVisible = isVisible;
	}	
	
	public String getName() {
		return name;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		items.add(item);
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
		return  name + "_" + count;
	}
	

}
