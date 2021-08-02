package sample;

public class Pallet {
    private String descriptionOfGoods;
    private int numberOfGoods;
    private double minStorageTemperature;
    private double maxStorageTemperature;
    private int coordinate1, coordinate2;

    public Pallet(String descriptionOfGoods, int numberOfGoods, double minStorageTemperature, double maxStorageTemperature, int coordinate1, int coordinate2) {
        /**
         * In the constructor I am setting parameter for the Pallets class, so every time the user tries to create an
         * object of this class he/she will have to enter values for those parameters which will then be assigned to the fields.
         */

        this.descriptionOfGoods = descriptionOfGoods;
        this.numberOfGoods = numberOfGoods;
        this.minStorageTemperature = minStorageTemperature;
        this.maxStorageTemperature = maxStorageTemperature;
        this.coordinate1 = coordinate1;
        this.coordinate2 = coordinate2;
    }

    public String getDescriptionOfGoods() {
        /**
         * The getters will contain the values of the private fields, because private fields can only be used
         * locally so instead we use public getters that contain the values of the fields.
         */
        return descriptionOfGoods;
    }

    public void setDescriptionOfGoods(String descriptionOfGoods) {
        /**
         * The setters allow us to change the values of private fields by storing the alternative value
         * as a parameter and changing the value of the required private field to the value of the parameter.
         */
        this.descriptionOfGoods = descriptionOfGoods;
    }

    public int getNumberOfGoods() {
        return numberOfGoods;
    }

    public void setNumberOfGoods(int numberOfGoods) {
        this.numberOfGoods = numberOfGoods;
    }

    public double getMinStorageTemperature() {
        return minStorageTemperature;
    }

    public void setMinStorageTemperature(double minStorageTemperature) {
        this.minStorageTemperature = minStorageTemperature;
    }

    public double getMaxStorageTemperature() {
        return maxStorageTemperature;
    }

    public void setMaxStorageTemperature(double maxStorageTemperature) {
        this.maxStorageTemperature = maxStorageTemperature;
    }

    public int getCoordinate1() {
        return coordinate1;
    }

    public void setCoordinate1(int coordinate1) {
        this.coordinate1 = coordinate1;
    }

    public int getCoordinate2() {
        return coordinate2;
    }

    public void setCoordinate2(int coordinate2) {
        this.coordinate2 = coordinate2;
    }

    @Override
    public String toString() {
        /**
         * The toString method allows the user to treat an object of a class as a string.
         */
        return "Pallet{" +
                "descriptionOfGoods='" + descriptionOfGoods + '\'' +
                ", numberOfGoods=" + numberOfGoods +
                ", minStorageTemperature=" + minStorageTemperature +
                ", maxStorageTemperature=" + maxStorageTemperature +
                ", coordinate1=" + coordinate1 +
                ", coordinate2=" + coordinate2 +
                '}';
    }
}
