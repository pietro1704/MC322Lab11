package br.unicamp.MC322.lab11.model;

import java.beans.DesignMode;
import java.util.List;



public class Player extends LabyrinthObject{
	private Direction currentDirection;

    Player(int x, int y){
        super(x, y);
        this.currentDirection = Direction.RIGHT;
    }

    public Direction getCurrentDirection(){
        return this.currentDirection;
    }

    private Coordinate getDestiny(Direction direction) {
    	int destinoX = getX();
    	int destinoY = getY();
        switch (direction){
            case UP:
                destinoY--;
                break;
            case DOWN:
                destinoY++;
                break;
            case LEFT:
                destinoX--;
                break;
            case RIGHT:
                destinoX++;
                break;
        }
        return new Coordinate(destinoX, destinoY);
    }
    
    private boolean containsWall(int x, int y, List<Wall> walls) {
    	 for(Wall wall : walls) {
         	if(wall.isSameCoordinates(x, y)) {
         		return true;
         	}
         }
    	 return false;
    }
    
    void move(Direction direction, List<Wall> walls){
    	Coordinate destiny = getDestiny(direction);
    	if(!containsWall(destiny.getX(), destiny.getY(), walls)) {
    		getCoordinate().changeCoordinates(destiny.getX(), destiny.getY());
    		this.currentDirection = direction;
    	}
    }

	@Override
	public void accept(LabyrinthObjectVisitor visitor) {
		visitor.visit(this);
	}


}
