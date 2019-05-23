package br.unicamp.MC322.lab11.model;

public class LabyrinthMap {
    LabyrinthObject.Player player;
    LabyrinthObject.CheckPoint[] checkPoints;
    LabyrinthObject.Wall wall;
    int width;
    int height;

   public LabyrinthMap(int width, int height, LabyrinthObject.Player player, LabyrinthObject.CheckPoint[] checkPoints, LabyrinthObject.Wall wall){
       this.checkPoints = checkPoints;
       this.player = player;
       this.wall = wall;
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
           //move o jogador
       }
       //verifica se o jogador conquistou checkpoint
    }

    public boolean isDone(){
        for (int i = 0; i < checkPoints.length; i++) {
            if (!checkPoints[i].isConquered()){
                return false;
            }
        }
        return true;
    }

    public void accept(LabyrinthObjectVisitor visitor){
       for(Wall wall : walls) {
           wall.accept(visitor);
       }
        for(CheckPoint checkpoint : checkPoints) {
            checkpoint.accept(visitor);
        }
        player.accept(visitor);
   }
}
