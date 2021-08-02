package sample;

public class Election implements Comparable<Election>{
    private String type;
    private String location;
    private int year;
    private int winners;
    private LL<Candidate> candidates;

    public Election(String type, String location, int year, int winners) {
        this.type = type;
        this.location = location;
        this.year = year;
        this.winners = winners;
        candidates = new LL<Candidate>();


    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getWinners() {
        return winners;
    }

    public void setWinners(int winners) {
        this.winners = winners;
    }

    public LL<Candidate> getCandidates() {
        return candidates;
    }

    public void setCandidates(LL<Candidate> candidates) {
        this.candidates = candidates;
    }

    public void addCandidate(Candidate candidate){
        candidates.add(candidate);
    }

    @Override
    public String toString() {
        return "Election{" +
                "type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", year=" + year +
                ", winners=" + winners +
                ", candidates=" + candidates +
                '}';
    }

    @Override
    public int compareTo(Election o) {
        return this.getYear() - o.getYear();
    }
}
