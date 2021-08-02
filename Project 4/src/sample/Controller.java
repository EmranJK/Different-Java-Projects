// create lines in the for loop
// add a parameter for the landmark type to the replication then and you should be working with nodes of that type

// find the path between two landmarks and color it by road, (make the map black and white in the back ground with the roads as a different color)
// -1 for anything that isn't a road, 0 for road.
// Make an Arraylist integers (negative value where the corresponding pixel isn't a part of the road, 0 for the corresponding pixel
// that is part of the road)
// pg 46 graphs
// landmarks.txt change the connections.
// leave the breadth first and it returns a list of nodes and write a different method similar to solution path.
// or change the breadth first search return a cost path, and make minor changes to solution path.
// page 41

package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import java.awt.event.MouseAdapter;
import java.io.*;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    @FXML
    ImageView picture;

    @FXML
    TextArea source;

    @FXML
    TextArea destination;

    @FXML
    TextArea directions;



//    public void getImage(){
//        String way = path.getText();
//        Image img=new Image(getClass().getResource(way).toExternalForm(),10,10,true,false);
//        picture.setImage(img);
//    }

    private ArrayList<Landmark> landmarks = new ArrayList<Landmark>();
    private ArrayList<GraphNodeAL2<Landmark>> nodes = new ArrayList<GraphNodeAL2<Landmark>>();
    private GraphNodeAL2 <Landmark> startNode;
    private Landmark destLandmark;
    private ArrayList<Integer> pixels;
    java.awt.Color white = new java.awt.Color(255,255,255);


    public ArrayList<Landmark> read() {
        /**
         * In this method we create a new file for Landmarks.txt, then we create a try and catch statement.
         * In the statement we a new bufferReader for file and we create a string called fileLine.
         * while fileLine with the value of bufferReader.readLine() is not null the we create a string array called token
         * in the array we will have all the lines components in file split by the comma.
         * Then we check if token[0] is equal to "Landmark". If yes then we create a new Landmark l with tokens from 0 to 4.
         * Then we add l to landmarks arrayList and we add it as a graphNodeAL2 to nodes arrayList.
         * We also check if token[0] is equal to "Link". If yes then we srcNode and destNode and we make them null.
         * Then we create string src and make it token[1] and string dest and make it token[2].
         * We also create integer cost and make it token[3].
         * Then for each node in nodes if name is equal to src then we make srcNode = i.
         * And if name is equal to dest then we make destNode = i.
         * Outside the loop we check if srcNode and destNode are not equal to null.
         * If yes the we connect them directly.
         * At the end we return the arrayList of landmarks.
         */

        File file = new File("Landmarks.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {
                String[] token = fileLine.split(", ");
                if (token[0].equalsIgnoreCase("Landmark")) {
                    Landmark l = new Landmark(token[0], token[1], token[2], (Integer.parseInt(token[3])), Integer.parseInt(token[4]));
                    landmarks.add(l);
                    nodes.add(new GraphNodeAL2(l));
                }
                if (token[0].equalsIgnoreCase("Link")){
                    GraphNodeAL2<Landmark> srcNode, destNode;
                    srcNode = destNode = null;
                    String src = token[1];
                    String dest = token[2];
                    int cost = Integer.parseInt(token[3]);
                    for (GraphNodeAL2 i : nodes){
                        if (((Landmark)i.data).getName().equalsIgnoreCase(src)){
                            srcNode = i;
                        }
                        if (((Landmark)i.data).getName().equalsIgnoreCase(dest)){
                            destNode = i;
                        }
                    }
                    if (srcNode != null && destNode != null)
                    srcNode.connectToNodeDirected(destNode, cost);
                }
            }

        } catch (Exception e) {

        }
        //System.out.println(landmarks);
        return landmarks;

    }

    public void blackWhite(){

        /**
         * For this method we make pixels equal to a new arrayList of integers.
         * Then we create img and make it equal to image in the imageView picture.
         * Then we create a writableImage and make it equal to new WritableImage with img pixel reader, length and width as parameters.
         * Then we create PixelReader pr and make it equal to img pixelReader.
         * The we create a nested for loop that will check get the RGB of every pixels in every raw and column of the image.
         * We check if a pixel is within a certain RGB range, if yes then we turn it black and add -1 to pixels arrayList.
         * Else we turn it white and add 0 to pixels arrayList.
         * Then we set the image as wimg.
         */
        pixels = new ArrayList<Integer>();
        Image img = picture.getImage();
        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
        PixelReader pr = img.getPixelReader();
        for(int r=0;r<img.getHeight();r++)
            for(int c=0;c<img.getWidth();c++)
            {
                double red=pr.getColor(c,r).getRed(); //0.0-1.0
                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
                double grey = (red + green + blue) / 3;
                if (red * 255 < 245 && green * 255 < 245 && blue * 255 < 245){
                    wimg.getPixelWriter().setColor(c,r,Color.BLACK);
                    pixels.add(-1);
                }
                else{
                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
                    pixels.add(0);
                }
            }
        //picture.setImage(wimg);
     //   System.out.println(pixels);
    }


    public void initialize(){
        read();
        testRout();
        loadImage();
        locations();
    }


    public void bfs(){
        /**
         * For this method we create a List called returnList.
         * Then we make it equal to Search.findPathBreathFirst(startNode, destLandmark).
         * We also create a GraphNodeAL2 of type Landmark called tn.
         * Then we remove children of picture casted to pane if x is instance of Line
         * Then for each node in returnList we create Line l equal to null and we check if tn is null.
         * If yes then we add line l to the children of picture Pane.
         * Then we make tn equal to al
         */
        System.out.println("Solution path");
        System.out.println("--------------------------------------------------------------");
//        List<GraphNodeAL2<?>> path=findPathDepthFirst(startNode,null,destLandmark);
//        for(GraphNodeAL2<?> n : path) System.out.println(n.data);
        List<GraphNodeAL2<?>> returnList;

        returnList=Search.findPathBreadthFirst(startNode, destLandmark);

        // assert cp != null;
        GraphNodeAL2<Landmark> tn = null;
        System.out.println(startNode);
        System.out.println(destLandmark);
        ((Pane)picture.getParent()).getChildren().removeIf(x->x instanceof Line);
        int pathCost = 0;
        for (GraphNodeAL2<?> al : returnList){
            Line l = null;
            if(tn!=null) {
                ((Pane) picture.getParent()).getChildren().add(l = new Line(tn.data.getX(), tn.data.getY(), ((Landmark) al.data).getX(), ((Landmark) al.data).getY()));
                l.setTranslateX(picture.getLayoutX());
                l.setTranslateY(picture.getLayoutY());
            }
            tn= (GraphNodeAL2<Landmark>) al;
        }
        // create lines in the for loop
        // System.out.println(al.data);
    }


    int startingX, startingY, endingX, endingY;
    boolean flag = true;

    public void findCoordinates(MouseEvent e){
        /**
         * In this method we check if flag is true.
         * If yes then we remove rectangles from picture.
         * We assign x and y to e.getX and e.getY.
         * We create an ImageView view called view and make it equal to e.getSource
         * We create Bounds bounds and make it equal to view.getLayoutBounds()
         * We create xScale and make it equal to bounds.getWidth() / view.getImage().getWidth()
         * We create yScale and make it equal to bounds.getHeight() / view.getImage().getHeight()
         * We make x = x / xScale and y = y / yScale
         * We add a rectangle to picture.
         * If flag is true then we make startingX = x, startingY = y and flag = false.
         * else we make endingX = x, endingY = y and flag = true.
         */
        // if statement to prevent user form drawing lots of circles

        //((Pane)picture.getParent()).getChildren().removeIf(x->x instanceof Circle);
        if (flag){
            ((Pane)picture.getParent()).getChildren().removeIf(x->x instanceof Rectangle);
            // need to remove path
        }

        int x = (int)e.getX();
        int y = (int)e.getY();
        ImageView view = (ImageView) e.getSource();
        Bounds bounds = view.getLayoutBounds();
        double xScale = bounds.getWidth() / view.getImage().getWidth();
        double yScale = bounds.getHeight() / view.getImage().getHeight();

        x /= xScale;
        y /= yScale;
        Rectangle rectangle = new Rectangle(x,y,4,4);
        rectangle.setFill(Color.GREEN);
        rectangle.setTranslateX(view.getLayoutX());
        rectangle.setTranslateY(view.getLayoutY());
        ((Pane)picture.getParent()).getChildren().add(rectangle);


        if (flag){
            // draw circle on map
            startingX = x;
            startingY = y;
            flag = false;
        }

        else{
            endingX = x;
            endingY = y;
            flag = true;
            bfs2();
        }

    }


    public void bfs2(){
        // check nearby pixels for white color
        int width = (int) picture.getImage().getWidth();
        int arrayLength = pixels.size();
        int value = 1;
        int startingElement = startingY * (int)picture.getImage().getWidth() + startingX;
        int endingElement = endingY * (int)picture.getImage().getWidth() + endingX;
        if (pixels.get(startingElement) == 0 && pixels.get(endingElement) == 0){
            ArrayList<Integer> arrayList = new ArrayList<Integer>();
            arrayList.add(startingElement);
            pixels.set(startingX, value);
            while (!arrayList.isEmpty()){
                int firstItem = arrayList.get(0);
                int height = (int) picture.getImage().getHeight();
                if (firstItem == endingElement){
                // will be found
                    break;
                }
                else{
                    // check the last assignment for checking the pixels sticking to the firstItem

                        if (firstItem >= 0) {
                        //    value++;
                            value = pixels.get(firstItem) + 1;
                            if (firstItem + 1 < arrayLength && pixels.get(firstItem + 1) == 0 && (firstItem + 1) % width != 0) {
                                arrayList.add(firstItem + 1);
                                pixels.set(firstItem + 1, value);
                            }

                            if (firstItem - 1 < arrayLength && pixels.get(firstItem - 1) == 0 && (firstItem) % width != 0) {
                                arrayList.add(firstItem - 1);
                                pixels.set(firstItem - 1, value);
                            }

                            if (firstItem + width < arrayLength && pixels.get(firstItem + width) == 0) {
                                arrayList.add(firstItem + width);
                                pixels.set(firstItem + width, value);
                            }

                            if (firstItem - width < arrayLength && pixels.get(firstItem - width) == 0) {
                                arrayList.add(firstItem - width);
                                pixels.set(firstItem - width, value);
                            }

//                            if (number < arrayLength && pixels[number] >= 0) {
//
//                            }

                            // check the all pixels around first item
                            // if pixels are of value 0 then we add them to the end of the array list
                            // change the value of pixels to whatever step you are on + 1

                            // Establish the path backwards
                            // Looking for the element 1 less each time to go back the way

                        }
                }
                arrayList.remove(0);

            }
        }
        ArrayList<Integer> path = new ArrayList<>();
        int value2;
        int totalDistance;
        value2 = totalDistance = pixels.get(endingElement);
        path.add(endingElement);
        int elementToBeChecked = endingElement;
        while (value2 > 0){
            value2--;

            if(elementToBeChecked + 1 < arrayLength &&
                    pixels.get(elementToBeChecked + 1) == value2 &&
                    (elementToBeChecked + 1) % width != 0){

                path.add(elementToBeChecked + 1);
                elementToBeChecked = elementToBeChecked + 1;
            }

            else if(elementToBeChecked - 1 > 0 && pixels.get(elementToBeChecked - 1) == value2 && (elementToBeChecked) % width != 0){
                path.add(elementToBeChecked - 1);
                elementToBeChecked = elementToBeChecked - 1;
            }

            else if(elementToBeChecked + width < arrayLength && pixels.get(elementToBeChecked + width) == value2){
                path.add(elementToBeChecked + width);
                elementToBeChecked = elementToBeChecked + width;
            }

            else if(elementToBeChecked - width > 0 && pixels.get(elementToBeChecked - width) == value2){
                path.add(elementToBeChecked - width);
                elementToBeChecked = elementToBeChecked - width;
            }

//            for (int i = 0; i < path.size() - 2; i++)
//                for (int j = 1; j < path.size() - 1; j++){
//                    Line l = new Line();
//            }

        }
        int tn = -1;
        for (int a1 : path){
            Line l = null;
            if(tn >= 0) {
                int startY = tn / width;
                int startX = tn % width;
                int endY = a1 / width;
                int endX = a1 % width;
                ((Pane) picture.getParent()).getChildren().add(l = new Line(startX, startY, endX, endY));
                l.setStroke(Color.RED);
                l.setTranslateX(picture.getLayoutX());
                l.setTranslateY(picture.getLayoutY());
            }
            tn = a1;
        }
        System.out.println("Total Distance is " + totalDistance);
        System.out.println("Path size is " + path.size());
    }




    public void testRout(){
    }

    public static <T> List<GraphNodeAL2<?>> findPathDepthFirst(GraphNodeAL2<?> from, List<GraphNodeAL2<?>> encountered, T lookingfor){
        List<GraphNodeAL2<?>> result;
        if(from.data.equals(lookingfor)) { //Found it
            result=new ArrayList<>(); //Create new list to store the path info (any List implementation could be used)
            result.add(from); //Add the current node as the only/last entry in the path list
            return result; //Return the path list
        }
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        for(GraphLinkAL adjNode : from.adjList)
            if(!encountered.contains(adjNode.destNode)) {
                result=findPathDepthFirst(adjNode.destNode,encountered,lookingfor);
                if(result!=null) { //Result of the last recursive call contains a path to the solution node
                    result.add(0,from); //Add the current node to the front of the path list
                    return result; //Return the path list
                }
            }
        return null;
    }

    public void locations(){

        /**
         * In this method we create a for loop to check every node in nodes.
         * For each node in nodes we make Landmark i equal to it.
         * If Landmark is a Landmark we create EvenHandler eh.
         * We create method called handle. In it we check if source text is empty. If yes the we set text to i.getName and startNode = node
         * Else if it is not empty and destination is empty then we set text to i.getName and destLandmark = node
         * Then we create a blue circle if type is cultural and red if type is not cultural and we create a tool tip for each circle.
         *
         */
//        WritableImage writableImage = (WritableImage) picture.getImage();
//        PixelWriter pixelWriter = writableImage.getPixelWriter();
        for (GraphNodeAL2<Landmark> node : nodes){
            Landmark i = node.data;
            if (i.getLandMark().equalsIgnoreCase("Landmark")) {
                EventHandler <MouseEvent> eh = new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        if (source.getText().isEmpty()) {
                            source.setText(i.getName());
                            startNode = node;
                        }
                        else if(!source.getText().isEmpty() && destination.getText().isEmpty()) {
                            destination.setText(i.getName());
                            destLandmark = i;
                        }
                    }
                };
                Circle circle = new Circle();
                circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eh);
                circle.setCenterX(i.getX());
                circle.setCenterY(i.getY());
                circle.setRadius(7);
                circle.setTranslateX(picture.getLayoutX());
                circle.setTranslateY(picture.getLayoutY());
                // if statement to color circles based on node type
                if (i.getType().equalsIgnoreCase("Cultural"))
                    circle.setFill(Color.BLUE);
                else
                    circle.setFill(javafx.scene.paint.Color.RED);
                Tooltip.install(circle, new Tooltip(i.getName() + "\n" + i.getType()));
                ((Pane)picture.getParent()).getChildren().add(circle);
                // pixelWriter.setColor(i.getX(), i.getY(), Color.RED);
                // add mouse event in here to add the circles to source and location
            }
        }
    }

    public void loadImage(){
        /**
         * In this method we load the image from the image location in the PC and we set it on picture
         */
        Image image = new Image("file:/C:/Users/USER/Desktop/Wat.jpg");
        picture.setImage(image);
        System.out.println(picture.getImage().getHeight());
        System.out.println(picture.getImage().getWidth());
    }

    public void setPath(MouseEvent e){
        /**
         * In here we check if source text is empty. If yes then we add "Start" to it. If no and destination text is empty then
         * We add "Finish to it"
         */
        if (source.getText().isEmpty())
            source.setText("Start");
        else if(!source.getText().isEmpty() && destination.getText().isEmpty())
            destination.setText("Finish");

    }
