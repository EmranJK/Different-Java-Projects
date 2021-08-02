package sample;

public class Node<E extends Comparable> implements Comparable, Cloneable {


    //Node next = null;
    E contents;
    Node<E> next;

    @Override
    public String toString() {
        return "Node{" +
                "contents=" + contents +
                ", next=" + next +
                '}';
    }

    public E getContents() {
        return contents;
    }

    public void setContents(E contents) {
        this.contents = contents;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }


    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
