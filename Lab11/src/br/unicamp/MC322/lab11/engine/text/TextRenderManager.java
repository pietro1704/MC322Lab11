package br.unicamp.MC322.lab11.engine.text;

import br.unicamp.MC322.lab11.model.Checkpoint;
import br.unicamp.MC322.lab11.model.LabyrinthMap;
import br.unicamp.MC322.lab11.model.LabyrinthObject;
import br.unicamp.MC322.lab11.model.LabyrinthObjectVisitor;
import br.unicamp.MC322.lab11.model.Player;
import br.unicamp.MC322.lab11.model.Wall;

class TextRenderManager implements LabyrinthObjectVisitor {
    private char charMap[][];

    TextRenderManager(int mapWidth, int mapHeight){
        this.charMap = new char[mapHeight][mapWidth];

    }

    public void render(LabyrinthMap map) {
    	clearMap();
    	map.accept(this);
    	printMap();
    	
    }
    private void printMap(){
        for(int i = 0; i < charMap.length; i++) {
            for(int j = 0; j < charMap[0].length; j++) {
                System.out.print(charMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void clearMap(){
        for(int i = 0; i < charMap.length; i++) {
            for(int j = 0; j < charMap[0].length; j++) {
                charMap[i][j] = ' ';
            }
        }
    }

    private void setSymbol(LabyrinthObject obj, char character) {
        charMap[obj.getY()][obj.getX()] = character;
    }

    @Override
    public void visit(Player jogador) {
        setSymbol(jogador ,'J');
    }

    @Override
    public void visit(Wall parede) {
        setSymbol(parede , 'X');
    }

    @Override
    public void visit(Checkpoint checkpoint) {
        if(checkpoint.isConquered()) {
            setSymbol(checkpoint ,'T');
        }else {
            setSymbol(checkpoint , 'C');
        }
    }

}
