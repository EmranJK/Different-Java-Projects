package sample;

public class Candidate implements Comparable<Candidate> {
    private String politicianName;
    private int votes;
    private String party;



    public Candidate(String politicianName, int votes, String party) {
        this.politicianName = politicianName;
        this.votes = votes;
        this.party = party;
    }


    public String getPoliticianName() {
        return politicianName;
    }

    public void setPoliticianName(String politicianName) {
        this.politicianName = politicianName;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "politicianName='" + politicianName + '\'' +
                ", votes=" + votes +
                ", party='" + party + '\'' +
                '}';
    }

    @Override
    public int compareTo(Candidate o) {
        return this.getVotes() - o.getVotes();
//        return o.getVotes() - this.getVotes();
    }
}

