package br.unicamp.MC322.lab11.model;

import br.unicamp.MC322.lab11.model.*;

public interface LabyrinthObjectVisitor {

    void visit(Player player);
    void visit(Wall wall);
    void visit(Checkpoint checkpoint);

}
