package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.*;


public class Controller {

    FloorLL list = new FloorLL();
    AisleLL list2 = new AisleLL();
    ShelfLL list3 = new ShelfLL();
    PalletLL list4 = new PalletLL();

    ///////////////////////////////////////////////////////////////////////////////////////

    public void initialize(){
        /**
         * This method loads the lists.
         */
        try {
            list.load();
        }
        catch (Exception e){
            System.out.println("There was a problem");
        }

        loadList2();
        loadList3();
        loadList4();

    }

    public void loadList2(){
        /**
         * In this method we check if the floor linked list exists.
         * If yes then we check if the list of aisle exists.
         * If yes then we iterate through the list of floors and we add each aisle in each floor to list2
         */
        if(list.head != null){
            FloorNode floorNode = list.head;
            while (floorNode != null){
                AisleNode aisleNode = floorNode.getContents().getAisles().head;
                while (aisleNode != null){
                    list2.insert(aisleNode.getContents());
                    aisleNode = aisleNode.next;
                }
                floorNode = floorNode.next;
            }
        }
    }


    public void loadList3(){
        /**
         * In this method we check if the floor linked list exists.
         * If yes then we check if the list of aisle exists.
         * If yes then we check if the list of shelves exists.
         * If yes then we iterate through the list of floors, aisles and shelves and we add each shelf in each aisle in each floor to list3
         */
        if(list.head != null && list2.head != null){
            FloorNode floorNode = list.head;
            while (floorNode != null){
                AisleNode aisleNode = floorNode.getContents().getAisles().head;
                while (aisleNode != null) {
                    ShelfNode shelfNode = aisleNode.getContents().getShelves().head;
//                    list2.insert(aisleNode.getContents());
//                    aisleNode = aisleNode.next;
                    while (shelfNode != null) {
                        list3.insert(shelfNode.getContents());
                        shelfNode = shelfNode.next;
                    }
                    aisleNode = aisleNode.next;
                }
                floorNode = floorNode.next;
            }
        }
    }

    public void loadList4(){
        /**
         * In this method we check if the floor linked list exists.
         * If yes then we check if the list of aisle exists.
         * If yes then we check if the list of shelves exists.
         * If yes then we check if the list of pallets exists.
         * If yes then we iterate through the list of floors, aisles, shelves and pallets and we add each pallet in each shelf in each aisle in each floor to list4
         */

        if(list.head != null && list2.head != null && list3 != null){
            FloorNode floorNode = list.head;
            while (floorNode != null){
                AisleNode aisleNode = floorNode.getContents().getAisles().head;
                while (aisleNode != null) {
                    ShelfNode shelfNode = aisleNode.getContents().getShelves().head;
//                    list2.insert(aisleNode.getContents());
//                    aisleNode = aisleNode.next;
                    while (shelfNode != null) {
                        PalletNode palletNode = shelfNode.getContents().getPallets().head;
//                        list3.insert(shelfNode.getContents());
//                        shelfNode = shelfNode.next;

                        while (palletNode != null) {
                            list4.insert(palletNode.getContents());
                            palletNode = palletNode.next;
                        }
                        shelfNode = shelfNode.next;
                    }
                    aisleNode = aisleNode.next;
                }
                floorNode = floorNode.next;
            }
        }
    }


//    public static String show(FloorLL list) {
//        FloorNode node = list.head;
//        String name = "";
//        while (node.next != null) {
//            name += node.contents + "\n";
//            node = node.next;
//        }
//        name += node.contents;
//        return name;
//    }
//
//    /*zzzzzz*//*zzzzzz*/
//    public static String show(AisleLL list) {
//        AisleNode node = list.head;
//        String name = "";
//        while (node.next != null) {
//            name += node.contents + "\n";
//            node = node.next;
//        }
//        name += node.contents;
//        return name;
//    }

//
//    public static String show(ShelfLL list) {
//        ShelfNode node = list.head;
//        String name = "";
//        while (node.next != null) {
//            name += node.contents + "\n";
//            node = node.next;
//        }
//        name += node.contents;
//        return name;
//    }
//
//    public static String show(PalletLL list) {
//        PalletNode node = list.head;
//        String name = "";
//        while (node.next != null) {
//            name += node.contents + "\n";
//            node = node.next;
//        }
//        name += node.contents;
//        return name;
//    }


