package br.unicamp.MC322.lab11.model;


public class Wall extends LabyrinthObject{
	//implementa o Labyrinth Object

	Wall(int x, int y){
        super(x, y);
    }


	
	//visitor pode aceitar o WALL
	@Override
    public void accept(LabyrinthObjectVisitor visitor) {
        visitor.visit(this);
    }
}
