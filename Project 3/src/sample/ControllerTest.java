package sample;

import com.sun.prism.Image;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import org.junit.jupiter.api.BeforeEach;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    Controller controller = new Controller();
    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[9];
        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 3;
        array[4] = 4;
        array[5] = 5;
        array[6] = -1;
        array[7] = 7;
        array[8] = 8;
    }

    ControllerTest() throws IOException {

    }

    @org.junit.jupiter.api.Test
    void checkingFindMethod() {
        int x = array[2];
        assertEquals(2, Controller.find(array, x));
    }

    @org.junit.jupiter.api.Test
    void checkingUnionMethod() {
        int x = array[2];
        int y = array[3];
        Controller.union(array, x, y);
        assertEquals(2, Controller.find(array,x));
        assertEquals(Controller.find(array, 2), Controller.find(array, 3));
    }


}