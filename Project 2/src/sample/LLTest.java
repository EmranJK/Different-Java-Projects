package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LLTest {

    LL<Politician> politicians = new LL<Politician>();
    Politician politician = new Politician("man",1999 , "karl", "ireland", "image");
    Politician politician2 = new Politician("ann",1999 , "karl", "ireland", "image");

    @Test
    void add_show() {
        politicians.add(politician);
        System.out.println(politicians.show());
        assertEquals(politician.toString(), politicians.head.contents.toString());
    }


    @Test
    void size() {
        politicians.add(politician);
        assertEquals(1, politicians.size());
    }

    @Test
    void selectionSort() {
        politicians.add(politician2);
        politicians.add(politician);
        try {
            politicians.selectionSort(politicians);
        }
        catch (Exception e){
            System.out.println("Error");
        }

        assertEquals(politician.toString(), politicians.head.contents.toString());

    }

    @Test
    void insertionSort() {

        politicians.add(politician);
        politicians.add(politician2);
        try {
            politicians.insertionSort(politicians);
        }
        catch (Exception e){
            System.out.println("Error");
        }

        assertEquals(politician2.toString(), politicians.head.contents.toString());
    }

    @Test
    void get() {
        politicians.add(politician);
        assertEquals(politician.toString(), politicians.get(0).toString());
    }

    @Test
    void set() {
        politicians.add(politician);
        politicians.set(0, politician2);
        assertEquals("ann", politicians.get(0).getName().toString());
    }

    @Test
    void removeByIndex() {
        politicians.add(politician);
        politicians.add(politician2);
        politicians.removeByIndex(0);
        assertEquals(politician2.toString(), politicians.head.contents.toString());
    }

    @Test
    void updateByIndex() {
        politicians.add(politician);
        politicians.updateByIndex(0, politician2);
        assertEquals(politician2.toString(), politicians.head.contents.toString());

    }
}