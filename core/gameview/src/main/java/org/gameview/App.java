package org.gameview;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import org.game.Game;
import org.itemsystem.Description;
import org.itemsystem.MapItem;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Load game
		ArrayList<MapSnippet> snippets = new ArrayList<>();

		MapSnippet s1 = new MapSnippet("Altes Ägypten", false);
		new MapItem("Altes Ägypten - Infotafel", new float[] { 2, 2 }, new Description("5000", "alt")) {
			@Override
			public void unlockMapSnippets() {
				s1.setVisible(true);
			}
		};

		snippets.add(s1);
		Map map = new Map((MapSnippet[]) snippets.toArray());
		Game game = new Game(map);

		// Loading resources
		HashMap<String, String> idImageNameMap = new HashMap<>();
		// put your resource mapping here:

		// ...

		// ============================
		GameResources resources = new GameResources(idImageNameMap);
		resources.loadImages();

		// Creating main frame
		MainWindow frame = new MainWindow(resources, game);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);

	}

}
