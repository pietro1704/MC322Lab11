package br.unicamp.MC322.lab11.engine;

import br.unicamp.MC322.lab11.model.*;


//classe abstrata, implementada conforme o objeto, 
//	pois engine pode ser gráfica ou textual
public abstract class GameEngine {
	
	//composta do mapa, gameLoop e getMap para o mapa 
	//só poder set chamado a partir daqui,  FAMOSO ENCAPSULAMENTO
    private LabyrinthMap labyrinthMap;

    public GameEngine(LabyrinthMap labyrinthMap) {
    	this.labyrinthMap = labyrinthMap;
    }
    
    public abstract void gameLoop();

    protected LabyrinthMap getLabyrinthMap() {
        return labyrinthMap;
    }
}
