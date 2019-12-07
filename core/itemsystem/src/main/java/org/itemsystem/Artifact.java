package org.itemsystem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public abstract class Artifact extends Item {

	private HashSet<Artifact> requiredArtifacts;

	public Artifact(String name, float[] location, Description description, Artifact... required) {
		super(name, location, description);
		this.requiredArtifacts = new HashSet<Artifact>(Arrays.asList(required));
	}

	public Artifact(String name, float[] location, Description description) {
		this(name, location, description, new Artifact[] {});
	}

	/**
	 * Defines if this artifact is unlocked or not unlocked. An artifact is unlocked
	 * if all required items are contained in the inventory which is defined by the
	 * argument of the method {@link #isUnlocked(Artifact[])}.
	 * 
	 * @return true if unlocked
	 */
	public boolean isUnlocked(Artifact[] inventory) {
		HashSet<Artifact> inv = new HashSet<Artifact>(Arrays.asList(inventory));
		return inv.containsAll(requiredArtifacts);
	}

	/**
	 * 
	 * @return all required artifacts to unlock this artifact
	 */
	public Collection<Artifact> getRequiredArtifacts() {
		return new HashSet<>(requiredArtifacts);
	}

}