    ///////////////////////////////////////////////////////////////////////////////////////


//////////////////////////////////////////////Floors/////////////////////////////////////////

    @FXML
    TextField floorNumber;
    @FXML
    TextField floorSecurityLevel;
    @FXML
    TextField floorID;
    @FXML
    TextField floorLevel;
    @FXML
    TextField floorTemperature;
    @FXML
    javafx.scene.control.Button addFloor;
    @FXML
    TextField floorRemoveNumber;
    @FXML
    TextField floorRemoveID;
    @FXML
    javafx.scene.control.Button floorRemoveNumberButton;
    @FXML
    javafx.scene.control.Button floorRemoveIDButton;
    @FXML
    TextField floorSearchNumber;
    @FXML
    javafx.scene.control.Button floorSearchNumberButton;
    @FXML
    TextField floorSearchNumberResult;
    @FXML
    TextField floorSearchTemperature;
    @FXML
    javafx.scene.control.Button floorSearchTemperatureButton;
    @FXML
    TextField floorSearchTemperatureResult;
    @FXML
    javafx.scene.control.Button floorReset;
    @FXML
    javafx.scene.control.Button floorSize;
    @FXML
    TextField floorSizeDisplay;
    @FXML
    javafx.scene.control.Button contents1;
    @FXML
    TextArea contentsDisplay1;
    @FXML
    TextArea floorAddError;
    @FXML
    TextArea floorRemoveByNumberError;
    @FXML
    TextArea floorRemoveByIDError;
    @FXML
    TextArea floorSearchByNumberError;
    @FXML
    TextArea floorSearchByTemperatureError;
    @FXML
    TextArea listSaveError1;



//    public void saveList() {
//        try {
//            list.save();
//
//        } catch (Exception e) {
//            listSaveError1.setText("There was a problem");
//            listSaveError2.setText("There was a problem");
//            listSaveError3.setText("There was a problem");
//            listSaveError4.setText("There was a problem");
//        }
//    }


    public void floorAdding() {
        /**
         * In this method we are taking the text from the appropriate text fields to create a floor.
         * If the security level is not high or medium or low then we set an error message to the error text field.
         * else we create the floor with the entered values and insert it into the linked list and we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         * If the floor is added we set the message 'Added successfully' error text field.
         */
        int num = Integer.parseInt(floorNumber.getText());
        String sLevel = floorSecurityLevel.getText();
        String id = floorID.getText();
        String level = floorLevel.getText();
        double temp = Double.parseDouble(floorTemperature.getText());

        if (!(sLevel.equals("high") || sLevel.equals("medium") || sLevel.equals("low"))) {
            floorAddError.setText("You can only choose high, medium or low");
        }

        Floor floor = new Floor(num, id, level, sLevel, temp);
        list.insert(floor);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError1.setText("There was a problem");
        }


