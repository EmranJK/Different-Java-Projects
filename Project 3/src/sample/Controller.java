// Oranges: 30 +- 10 or 20
// Blue Plums: 250 or 260 +- 10 or 20
// "pixelReader" function and "clusters" function
// Text rectNum = new Text("" + counter);

package sample;

import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.scene.control.ScrollPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.WeakReference;
import java.util.*;

public class Controller {

    @FXML
    TextArea details;

    @FXML
    ImageView picture;

    @FXML
    ImageView picture2;

    @FXML
    ImageView picture3;

    @FXML
    ImageView picture4;

    @FXML
    ImageView picture5;

    @FXML
    ImageView picture6;

    @FXML
    ImageView picture7;

    @FXML
    ImageView picture8;


    @FXML
    ImageView pictureOfColor;


    @FXML
    Tab taby;

    @FXML
    Tab taby2;

    @FXML
    Slider sliderGrey;


//    public void getImage(){
//        String way = path.getText();
//        Image img=new Image(getClass().getResource(way).toExternalForm(),10,10,true,false);
//        picture.setImage(img);
//    }


    Color chosenColor;
    int[] pixelArray;
    HashMap<Integer, ArrayList<Integer>> root = new HashMap<Integer, ArrayList<Integer>>();

    public void browse() throws FileNotFoundException {
        /**
         * In this method, we declare a fileChooser fc, then we get the contents of the second tab,
         * then we declare a File called selectedFile and make it equal to fc.showOpenDialog(null),
         * then we declare an Image called image, then we declare an if statements, that checks if
         * the selectedFile is not null and if selectedFile is of type jpg or png, if so the image
         * will equal new image of new FileInputStream of selectedFile. Also WritableImage writableImage
         * will be declared and will equal to new WritableImage, the writableImage will be image.getPixelReader.
         * width and height will get the value of image.getWidth and image.getHeight and all imageViews will
         * have their image set to image or writable image. Then details of the image will be written in the
         * details textArea.
         */
        FileChooser fc = new FileChooser();
        taby.getContent();
        File selectedFile = fc.showOpenDialog(null);
//        String way = null;
        Image image;
        if (selectedFile != null && (selectedFile.getName().contains(".png") || (selectedFile.getName().contains(".jpg")))){
//              way = selectedFile.getAbsoluteFile().toString();
            image = new Image(new FileInputStream(selectedFile),picture.getFitWidth(),picture.getFitHeight(),false,true);
            WritableImage writableImage = new WritableImage(image.getPixelReader(), (int)image.getWidth(),(int)image.getHeight());
            double width = image.getWidth();
            double height = image.getHeight();
//          path.setText(way);
            picture.setImage(image);
            picture2.setImage(writableImage);
            picture3.setImage(writableImage);
            picture4.setImage(writableImage);
            picture5.setImage(image);
            picture6.setImage(writableImage);
            picture7.setImage(image);
            picture8.setImage(writableImage);
            details.setText("Name: " + selectedFile.getName() + "\n" + "Path: " + selectedFile.getAbsolutePath().toString() + "\n" + "Total Space: " + selectedFile.getTotalSpace() + "\n" + "width: " + width + "\n" + "height: " + height);
        }
    }



//    public void greyScale(){
////        System.out.println("Hello");
//        Image img = picture.getImage();
//        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
//        PixelReader pr = img.getPixelReader();
//        for(int r=0;r<img.getHeight();r++)
//            for(int c=0;c<img.getWidth();c++)
//            {
//                double red=pr.getColor(c,r).getRed(); //0.0-1.0
//                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
//                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
//                double grey = (red + green + blue) / 3;
//                grey = (grey + sliderGrey.getValue()) / 2;
//                wimg.getPixelWriter().setColor(c,r,Color.gray(grey));
////        Color grey2=Color.gray(pr.getColor(c,r));
////        img.getPixelW().setColor(grey2);
//    }
//        picture2.setImage(wimg);
//
//    }


//    public void makeRedder(){
////        System.out.println("Hello");
//        Image img = picture.getImage();
//        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
//        PixelReader pr = img.getPixelReader();
//        for(int r=0;r<img.getHeight();r++)
//            for(int c=0;c<img.getWidth();c++)
//            {
//                double red=pr.getColor(c,r).getRed(); //0.0-1.0
//                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
//                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
//                double grey = (red + green + blue) / 3;
////                grey = (grey + sliderGrey.getValue()) / 2;
////                if (red > green && red > blue){
////                    wimg.getPixelWriter().setColor(c,r,Color.RED);
////                }
////                else
////                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
//                wimg.getPixelWriter().setColor(c,r,new Color(red,0,0,1));
//            }
//        picture2.setImage(wimg);
//
//    }



