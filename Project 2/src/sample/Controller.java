package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;


public class Controller {

    LL<Election> list1 = new LL<Election>();
    LL<Candidate> list2 = new LL<Candidate>();
    LL<Politician> list3 = new LL<Politician>();
    MegaHashSC4<Election> hash1  = new MegaHashSC4<Election>(10);
    MegaHashSC4<Candidate> hash2  = new MegaHashSC4<Candidate>(10);
    MegaHashSC4<Politician> hash3  = new MegaHashSC4<Politician>(10);


    /////////////////////////////////////// Politician //////////////////////////////////////////

    public static Politician searchPoliticians(MegaHashSC4<Politician> politiciansHash, String name){
        /**
         * In this method we create a politician linked list called politicians and we make it equal to linked list with the index
         * name.length in the hash table, then we sort that list with the insertion sort in a descending order, the we create a for
         * loop, in it we say for each politician p, if the name that the user provided is the same as the name of p then we return p,
         * else if the name that the user provided compared to the name of p is less than 0 then we return null, if the for loop is
         * finished and the name of p is not equal to name then we return null.
         */
        LL<Politician> politicians = politiciansHash.get(name.length());
        politicians.insertionSort(politicians);
        for (Politician p : politicians){
            if (name.equalsIgnoreCase(p.getName())){
                return p;
            }
            else if (name.compareTo(p.getName()) < 0)
                return null;
        }
        return null;
    }

    @FXML
    TextField polititianName;
    @FXML
    TextField polititianDOB;
    @FXML
    TextField polititianParty;
    @FXML
    TextField polititianCountry;
    @FXML
    TextField polititianImage;
    @FXML
    TextField updatePollititianByIndex;
    @FXML
    TextField UpdatePolititianName;
    @FXML
    TextField UpdatePolititianDOB;
    @FXML
    TextField UpdatePolititianParty;
    @FXML
    TextField UpdatePolititianCountry;
    @FXML
    TextField UpdatePolititianImage;
    @FXML
    TextArea updatePolititianStatus;
    @FXML
    TextField polititianIndexDelete;
    @FXML
    TextField deletePolititianStatus;
    @FXML
    TextField serachPolititianName;
    @FXML
    TextField searchPolititianNameStatus;
    @FXML
    TextField multiplePoliticiansDOBSearch;
    @FXML
    TextArea searchMultiplePoliticiansStatus;

    public void addpolititian(){
        String name = polititianName.getText();
        int DOB = Integer.parseInt(polititianDOB.getText());
        String party = polititianParty.getText();
        String country = polititianCountry.getText();
        String image = polititianImage.getText();

        Politician p = new Politician(name, DOB, party, country, image);
        list3.add(p);
//        try {
//            list3.save();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }
        hash3.add(p, p.getName().length());
    }

    public void updatePolititian(){
        int index = Integer.parseInt(updatePollititianByIndex.getText());

        String name = UpdatePolititianName.getText();
        int DOB = Integer.parseInt(UpdatePolititianDOB.getText());
        String party = UpdatePolititianParty.getText();
        String country = UpdatePolititianCountry.getText();
        String image = UpdatePolititianImage.getText();

        Politician p = new Politician(name, DOB, party, country, image);
        list3.updateByIndex(index, p);
//        try {
//            list3.save();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }

    }

    public void deletePolititian(){
        int index = Integer.parseInt(polititianIndexDelete.getText());
        if (index > list3.size()-1 || index < 0)
            System.out.println("Index is wrong, try again");
        else {
            list3.removeByIndex(index);
//            try {
//                list3.save();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
        }
    }

    public void SearchPolititianByName(){

//        try {
//            list3.load();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }
        String name  = serachPolititianName.getText();
        Politician polFound = searchPoliticians(hash3, name);
        assert polFound != null;
//        searchPolititianNameStatus.setText(polFound.toString());
        System.out.println(polFound.toString());

    }

    public void SearchMultiplePoliticians(){

        int dob = Integer.parseInt(multiplePoliticiansDOBSearch.getText());
        LL<Politician> politicians = new LL<Politician>();

//        for (int i = 0; i > list3.size(); i++){
//            if (list3.get(i).getDob() == dob)
//                politicians.add(list3.get(i));
//        }

        for (Politician p : list3){
            if (p.getDob() == dob)
                politicians.add(p);
        }

        try {
            politicians.selectionSort(politicians);
        }
        catch (Exception e){
            System.out.println("Error");
        }

//        System.out.println(politicians.show());
          searchMultiplePoliticiansStatus.setText(politicians.show());
    }










    /////////////////////////////////////// Election //////////////////////////////////////////

