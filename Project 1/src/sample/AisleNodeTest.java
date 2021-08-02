package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleNodeTest {

    AisleNode aisleNode = new AisleNode();
    Aisle aisle1 = new Aisle("A1", 3, 4);


    @Test
    void getAndSetContents() {
        aisleNode.setContents(aisle1);
        assertEquals(aisle1, aisleNode.getContents());
    }
}