package org.itemsystem;

public abstract class MapItem extends Item {
	
	/**
	 * Overview epoche/thema, Unlocks new mapsnippet
	 * @param name
	 * @param location
	 * @param description
	 */
	public MapItem(String name, float[] location, Description description) {
		super(name, location, description);
	}

	public abstract void unlockMapSnippets();
}
