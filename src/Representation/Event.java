package Representation;

import Univers.Personnage;

import javax.swing.*;
import java.util.List;

/**
 * L'interface Event définit le contrat que doivent suivre toutes les classes représentant des événements
 * ou des actions dans le contexte de l'application.
 * Les classes implémentant cette interface doivent fournir des méthodes pour choisir le nœud suivant,
 * afficher l'événement sur l'interface, ajouter un nœud à la liste des nœuds suivants,
 * récupérer la liste des nœuds suivants, obtenir une représentation textuelle de l'événement,
 * et récupérer l'identifiant de l'événement.
 * Cette interface permet de standardiser le comportement des différentes classes d'événements.
 *
 * @author David Roufé
 */
public interface Event {

    /**
     * Méthode permettant de choisir le nœud suivant en fonction des actions du joueur.
     *
     * @param pnlRoot    Le JPanel de la fenêtre.
     * @param personnage Le personnage associé à la décision.
     * @return Un nœud de type Event, correspondant au choix du joueur.
     */
    Event chooseNext(JPanel pnlRoot, Personnage personnage);

    /**
     * Méthode permettant d'afficher l'événement sur l'interface utilisateur.
     *
     * @param pnlRoot Le JPanel de la fenêtre.
     */
    void display(JPanel pnlRoot);

    /**
     * Méthode permettant d'ajouter un nœud à la liste des nœuds suivants possibles.
     *
     * @param nodeFromJson Le nœud à ajouter.
     */
    void addNode(Event nodeFromJson);

    /**
     * Méthode permettant de récupérer la liste des nœuds suivants possibles.
     *
     * @return La liste des nœuds suivants possibles.
     */
    List<Event> getNextNodes();

    /**
     * Méthode permettant d'obtenir une représentation textuelle de l'événement.
     *
     * @return Une chaîne de caractères représentant l'événement.
     */
    String toString();

    /**
     * Méthode permettant de récupérer l'identifiant de l'événement.
     *
     * @return L'identifiant de l'événement.
     */
    int getId();
}
