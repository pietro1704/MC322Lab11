package br.unicamp.MC322.lab11.engine;

import br.unicamp.MC322.lab11.model.*;


public abstract class GameEngine {
    private LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
    	this.labyrinthMap = labyrinthMap;
    }
    
    public abstract void gameLoop();

    protected LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }
}
