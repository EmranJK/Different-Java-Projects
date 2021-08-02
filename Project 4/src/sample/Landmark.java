package sample;

public class Landmark {
    String landMark;
    String name;
    String type;
    int x;
    int y;

    public Landmark(String landMark, String name, String type, int x, int y) {
        this.landMark = landMark;
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getLandMark() {
        return landMark;
    }

    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Landmark{" +
                "landMark='" + landMark + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }


}
