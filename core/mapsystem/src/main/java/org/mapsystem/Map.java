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

	public MapSnippet[] getMapSnippets() {
		return mapSnippets;
	}

	public void setMapSnippets(MapSnippet[] mapSnippets) {
		this.mapSnippets = mapSnippets;
	}
}
