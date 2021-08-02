package sample;

public class Shelf {
    private int number;
    private PalletLL pallets;

    public Shelf(int number) {
        /**
         * In the constructor I am setting parameter for the Shelf class, so every time the user tries to create an
         * object of this class he/she will have to enter values for those parameters which will then be assigned to the fields.
         * There is also a linked list of Pallets in the body of the constructor because each floor will include aisles.
         */
        this.number = number;
        pallets = new PalletLL();
    }

    public int getNumber() {
        /**
         * The getters will contain the values of the private fields, because private fields can only be used
         * locally so instead we use public getters that contain the values of the fields.
         */
        return number;
    }

    public void setNumber(int number) {
        /**
         * The setters allow us to change the values of private fields by storing the alternative value
         * as a parameter and changing the value of the required private field to the value of the parameter.
         */
        this.number = number;
    }

    public PalletLL getPallets() {
        return pallets;
    }

    public void setPallets(PalletLL pallets) {
        this.pallets = pallets;
    }

    @Override
    public String toString() {
        /**
         * The toString method allows the user to treat an object of a class as a string.
         */
        return "Shelf{" +
                "number=" + number +
                ", pallets=" + pallets +
                '}';
    }
}
