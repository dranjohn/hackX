package org.itemsystem;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public abstract class Artifact extends Item {

	private Set<Artifact> requiredArtifacts = new HashSet<>();

	public Artifact(String name, float[] location, Description description) {
		super(name, location, description);
	}

	public void setRequiredArtifacts(Artifact... required) {
		this.requiredArtifacts = new HashSet<Artifact>(Arrays.asList(required));
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
