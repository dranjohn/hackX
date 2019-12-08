package org.game;

import java.util.Arrays;
import java.util.LinkedList;

import org.gameobject.PointF;
import org.itemsystem.Artifact;
import org.itemsystem.Item;
import org.itemsystem.MapItem;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet;

public class Game {
	private Player player;
	private Map map;

	public Game(Map map, Player player) {
		this.map = map;
		this.player = player;
	}

	public MapSnippet[] getVisibleMapSnippets() {
		MapSnippet[] allMapSnippets = map.getMapSnippets();
		LinkedList<MapSnippet> snippets = new LinkedList<>();
		for (int i = 0; i < allMapSnippets.length; i++) {
			if (allMapSnippets[i].getVisibility()) {
				snippets.add(allMapSnippets[i]);
			}
		}

		MapSnippet[] arr = new MapSnippet[snippets.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = snippets.get(i);
		}
		return arr;
	}

	/**
	 * 
	 * @return returns all items of type {@link MapItem} and the currently unlocked
	 *         artifacts
	 */
	public Item[] getVisibleItems() {
		LinkedList<Item> items = new LinkedList<>();
		MapSnippet[] allMapSnippets = map.getMapSnippets();
		for (MapSnippet s : allMapSnippets) {
			if (s.getVisibility()) {
				for (Item item : s.getItems()) {
					if (item instanceof Artifact) {
						if (((Artifact)(item)).isUnlocked(player.getArtifactInventory())) {
							items.add(item);
						}
					} else {
						items.add(item);
					}
					
				}
			}
		}
		
		MapItem[] mapItems = player.getMapItemInventory();
		for (MapItem mi : mapItems) {
			items.add(mi);
		}
		
		Item[] arr = new Item[items.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = items.get(i);
		}
		return arr;
	}

	public Item[] getItemsInRangeOfPlayer() {
		PointF locPlayer = player.getLocation();
		LinkedList<Item> itemsInRange = new LinkedList<>();
		MapSnippet[] allMapSnippets = map.getMapSnippets();
		for (MapSnippet s : allMapSnippets) {
			for (Item i : s.getItems()) {
				PointF locItem = i.getLocation();
				if (Math.hypot(locItem.getX() - locPlayer.getY(), locItem.getX()- locPlayer.getY()) < player.getRange()) {
					itemsInRange.add(i);
				}
			}
		}

		return (Item[]) itemsInRange.toArray();
	}

	public Player getPlayer() {
		return player;
	}

}
