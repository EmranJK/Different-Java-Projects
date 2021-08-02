package sample;

import java.util.Iterator;

public class FunkyIterator<E extends Comparable> implements Iterator<E> {


    Node<E> curr = new Node<E>();


    public FunkyIterator(Node<E> curr) {
        this.curr = curr;
    }

    @Override
    public boolean hasNext(){
        return curr != null;

    }

    @Override
    public E next(){
        Node<E> temp=curr;
        curr=curr.next;
        return temp.getContents();

    }
}
