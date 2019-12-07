package org.mapsystem;

public class MapSnippet {

	private int id;
	private Room[] rooms;
	private boolean isVisible;
	
	/**
	 * collection of rooms
	 * @param id mapsnippet id
	 * @param rooms list of rooms mapsnippet contains
	 * @param isVisible is mapsnippet visible
	 */
	public MapSnippet(int id, Room[] rooms, boolean isVisible) {
		this.id = id;
		this.rooms = rooms;
		this.isVisible = isVisible;
	}
	
	public int getId() {
		return id;
	}
	
	public Room[] getRooms() {
		return rooms;
	}

	public boolean getVisibility() {
		return isVisible;
	}
	
	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}

}
