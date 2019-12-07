package org.itemsystem;

public abstract class MapItem extends Item {
	
	public MapItem(String name) {
		super(name);
	}

	public abstract void unlockMapSnippets();
}