    public void makeRedWhite(){
        /**
         * In this method, we give img the value of picture5.getImage(), then we create new
         * WritableImage wimg the values img.getPixelReader(), (int)img.getWidth() and (int)img.getHeight().
         * we create a PixelReader pr for img. We declare a for loop that checks for pixel rows in img and a
         * nested for loop that checks for pixel columns for every pixel row in img. For each of those pixels
         * we get the red, blue and green colors, the we check if the Hue of those colors is less than 20
         * or more than 340, if yes then we set the color of the pixel to white, else we make it black, then
         * we set image wimg for picture2 and picture 6 and call the addToRedSet() method
         */

        taby.getContent();
        Image img = picture5.getImage();
        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
        PixelReader pr = img.getPixelReader();
        for(int r=0;r<img.getHeight();r++)
            for(int c=0;c<img.getWidth();c++)
            {
                double red=pr.getColor(c,r).getRed(); //0.0-1.0
                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
                double grey = (red + green + blue) / 3;
                if (pr.getColor(c,r).getHue()<20 || pr.getColor(c,r).getHue()>340){
                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
                }
                else
                    wimg.getPixelWriter().setColor(c,r,Color.BLACK);
            }
        picture2.setImage(wimg);
        picture6.setImage(wimg);
        addToRedSet();
    }



    public void makeColor(){
        /**
         * In this method, we give img the value of picture5.getImage(), then we create new
         * WritableImage wimg the values img.getPixelReader(), (int)img.getWidth() and (int)img.getHeight().
         * we create a PixelReader pr for img. We declare a for loop that checks for pixel rows in img and a
         * nested for loop that checks for pixel columns for every pixel row in img. For each of those pixels
         * we get the red, blue and green colors, the we check if red is bigger than chosenColor.getRed() - 0.2
         * and if red is smaller than chosenColor.getRed() and green is bigger than chosenColor.getGreen() - 0.2
         * and if green is smaller than chosenColor.getGreen() and blue is bigger than chosenColor.getBlue() - 0.2
         * and if blue is smaller than chosenColor.getBlue(). If the statement is fulfilled then we set color white
         * to the wimg PixelWriter, else we set color black. Then we set image wimg to picture8.
         */
        taby.getContent();
        Image img = picture.getImage();
        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
        PixelReader pr = img.getPixelReader();
        for(int r=0;r<img.getHeight();r++)
            for(int c=0;c<img.getWidth();c++)
            {
                double red=pr.getColor(c,r).getRed(); //0.0-1.0
                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
                if (red > chosenColor.getRed() - 0.2 && red < chosenColor.getRed() + 0.2
                    && green > chosenColor.getGreen() - 0.2 && green < chosenColor.getGreen() + 0.2
                        && blue > chosenColor.getBlue() - 0.2 && blue < chosenColor.getBlue() + 0.2){
                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
                }
                else
                    wimg.getPixelWriter().setColor(c,r,Color.BLACK);
            }
        picture8.setImage(wimg);

    }