        floorAddError.setText("Added successfully");

    }

    public void floorRemovingByNumber() {
        /**
         * In this method we are taking the number typed by the user from the appropriate text field.
         * Then we are calling the removeByNumber method from the linked list class to remove the floor by number.
         * Then we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         */

        int num1 = Integer.parseInt(floorRemoveNumber.getText());
        list.removeByNumber(num1);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError1.setText("There was a problem");
        }

    }

    public void floorRemovingByID() {
        /**
         * In this method we are taking the identifier typed by the user from the appropriate text field.
         * Then we are calling the removeByIdentifier method from the linked list class to remove the floor by identifier.
         * Then we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         */
        String id = floorRemoveID.getText();
        list.removeByIdentifier(id);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError1.setText("There was a problem");
        }

    }

    public void floorSearchingByNumber() {
        /**
         * In this method we are taking the value typed by the user from the appropriate text field.
         * Then we are setting the value of the searchByNumber method from the linked list class to to the appropriate text field
         */

        int num2 = Integer.parseInt(floorSearchNumber.getText());
        floorSearchNumberResult.setText(list.searchByNumber(num2).toString());

    }

    public void floorSearchingByTemperature() {
        /**
         * In this method we are taking the value typed by the user from the appropriate text field.
         * Then we are setting the value of the searchByTemperature method from the linked list class to to the appropriate text field
         */
        double num2 = Double.parseDouble(floorSearchTemperature.getText());
        floorSearchTemperatureResult.setText(list.searchByTemperature(num2).toString());

    }

    public void floorResetting() {
        /**
         * In this method we are calling the reset function from the linked list class and using it to reset the floor list.
         * The we are saving the list.
         * If the list doesn't save we set an error message to the save error text field.
         */
        list.reset(list);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError1.setText("There was a problem");
        }

    }

    public void floorSizing() {
        /**
         * In this method we are setting the value of the size method from the linked list class to the appropriate field.
         */
        floorSizeDisplay.setText("The number of current floors is " + list.size());

    }

//    public String sh1() {
//        String man = list2.head.getContents().toString();
//        while (list2.head != null && list2.head.next != null) {
//            list2.head = list2.head.next;
//            return man + list2.head.getContents().toString();
//        }
//        return man;
//    }

    public void showing1() {
        /**
         * In this method we are displaying all contents of the warehouse in the appropriate text field.
         */


        contentsDisplay1.setText("Floors" + "\n" + list.show() + "\n" + "Aisles" + "\n" + list2.show() + "\n" + "Shelves" + "\n" + list3.show() + "\n" + "Pallets" + "\n" + list4.show() + "\n");
     // System.out.println("Floors" + "\n" + list.show() + "\n" + "Aisles" + "\n" + sh1() + "\n" + "Shelves" + "\n" + list3.show() + "\n" + "Pallets" + "\n" + list4.show() + "\n");

    }


