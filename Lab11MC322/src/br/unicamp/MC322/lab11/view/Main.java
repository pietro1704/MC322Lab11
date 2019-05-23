package br.unicamp.MC322.lab11.view;

import br.unicamp.MC322.lab11.*;

public class Main {
    private static void runGame(GameEngine gameEngine){
        gameEngine.gameLoop();
    }
    public static void main(String[] args) {
        Mapa map = MapLoader.getInstance().createDefaultMap();
        runGame(new TextEngine(map)); //executa o jogo de forma textual
        runGame(new GraphicalEngine(map)); //executa o jogo de forma grafica
    }
}
