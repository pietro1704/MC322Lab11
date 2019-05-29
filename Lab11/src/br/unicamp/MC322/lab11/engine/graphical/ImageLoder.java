package br.unicamp.MC322.lab11.engine.graphical;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class ImageLoder {

	private static final ImageLoder INSTANCE = new ImageLoder();

	private Image playerRight;
	private Image playerLeft;
	private Image playerDown;
	private Image playerUp;
	private Image wall;
	private Image floor;
	private Image checkpointConquered;
	private Image checkpointNotConquered;
	
	

	private ImageLoder() {
		
	}
	
	public static ImageLoder getInstance() {
		return INSTANCE;
	}
	
	private Image loadImg(String imgName) throws IOException {
		File imgFile = new File(ImageLoder.class.getResource("images/" + imgName).getPath());
		return ImageIO.read(imgFile);
	}
	
	public void loadAllImg() throws IOException {
		this.playerDown = loadImg("player_down.png");
		this.playerLeft = loadImg("player_left.png");
		this.playerRight = loadImg("player_right.png");
		this.playerUp = loadImg("player_up.png");
		this.wall = loadImg("wall.png");
		this.floor = loadImg("floor.png");
		this.checkpointConquered = loadImg("checkpoint_conquested.png");
		this.checkpointNotConquered = loadImg("checkpoint_not_conquested.png");
	}
	
	
	public Image getPlayerRight() {
		return playerRight;
	}

	public Image getPlayerLeft() {
		return playerLeft;
	}

	public Image getPlayerDown() {
		return playerDown;
	}

	public Image getPlayerUp() {
		return playerUp;
	}

	public Image getWall() {
		return wall;
	}

	public Image getFloor() {
		return floor;
	}

	public Image getCheckpointConquered() {
		return checkpointConquered;
	}

	public Image getCheckpointNotConquered() {
		return checkpointNotConquered;
	}
}
