package sample;

public class FloorNode {
    /**
     * FloorNode is a class that I use to create a node for the floor and the nodes are used as a container that will
     * contain the actual floor and it will be used to iterate in the node chain hence I created a node called next.
     * The value of next is set is set to null because when I create the first node there won't be a node after it
     * and when I create more than one node then the FloorNode next will be useful.
     */
    FloorNode next = null;
    Floor contents;

    public Floor getContents() {
        return contents;
    }

    public void setContents(Floor contents) {
        this.contents = contents;
    }
}

