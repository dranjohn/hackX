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
	
	public Map getMap() {
		return map;
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
			for (Item item : s.getItems()) {
				if (item instanceof Artifact) {
					
					if (s.getVisibility() && ((Artifact)(item)).isUnlocked(player.getArtifactInventory())) {
						items.add(item);
					}
				} else {
					items.add(item);
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
				float distance = (float) Math.hypot(locItem.getX() - locPlayer.getX(), locItem.getY()- locPlayer.getY());
				if ( distance < player.getRange()) {
					itemsInRange.add(i);
				}
			}
		}

		Item[] arr = new Item[itemsInRange.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = itemsInRange.get(i);
		}
		return arr;
	}

	public Player getPlayer() {
		return player;
	}

}
