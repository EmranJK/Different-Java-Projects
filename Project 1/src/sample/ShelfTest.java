package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfTest {

    Shelf shelf = new Shelf(66);

    @Test
    void getNumber() {
        assertEquals(66, shelf.getNumber());
    }

    @Test
    void setNumber() {
        shelf.setNumber(77);
        assertEquals(77, shelf.getNumber());
    }
}