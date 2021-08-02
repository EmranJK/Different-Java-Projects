package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfNodeTest {

    ShelfNode shelfNode = new ShelfNode();
    Shelf shelf1 = new Shelf(5);

    @Test
    void getAndSetContents() {
        shelfNode.setContents(shelf1);
        assertEquals(shelf1, shelfNode.getContents());
    }
}