public void path(){
    /**
     * In this method we set solution path to true
     */
    solutionPath(true);
}

public void pathType(){
    /**
     * In here we check if startNode type is equal to destLandmark type.
     * If yes then we set solutionPath to false and we print "Landmark type of source and destination must be the same"
     */
    //  if(source.getText().charAt(0) == destination.getText().charAt(0))
            if (startNode.data.getType().equalsIgnoreCase(destLandmark.getType()))
            solutionPath(false);
            System.out.println("Landmark type of source and destination must be the same");
}

    public void solutionPath(boolean flag){
        /**
         * For this method we create CostedPath cp.
         * If flag is true then we make cp = Search.findCheapestPathDijkstra(startNode, destLandmark)
         * If flag is false then we make cp = Search.findPathOfTypeDijkstra(startNode, destLandmark, destLandmark.getType())
         * We create GraphNodeAL2 called tn and set it to null.
         * Then we remove all lines from picture
         * If cp is not equal to null then we create string lName and instruction.
         * we make lName = ((Landmark)cp.pathList.get(0).data).name and instruction = "Starting at landmark " + lName
         * For each node in cp.pathList we make Line l = null.
         * If tn is not null we make instruction = instruction + " go to " + ((Landmark)al.data).getName() + "\n".
         * Then we add l to picture and make tn = al
         * Then we set directions test to instructions
         * else we print "There is no path between those two nodes"
         */
        System.out.println("Solution path");
        System.out.println("--------------------------------------------------------------");
//        List<GraphNodeAL2<?>> path=findPathDepthFirst(startNode,null,destLandmark);
//        for(GraphNodeAL2<?> n : path) System.out.println(n.data);
        CostedPath cp;

        if (flag)
            cp = Search.findCheapestPathDijkstra(startNode, destLandmark);
        else
            cp = Search.findPathOfTypeDijkstra(startNode, destLandmark, destLandmark.getType());

        // assert cp != null;
        GraphNodeAL2<Landmark> tn = null;
        System.out.println(startNode);
        System.out.println(destLandmark);
        ((Pane)picture.getParent()).getChildren().removeIf(x->x instanceof Line);
        if(cp != null){

        String lName, instruction;
        lName = ((Landmark)cp.pathList.get(0).data).name;
        instruction = "Starting at landmark " + lName;

        for (GraphNodeAL2<?> al : cp.pathList){

                Line l = null;
                if(tn!=null) {
                    instruction = instruction + " go to " + ((Landmark)al.data).getName() + "\n";
                    ((Pane) picture.getParent()).getChildren().add(l = new Line(tn.data.getX(), tn.data.getY(), ((Landmark) al.data).getX(), ((Landmark) al.data).getY()));
                    l.setTranslateX(picture.getLayoutX());
                    l.setTranslateY(picture.getLayoutY());
                }
                tn= (GraphNodeAL2<Landmark>) al;
        }
            // create lines in the for loop
         //   System.out.println(al.data);
        System.out.println("Total cost " + cp.pathCost);
        // System.out.println(instruction); //////////////////
        directions.setText(instruction);
    }
        else
            System.out.println("There is no path between those two nodes");
    }





