package br.unicamp.MC322.lab11.engine.text;

import java.util.Scanner;

import br.unicamp.MC322.lab11.engine.GameEngine;
import br.unicamp.MC322.lab11.model.Direction;
import br.unicamp.MC322.lab11.model.LabyrinthMap;

public class TextEngine extends GameEngine {

	private TextRenderManager renderManager;
	
	public TextEngine(LabyrinthMap map) {
		super(map);
		this.renderManager = new TextRenderManager(map.getWidth(), map.getHeight());
	}
	
	private Direction readDirectionFromKeyboard(Scanner scanner) {
		System.out.print("Qual direcao? (8,4,6,2)");
		int directionInt = scanner.nextInt();
		switch (directionInt) {
		case 8:
			return Direction.UP;
		case 4:
			return Direction.LEFT;
		case 6:
			return Direction.RIGHT;
		case 2:
			return Direction.DOWN;
		default:
			return null;
		}
	}

	//gameLoop para GameEngine em modo TEXTO
	@Override
	public void gameLoop() {
		Scanner scanner = new Scanner(System.in);
		LabyrinthMap map = getLabyrinthMap();
		Direction d;
		while (!map.isDone()) {
			renderManager.render(map);
			d = readDirectionFromKeyboard(scanner);
			map.updateMap(d);
		}
		System.out.println("Labirinto Finalizado!");
	}

}
