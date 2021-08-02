package sample;

import static org.junit.jupiter.api.Assertions.*;

class PoliticianTest {

    Politician politician = new Politician("man",1999 , "karl", "ireland", "image");

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("man", politician.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        politician.setName("jack");
        assertEquals("jack", politician.getName());

    }

    @org.junit.jupiter.api.Test
    void getDob() {
        assertEquals(1999, politician.getDob());
    }

    @org.junit.jupiter.api.Test
    void setDob() {
        politician.setDob(8888);
        assertEquals(8888, politician.getDob());
    }

    @org.junit.jupiter.api.Test
    void getParty() {
        assertEquals("karl", politician.getParty());
    }

    @org.junit.jupiter.api.Test
    void setParty() {
        politician.setParty("labor");
        assertEquals("labor", politician.getParty());
    }

    @org.junit.jupiter.api.Test
    void getCountry() {
        assertEquals("ireland", politician.getCountry());
    }

    @org.junit.jupiter.api.Test
    void setCountry() {
        politician.setCountry("france");
        assertEquals("france", politician.getCountry());
    }

    @org.junit.jupiter.api.Test
    void getImage() {
        assertEquals("image", politician.getImage());
    }

    @org.junit.jupiter.api.Test
    void setImage() {
        politician.setImage("photo");
        assertEquals("photo", politician.getImage());
    }
}