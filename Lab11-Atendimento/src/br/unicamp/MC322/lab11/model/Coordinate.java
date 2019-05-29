package br.unicamp.MC322.lab11.model;

public class Coordinate {
    private int x, y;

    public  Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public void changeCoordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean isSameCoordinates(int x, int y) {
        return (this.getX() == x && this.getY() == y);
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Coordinate) {
        	Coordinate c  = (Coordinate) obj;
        	return isSameCoordinates(c.x, c.y);
        }
        return false;
    }
}