    public void makeOrangeWhite(){
        /**
         * In this method, we give img the value of picture5.getImage(), then we create new
         * WritableImage wimg the values img.getPixelReader(), (int)img.getWidth() and (int)img.getHeight().
         * we create a PixelReader pr for img. We declare a for loop that checks for pixel rows in img and a
         * nested for loop that checks for pixel columns for every pixel row in img. For each of those pixels
         * we get the red, blue, orange and green colors, then we check if orange is bigger than blue and 170 and less
         * than or equal tom 255 and if blue is bigger than or equal to 0 and less than or equal to 255 and green
         * is less than 173 and bigger than 88,
         * if yes then we set the color of the pixel to white, else we make it black, then
         * we set image wimg for picture3 and picture 6 and call the addToRedSet() method
         */
        taby.getContent();
//        System.out.println("Hello");
        Image img = picture5.getImage();
        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
        PixelReader pr = img.getPixelReader();
        for(int r=0;r<img.getHeight();r++)
            for(int c=0;c<img.getWidth();c++)
            {
                double orange=pr.getColor(c,r).getRed(); //0.0-1.0
                double red=pr.getColor(c,r).getRed(); //0.0-1.0
                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
                if (orange > blue && (orange * 255 > 170 && orange * 255 <= 255 && blue * 255 >= 0 && blue * 255 <= 255 && green * 255 < 173 && green * 255 > 88)){
                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
                }
                else
                    wimg.getPixelWriter().setColor(c,r,Color.BLACK);

            }
        picture3.setImage(wimg);
        picture6.setImage(wimg);
        addToRedSet();

    }


    public void makeBlueWhite(){
        /**
         * In this method, we give img the value of picture5.getImage(), then we create new
         * WritableImage wimg the values img.getPixelReader(), (int)img.getWidth() and (int)img.getHeight().
         * we create a PixelReader pr for img. We declare a for loop that checks for pixel rows in img and a
         * nested for loop that checks for pixel columns for every pixel row in img. For each of those pixels
         * we get the red, blue and green colors, the we check if the Hue of those colors -240 is less than 20
         * or more than 340, if yes then we set the color of the pixel to white, else we make it black, then
         * we set image wimg for picture4 and picture6 and call the addToRedSet() method
         */
        taby.getContent();
        Image img = picture5.getImage();
        WritableImage wimg = new WritableImage(img.getPixelReader(), (int)img.getWidth(),(int)img.getHeight());
        PixelReader pr = img.getPixelReader();
        for(int r=0;r<img.getHeight();r++)
            for(int c=0;c<img.getWidth();c++)
            {
                double red=pr.getColor(c,r).getRed(); //0.0-1.0
                double green=pr.getColor(c,r).getGreen(); //0.0-1.0
                double blue=pr.getColor(c,r).getBlue(); //0.0-1.0
                double grey = (red + green + blue) / 3;
//                grey = (grey + sliderGrey.getValue()) / 2;
             //   if (blue > green && blue > red && (blue * 255 > 151 && blue * 255 < 241)){
                if (Math.abs(pr.getColor(c,r).getHue()-240) < 20){
                    wimg.getPixelWriter().setColor(c,r,Color.WHITE);
                }
                else
                    wimg.getPixelWriter().setColor(c,r,Color.BLACK);
//                wimg.getPixelWriter().setColor(c,r,new Color(red,0,0,1));
//                wimg.getPixelWriter().setColor(c,r,new Color(0,0,blue,1));
//        Color grey2=Color.gray(pr.getColor(c,r));
//        img.getPixelW().setColor(grey2);
            }
        picture4.setImage(wimg);
        picture6.setImage(wimg);
        addToRedSet();

    }


