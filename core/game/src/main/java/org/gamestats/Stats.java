package org.gamestats;

public class Stats {
	
	private int artifactCount = 0;
	private int mapItemCount = 0;
	private int questionsAnswered = 0;
	
	/**
	 * Keeps track of the Players stats
	 * @param artifactCount Amount of Artifacts collected
	 * @param mapItemCount Amount of MapItem collected
	 * @param questionsAnswered Amount of Questions Answered 
	 */
	public Stats() {
		
	}
	
	public int getQuestionsAnswered() {
		return questionsAnswered;
	}

	public void addQuestionsAnswered(int questionsAnswered) {
		this.questionsAnswered = this.questionsAnswered + questionsAnswered;
	}

	public int getArtifactCount() {
		return artifactCount;
	}

	public void addArtifactCount(int artifactCount) {
		this.artifactCount = this.artifactCount + artifactCount;
	}

	public int getmapItemCount() {
		return mapItemCount;
	}

	public void addmapItemCount(int mapItemCount) {
		this.mapItemCount = this.mapItemCount + mapItemCount;
	}

}
