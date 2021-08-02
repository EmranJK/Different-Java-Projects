package sample;

import static org.junit.jupiter.api.Assertions.*;

class LandmarkTest {

    Landmark landmark;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        landmark = new Landmark("Landmark", "WIT", "Social", 234, 342);
    }

    @org.junit.jupiter.api.Test
    void getLandMark() {
        assertEquals("Landmark", landmark.getLandMark());
    }

    @org.junit.jupiter.api.Test
    void setLandMark() {
        landmark.setLandMark("Well");
        assertEquals("Well", landmark.getLandMark());
    }

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("WIT", landmark.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        landmark.setName("EM");
        assertEquals("EM", landmark.getName());
    }

    @org.junit.jupiter.api.Test
    void getX() {
        assertEquals(234, landmark.getX());
    }

    @org.junit.jupiter.api.Test
    void setX() {
        landmark.setX(33);
        assertEquals(33, landmark.getX());
    }

    @org.junit.jupiter.api.Test
    void getY() {
        assertEquals(342, landmark.getY());
    }

    @org.junit.jupiter.api.Test
    void setY() {
        landmark.setY(44);
        assertEquals(44, landmark.getY());
    }

    @org.junit.jupiter.api.Test
    void getType() {
        assertEquals("Social", landmark.getType());
    }

    @org.junit.jupiter.api.Test
    void setType() {
        landmark.setType("Cultural");
        assertEquals("Cultural", landmark.getType());
    }
}