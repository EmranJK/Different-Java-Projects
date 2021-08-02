package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    LL<Politician> politicians = new LL<Politician>();
    Politician politician = new Politician("man",1999 , "karl", "ireland", "image");
    Politician politician2 = new Politician("ann",1999 , "karl", "ireland", "image");

    @Test
    void getContents() {
        politicians.add(politician);
        assertEquals(politician.toString(), politicians.head.getContents().toString());

    }

    @Test
    void setContents() {
        politicians.add(politician);
        politicians.head.setContents(politician2);
        assertEquals(politician2.toString(), politicians.head.getContents().toString());

    }
}