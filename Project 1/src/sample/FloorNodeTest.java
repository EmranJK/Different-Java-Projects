package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorNodeTest {

    FloorNode floorNode = new FloorNode();
    Floor floor1 = new Floor(1, "A", "B", "High", 2.3);

    @Test
    void getAndSetContents() {
        floorNode.setContents(floor1);
        assertEquals(floor1, floorNode.contents);
    }

}