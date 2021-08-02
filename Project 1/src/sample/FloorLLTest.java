package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloorLLTest {

    FloorLL floorLL = new FloorLL();
    Floor floor1 = new Floor(1, "A", "B", "High", 2.3);
    Floor floor2 = new Floor(5, "V", "H", "Low", 5.9);



    @Test
    void insert() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(floor1.toString(), floorLL.head.contents.toString());
        assertEquals(floor2.toString(), floorLL.head.next.contents.toString());
    }

    @Test
    void show() {
        floorLL.insert(floor2);
        assertEquals(floor2.toString()+ "\n", floorLL.show());
    }

    @Test
    void size() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(2, floorLL.size());

    }

    @Test
    void removeByNumber() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(2, floorLL.size());
        floorLL.removeByNumber(floor1.getNumber());
        assertEquals(1, floorLL.size());
    }

    @Test
    void removeByIdentifier() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(2, floorLL.size());
        floorLL.removeByIdentifier(floor1.getIdentifier());
        assertEquals(1, floorLL.size());
    }

    @Test
    void searchByNumber() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(floor1, floorLL.searchByNumber(1));
    }

    @Test
    void reset() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(2, floorLL.size());
        floorLL.reset(floorLL);
        assertEquals(0, floorLL.size());
    }

    @Test
    void searchByTemperature() {
        floorLL.insert(floor1);
        floorLL.insert(floor2);
        assertEquals(floor1, floorLL.searchByTemperature(2.3).head.contents);
    }
}