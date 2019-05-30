package br.unicamp.MC322.lab11.model;

public abstract class LabyrinthObject {
	
	//métodos e coisas valem poara todos os filhos
	
	
	//SEMPRE DECLARARR TUDO PRIVATE ----- PRINCIPALMENTE ATRIBUTOS--------- E MUDAR SE NECESSÁRIO
    private Coordinate coordinate;

    //parede, jogador, checkpoint
    LabyrinthObject(int x, int y){
        this.coordinate = new Coordinate(x, y);
    }

    public abstract void accept(LabyrinthObjectVisitor visitor);
    
    public int getX(){
    	
    	//nao fazer .x, usar GET X <ou Set>, para todos os atributos
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
