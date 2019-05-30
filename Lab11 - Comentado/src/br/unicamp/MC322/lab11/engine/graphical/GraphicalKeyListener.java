package br.unicamp.MC322.lab11.engine.graphical;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.unicamp.MC322.lab11.model.Direction;

public class GraphicalKeyListener implements KeyListener{
	
	//implementacao da KeyListener ocorre  nessa classe

	private Direction directionToMove;
	
	//faz o movimento e reseta a direcao para mover para null
	public Direction consumeDirection() {
		Direction d = directionToMove;
		directionToMove = null;
		return d;// = direction to move; enquanto que directionToMove = 0
	}

	//nao precisa escrever nada pois nao vamos usar
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			directionToMove = Direction.UP;
			break;
		case KeyEvent.VK_DOWN:
			directionToMove = Direction.DOWN;
			break;
		case KeyEvent.VK_LEFT:
			directionToMove = Direction.LEFT;
			break;
		case KeyEvent.VK_RIGHT:
			directionToMove = Direction.RIGHT;
			break;
		}
		
	}

	//nao precisa escrever nada pois nao vamos usar
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
