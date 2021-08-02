package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AisleLLTest {

    AisleLL aisleLL = new AisleLL();
    Aisle aisle1 = new Aisle("A1", 3, 4);
    Aisle aisle2 = new Aisle("B2", 5, 7);


    @Test
    void insert() {
        aisleLL.insert(aisle1);
        aisleLL.insert(aisle2);
        assertEquals(aisle1.toString(), aisleLL.head.contents.toString());
        assertEquals(aisle2.toString(), aisleLL.head.next.contents.toString());

    }

    @Test
    void show() {
        aisleLL.insert(aisle1);
        assertEquals(aisle1.toString() + "\n" , aisleLL.show());
    }

    @Test
    void size() {
        aisleLL.insert(aisle1);
        aisleLL.insert(aisle2);
        assertEquals(2, aisleLL.size());
    }

    @Test
    void removeByIdentifier() {
        aisleLL.insert(aisle1);
        aisleLL.insert(aisle2);
        aisleLL.removeByIdentifier("A1");
        assertEquals(1, aisleLL.size());
    }

    @Test
    void searchByIdentifier() {
        aisleLL.insert(aisle1);
        aisleLL.insert(aisle2);
        Aisle aisle = aisleLL.searchByIdentifier("A1");
        assertEquals(aisle1, aisle);
    }

    @Test
    void reset() {
        aisleLL.insert(aisle1);
        aisleLL.insert(aisle2);
        aisleLL.reset(aisleLL);
        assertEquals(0, aisleLL.size());
    }
}