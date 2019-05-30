package br.unicamp.MC322.lab11.model;


//uso de lista
import java.util.List;


public class Player extends LabyrinthObject{
	
	//lemvrando, atributos PRIVATE
	private Direction currentDirection;

    Player(int x, int y){
        super(x, y);
        //inicializa com alguma direcao qqr
        this.currentDirection = Direction.RIGHT;
    }

    public Direction getCurrentDirection(){
        return this.currentDirection;
    }

    private Coordinate getDestiny(Direction direction) {
    	
    	//olha o GET de novo
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
    
    //-=-=-=-==-=-=-=-=-=-=--=--=-=-=-=-=-=-lista ligada de paredes
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

    //visitor pode aceitar o PLAYER
	@Override
	public void accept(LabyrinthObjectVisitor visitor) {
		visitor.visit(this);
	}
}
