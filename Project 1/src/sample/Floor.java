package sample;

public class Floor {
    private int number;
    private String identifier;
    private String level;
    private String securityLevel;
    private double temperature;
    private AisleLL aisles;


    public Floor(int number, String identifier, String level, String securityLevel, double temperature) {

        /**
         * In the constructor I am setting parameter for the Floor class, so every time the user tries to create an
         * object of this class he/she will have to enter values for those parameters which will then be assigned to the fields.
         * There is also a linked list of Aisles in the body of the constructor because each floor will include aisles.
         */
        this.number = number;
        this.identifier = identifier;
        this.level = level;
        this.securityLevel = securityLevel;
        this.temperature = temperature;
        aisles = new AisleLL();
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

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSecurityLevel() {
        return securityLevel;
    }

    public void setSecurityLevel(String securityLevel) {
        this.securityLevel = securityLevel;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public AisleLL getAisles() {
        return aisles;
    }

    public void setAisles(AisleLL aisles) {
        this.aisles = aisles;
    }

    @Override
    public String toString() {
        /**
         * The toString method allows the user to treat an object of a class as a string.
         */
        return "floor{" +
                "number=" + number +
                ", identifier='" + identifier + '\'' +
                ", level=" + level +
                ", securityLevel='" + securityLevel + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
