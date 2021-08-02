package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletTest {

    Pallet pallet = new Pallet("A", 5, 3.1,5.1, 8, 7);

    @Test
    void getDescriptionOfGoods() {
        assertEquals("A", pallet.getDescriptionOfGoods());
    }

    @Test
    void setDescriptionOfGoods() {
        pallet.setDescriptionOfGoods("B");
        assertEquals("B", pallet.getDescriptionOfGoods());
    }

    @Test
    void getNumberOfGoods() {
        assertEquals(5, pallet.getNumberOfGoods());
    }

    @Test
    void setNumberOfGoods() {
        pallet.setNumberOfGoods(23);
        assertEquals(23, pallet.getNumberOfGoods());
    }

    @Test
    void getMinStorageTemp() {
        assertEquals(3.1, pallet.getMinStorageTemperature());
    }
    @Test
    void setMinStorageTemp() {
        pallet.setMinStorageTemperature(2.3);
        assertEquals(2.3, pallet.getMinStorageTemperature());
    }
    @Test
    void getMaxStorageTemp() {
        assertEquals(5.1, pallet.getMaxStorageTemperature());
    }
    @Test
    void setMaxStorageTemp() {
        pallet.setMaxStorageTemperature(7.3);
        assertEquals(7.3, pallet.getMaxStorageTemperature());
    }
    @Test
    void getCoordinate1() {
        assertEquals(8, pallet.getCoordinate1());
    }
    @Test
    void setCoordinate1() {
        pallet.setCoordinate1(55);
        assertEquals(55, pallet.getCoordinate1());
    }
    @Test
    void getCoordinate2() {
        assertEquals(7, pallet.getCoordinate2());
    }
    @Test
    void setCoordinate2() {
        pallet.setCoordinate2(42);
        assertEquals(42, pallet.getCoordinate2());
    }
}