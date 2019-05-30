package br.unicamp.MC322.lab11.model;

import java.util.List;

public class LabyrinthMap {
    private Player player;
    
    //chekpoints = lista de checkpoint
    private List<Checkpoint> checkpoints;
    //mesma coisa para walls
    private List<Wall> walls;
    private int width;
    private int height;

   //somente as classes do mesmo pacote podem instanciar
    protected LabyrinthMap(int width, int height, Player player, List<Checkpoint> checkpoints, List<Wall> walls){
       this.checkpoints = checkpoints;
       this.player = player;
       this.walls = walls;
       this.width = width;
       this.height = height;
   }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void updateMap(Direction direction){
       if (direction != null){
            player.move(direction, walls);
            for(Checkpoint checkpoint : checkpoints) {
         	   if(player.isSameCoordinates(checkpoint)) {
         		   checkpoint.conquer();
         	   }
            }
       }
    }

    public boolean isDone(){
        for (Checkpoint checkpoint : checkpoints) {
            if (!checkpoint.isConquered()){
                return false;
            }
        }
        return true;
    }

    public void accept(LabyrinthObjectVisitor visitor){
       for(Wall wall : walls) {
           wall.accept(visitor);
       }
        for(Checkpoint checkpoint : checkpoints) {
            checkpoint.accept(visitor);
        }
        player.accept(visitor);
   }
}
