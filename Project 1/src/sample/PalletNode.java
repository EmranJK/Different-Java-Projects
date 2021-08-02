package sample;

public class PalletNode {
    /**
     * PalletNode is a class that I use to create a node for the pallet and the nodes are used as a container that will
     * contain the actual pallet and it will be used to iterate in the node chain hence I created a node called next.
     * The value of next is set is set to null because when I create the first node there won't be a node after it
     * and when I create more than one node then the PalletNode next will be useful.
     */
    PalletNode next = null;
    Pallet contents;

    public Pallet getContents() {
        return contents;
    }

    public void setContents(Pallet contents) {
        this.contents = contents;
    }
}
