package br.unicamp.MC322.lab11.model;

public class Coordinate {
    int x, y;

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
        if (this.getX() == x && this.getY() == y) {
            return true;
        } else {
            return false;
        }
    }

    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        } else {
            return false;
        }
    }
}
