package sample;

import static org.junit.jupiter.api.Assertions.*;

class FloorTest {

    Floor floor = new Floor(1, "A", "B", "High", 2.3);

    @org.junit.jupiter.api.Test
    void getNumber() {
        assertEquals(1, floor.getNumber());
    }

    @org.junit.jupiter.api.Test
    void setNumber() {
        floor.setNumber(2);
        assertEquals(2, floor.getNumber());
    }

    @org.junit.jupiter.api.Test
    void getIdentifier() {
        assertEquals("A", floor.getIdentifier());
    }

    @org.junit.jupiter.api.Test
    void setIdentifier() {
        floor.setIdentifier("B");
        assertEquals("B", floor.getIdentifier());
    }

    @org.junit.jupiter.api.Test
    void getLevel() {
        assertEquals("B", floor.getLevel());
    }

    @org.junit.jupiter.api.Test
    void setLevel() {
        floor.setLevel("HH");
        assertEquals("HH", floor.getLevel());

    }

    @org.junit.jupiter.api.Test
    void getSecurityLevel() {
        assertEquals("High", floor.getSecurityLevel());
    }

    @org.junit.jupiter.api.Test
    void setSecurityLevel() {
        floor.setSecurityLevel("Low");
        assertEquals("Low", floor.getSecurityLevel());
    }

    @org.junit.jupiter.api.Test
    void getTemp() {
        assertEquals(2.3, floor.getTemperature());
    }

    @org.junit.jupiter.api.Test
    void setTemp() {
        floor.setTemperature(5.5);
        assertEquals(5.5, floor.getTemperature());
    }


}