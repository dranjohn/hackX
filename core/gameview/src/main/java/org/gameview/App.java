package org.gameview;

import java.util.HashMap;

import javax.swing.JFrame;

import org.game.Game;
import org.game.Player;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		// Creating main frame
		MainWindow frame = new MainWindow(createTextures(), createDemoGame());
		frame.setSize(900, 700);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);

	}

	public static Game createDemoGame() {
		MapSnippet[] arr = new MapSnippet[3];
		// add Map snippets here:
		MapSnippet s1 = new MapSnippet("s1", "s1", false, new float[] { 0, 510 });
		MapSnippet s2 = new MapSnippet("s2", "s1", true, new float[] { 0, 0 });
		MapSnippet s3 = new MapSnippet("s3", "s1", true, new float[] { 473, 0 });
//		snippets.add(s1);
//		snippets.add(s2);
//		snippets.add(s3);

		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;

		// MapSnippet[] arr = (MapSnippet[]) snippets.toArray();
		// ===============

		Player p = new Player(3);
		Map map = new Map(arr, 900, 700);
		Game game = new Game(map, p);
		return game;
	}

	public static GameResources createTextures() {

		// Loading resources
		HashMap<String, String> idImageNameMap = new HashMap<>();

		// put your resource mapping here:
		idImageNameMap.put("s1", "map_part1.png");
		idImageNameMap.put("s2", "map_part2.png");
		idImageNameMap.put("s3", "map_part3.png");
		idImageNameMap.put("background", "map_hintergrund.png");
		// ...

		// ============================
		GameResources resources = new GameResources(idImageNameMap);
		resources.loadImages();
		return resources;
	}

}
