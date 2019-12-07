package org.mapsystem;

public class Map {

	private MapSnippet[] mapSnippets;
	
	/**
	 * complete map
	 * @param mapSnippets list of mapsnippets map contains
	 */
	public Map(MapSnippet[] mapSnippets) {
		this.mapSnippets = mapSnippets;
	}

	/**
	 * @return Returns Array of all mapsnippets
	 */
	public MapSnippet[] getMapSnippets() {
		return mapSnippets;
	}
}
