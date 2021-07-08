package core;

public interface INode<T extends Comparable<T>> {
    INode<T> getRightNode();
    INode<T> getLeftNode();
    T getElement();
}