//////////////////////////////////////////////Aisles/////////////////////////////////////////


    @FXML
    TextField aisleFloorNumber;
    @FXML
    TextField aisleIdentifier;
    @FXML
    TextField aisleLength;
    @FXML
    TextField aisleWidth;
    @FXML
    javafx.scene.control.Button addAisle;
    @FXML
    TextField aisleFloorNumRemove;
    @FXML
    TextField aisleRemoveID;
    @FXML
    javafx.scene.control.Button aisleRemoveIDButton;
    @FXML
    TextField aisleFloorNumSearch;
    @FXML
    TextField aisleSearchID;
    @FXML
    javafx.scene.control.Button aisleSearchIDButton;
    @FXML
    TextField aisleSearchIDResult;
    @FXML
    javafx.scene.control.Button aisleReset;
    @FXML
    TextField aisleFloorNumSize;
    @FXML
    javafx.scene.control.Button aisleSize;
    @FXML
    TextField aisleSizeDisplay;
    @FXML
    javafx.scene.control.Button contents2;
    @FXML
    TextArea contentsDisplay2;
    @FXML
    TextArea aisleAddError;
    @FXML
    TextArea aisleRemoveByIDError;
    @FXML
    TextArea aisleSearchByIDError;
    @FXML
    TextArea listSaveError2;


    public void aisleAdding() {
        /**
         * In this method we are declaring a string called id.
         * Also we are making the user choose a floor by number and checking if the chosen floor is not null.
         * if yes then we declare a boolean called goodID and set it to false.
         * Then we get the aisle identifier from the appropriate text field.
         * Then we declare a boolean called flag and set it to false.
         * If the length of the id is 2 and the first character is not a number and the second one is a number then flag is true.
         * We declare a node and give it the value of list2.head.
         * If node is not null and flag is true we use node to iterate in the node chain and check if any aisles in the nodes have the same
         * id that the user typed.
         * If yes then flag is set to false.
         * Then we create the aisle and save the list and if the list doesn't save we set an error message to the error text field.
         * If the floor doesn't exist we add an error message to the error text field
         */
        int floor = Integer.parseInt(aisleFloorNumber.getText());
        Floor floorFound = list.searchByNumber(floor);

        //Floor floorFound = chooseFloor();
        String id;
        if (floorFound != null) {
            boolean goodID = false;

        //    do {


                id = aisleIdentifier.getText();


//        AisleNode node = head;
                boolean flag = false;


                // if (id.startsWith("[0-9]") || !id.endsWith("[0-9]") || id.length() != 2){
                if (id.length() == 2 && !Character.isDigit(id.charAt(0)) && Character.isDigit(id.charAt(1))) {
                    flag = true;
                }


                    AisleNode node = list2.head;
                    while (node != null && flag == true) {
                        if (node.getContents().getIdentifier().equalsIgnoreCase(id)) {
//                      System.out.println("Please enter another identifier");
//                    id = input.next();
                            flag = false;
                        }
                        node = node.next;
                    }
                    goodID = flag;
                    //  }
                    //    while (goodID == false);


                    int length = Integer.parseInt(aisleLength.getText());
                    int width = Integer.parseInt(aisleWidth.getText());
                    if (flag == true) {
                        Aisle aisle = new Aisle(id, length, width);
                        list2.insert(aisle);
                        floorFound.getAisles().insert(aisle);
                        aisleAddError.setText("Added successfully");
                        try {
                            list.save();

                        } catch (Exception e) {
                            listSaveError2.setText("There was a problem");
                        }
                    }
                    else
                        floorAddError.setText("The ID doesn't meet the requirements");

        } else
            aisleAddError.setText("This floor is not present");


    }


    public void aisleRemovingByID() {
        /**
         * In this method we are making the user choose a floor by number and checking if the chosen floor is not null.
         * If yes then we get the aisles of the chosen floor and we remove the aisle that has the chosen id and save the list.
         * If there is no aisle with such an id we set an error message to the error text field.
         */
        int floor = Integer.parseInt(aisleFloorNumRemove.getText());
        Floor floorFound = list.searchByNumber(floor);
        if (floorFound != null) {
            String id = aisleRemoveID.getText();
            floorFound.getAisles().removeByIdentifier(id);
            list2.removeByIdentifier(id);
            try {
                list.save();

            } catch (Exception e) {
                listSaveError2.setText("There was a problem");
            }

        }
        else
            aisleRemoveByIDError.setText("This floor is not present");
    }


    public void aisleSearchingByID() {
        /**
         * In this method we are making the user choose a floor by number and checking if the chosen floor is not null.
         * If yes then get the aisles of the chosen floor and search for the aisle that has the chosen id.
         * If there is no aisle with such an id we set an error message to the error text field.
         */
        int floor = Integer.parseInt(aisleFloorNumSearch.getText());
        Floor floorFound = list.searchByNumber(floor);
        if (floorFound != null) {
            String id = aisleSearchID.getText();
            aisleSearchIDResult.setText(floorFound.getAisles().searchByIdentifier(id).toString());
        }
        else
            aisleSearchByIDError.setText("This floor is not present");
    }

    public void aisleResetting() {
        /**
         * In this method we are calling the reset function from the linked list class and using it to reset the aisle list.
         * Then we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         */
        list2.reset(list2);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError2.setText("There was a problem");
        }

    }

    public void aisleSizing() {
        /**
         * In this method we are making the user choose a floor by number and checking if the chosen floor is not null.
         * if yes then we get the aisles and set their size to the appropriate text field.
         */
        int floor = Integer.parseInt(aisleFloorNumSize.getText());
        Floor floorFound = list.searchByNumber(floor);
        if (floorFound != null) {
            aisleSizeDisplay.setText("The number of current aisles is " + floorFound.getAisles().size());

        }

    }

        public void showing2(){
            /**
             * In this method we are displaying all contents of the warehouse in the appropriate text field.
             */
            contentsDisplay2.setText("Floors" + "\n" + list.show() + "\n" + "Aisles" + "\n" + list2.show() + "\n" + "Shelves" + "\n" + list3.show() + "\n" + "Pallets" + "\n" + list4.show() + "\n");

        }

