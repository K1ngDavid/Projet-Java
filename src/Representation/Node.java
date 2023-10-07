package Representation;

//TODO: #3 Création de la classe mère 'Node.java'

public abstract class Node {
		private int id;
		private String description;
		private static int  nbNodes = 0;

		public Node(String description){
			this.id = nbNodes;
			this.description = description;
			nbNodes++;
		}

		public void display(){
			System.out.println(this.description);
		}

		public Node chooseNext(){
			return this;
		}

		public static int getNbNodes(){
			return nbNodes;
		}
}
