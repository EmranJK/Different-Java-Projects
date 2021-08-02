package sample;

public class Politician implements Comparable<Politician>{
    private String name;
    private int dob;
    private String party;
    private String country;
    private String image;

    public Politician(String name, int dob, String party, String country, String image) {
        this.name = name;
        this.dob = dob;
        this.party = party;
        this.country = country;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDob() {
        return dob;
    }

    public void setDob(int dob) {
        this.dob = dob;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Politician{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", party='" + party + '\'' +
                ", country='" + country + '\'' +
                ", image='" + image + '\'' +
                '}';
    }



    @Override
    public int compareTo(Politician o) {
        return this.getName().compareTo(o.getName());
    }
}
