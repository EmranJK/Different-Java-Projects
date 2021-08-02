package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShelfLLTest {

    ShelfLL shelfLL = new ShelfLL();
    Shelf shelf1 = new Shelf(5);
    Shelf shelf2 = new Shelf(7);

    @Test
    void insert() {
        shelfLL.insert(shelf1);
        assertEquals(shelf1.toString(), shelfLL.head.contents.toString());
    }

    @Test
    void show() {
        shelfLL.insert(shelf1);
        assertEquals(shelf1.toString() + "\n", shelfLL.show());
    }

    @Test
    void size() {
        shelfLL.insert(shelf1);
        shelfLL.insert(shelf2);
        assertEquals(2, shelfLL.size());
    }

    @Test
    void removeByNumber() {
        shelfLL.insert(shelf1);
        shelfLL.insert(shelf2);
        shelfLL.removeByNumber(5);
        assertEquals(1, shelfLL.size());
    }

    @Test
    void searchByNumber() {
        shelfLL.insert(shelf1);
        shelfLL.insert(shelf2);
        Shelf shelf = shelfLL.searchByNumber(5);
        assertEquals(shelf1, shelf);
    }

    @Test
    void reset() {
        shelfLL.insert(shelf1);
        shelfLL.insert(shelf2);
        shelfLL.reset(shelfLL);
        assertEquals(0, shelfLL.size());
    }
}