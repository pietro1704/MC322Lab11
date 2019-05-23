package br.unicamp.MC322.lab11.engine;

import br.unicamp.MC322.lab11.model.LabyrinthObject;

class TextRenderManager implements LabyrinthObjectVisitor {
    private char charMap[][];

    void TextRenderManager(int mapWidth, int mapHeight){
        this.charMap = new char[mapHeight][mapWidth];

    }

    public void printMap(){
        for(int i = 0; i < charMap.length; i++) {
            for(int j = 0; j < charMap[0].length; j++) {
                System.out.print(charMap[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void clearMap(){
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
    public void visit(LabyrinthObject.Player jogador) {
        setSymbol(jogador ,'J');
    }

    @Override
    public void visit(LabyrinthObject.Wall parede) {
        setSymbol(parede , 'X');
    }

    @Override
    public void visit(CheckPoint checkpoint) {
        if(checkpoint.isConquered()) {
            setSymbol(checkpoint ,'T');
        }else {
            setSymbol(checkpoint , 'C');
        }
    }

}
