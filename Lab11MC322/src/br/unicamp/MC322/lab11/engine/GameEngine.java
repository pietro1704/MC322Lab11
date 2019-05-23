package br.unicamp.MC322.lab11.engine;

import br.unicamp.MC322.lab11.model.*;
import java.util.Scanner;

public class GameEngine {
    private LabyrinthMap labyrinthMap;

    @Override
    public void gameLoop(){
        Scanner scanner = new Scanner(System.in);
        LabyrinthMap map = getMap();
        Direction newDirection;
        while (!map.isDone()) {
            renderManager.clearMap(); //limpa o mapa
            map.accept(renderManager); //estrutura o mapa
            renderManager.printMap(); //imprime o mapa na tela
            newDirection = readCommandFromKeyboard(scanner);
            map.updateMap(newDirection);
        }
        System.out.println("Labirinto finalizado! Parabens");
        scanner.close();
    }

    public LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }
}
