package br.unicamp.MC322.lab11.model;


public class Checkpoint extends LabyrinthObject{
	//implementa Lab Obj

	 private boolean conquered;

     Checkpoint(int x, int y){
         super(x, y);
         this.conquered = false;
     }

     public boolean isConquered(){
         return conquered;
     }

     void conquer(){
         this.conquered = true;
     }

     //visitor aceita o Checkpoint
     @Override
     public void accept(LabyrinthObjectVisitor visitor) {
         visitor.visit(this);
     }
}
