package org.gameview;

import java.awt.Point;
import java.util.HashMap;
 

import javax.swing.JFrame;

import org.game.Game;
import org.game.Player;
import org.gameobject.PointF;
import org.itemsystem.Artifact;
import org.itemsystem.Description;
import org.itemsystem.MapItem;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet; 
 
/**
 * Hello world! 
 *
 */
public class App {
	
	private static Point size = new Point(900, 700);
	
	public static void main(String[] args) {
 
		// Creating main frame
		MainWindow frame = new MainWindow(createTextures(), createDemoGame());
		frame.setSize(size.x, size.y);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

	public static Game createDemoGame() {
		MapSnippet[] arr = new MapSnippet[4];
		// add Map snippets here:

		MapSnippet s1 = new MapSnippet("s1", "s1");
		MapSnippet s2 = new MapSnippet("s2", "s1");
		MapSnippet s3 = new MapSnippet("s3", "s1");
		MapSnippet s4 = new MapSnippet("s4", "s1");
		
		MapItem a1 = new MapItem("map_item", "map_item", new PointF(700, 400), new Description("", "")) {
			
			@Override
			public void unlockMapSnippets() {
				s2.setVisible(true);
			}
		};
		s1.addItem(a1);
		
		
		s1.setVisible(true);
		s3.setVisible(true);
		s4.setVisible(true);

		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = s4;
		

		// MapSnippet[] arr = (MapSnippet[]) snippets.toArray();
		// ===============

		Player p = new Player(3);
		p.setLocation(new PointF(450, 640));
		
		Map map = new Map(arr, new PointF(size.x, size.y));
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
		idImageNameMap.put("s4", "map_part4.png");
		idImageNameMap.put("background", "map_hintergrund.png");
		idImageNameMap.put("map_item", "map_item.png");
		idImageNameMap.put("player_image", "player_image.png");
		// ...

		// ============================
		GameResources resources = new GameResources(idImageNameMap);
		resources.loadImages();
		return resources;
	}

}
