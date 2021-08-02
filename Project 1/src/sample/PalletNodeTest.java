package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalletNodeTest {

    PalletNode palletNode = new PalletNode();
    Pallet pallet1 = new Pallet("Apples", 5, 3.1, 5.4, 0,0);


    @Test
    void getAndSetContents() {
        palletNode.setContents(pallet1);
        assertEquals(pallet1, palletNode.getContents());
    }
}