package br.unicamp.MC322.lab11.model;

import br.unicamp.MC322.lab11.engine.*;

public abstract class LabyrinthObject {
    private Coordinate coordinate;

    LabyrinthObject(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }

    public abstract void accept(LabyrinthObjectVisitor visitor);
    
    public int getX(){
        return coordinate.getX();
    }

    public int getY(){
        return coordinate.getY();
    }

    protected Coordinate getCoordinate(){
        return coordinate;
    }

    public boolean isSameCoordinates(int x, int y){
        return (this.getX() == x && this.getY() == y);
    }

    public boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
       return isSameCoordinates(labyrinthObject.getX(), labyrinthObject.getY());
    }

    
}
