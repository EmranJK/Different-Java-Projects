package sample;

public class ShelfNode {
    /**
     * ShelfNode is a class that I use to create a node for the shelf and the nodes are used as a container that will
     * contain the actual shelf and it will be used to iterate in the node chain hence I created a node called next.
     * The value of next is set is set to null because when I create the first node there won't be a node after it
     * and when I create more than one node then the ShelfNode next will be useful.
     */
    ShelfNode next = null;
    Shelf contents;

    public Shelf getContents() {
        return contents;
    }

    public void setContents(Shelf contents) {
        this.contents = contents;
    }



}
