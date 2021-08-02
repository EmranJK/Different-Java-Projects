package sample;

public class Aisle {
    private String identifier;
    private int length, width;
    private ShelfLL shelves;

    public Aisle(String identifier, int length, int width) {
        /**
         * In the constructor I am setting parameter for the Aisle class, so every time the user tries to create an
         * object of this class he/she will have to enter values for those parameters which will then be assigned to the fields.
         * There is also a linked list of Shelves in the body of the constructor because each floor will include aisles.
         */
        this.identifier = identifier;
        this.length = length;
        this.width = width;
        shelves = new ShelfLL();
    }


    public String getIdentifier() {
        /**
         * The getters will contain the values of the private fields, because private fields can only be used
         * locally so instead we use public getters that contain the values of the fields.
         */
        return identifier;
    }

    public void setIdentifier(String identifier) {
        /**
         * The setters allow us to change the values of private fields by storing the alternative value
         * as a parameter and changing the value of the required private field to the value of the parameter.
         */
        this.identifier = identifier;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public ShelfLL getShelves() {
        return shelves;
    }

    public void setShelves(ShelfLL shelves) {
        this.shelves = shelves;
    }

    @Override
    public String toString() {
        /**
         * The toString method allows the user to treat an object of a class as a string.
         */
        return "Aisle{" +
                "identifier='" + identifier + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", shelves=" + shelves +
                '}';
    }
}

