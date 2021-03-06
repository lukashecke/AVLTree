import core.INode;
import util.Util;

import java.io.IOException;

public class AVLBaum<T extends Comparable<T>> {
	
	private AVLNode root;
	
	public boolean add(T toAdd) {
		if(root == null) {
			root = new AVLNode(toAdd, null);
			return true;
		}
		return add(toAdd, root);
	}

	private boolean add(T toAdd, AVLNode node) {
		int compare = node.element.compareTo(toAdd);
		if(compare == 0) {
			return false;
		}
		if(compare < 0) { //Rechts weiter
			if(node.rightNode == null) {
				AVLNode newNode = new AVLNode(toAdd, node);
				node.rightNode = newNode;
				node.hoeheRechterTeilbaum++;
				return true;
			}
			boolean temp = add(toAdd, node.rightNode);
			node.hoeheRechterTeilbaum = getHoehe(node.rightNode);
			balance(node);
			return temp;
		}
		//Links weiter
		if(node.leftNode == null) {
			AVLNode newNode = new AVLNode(toAdd, node);
			node.leftNode = newNode;
			node.hoeheLinkerTeilbaum++;
			return true;
		}
		boolean temp = add(toAdd, node.leftNode);
		node.hoeheLinkerTeilbaum = getHoehe(node.leftNode);
		balance(node);
		return temp;
	}

	private void balance(AVLNode node) {
		int balanceFaktor = node.getBalanceFaktor();
		if (Math.abs(balanceFaktor) >= 2) {
			AVLNode referenceNode;
			// Rotation
			if (balanceFaktor < 0) {
				if (node.leftNode.getBalanceFaktor() < 0) {
					rechtsRotation(node);
				} else {
					linksRechtsRotation(node);
				}
			} else {
				if (node.rightNode.getBalanceFaktor() > 0) {
					linksRotation(node);
				} else {
					rechtsLinksRotation(node);
				}
			}
		}
	}

	private void linksRechtsRotation(AVLNode node) {
		linksRotation(node.leftNode);
		rechtsRotation(node);
	}

	private void rechtsLinksRotation(AVLNode node) {
		rechtsRotation(node.rightNode);
		linksRotation(node);
	}

	private void rechtsRotation(AVLNode node) {
		if(node.parentNode == null) { // node ist Wurzel
			root = node.leftNode;
		}
		else {
			int compare = node.element.compareTo(node.parentNode.element);
			if(compare < 0) { // Node ist links
				node.parentNode.leftNode = node.leftNode;
			}
			else { //Node ist rechts, = 0 geht nicht
				node.parentNode.rightNode = node.leftNode;
			}
		}

		node.leftNode.parentNode = node.parentNode; //ParentNodes anpassen
		node.parentNode = node.leftNode;

		AVLNode toShift = node.leftNode.rightNode;
		node.leftNode.rightNode = node;
		node.leftNode = toShift;
		if(toShift != null) {
			toShift.parentNode = node.parentNode; //Referenz von parentNode in toShift ??ndern
		}
		node.hoeheLinkerTeilbaum = getHoehe(toShift);
		node.parentNode.hoeheRechterTeilbaum = getHoehe(node);
	}

	private void linksRotation(AVLNode node) {
		if(node.parentNode == null) { // node ist Wurzel
			root = node.rightNode;
		} else {
			int compare = node.element.compareTo(node.parentNode.element);
			if (compare < 0) { // Node ist links
				node.parentNode.leftNode = node.rightNode;
			} else { // Node ist rechts, = 0 geht nicht
				node.parentNode.rightNode = node.rightNode;
			}
		}
		node.rightNode.parentNode = node.parentNode;
		node.parentNode = node.rightNode;
		AVLNode toShift = node.rightNode.leftNode;
		node.rightNode.leftNode = node;
		node.rightNode = toShift;
		if(toShift != null) {
			toShift.parentNode = node.parentNode; //Referenz von parentNode in toShift ??ndern
		}
		node.hoeheRechterTeilbaum = getHoehe(toShift);
		node.parentNode.hoeheLinkerTeilbaum = getHoehe(node);
	}

	private int getHoehe(AVLNode node) {
		if (node == null) {
			return 0;
		}
		return Math.max(node.hoeheLinkerTeilbaum,node.hoeheRechterTeilbaum) + 1; // plus sich selber
	}

	public void printDotFile(String name) {
		try {
			Util.printDOTFile(name, root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	class AVLNode implements INode<T> {
		T element;
		AVLNode rightNode;
		AVLNode leftNode;
		AVLNode parentNode;
		int hoeheLinkerTeilbaum;
		int hoeheRechterTeilbaum;
		
		public AVLNode(T element, AVLNode parentNode) {
			this.element = element;
			this.parentNode = parentNode;
		}

		public int getBalanceFaktor() {
			return hoeheRechterTeilbaum - hoeheLinkerTeilbaum;
		}
		
		@Override
		public INode<T> getLeftNode() {
			return leftNode;
		}
		@Override
		public INode<T> getRightNode() {
			return rightNode;
		}
		@Override
		public T getElement() {
			return element;
		}
	}

}
