package org.mapsystem;

import org.gameobject.PointF;

public class Map {

	private MapSnippet[] mapSnippets;
	private PointF size;

	/**
	 * complete map
	 * 
	 * @param mapSnippets list of mapsnippets map contains
	 * @param width       the width of the map in meters
	 * @param height      the height of the map in meters
	 */
	public Map(MapSnippet[] mapSnippets, PointF size) {
		this.mapSnippets = mapSnippets;
		this.size = size;
	}

	/**
	 * @return Returns Array of all mapsnippets
	 */
	public MapSnippet[] getMapSnippets() {
		return mapSnippets;
	}
	
	public PointF getMapSize() {
		return size;
	}
}