//    public void path(MouseEvent e){
//
//        int srcX = 0;
//        int srcY = 0;
//        int destX = 0;
//        int destY = 0;
//
//        for (Landmark i : landmarks)
//            if((e.getX() > i.getX() - 8 && e.getX() < i.getX() + 8) && (e.getY() > i.getY() - 8 && e.getY() < i.getY() + 8)){
//                source.setText(i.getName());
//                srcX = i.getX();
//                srcY = i.getY();
//            }
//
//        for (Landmark j : landmarks){
//            if (j.getName().equalsIgnoreCase(source.getText()))
//                landmarks.remove(j);
//            if((e.getX() > j.getX() - 8 && e.getX() < j.getX() + 8) && (e.getY() > j.getY() - 8 && e.getY() < j.getY() + 8)){
//                destination.setText(j.getName());
//                destX = j.getX();
//                destY = j.getY();
//            }
//        }
////        g.drawLine(srcX, srcY, destX, destY);
//        Line line = new Line(srcX, srcY, destX, destY);
//        ((Pane)picture.getParent()).getChildren().add(line);
//    }


    public void locDetails(MouseEvent e){
        int x = (int)e.getX();
        int y = (int)e.getY();
        ImageView view = (ImageView) e.getSource();
        Bounds bounds = view.getLayoutBounds();
        double xScale = bounds.getWidth() / view.getImage().getWidth();
        double yScale = bounds.getHeight() / view.getImage().getHeight();

        x /= xScale;
        y /= yScale;

        Image img = picture.getImage();
        PixelReader pr = img.getPixelReader();
        int height = (int)img.getHeight();
        int width = (int)img.getWidth();

        // WIT
        if (pr.getColor(x,y) == Color.RED && (e.getX() >= 341-7 ||  e.getX() <= 341+7) && (e.getY() >= 600-7 ||  e.getY() <= 600+7))
            Tooltip.install(picture, new Tooltip("WIT"));

        // Waterford Gulf Club
        if (pr.getColor(x,y) == Color.RED && (e.getX() >= 628-7 ||  e.getX() <= 628+7) && (e.getY() >= 145-7 ||  e.getY() <= 145+7))
            Tooltip.install(picture, new Tooltip("Waterford Gulf Club"));

        // University hospital Waterford
        if (pr.getColor(x,y) == Color.RED && (e.getX() >= 1156-7 ||  e.getX() < 1156+7) && (e.getY() >= 528-7 ||  e.getY() <= 528+7))
            Tooltip.install(picture, new Tooltip("University hospital Waterford"));

        // Waterford School of Grinds
        if (pr.getColor(x,y) == Color.RED && (e.getX() >= 786-7 ||  e.getX() <= 786+7) && (e.getY() >= 378-7 ||  e.getY() <= 378+7))
            Tooltip.install(picture, new Tooltip("Waterford School of Grinds"));

        // Waterford Regional Sports Center
        if (pr.getColor(x,y) == Color.RED && (e.getX() >= 566-7 ||  e.getX() <= 566+7) && (e.getY() >= 568-7 ||  e.getY() <= 568+7))
            Tooltip.install(picture, new Tooltip("Waterford Regional Sports Center"));


//        pixelArray = new int[(height * width)];
//
//
//        for(int r=0;r<height;r++)
//            for(int c=0;c<width;c++)
//            {
//                if (pr.getColor(c,r).equals(Color.RED))
//                    pixelArray[(r * width + c)] = (r * width + c);
//                else
//                    pixelArray[(r * width + c)] = -1;
//            }
    }



    //Regular recursive depth-first graph traversal
    public static void traverseGraphDepthFirst(GraphNodeAL2<?> from, List<GraphNodeAL2<?>> encountered){
        System.out.println(from.data);
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
        for(GraphLinkAL adjLink : from.adjList)
            if(!encountered.contains(adjLink.destNode)) traverseGraphDepthFirst(adjLink.destNode,encountered);
    }


    //Regular recursive depth-first graph traversal with total cost
    public static void traverseGraphDepthFirstShowingTotalCost(GraphNodeAL2<?> from,
                                                               List<GraphNodeAL2<?>> encountered, int totalCost ){
        System.out.println(from.data+" (Total cost of reaching node: "+ totalCost +")");
        if(encountered==null) encountered=new ArrayList<>(); //First node so create new (empty) encountered list
        encountered.add(from);
//Could sort adjacency list here based on cost – see next slide for more info!
        for(GraphLinkAL adjLink : from.adjList)
            if(!encountered.contains(adjLink.destNode))
                traverseGraphDepthFirstShowingTotalCost(adjLink.destNode,encountered, totalCost+adjLink.cost );
    }




