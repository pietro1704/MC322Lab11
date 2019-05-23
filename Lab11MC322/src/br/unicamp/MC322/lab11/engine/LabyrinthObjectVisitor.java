package br.unicamp.MC322.lab11.engine;

import br.unicamp.MC322.lab11.model.*;

public interface LabyrinthObjectVisitor {

    void visit(LabyrinthObject.Player player);
    void visit(LabyrinthObject.Wall wall);
    void visit(LabyrinthObject.CheckPoint checkpoint);

}
