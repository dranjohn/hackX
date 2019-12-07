package org.mapsystem;

public class Map {

	private MapSnippet[] mapSnippets;
	float width;
	float height;

	/**
	 * complete map
	 * 
	 * @param mapSnippets list of mapsnippets map contains
	 * @param width       the width of the map in meters
	 * @param height      the height of the map in meters
	 */
	public Map(MapSnippet[] mapSnippets, float width, float height) {
		this.mapSnippets = mapSnippets;
		this.height = height;
		this.width = width;
	}

	/**
	 * @return Returns Array of all mapsnippets
	 */
	public MapSnippet[] getMapSnippets() {
		return mapSnippets;
	}
}
