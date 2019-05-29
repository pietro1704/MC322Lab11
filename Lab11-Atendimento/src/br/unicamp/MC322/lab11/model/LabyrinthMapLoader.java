package br.unicamp.MC322.lab11.model;

import java.util.LinkedList;
import java.util.List;

public class LabyrinthMapLoader {


	private static final LabyrinthMapLoader INSTANCE = new LabyrinthMapLoader();

    private LabyrinthMapLoader() {
    	
    }
    
    public static LabyrinthMapLoader getInstance(){
    	return INSTANCE;
    }

    public LabyrinthMap createDefaultMap(){
    	List<Wall> walls = new LinkedList<>();
    	walls.add(new Wall(0,0));
    	walls.add(new Wall(1,0));
    	walls.add(new Wall(2,0));
    	walls.add(new Wall(3,0));
    	walls.add(new Wall(0,1));
    	walls.add(new Wall(3,1));
    	walls.add(new Wall(0,2));
    	walls.add(new Wall(3,2));
    	walls.add(new Wall(0,3));
    	walls.add(new Wall(1,3));
    	walls.add(new Wall(2,3));
    	walls.add(new Wall(3,3));
    	List<Checkpoint> checkpoints = new LinkedList<>();
    	checkpoints.add(new Checkpoint(1, 2));
    	checkpoints.add(new Checkpoint(2, 2));
    	Player player = new Player(1,1);
    	return new LabyrinthMap(4, 4, player, checkpoints, walls);
    }
}