    public void pixelReader2(MouseEvent e){
        /**
         * For this method we get x and y of MouseEven e, view is equal to e.getSource(),
         * bounds is equal to view.getLayoutBounds(), xScale is equal to width of bounds
         * divided by width of image and yScale is equal to height of bounds
         * divided by height of image, then x will be equal to x / xScale and y will be
         * equal to y / yScale. Then img will be equal to picture7 image and pr will be equal
         * to picture2 image PixelReader and chosen color will be equal to pr.getColor(x,y).
         * After that, we get colors Red, Green and Blue. Then we check if a pixel has a Hue less than 20
         * more than 340, if yes then it is considered a pixel of an apple picture. Then we check if a pixel
         * has a Hue -240 less than 20, if yes then it is considered as a pixel of a blue plum picture. Then we
         * check if orange is bigger than blue and 170 and less
         * than or equal tom 255 and if blue is bigger than or equal to 0 and less than or equal to 255 and green
         * is less than 173 and bigger than 88, if yes then the pixel is considered as a pixel of an orange image.
         * For all the if statements, we write the type of the image in a Tooltip. After checks are done, we declare
         * integer rootElement which will store root elements and Arraylist storage will get root elements from root.
         * Then a writableImage will be declared for pr and pixelWriter will get pixelWriter of writableImage.
         * For i in storage, row will be equal to i / img width and col will be equal to i / img height and the color
         * for the pixel with row and col will be set to pink. Then picture6 will be set as writableImage.
         */

        int x = (int)e.getX();
        int y = (int)e.getY();
        ImageView view = (ImageView) e.getSource();
        Bounds bounds = view.getLayoutBounds();
        double xScale = bounds.getWidth() / view.getImage().getWidth();
        double yScale = bounds.getHeight() / view.getImage().getHeight();


        x /= xScale;
        y /= yScale;


        Image img = picture7.getImage();
        PixelReader pr = picture2.getImage().getPixelReader();
        chosenColor = pr.getColor(x,y);
        double orange=pr.getColor(x,y).getRed();
        double blue=pr.getColor(x,y).getBlue(); //0.0-1.0
        double green=pr.getColor(x,y).getGreen(); //0.0-1.0
        if (pr.getColor(x,y).getHue()<20 || pr.getColor(x,y).getHue()>340)
            Tooltip.install(picture7, new Tooltip("This is an apple \nSize is: " + root.get(find(pixelArray, (int) (y * view.getImage().getWidth() + x))).size() + " pixels" + "\nClusters ordered by size: " + ordered() + "\nTotal number of clusters: " + clusters()));

        if (Math.abs(pr.getColor(x,y).getHue()-240) < 20)
            Tooltip.install(picture7, new Tooltip("This is a blue plum \nSize is " + root.get(find(pixelArray, (int) (y * view.getImage().getWidth() + x))).size() + " pixels" + "\nClusters ordered by size: " + ordered() + "\nTotal number of clusters: " + clusters()));


        if (orange > blue && (orange * 255 > 170 && orange * 255 <= 255 && blue * 255 >= 0 && blue * 255 <= 255 && green * 255 < 173 && green * 255 > 88))
            Tooltip.install(picture7, new Tooltip("This is an orange \nSize is " + root.get(find(pixelArray, (int) (y * view.getImage().getWidth() + x))).size() + " pixels" + "\nClusters ordered by size: " + ordered() + "\nTotal number of clusters: " + clusters()));

        int rootElement = find(pixelArray, (int) (y * view.getImage().getWidth() + x));
        ArrayList<Integer> storage = root.get(rootElement);

        WritableImage writableImage = new WritableImage(pr ,(int)picture7.getImage().getWidth(), (int)picture7.getImage().getHeight());

        PixelWriter pixelWriter = writableImage.getPixelWriter();

            for (int i : storage){
                int row = (int) (i / img.getWidth());
                int col = (int) (i % img.getWidth());
                pixelWriter.setColor(col,row,Color.PINK);
            }

            picture6.setImage(writableImage);
    }


    public ArrayList<Integer> ordered(){
        /**
         * For this method, unionSet() method is called. Then Arraylists sorted and sorted2 are declared.
         * sorted gets all keys of root and sorted2 gets all sizes of values of keys in sorted. Then sorted2 is ordered
         * from smallest to biggest and the returned.
         */

        //System.out.println(root.keySet().size());
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        ArrayList<Integer> sorted2 = new ArrayList<Integer>();
        sorted.addAll(root.keySet());
        for (int i: sorted)
            sorted2.add(root.get(i).size());

        Collections.sort(sorted2);
        return sorted2;
    }

    public int clusters(){
        /**
         * For this method, unionSet() method is called and the size of keySet of root is returned.
         */

        return (root.keySet().size());
    }


