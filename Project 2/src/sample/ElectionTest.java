package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ElectionTest {

    Election election = new Election("local", "ireland", 2000, 3);

    @Test
    void getType() {
        assertEquals("local", election.getType());
    }

    @Test
    void setType() {
        election.setType("general");
        assertEquals("general", election.getType());
    }

    @Test
    void getLocation() {
        assertEquals("ireland", election.getLocation());
    }

    @Test
    void setLocation() {
        election.setLocation("france");
        assertEquals("france", election.getLocation());
    }

    @Test
    void getYear() {
        assertEquals(2000, election.getYear());
    }

    @Test
    void setYear() {
        election.setYear(13);
        assertEquals(13, election.getYear());
    }

    @Test
    void getWinners() {
        assertEquals(3, election.getWinners());
    }

    @Test
    void setWinners() {
        election.setWinners(5);
        assertEquals(5, election.getWinners());
    }
}