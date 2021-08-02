package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CandidateTest {

    Candidate candidate = new Candidate("michael", 33, "gail");

    @Test
    void getPoliticianName() {
        assertEquals("michael", candidate.getPoliticianName());
    }

    @Test
    void setPoliticianName() {
        candidate.setPoliticianName("jack");
        assertEquals("jack", candidate.getPoliticianName());
    }

    @Test
    void getVotes() {
        assertEquals(33, candidate.getVotes());
    }

    @Test
    void setVotes() {
        candidate.setVotes(5);
        assertEquals(5, candidate.getVotes());
    }

    @Test
    void getParty() {
        assertEquals("gail", candidate.getParty());
    }

    @Test
    void setParty() {
        candidate.setParty("fein");
        assertEquals("fein", candidate.getParty());
    }
}