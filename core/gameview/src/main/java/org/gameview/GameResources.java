package org.gameview;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class GameResources {
	private HashMap<String, BufferedImage> imageResources = new HashMap<>();
	private HashMap<String, String> idtoImageNameMap;
	private File resourceFolder = new File("src\\main\\resources");
	private String imagefolder = "images";

	/**
	 * 
	 * @param idtoImageNameMap the map maps an id (for example an item id onto the
	 *                         name of an image")
	 */
	public GameResources(HashMap<String, String> idtoImageNameMap) {
		this.idtoImageNameMap = idtoImageNameMap;
		loadImages();
	}

	public BufferedImage getImageById(String id) {
		System.out.println(imageResources);
		System.out.println(idtoImageNameMap);
		System.out.println("==");
		return imageResources.get(idtoImageNameMap.get(id));
	}

	public void loadImages() {
		String imagePath = resourceFolder.getAbsolutePath() + "\\" + imagefolder;
		File imageFolder = new File(imagePath);
		if (!imageFolder.exists()) {
			System.err.println("The folder at the path " + imagePath + " does not exist");
		}

		File[] files = imageFolder.listFiles();
		for (File f : files) {
			try {
				BufferedImage i = ImageIO.read(f);
				imageResources.put(f.getName(), i);
			} catch (IOException e) {
				System.err.println("Can not load file " + f.getAbsolutePath() + " as an image");
			}
		}
	}

}