//    public void browse() throws FileNotFoundException {
//        FileChooser fc = new FileChooser();
//        File selectedFile = fc.showOpenDialog(null);
////        String way = null;
//        Image image;
//        if (selectedFile != null && (selectedFile.getName().contains(".png") || (selectedFile.getName().contains(".jpg")))){
////              way = selectedFile.getAbsoluteFile().toString();
//            image = new Image(new FileInputStream(selectedFile),picture.getFitWidth(),picture.getFitHeight(),false,true);
//            WritableImage writableImage = new WritableImage(image.getPixelReader(), (int)image.getWidth(),(int)image.getHeight());
//
//            double width = image.getWidth();
//            double height = image.getHeight();
////          path.setText(way);
//            // picture.setImage(image);
//            picture.setImage(writableImage);
////            picture2.setImage(writableImage);
//        }



//    public void pixelReader(){
//
//        Image img = picture2.getImage();
//        PixelReader pr = img.getPixelReader();
//
//        for(int r=0;r<img.getHeight();r++)
//            for(int c=0;c<img.getWidth();c++)
//            {
//                double red=pr.getColor(c,r).getRed(); //0.0-1.0
//                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
//                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
//            }
//    }

    public void reset(){
        /**
         * In this method we empty the source and destination text boxes
         */
        source.setText("");
        destination.setText("");
    }



    public void exit(){
        /**
         * In this method we exit the program
         */
        System.exit(0);
    }


}