    public static Election searchElections(MegaHashSC4<Election> electionsHash, String type){
        /**
         * In this method we create an election linked list called elections and we make it equal to linked list with the index
         * type.length in the hash table, then we sort that list with the insertion sort in a descending order, the we create a for
         * loop, in it we say for each election e, if the type that the user provided is the same as the type of e then we return e,
         * else if the type that the user provided compared to the type of e is less than 0 then we return null, if the for loop is
         * finished and the type of e is not equal to type then we return null.
         */
        LL<Election> elections = electionsHash.get(type.length());
        elections.insertionSort(elections);
        for (Election e : elections){
            if (type.equalsIgnoreCase(e.getType())){
                return e;
            }
            else if (type.compareTo(e.getType()) < 0)
                return null;
        }
        return null;
    }

    @FXML
    TextField electionType;
    @FXML
    TextField electionLocation;
    @FXML
    TextField electionYear;
    @FXML
    TextField electionNumOFWinners;
    @FXML
    TextArea electionTypeSearchStatus;
    @FXML
    TextField updateElectionByIndex;
    @FXML
    TextField updateElectionType;
    @FXML
    TextField updateElectionLocation;
    @FXML
    TextField updateElectionYears;
    @FXML
    TextField updateElectionNumOfWinners;
    @FXML
    TextField deleteElectionByIndex;
    @FXML
    TextField deleteElectionStatus;
    @FXML
    TextField searchElectionType;
    @FXML
    TextField ElectionsWinnersMultipleSearch;
    @FXML
    TextArea ElectionsMultipleSearchStatus;

    public void addElection(){
        String type = electionType.getText();
        String location = electionLocation.getText();
        int year = Integer.parseInt(electionYear.getText());
        int winners = Integer.parseInt(electionNumOFWinners.getText());

        Election election = new Election(type, location, year, winners);
        list1.add(election);
//        try {
//            list1.save();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }
        hash1.add(election, election.getType().length());

    }

    public void SearchElectionType(){
//        try {
//            list1.load();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }
        String type  = searchElectionType.getText();
        Election elFound = searchElections(hash1, type);
        assert elFound != null;
//        electionTypeSearchStatus.setText(elFound.toString());
        System.out.println(elFound.toString());

    }

    public void updateElections(){

        int index = Integer.parseInt(updateElectionByIndex.getText());

        String type = updateElectionType.getText();
        String location = updateElectionLocation.getText();
        int year = Integer.parseInt(updateElectionYears.getText());
        int winners = Integer.parseInt(updateElectionNumOfWinners.getText());

        Election election = new Election(type, location, year, winners);
        list1.updateByIndex(index, election);
//        try {
//            list1.save();
//        }
//        catch (Exception e){
//            System.out.println("Error");
//        }

    }

    public void deleteElection(){
        int index = Integer.parseInt(deleteElectionByIndex.getText());
        if (index > list1.size()-1 || index < 0)
            System.out.println("Index is wrong, try again");
        else {
            list1.removeByIndex(index);
//            try {
//                list1.save();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
        }
    }

    public void SearchMultipleElections(){
        int winners = Integer.parseInt(ElectionsWinnersMultipleSearch.getText());
        LL<Election> elections = new LL<Election>();

//        for (int i = 0; i > list3.size(); i++){
//            if (list3.get(i).getDob() == dob)
//                politicians.add(list3.get(i));
//        }

        for (Election e : list1){
            if (e.getWinners() == winners)
                elections.add(e);
        }

        try {
            elections.selectionSort(elections);
        }
        catch (Exception e){
            System.out.println("Error");
        }

//        System.out.println(elections.show());
        ElectionsMultipleSearchStatus.setText(elections.show());

    }




    /////////////////////////////////////// Candidate //////////////////////////////////////////

    @FXML
    TextField candidateElection;
    @FXML
    TextField candidatePolitianName;
    @FXML
    TextField candidateNumOfVotes;
    @FXML
    TextField candidateParty;
    @FXML
    TextField CandidateUpdateIndex;
    @FXML
    TextField updateCandidateElection;
    @FXML
    TextField updateCandidatePolititanName;
    @FXML
    TextField updateCandidateNumOfVotes;
    @FXML
    TextField updateCandidateParty;
    @FXML
    TextField deleteCandidateByElection;
    @FXML
    TextField deleteCandidateByIndex;
    @FXML
    TextField deleteCandidateStatus;


