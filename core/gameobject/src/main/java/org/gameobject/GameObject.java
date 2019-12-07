package org.gameobject;

public abstract class GameObject {

	private String id;
	private String name;
	
	public GameObject(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
