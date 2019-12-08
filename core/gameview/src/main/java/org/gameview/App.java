package org.gameview;

import java.awt.Point;
import java.util.HashMap;
 

import javax.swing.JFrame;

import org.game.Game;
import org.game.Player;
import org.gameevents.Dialogue;
import org.gameevents.TextNode;
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
		
		TextNode rootChild1 = new TextNode("tn2", "", "Hallo Universum", null, null);
		TextNode[] c = new TextNode[] {null};
		TextNode rootChild2 = new TextNode("tn3", "", "Test", new String[] {"end dialog"}, c);	

		TextNode[] children = new TextNode[] {rootChild1, rootChild2};
		TextNode root = new TextNode("tn1", "", "Hallo Welt", new String[] {"Hallo zurück", "Ich bin müde"}, children);
		TextNode child3 = new TextNode("tn3", "", "looooper", new String[] {"loop back to start"}, new TextNode[] {root});
		c[0] = child3;
		Dialogue dialogue = new Dialogue(root);
		
		DialogWindow d = new DialogWindow();
		d.setSize(300, 700);
		d.setDialogue(dialogue);
		d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d.setVisible(true);
		
		
		// Creating main frame
		MainWindow frame = new MainWindow(createTextures(), createDemoGame());
		frame.setSize(size.x, size.y);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setVisible(true);
		

	}

	public static Game createDemoGame() {
	
		//Ab hier Map Snippet init
		MapSnippet[] arr = new MapSnippet[4];

		MapSnippet s1 = new MapSnippet("s1", "s1");
		MapSnippet s2 = new MapSnippet("s2", "s1");
		MapSnippet s3 = new MapSnippet("s3", "s1");
		MapSnippet s4 = new MapSnippet("s4", "s1");
		
		arr[0] = s1;
		arr[1] = s2;
		arr[2] = s3;
		arr[3] = s4;
		
		
		//Ab hier Map item init
		MapItem mi1 = new MapItem("map_item1", "map_item", new PointF(800, 100), new Description("", "")) {
			public void unlockMapSnippets() {
				s1.setVisible(true);
			}
		};
		MapItem mi2 = new MapItem("map_item2", "map_item", new PointF(600, 500), new Description("", "")) {
			public void unlockMapSnippets() {
				s2.setVisible(true);
			}
		};
		MapItem mi3 = new MapItem("map_item3", "map_item", new PointF(300, 600), new Description("", "")) {
			public void unlockMapSnippets() {
				s3.setVisible(true);
			}
		};
		MapItem mi4 = new MapItem("map_item4", "map_item", new PointF(90, 180), new Description("", "")) {
			public void unlockMapSnippets() {
				s4.setVisible(true);
			}
		};
		
		s1.addItem(mi1);
		s2.addItem(mi2);
		s3.addItem(mi3);
		s4.addItem(mi4);
		
		//Ab hier Artifact init
		Artifact a1 = new Artifact("a1", "artifact", new PointF(420,  630), new Description("", ""));
		Artifact a2 = new Artifact("a2", "artifact", new PointF(800,  530), new Description("", ""));
		Artifact a3 = new Artifact("a3", "artifact", new PointF(155,  455), new Description("", ""));
		Artifact a4 = new Artifact("a4", "artifact", new PointF(180,  640), new Description("", ""));
		Artifact a5 = new Artifact("a5", "artifact", new PointF(835,  635), new Description("", ""));
		Artifact a6 = new Artifact("a6", "artifact", new PointF(50,  50), new Description("", ""));
				
		s2.addItem(a1);
		s2.addItem(a2);
		s2.addItem(a5);;
		
		s3.addItem(a3);
		s3.addItem(a4);

		s4.addItem(a6);
		
		a1.setRequiredArtifacts(a2);
		a5.setRequiredArtifacts(a2);
		
		a4.setRequiredArtifacts(a3);
		
		//Ab hier player init
		Player p = new Player(20);
		p.setLocation(new PointF(450, 640));
		
		//Ab hier Map init
		Map map = new Map(arr, new PointF(size.x, size.y));
		Game game = new Game(map, p);
		
		//Return
		return game;
	} 

	public static GameResources createTextures() {

		// Loading resources
		HashMap<String, String> idImageNameMap = new HashMap<>();

		// put your resource mapping here:
		idImageNameMap.put("background", "map_hintergrund.png");
		
		idImageNameMap.put("s1", "map_part1.png");
		idImageNameMap.put("s2", "map_part2.png");
		idImageNameMap.put("s3", "map_part3.png");
		idImageNameMap.put("s4", "map_part4.png");
		
		idImageNameMap.put("a1", "artifact_1.png");
		idImageNameMap.put("a2", "artifact_2.png");
		idImageNameMap.put("a3", "artifact_3.png");
		idImageNameMap.put("a4", "artifact_4.png");
		idImageNameMap.put("a5", "artifact_5.png");
		idImageNameMap.put("a6", "artifact_6.png");
		
		idImageNameMap.put("map_item1", "map_item_1.png");
		idImageNameMap.put("map_item2", "map_item_1.png");
		idImageNameMap.put("map_item3", "map_item_1.png");
		idImageNameMap.put("map_item4", "map_item_1.png");
		
		idImageNameMap.put("player_image", "player_image.png");
		// ...

		// ============================
		GameResources resources = new GameResources(idImageNameMap);
		resources.loadImages();
		return resources;
	}

}