    public void addCandidate(){



//        String electionType = candidateElection.getText();
//        String politicianName = candidatePolitianName.getText();
//        int votes = Integer.parseInt(candidateNumOfVotes.getText());
//        String party = candidateParty.getText();
//
//        Election result = searchElections(hash1, electionType);
//        Politician result1 = searchPoliticians(hash3, politicianName);
//
//        if (result != null && result1 != null){
//            Candidate candidate = new Candidate(politicianName, votes, party);
//            result.addCandidate(candidate);
//            list2.add(candidate);
//            try {
//                list1.save();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
//        }

        int electionIndex = Integer.parseInt(candidateElection.getText());
        String politicianName = candidatePolitianName.getText();
        int votes = Integer.parseInt(candidateNumOfVotes.getText());
        String party = candidateParty.getText();

        Politician result1 = searchPoliticians(hash3, politicianName);

        if (list1.get(electionIndex) != null && result1 != null){
            Candidate candidate = new Candidate(politicianName, votes, party);
            list1.get(electionIndex).addCandidate(candidate);
            list2.add(candidate);
//            try {
//                list1.save();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
        }


    }

    public void deleteCandidate(){

//        int index = Integer.parseInt(deleteCandidateByIndex.getText());
//        String electionType = deleteCandidateByElection.getText();
//
//        Election result = searchElections(hash1, electionType);
//
//
//        if (result != null) {
//            if (index > result.getCandidates().size() - 1 || index < 0)
//                System.out.println("Index is wrong, try again");
//            else{
//                result.getCandidates().removeByIndex(index);
//                try {
//                    list1.save();
//                }
//                catch (Exception e){
//                    System.out.println("Error");
//                }
//            }
//        }



        int index = Integer.parseInt(deleteCandidateByIndex.getText());
        int electionIndex = Integer.parseInt(deleteCandidateByElection.getText());



        if (list1.get(electionIndex) != null) {
            if (index > list1.get(electionIndex).getCandidates().size() - 1 || index < 0)
                System.out.println("Index is wrong, try again");
            else{
                list1.get(electionIndex).getCandidates().removeByIndex(index);
//                try {
//                    list1.save();
//                }
//                catch (Exception e){
//                    System.out.println("Error");
//                }
            }
        }

    }

    public void updateCandidate(){
//        int index = Integer.parseInt(CandidateUpdateIndex.getText());
//        String electionType = updateElectionType.getText();
//        String politicianName = updateCandidatePolititanName.getText();
//        int votes = Integer.parseInt(updateCandidateNumOfVotes.getText());
//        String party = updateCandidateParty.getText();
//
//        Election result = searchElections(hash1, electionType);
//        Politician result1 = searchPoliticians(hash3, politicianName);
//
//        if (result != null && result1 != null) {
//            if (index > result.getCandidates().size() - 1 || index < 0)
//                System.out.println("Index is wrong, try again");
//            else{
//                result.getCandidates().removeByIndex(index);
//                try {
//                    list1.save();
//                }
//                catch (Exception e){
//                    System.out.println("Error");
//                }
//            }
//        }

        int index = Integer.parseInt(CandidateUpdateIndex.getText());
        int electionIndex = Integer.parseInt(updateCandidateElection.getText());
        String politicianName = updateCandidatePolititanName.getText();
        int votes = Integer.parseInt(updateCandidateNumOfVotes.getText());
        String party = updateCandidateParty.getText();

        Candidate candidate = new Candidate(politicianName, votes, party);

        list1.get(electionIndex).getCandidates().set(index, candidate);
//        Politician result1 = searchPoliticians(hash3, politicianName);
//
//
//        if (list1.get(electionIndex) != null) {
//            if (index > list1.get(electionIndex).getCandidates().size() - 1 || index < 0)
//                System.out.println("Index is wrong, try again");
//            else{
//                list1.get(electionIndex).getCandidates().set(index, candidate);
////                try {
////                    list1.save();
////                }
////                catch (Exception e){
////                    System.out.println("Error");
////                }
//            }
//        }

    }





    /////////////////////////////////////// Show //////////////////////////////////////////

    @FXML
    TextField winnersElectionIndex;
    @FXML
    TextField showWinningCandidateStatus;
    @FXML
    TextArea showStatus;



    public void showWinningCandidate(){
        int index = Integer.parseInt(winnersElectionIndex.getText());
        String elections = list1.get(index).getType().toString();
        Election result = searchElections(hash1, elections);
        if (result != null){
//            try {
//                list1.load();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
            try {
                result.getCandidates().insertionSort(result.getCandidates());
            }
            catch (Exception e){
                System.out.println("There was an error");
            }
        }

        assert result != null;
//        showWinningCandidateStatus.setText(result.getCandidates().toString());
        System.out.println(result.getCandidates().show());

    }

    public void show(){
        try {
//            try {
//                list1.load();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }
//
//            try {
//                list3.load();
//            }
//            catch (Exception e){
//                System.out.println("Error");
//            }

            list3.selectionSort(list3);
            list1.selectionSort(list1);
        }
        catch (Exception e){
            System.out.println("There was an error");
        }

        showStatus.setText("Politicians" + "\n" + list3.show() + "\n" + "-----------" + "\n" +"Elections" + "\n" + list1.show());

    }
}
