package org.itemsystem;

import java.util.ArrayList;
import java.util.List;

public abstract class Item {

	private static int idNumber = 0;
	private String name;
	private String id;
	private float[] location;
	private Description description;
	private List<ItemCollectionListener> actions = new ArrayList<>();

	public Item(String name, float[] location, Description description) {
		this.name = name;
		this.location = location;
		this.description = description;
		this.id = makeId(idNumber, name);
		idNumber++;
	}

	/**
	 * Adds an {@link ItemCollectionListener} to this item. They are triggered when
	 * the {@link Player} collects this item.
	 * 
	 * @param listener
	 */
	public void addItemCollectionListener(ItemCollectionListener listener) {
		this.actions.add(listener);
	}

	/**
	 * Contacts all {@link ItemCollectionListener}s of this item entity.
	 */
	public void triggerAllCollectionListeners() {
		for (ItemCollectionListener listener : actions) {
			listener.itemCollected(this);
		}
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
