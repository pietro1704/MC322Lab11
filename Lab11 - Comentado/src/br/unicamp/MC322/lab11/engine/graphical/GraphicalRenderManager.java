package br.unicamp.MC322.lab11.engine.graphical;

import java.awt.Graphics;
import java.awt.Image;

import br.unicamp.MC322.lab11.model.Checkpoint;
import br.unicamp.MC322.lab11.model.LabyrinthMap;
import br.unicamp.MC322.lab11.model.LabyrinthObject;
import br.unicamp.MC322.lab11.model.LabyrinthObjectVisitor;
import br.unicamp.MC322.lab11.model.Player;
import br.unicamp.MC322.lab11.model.Wall;

//package private
class GraphicalRenderManager implements LabyrinthObjectVisitor {

	public static final int BLOCK_SIZE = 35;//tamanho das imagens
	private Graphics g;

	public void render(Graphics g, LabyrinthMap map) {
		this.g = g;
		drawBackground(map.getWidth(), map.getHeight());
		map.accept(this);
	}

	private void drawBackground(int mapWidth, int mapHeight) {
		Image floorImg = ImageLoder.getInstance().getFloor();
		for (int y = 0; y < mapHeight * BLOCK_SIZE; y += BLOCK_SIZE) {
			for (int x = 0; x < mapWidth * BLOCK_SIZE; x += BLOCK_SIZE) {
				g.drawImage(floorImg, x, y, null);//listener = null pq nao precisa
			}
		}
	}

	
	//padding = distancia da borda da imagem em que está sobreposta
	private void drawObject(LabyrinthObject obj, Image img, int paddingX, int paddingY) {
		g.drawImage(img, obj.getX() * BLOCK_SIZE + paddingX, obj.getY() * BLOCK_SIZE + paddingY, null);
	}

	//desenha a imagem
	private void drawObject(LabyrinthObject obj, Image img) {
		drawObject(obj, img, 0, 0);
	}

	
	//player visita o labirinto em modo IMAGEM
	@Override
	public void visit(Player player) {
		switch (player.getCurrentDirection()) {
		case UP:
			drawObject(player, ImageLoder.getInstance().getPlayerUp(), 5, 5);
			break;
		case DOWN:
			drawObject(player, ImageLoder.getInstance().getPlayerDown(), 5, 5);
			break;
		case LEFT:
			drawObject(player, ImageLoder.getInstance().getPlayerLeft(), 5, 5);
			break;
		case RIGHT:
			drawObject(player, ImageLoder.getInstance().getPlayerRight(), 5, 5);
			break;
		}

	}

	
	//wall visita o labirinto em modo IMAGEM
	@Override
	public void visit(Wall wall) {
		drawObject(wall, ImageLoder.getInstance().getWall());

	}

	
	//checkpoint visita o labirinto em modo IMAGEM
	@Override
	public void visit(Checkpoint checkpoint) {
		if (checkpoint.isConquered()) {
			drawObject(checkpoint, ImageLoder.getInstance().getCheckpointConquered());
		} else {
			drawObject(checkpoint, ImageLoder.getInstance().getCheckpointNotConquered());
		}

	}

}