//////////////////////////////////////////////Shelves/////////////////////////////////////////

        @FXML
        TextField shelfFloorNumber;
        @FXML
        TextField shelfAisleIdentifier;
        @FXML
        TextField shelfNumber;
        @FXML
        javafx.scene.control.Button addShelf;

        @FXML
        TextField shelfFloorNumRemove;
        @FXML
        TextField shelfAisleIDRemove;


        @FXML
        TextField removeShelfNumber;
        @FXML
        javafx.scene.control.Button removeShelfNumberButton;


        @FXML
        TextField shelfFloorNumSearch;
        @FXML
        TextField shelfAisleIDSearch;


        @FXML
        TextField searchShelfNumber;
        @FXML
        javafx.scene.control.Button searchShelfNumberButton;
        @FXML
        TextField searchShelfNumberResult;
        @FXML
        javafx.scene.control.Button shelfReset;


        @FXML
        TextField shelfFloorNumSize;
        @FXML
        TextField shelfAisleIDSize;


        @FXML
        javafx.scene.control.Button shelfSize;
        @FXML
        TextField shelfSizeDisplay;
        @FXML
        javafx.scene.control.Button contents3;
        @FXML
        TextArea contentsDisplay3;
        @FXML
        TextArea shelfAddError;
        @FXML
        TextArea shelfRemoveByNumberError;
        @FXML
        TextArea shelfSearchByNumberError;
        @FXML
        TextArea listSaveError3;


    public void shelfAdding(){
        /**
         * In this method we making the user choose a floor by number and an aisle by id and checking if the chosen aisle is not null
         * if yes then:
         * We take the text from the appropriate text fields to create a shelf.
         * We create the shelf with the entered values and insert it into the linked list and we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         * If the shelf is added we set the message 'Added successfully' error text field.
         * If the aisle doesn't exist we add an error message to the error text field
         */

        //Aisle aisleFound = chooseAisle();
        int floor = Integer.parseInt(shelfFloorNumber.getText());
        String aisle = shelfAisleIdentifier.getText();
        Floor floor2 = list.searchByNumber(floor);
        Aisle aisleFound = floor2.getAisles().searchByIdentifier(aisle);
        if (aisleFound != null) {

            int num = Integer.parseInt(shelfNumber.getText());
            Shelf shelf = new Shelf(num);
            list3.insert(shelf);

            aisleFound.getShelves().insert(shelf);
            shelfAddError.setText("Successfully added");
            try {
                list.save();

            } catch (Exception e) {
                listSaveError3.setText("There was a problem");
            }
        }
        else
            shelfAddError.setText("This aisle is not present");

        }


        public void shelfRemovingByNumber(){
            /**
             * In this method we making the user choose a floor by number and an aisle by id and checking if the chosen aisle is not null
             * If yes then we get the shelves in the chosen aisle and we remove the shelf that has the chosen number.
             * Then we save the list.
             * If the list doesn't save we set an error message to the save error text field.
             */


            int floor = Integer.parseInt(shelfFloorNumRemove.getText());
            String aisle = shelfAisleIDRemove.getText();
            Floor floor2 = list.searchByNumber(floor);
            Aisle aisleFound = floor2.getAisles().searchByIdentifier(aisle);
            if (aisleFound != null) {

                int num = Integer.parseInt(removeShelfNumber.getText());
                aisleFound.getShelves().removeByNumber(num);
                list3.removeByNumber(num);
                try {
                    list.save();

                } catch (Exception e) {
                    listSaveError3.setText("There was a problem");
                }
            }
            else
                shelfRemoveByNumberError.setText("This aisle is not present");

        }



        public void shelfSearchingByNumber(){
            /**
             * In this method we making the user choose a floor by number and an aisle by id and checking if the chosen aisle is not null
             * if yes then:
             * We take the value typed by the user from the appropriate text field.
             * Then we are setting the value of the searchByNumber method from the linked list class to to the appropriate text field
             */

            int floor = Integer.parseInt(shelfFloorNumSearch.getText());
            String aisle = shelfAisleIDSearch.getText();
            Floor floor2 = list.searchByNumber(floor);
            Aisle aisleFound = floor2.getAisles().searchByIdentifier(aisle);
            if (aisleFound != null){
                int num = Integer.parseInt(searchShelfNumber.getText());
                searchShelfNumberResult.setText(aisleFound.getShelves().searchByNumber(num).toString());
                searchShelfNumberResult.setText(list3.searchByNumber(num).toString());
                //   System.out.println(list2.searchByIdentifier(id));
            }
            else
                shelfSearchByNumberError.setText("This aisle is not present");

        }

        public void shelfResetting(){
            /**
             * In this method we are calling the reset function from the linked list class and using it to reset the shelf list.
             * Then we save the list.
             * If the list doesn't save we set an error message to the save error text field.
             */
            list3.reset(list3);
            try {
                list.save();

            } catch (Exception e) {
                listSaveError3.setText("There was a problem");
            }

        }

        public void shelfSizing(){
            /**
             * In this method we making the user choose a floor by number and an aisle by id and checking if the chosen aisle is not null
             * if yes then we get the shelves and set their size to the appropriate text field.
             */
            int floor = Integer.parseInt(shelfFloorNumSize.getText());
            String aisle = shelfAisleIDSize.getText();
            Floor floor2 = list.searchByNumber(floor);
            Aisle aisleFound = floor2.getAisles().searchByIdentifier(aisle);
            if (aisleFound != null) {
                shelfSizeDisplay.setText("The number of current shelves is " + aisleFound.getShelves().size());
            }
        }

        public void showing3(){
            /**
             * In this method we are displaying all contents of the warehouse in the appropriate text field.
             */
            contentsDisplay3.setText("Floors" + "\n" + list.show() + "\n" + "Aisles" + "\n" + list2.show() + "\n" + "Shelves" + "\n" + list3.show() + "\n" + "Pallets" + "\n" + list4.show() + "\n");

        }