    public void randColor(){
        /**
         * In this method we call unionSet() method. For k in keySet of root we create a Random called rn
         * and we make it equal to new Random(k), then we create Color col and make it equal to 3 random rgb
         * values. Then v in root values of keys k, r is equal to v / picture6 image width and c is equal to
         * v % picture6 image width.Then we set color col for pixel c,r pixelWriter in picture6 image.
         */

        unionSet();
        for(int k : root.keySet()) {
            Random rn=new Random();
            Color col=new Color(rn.nextDouble(),rn.nextDouble(),rn.nextDouble(),1);
            for(int v : root.get(k)) {
                int r=v/(int)(picture6.getImage().getWidth());
                int c=v%(int)picture6.getImage().getWidth();
                ((WritableImage)picture6.getImage()).getPixelWriter().setColor(c,r,col);
            }
        }
    }



    public void addToRedSet(){
        /**
         * For this method, img is equal to picture6 image and pr is equal to img pixelReader.
         * height is equal to img height and width is equal to img width. pixelArray will have the
         * size of height * width, for every pixel in img, if it's white then the pixel will equal itself,
         * If it is not white then the pixel will equal to -1.
         */
        Image img = picture6.getImage();
        PixelReader pr = img.getPixelReader();
            int height = (int)img.getHeight();
            int width = (int)img.getWidth();

        pixelArray = new int[(height * width)];


        for(int r=0;r<height;r++)
            for(int c=0;c<width;c++)
            {
                if (pr.getColor(c,r).equals(Color.WHITE))
                    pixelArray[(r * width + c)] = (r * width + c);
                else
                    pixelArray[(r * width + c)] = -1;
            }
    }






    public static int find(int[] a, int id) {
        /**
         * This method takes two parameters, an integer id and an integer array a. While element in
         * array a with index id is not equal to id, id is equal to the element with index id and id is returned.
         */
        while(a[id]!=id) id=a[id];
        return id;
    }

    public static void union(int[] a, int p, int q) {
        /**
         * This method takes three parameters, two integers p and q, and an integer array a.
         * the element find(a,q) is equal to find(a,p).
         */
        a[find(a,q)]=find(a,p);
    }

    public void unionSet() {

        /**
         * In this method, we pixelArray length in arrayLength, width is equal to picture6 image width.
         * for i less than pixelArray length, number is equal to i + width, if element i in pixel array is
         * bigger or equal to 0 then if i + 1is less than arrayLength and element i + 1 in pixelArray is bigger
         * than or equal to 0 and i + 1 % width is not equal to 0 then we union i and i+1. If number is less than
         * arrayLength and element number in pixelArray is bigger or equal to 0 then we union i and number. This will
         * union the pixel with the pixel under it. For i in pixel array length, if element i in pixel array is bigger
         * than or equal to 0 then store is equal to i key. If root contains that key then an Arraylist rootValues is
         * created and is equal to values of the key store. Then i is added to rootValues. Else, we create ArrayList
         * kak and we add store to it and we put store and kak in Hashmap root. We remove keySet of root if size of key r
         * is less than 35 and we draw rectangles.
         */
        int arrayLength = pixelArray.length;
        int width = (int) picture6.getImage().getWidth();

        for (int i = 0; i < pixelArray.length; i++) {
            int number = i + width;
            if (pixelArray[i] >= 0) {


                ArrayList<Integer> values = new ArrayList<Integer>();

                if (i + 1 < arrayLength && pixelArray[i + 1] >= 0 && (i + 1) % width != 0) {
                    union(pixelArray, i, i + 1);
                }

                if (number < arrayLength && pixelArray[number] >= 0) {
                    union(pixelArray, i, number);

                }
            }
        }
        for (int i = 0; i < pixelArray.length; i++) {
            if (pixelArray[i] >= 0){
            int store = find(pixelArray, i);
            if (root.containsKey(store)) {
                ArrayList<Integer> rootValues = root.get(store);
                rootValues.add(i);

            } else {
                ArrayList<Integer> kak = new ArrayList<Integer>();
                kak.add(store);
                root.put(store, kak);

                }
            }
        }
        // noise reduction
        root.keySet().removeIf(r->root.get(r).size()<35);
            drawRectangle();
    }


