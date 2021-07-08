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
		return temp;
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
