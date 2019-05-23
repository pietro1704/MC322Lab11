package br.unicamp.MC322.lab11.model;

import br.unicamp.MC322.lab11.engine.*;

public abstract class LabyrinthObject {
    Coordinate coordinate;

    public LabyrinthObject(int x, int y){
        Coordinate coordinate = new Coordinate(x, y);
    }

    int getX(){
        return coordinate.x;
    }

    int getY(){
        return coordinate.y;
    }

    protected Coordinate getCoordinate(){
        return coordinate;
    }

    boolean isSameCoordinates(int x, int y){
        if (this.getX() == x && this.getY() == y){
            return true;
        }else{
            return false;
        }
    }
    boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        if (this.getX() == labyrinthObject.getX() && this.getY() == labyrinthObject.getY()){
            return true;
        }else{
            return false;
        }
    }

    public abstract void accept(LabyrinthObjectVisitorvisitor visitor);



    public class Player extends LabyrinthObject {

        Direction currentDirection;

        public Player(int x, int y){
            super(x, y);
        }

        Direction getCurrentDirection(){
            Direction direction;
            switch(this.currentDirection){
                case UP:     direction =  Direction.UP;break;
                case DOWN:   direction =  Direction.DOWN;break;
                case LEFT:   direction =  Direction.LEFT;break;
                case RIGHT:  direction =  Direction.RIGHT;break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.currentDirection);
            }
            return direction;
        }

        void move(Direction direction, Wall walls){
            //implementar
        }

        @Override
        public void accept(LabyrinthObjectVisitor visitor) {
            visitor.visit(this);
        }
    }

    public class Wall extends LabyrinthObject {

        public Wall(int x, int y){
            this.coordinate.x = x;
            this.coordinate.y = y;
        }

        @Override
        public void accept(LabyrinthObjectVisitor visitor) {
            visitor.visit(this);
        }
    }

    public class CheckPoint extends LabyrinthObject {
        boolean conquered;

        public CheckPoint(int x, int y){
            this.coordinate.x = x;
            this.coordinate.y = y;
        }

        boolean isConquered(){
            if (conquered){
                return true;
            }else{
                return false;
            }
        }

        void conquer(){
            this.conquered = true;
        }

        @Override
        public void accept(LabyrinthObjectVisitor visitor) {
            visitor.visit(this);
        }
    }
}
