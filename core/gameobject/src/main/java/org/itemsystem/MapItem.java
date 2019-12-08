package org.itemsystem;

import org.gameobject.PointF;

public abstract class MapItem extends Item {

	/**
	 * Overview epoche/thema, Unlocks new mapsnippet
	 * 
	 * @param name
	 * @param location
	 * @param description
	 */
	public MapItem(String id, String name, PointF location, Description description) {
		super(id, name, location, description);
	}

	public abstract void unlockMapSnippets();
}
