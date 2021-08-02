package sample;

public class AisleNode {
    /**
     * AisleNode is a class that I use to create a node for the aisle and the nodes are used as a container that will
     * contain the actual aisle and it will be used to iterate in the node chain hence I created a node called next.
     * The value of next is set is set to null because when I create the first node there won't be a node after it
     * and when I create more than one node then the AisleNode next will be useful.
     */
    AisleNode next = null;
    Aisle contents;

    public Aisle getContents() {
        return contents;
    }

    public void setContents(Aisle contents) {
        this.contents = contents;
    }
}
