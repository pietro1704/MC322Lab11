package br.unicamp.MC322.lab11.view;


import br.unicamp.MC322.lab11.engine.GameEngine;
import br.unicamp.MC322.lab11.engine.graphical.GraphicalEngine;
import br.unicamp.MC322.lab11.engine.text.TextEngine;
import br.unicamp.MC322.lab11.model.LabyrinthMap;
import br.unicamp.MC322.lab11.model.LabyrinthMapLoader;

public class Main {
    private static void runGame(GameEngine gameEngine){
        gameEngine.gameLoop();
    }
    
    public static void main(String[] args) {
    	LabyrinthMap map = LabyrinthMapLoader.getInstance().createDefaultMap();
        //runGame(new TextEngine(map)); //executa o jogo de forma textual
        runGame(new GraphicalEngine(map)); //executa o jogo de forma grafica
    }
}
