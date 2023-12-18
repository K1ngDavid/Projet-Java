package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe abstraite InnerNode, classe parente de tous les nœuds internes. Elle étend la classe abstraite Node.
 * Les nœuds internes sont des nœuds de décision ou des nœuds contenant des options pour le joueur.
 *
 * @author David Roufé
 */
public abstract class InnerNode extends Node {

    /** Liste des nœuds suivants possibles à partir de ce nœud interne. */
    protected List<Event> nextNodes;

    /**
     * Constructeur de la classe InnerNode avec une description.
     *
     * @param description La description du nœud interne.
     */
    public InnerNode(String description) {
        super(description);
        this.nextNodes = new ArrayList<>(4); // Initialisation de la liste avec une capacité de 4 (ajustable selon les besoins).
    }

    /**
     * Constructeur de la classe InnerNode avec une description et une liste de nœuds suivants.
     *
     * @param description La description du nœud interne.
     * @param nextNodes   La liste des nœuds suivants possibles.
     */
    public InnerNode(String description, List<Event> nextNodes) {
        super(description);
        this.nextNodes = nextNodes;
    }

    /**
     * Ajoute un nœud à la liste des nœuds suivants possibles.
     *
     * @param node Le nœud à ajouter.
     */
    public void addNode(Node node) {
        this.nextNodes.add(node);
    }

    /**
     * Méthode abstraite permettant de choisir le nœud suivant en fonction des actions du joueur.
     *
     * @param pnlRoot    Le JPanel de la fenêtre.
     * @param personnage Le personnage associé à la décision.
     * @return Un nœud de type Event, correspondant au choix du joueur.
     */
    public abstract Event chooseNext(JPanel pnlRoot, Personnage personnage);

    /**
     * Renvoie la liste des nœuds suivants possibles à partir de ce nœud interne.
     *
     * @return La liste des nœuds suivants possibles.
     */
    @Override
    public List<Event> getNextNodes() {
        return nextNodes;
    }
}