    public void drawRectangle(){
        /**
         * In this method we create arrayList of rectangles called allRects. For integer rRoot in
         * keySet of root we create integers startX, startY, endX and endY, then we create integer
         * width and make it equal to width of picture 5 image. Then we create ArrayList of integers
         * called indexes and we make it equal to values of rRoot key. We make startX equal to endX
         * equal to first index % width and we make startY equal to endY
         * equal to first index / width. For i in indexes size, if index i % width is less than startX
         * then startX is equal to index i % width, if index i % width is more than endX
         * then endX is equal to index i % width, if index i / width is less than startY
         * then startY is equal to index i / width, if index i / width is more than endY
         * then endY is equal to index i / width. After that we make bounds equal to
         * picture5 LayoutBounds, we make xScale equal to bounds width / width of picture5
         * image and we make yScale equal to bounds width / width of picture5
         * image. Then we make startX equal to startX divided by xScale and
         * startY equal to startY divided by yScale. Then we create a rectangle and we
         * give it the dimensions startX,startY,endX-startX and endY-startY, we fill
         * the rectangle with transparent color, we make its borders blue, we set translateX
         * to picture5 LayoutX and translateY to picture5 LayoutY and we add rectangle to allRects
         * ArrayList. We sort rectangles in allRects from biggest to smallest and rectangles with
         * area less than 100 pixels. For n in allRects size, we create text for each rectangle in
         * allRects and we give it x dimension of n X dimension and y dimension of n Y dimension and
         * we give it a value of n + 1. Then we add text to children of picture5.
         *
         */

        ArrayList<Rectangle> allRects=new ArrayList<>();

        for (int rRoot : root.keySet()) {
//            System.out.println(rRoot + " " + root.get(rRoot));
            int startX, startY, endX, endY;
            int width =  (int)picture5.getImage().getWidth();
            ArrayList<Integer> indexes = root.get(rRoot);
            startX = endX = indexes.get(0) % width;
            startY = endY = indexes.get(0) / width;
            for (int i = 0; i < indexes.size(); i++){
                if (indexes.get(i) % width < startX){
                    startX = indexes.get(i) % width;
                }
                if (indexes.get(i) % width > endX){
                    endX = indexes.get(i) % width;
                }

                if (indexes.get(i) / width < startY){
                    startY = indexes.get(i) / width;
                }

                if (indexes.get(i) / width > endY){
                    endY = indexes.get(i) / width;
                }

            }
            Bounds bounds = picture5.getLayoutBounds();
            double xScale = bounds.getWidth() / picture5.getImage().getWidth();
            double yScale = bounds.getHeight() / picture5.getImage().getHeight();

            startX /= xScale;
            startY /= yScale;


            Rectangle rectangle = new Rectangle(startX,startY,endX-startX,endY-startY);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.BLUE);
            rectangle.setTranslateX(picture5.getLayoutX());
            rectangle.setTranslateY(picture5.getLayoutY());
            allRects.add(rectangle);
            ((Pane) picture5.getParent()).getChildren().add(rectangle);
        }
            Collections.sort(allRects,(b,a)-> (int) (a.getWidth()*a.getHeight()-b.getWidth()*b.getHeight()));
            // noise reduction
            allRects.removeIf(r->r.getWidth()*r.getHeight()<100);
            for(int n=0;n<allRects.size();n++) {
                Text text = new Text(allRects.get(n).getX() + 3, allRects.get(n).getY() + 10, (n + 1) + "");
                Font font = new Font(12);
                text.setFont(font);
                ((Pane) picture5.getParent()).getChildren().add(text);
                text.setLayoutX(picture5.getLayoutX()+allRects.get(n).getLayoutX());
                text.setLayoutY(picture5.getLayoutY()+allRects.get(n).getLayoutY());
            }
    }

    public void exit(){
        /**
         * This method closes the program.
         */
        System.exit(0);
    }


}
