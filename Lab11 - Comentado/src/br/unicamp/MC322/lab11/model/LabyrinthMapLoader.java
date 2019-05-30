package br.unicamp.MC322.lab11.model;

//lista ligada
import java.util.LinkedList;
import java.util.List;

public class LabyrinthMapLoader {

	//só pode declarar 1 instância
	private static final LabyrinthMapLoader INSTANCE = new LabyrinthMapLoader();

	
	//CONSTRUTOR PRIVADO = SÓ A CLASSE PODE SE INSTANCIAR
	//ASSIM EU CONTROLO QUANTAS INSTÂNCIAS EU TENHO
    private LabyrinthMapLoader() {
    	
    }
    
    public static LabyrinthMapLoader getInstance(){
    	return INSTANCE;
    }

    public LabyrinthMap createDefaultMap(){
    	//lista ligada
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
    	
    	//lista ligada
    	List<Checkpoint> checkpoints = new LinkedList<>();
    	
    	checkpoints.add(new Checkpoint(1, 2));
    	checkpoints.add(new Checkpoint(2, 2));
    	Player player = new Player(1,1);
    	
    	//USAR RETURN NEW
    	return new LabyrinthMap(4, 4, player, checkpoints, walls);
    }
}
