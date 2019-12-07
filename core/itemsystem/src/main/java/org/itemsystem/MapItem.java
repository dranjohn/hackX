package org.itemsystem;

public abstract class MapItem extends Item {
	
	public MapItem(String name, float[] location, Description description) {
		super(name, location, description);
	}

	public abstract void unlockMapSnippets();
}
