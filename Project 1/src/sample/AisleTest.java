package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleTest {

    Aisle aisle = new Aisle("U", 3, 5);

    @Test
    void getIdentifier() {
        assertEquals("U", aisle.getIdentifier());
    }

    @Test
    void setIdentifier() {
        aisle.setIdentifier("A");
        assertEquals("A", aisle.getIdentifier());
    }

    @Test
    void getLength() {
        assertEquals(3, aisle.getLength());
    }

    @Test
    void setLength() {
        aisle.setLength(4);
        assertEquals(4, aisle.getLength());
    }

    @Test
    void getWidth() {
        assertEquals(5, aisle.getWidth());
    }

    @Test
    void setWidth() {
        aisle.setWidth(11);
        assertEquals(11, aisle.getWidth());
    }

}