//////////////////////////////////////////////Pallets/////////////////////////////////////////



    @FXML
    TextField palletFloorNumber;
    @FXML
    TextField palletAisleIdentifier;
    @FXML
    TextField palletShelfNumber;
    @FXML
    TextField palletTypeOfGoods;
    @FXML
    TextField palletNumberOfGoods;
    @FXML
    TextField palletMinStorageTemp;
    @FXML
    TextField palletMaxStorageTemp;
    @FXML
    TextField palletCoordinate1;
    @FXML
    TextField palletCoordinate2;
    @FXML
    javafx.scene.control.Button addPallet;

    @FXML
    TextField palletFloorNumRemove;
    @FXML
    TextField palletAisleIDRemove;
    @FXML
    TextField palletShelfNumRemove;


    @FXML
    TextField removePalletNumOfGoods;
    @FXML
    javafx.scene.control.Button removePalletNumOfGoodsButton;


    @FXML
    TextField palletNumFloorNumSearch;
    @FXML
    TextField palletNumAisleIDSearch;
    @FXML
    TextField palletNumShelfNumSearch;


    @FXML
    TextField searchPalletNumberOfGoods;
    @FXML
    javafx.scene.control.Button searchPalletNumberOfGoodsButton;
    @FXML
    TextField searchPalletNumberOfGoodsResult;


    @FXML
    TextField palletTypeFloorNumSearch;
    @FXML
    TextField palletTypeAisleIDSearch;
    @FXML
    TextField palletTypeShelfNumSearch;


    @FXML
    TextField searchPalletTypeOfGoods;
    @FXML
    javafx.scene.control.Button searchPalletTypeOfGoodsButton;
    @FXML
    TextField searchPalletTypeOfGoodsResult;



    @FXML
    javafx.scene.control.Button palletReset;


    @FXML
    TextField palletFloorNumSize;
    @FXML
    TextField palletAisleIDSize;
    @FXML
    TextField palletShelfNumSize;


    @FXML
    javafx.scene.control.Button palletSize;
    @FXML
    TextField palletSizeDisplay;
    @FXML
    javafx.scene.control.Button contents4;
    @FXML
    TextArea contentsDisplay4;
    @FXML
    TextArea palletAddError;
    @FXML
    TextArea palletRemoveByNumOfGoodsError;
    @FXML
    TextArea palletSearchByNumOfGoodsError;
    @FXML
    TextArea palletSearchByTypeOfGoodsError;
    @FXML
    TextArea listSaveError4;





    public void palletAdding(){
        /**
         * In this method we are making the user choose a floor by number, an aisle by id and a shelf by number and checking if the chosen shelf is not null.
         * if yes then:
         * Once we get all the values from the text fields we declare an integer called palletSize and make it equal to the size of pallets.
         * Then we check if palletSize is bigger or equal to the aisle area.
         * If yes then the shelf is full.
         * If no then we declare an integer called position and we give it the value of palletSize.
         * Then we give cor1 the value of position / aLength and cor2 the value of position % aLength.
         * Then we create the pallet and save the list.
         * If the pallet is added we add 'Successfully added' to the error text field.
         * If the list doesn't save we set an error message to the save error text field.
         * If the shelf doesn't exist we add an error message to the error text field.
         */

        int floor = Integer.parseInt(palletFloorNumber.getText());
        String aisle = palletAisleIdentifier.getText();
        int shelf = Integer.parseInt(palletShelfNumber.getText());
        Floor floor2 = list.searchByNumber(floor);
        Aisle aisle2 = floor2.getAisles().searchByIdentifier(aisle);
        Shelf shelfFound = aisle2.getShelves().searchByNumber(shelf);
        if (shelfFound != null) {
            int number = Integer.parseInt(palletNumberOfGoods.getText());
            String type = palletTypeOfGoods.getText();
            double minTemp = Double.parseDouble(palletMinStorageTemp.getText());
            double maxTemp = Double.parseDouble(palletMaxStorageTemp.getText());
            int cord1 = Integer.parseInt(palletCoordinate1.getText());
            int cord2 = Integer.parseInt(palletCoordinate2.getText());
            int aLength = aisle2.getLength();
            int aWidth = aisle2.getWidth();
            int palletSize = shelfFound.getPallets().size();

            if (palletSize >= aLength * aWidth){
                palletAddError.setText("Shelf full");
            }
            else{
                int position = palletSize;
                cord1 =  position / aLength;
                cord2 = position % aLength;
            }


            Pallet pallet = new Pallet(type, number, minTemp, maxTemp, cord2, cord1);
            list4.insert(pallet);
            shelfFound.getPallets().insert(pallet);
            palletAddError.setText("Successfully added");
            try {
                list.save();

            } catch (Exception e) {
                listSaveError4.setText("There was a problem");
            }
        }
        else
            palletAddError.setText("This shelf is not present");

    }


    public void palletRemovingByNumberOfGoods(){
        /**
         * In this method we are making the user choose a floor by number, an aisle by id and a shelf by number and checking if the chosen shelf is not null.
         * if yes then we get the pallets in the chosen shelf and we remove the pallet that has the chosen number of goods.
         * Then we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         */




        int floor = Integer.parseInt(palletFloorNumRemove.getText());
        String aisle = palletAisleIDRemove.getText();
        int shelf = Integer.parseInt(palletShelfNumRemove.getText());
        Floor floor2 = list.searchByNumber(floor);
        Aisle aisle2 = floor2.getAisles().searchByIdentifier(aisle);
        Shelf shelfFound = aisle2.getShelves().searchByNumber(shelf);
        if (shelfFound != null) {

            int num = Integer.parseInt(removePalletNumOfGoods.getText());
            shelfFound.getPallets().removeByNumberOfGoods(num);
            list4.removeByNumberOfGoods(num);
            try {
                list.save();

            } catch (Exception e) {
                listSaveError4.setText("There was a problem");
            }
        }
        else
            palletRemoveByNumOfGoodsError.setText("This shelf is not present");

    }



    public void palletSearchingByNumberOfGoods() {
        /**
         * In this method we are making the user choose a floor by number, an aisle by id and a shelf by number and checking if the chosen shelf is not null.
         * if yes then
         * We take the value typed by the user from the appropriate text field.
         * Then we are setting the value of the searchByNumberOfGoods method from the linked list class to to the appropriate text field
         */



        int floor = Integer.parseInt(palletNumFloorNumSearch.getText());
        String aisle = palletNumAisleIDSearch.getText();
        int shelf = Integer.parseInt(palletNumShelfNumSearch.getText());
        Floor floor2 = list.searchByNumber(floor);
        Aisle aisle2 = floor2.getAisles().searchByIdentifier(aisle);
        Shelf shelfFound = aisle2.getShelves().searchByNumber(shelf);
        if (shelfFound != null) {
            int num = Integer.parseInt(searchPalletNumberOfGoods.getText());
            searchPalletNumberOfGoodsResult.setText(shelfFound.getPallets().searchByNumberOfGoods(num).toString());
            searchPalletNumberOfGoodsResult.setText(list4.searchByNumberOfGoods(num).toString());
            //   System.out.println(list2.searchByIdentifier(id));
        }
        else
            palletSearchByNumOfGoodsError.setText("This shelf is not present");
    }

        public void palletSearchingByTypeOfGoods(){
            /**
             * In this method we are making the user choose a floor by number, an aisle by id and a shelf by number and checking if the chosen shelf is not null.
             * if yes then
             * We take the value typed by the user from the appropriate text field.
             * Then we are setting the value of the searchByTypeOfGoods method from the linked list class to to the appropriate text field
             */
            int floor = Integer.parseInt(palletTypeFloorNumSearch.getText());
            String aisle = palletTypeAisleIDSearch.getText();
            int shelf = Integer.parseInt(palletTypeShelfNumSearch.getText());
            Floor floor2 = list.searchByNumber(floor);
            Aisle aisle2 = floor2.getAisles().searchByIdentifier(aisle);
            Shelf shelfFound = aisle2.getShelves().searchByNumber(shelf);
            if (shelfFound != null) {
                String type = searchPalletTypeOfGoods.getText();
                searchPalletTypeOfGoodsResult.setText(shelfFound.getPallets().searchByTypeOfGoods(type).toString());
                searchPalletTypeOfGoodsResult.setText(list4.searchByTypeOfGoods(type).toString());
                //   System.out.println(list2.searchByIdentifier(id));
            }
            else
                palletSearchByTypeOfGoodsError.setText("This shelf is not present");

    }

    public void palletResetting(){
        /**
         * In this method we are calling the reset function from the linked list class and using it to reset the pallet list.
         * Then we save the list.
         * If the list doesn't save we set an error message to the save error text field.
         */
        list4.reset(list4);
        try {
            list.save();

        } catch (Exception e) {
            listSaveError4.setText("There was a problem");
        }

    }

    public void palletSizing(){
        /**
         * In this method we are making the user choose a floor by number, an aisle by id and a shelf by number and checking if the chosen shelf is not null.
         * if yes then we get the pallets and set their size to the appropriate text field.
         */
        int floor = Integer.parseInt(palletFloorNumSize.getText());
        String aisle = palletAisleIDSize.getText();
        int shelf = Integer.parseInt(palletShelfNumSize.getText());
        Floor floor2 = list.searchByNumber(floor);
        Aisle aisle2 = floor2.getAisles().searchByIdentifier(aisle);
        Shelf shelfFound = aisle2.getShelves().searchByNumber(shelf);
        if (shelfFound != null) {
            palletSizeDisplay.setText("The number of current pallets is " + shelfFound.getPallets().size());
        }
    }

    public void showing4(){
        /**
         * In this method we are displaying all contents of the warehouse in the appropriate text field.
         */
        contentsDisplay4.setText("Floors" + "\n" + list.show() + "\n" + "Aisles" + "\n" + list2.show() + "\n" + "Shelves" + "\n" + list3.show() + "\n" + "Pallets" + "\n" + list4.show() + "\n");

    }

    }
