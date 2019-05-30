package br.unicamp.MC322.lab11.model;

//interface
//implementacao depende do tipo do objeto

public interface LabyrinthObjectVisitor {

    void visit(Player player);
    void visit(Wall wall);
    void visit(Checkpoint checkpoint);

}
