package org.game;

import java.util.Arrays;
import java.util.LinkedList;

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
				items.addAll(s.getItems());
			}
		}
		items.addAll(Arrays.asList(player.getMapItemInventory()));
		return (Item[]) items.toArray();
	}

	public Item[] getItemsInRangeOfPlayer() {
		float[] locPlayer = player.getLocation();
		LinkedList<Item> itemsInRange = new LinkedList<>();
		MapSnippet[] allMapSnippets = map.getMapSnippets();
		for (MapSnippet s : allMapSnippets) {
			for (Item i : s.getItems()) {
				float[] locItem = i.getLocation();
				if (Math.hypot(locItem[0] - locPlayer[0], locItem[1] - locPlayer[1]) < player.getRange()) {
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
