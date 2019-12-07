package org.itemsystem;

import java.util.ArrayList;
import java.util.List;

import org.gameobject.GameObject;
import org.listeners.ItemCollectionListener;

public abstract class Item extends GameObject {

	private float[] location;
	private Description description;
	private List<ItemCollectionListener> actions = new ArrayList<>();

	public Item(String id, String name, float[] location, Description description) {
		super(id, name);
		this.location = location;
		this.description = description;
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
