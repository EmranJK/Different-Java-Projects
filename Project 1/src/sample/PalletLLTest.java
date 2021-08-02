package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletLLTest {

    PalletLL palletLL = new PalletLL();
    Pallet pallet1 = new Pallet("Apples", 5, 3.1, 5.4, 0,0);
    Pallet pallet2 = new Pallet("Oranges", 3, 5.3, 7.4, 4,3);

    @Test
    void insert() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        assertEquals(pallet1.toString(), palletLL.head.contents.toString());
        assertEquals(pallet2.toString(), palletLL.head.next.contents.toString());
    }

    @Test
    void show() {
        palletLL.insert(pallet1);
        assertEquals(pallet1.toString() + "\n", palletLL.show());
    }

    @Test
    void size() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        assertEquals(2, palletLL.size());
    }

    @Test
    void removeByNumberOfGoods() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        palletLL.removeByNumberOfGoods(5);
        assertEquals(1, palletLL.size());
    }

    @Test
    void searchByNumberOfGoods() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        Pallet pallet = palletLL.searchByNumberOfGoods(5);
        assertEquals(pallet1, pallet);
    }

    @Test
    void searchByTypeOfGoods() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        PalletLL pallet = palletLL.searchByTypeOfGoods("Apples");
        assertEquals(pallet1, pallet.head.contents);
    }

    @Test
    void reset() {
        palletLL.insert(pallet1);
        palletLL.insert(pallet2);
        palletLL.reset(palletLL);
        assertEquals(0, palletLL.size());
    }
}