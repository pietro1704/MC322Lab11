package br.unicamp.MC322.lab11.model;

import br.unicamp.MC322.lab11.engine.*;

abstract class LabyrinthObject {
    Coordinate coordinate;

    LabyrinthObject(int x, int y){
        Coordinate coordinate = new Coordinate(x, y);
    }

    public int getX(){

        return coordinate.x;
    }

    public int getY(){

        return coordinate.y;
    }

    protected Coordinate getCoordinate(){
        return coordinate;
    }

    public boolean isSameCoordinates(int x, int y){
        if (this.getX() == x && this.getY() == y){
            return true;
        }else{
            return false;
        }
    }

    public boolean isSameCoordinates(LabyrinthObject labyrinthObject) {
        if (this.getX() == labyrinthObject.getX() && this.getY() == labyrinthObject.getY()){
            return true;
        }else{
            return false;
        }
    }

    public abstract void accept(LabyrinthObjectVisitorvisitor visitor);

    class Player extends LabyrinthObject {

        Direction currentDirection;

        Player(int x, int y){

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

        void move(Direction direction, Wall[] walls){
            switch (direction){
                case UP:
                    if (walls[this.coordinate.y + 1]  == null){
                        this.coordinate.y++;
                    }
                case DOWN:
                    if (walls[this.coordinate.y - 1]  == null){
                        this.coordinate.y--;
                    }
                case LEFT:
                    if (walls[this.coordinate.x - 1]  == null){
                        this.coordinate.x--;
                    }
                case RIGHT:
                    if (walls[this.coordinate.x + 1]  == null){
                        this.coordinate.x++;
                    }
            }
        }

        public void accept(LabyrinthObjectVisitor visitor) {
            visitor.visit(this);
        }
    }

    class Wall extends LabyrinthObject {

        Wall(int x, int y){
            this.coordinate.x = x;
            this.coordinate.y = y;
        }

        public void accept(LabyrinthObjectVisitor visitor) {
            visitor.visit(this);
        }
    }

    class CheckPoint extends LabyrinthObject {
        boolean conquered;

        CheckPoint(int x, int y){
            this.coordinate.x = x;
            this.coordinate.y = y;
        }

        public boolean isConquered(){
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
