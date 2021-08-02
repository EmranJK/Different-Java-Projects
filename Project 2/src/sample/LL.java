package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LL<E extends Comparable> implements Iterable<E>, Comparable {


    Node<E> head;

    @Override
    public String  toString() {
        return "Node{" +
                "head=" + head +
                '}';
    }



    public void add(E e){
        /**
         *  In this method, we declare a new node, then we check if the head is equal to null, if it is then we make it equal
         *  to that node and we set the contents of the head to be the object that the user wants to add, if it isn't then we
         *  we create a node and make it equal to the head, then while the next nodes are not null, we keep iterating until we find
         *  the last node which is equal to null, then we make it equal to a new node and we set its content to the object that the user
         *  has provided.
         */
        Node<E> node = new Node<E>();
        if (head == null) {
            head = node;
            head.setContents(e);
        }
        else{
            Node<E> f = head;
            while (f.next != null) {
                f = f.next;
            }
            f.next = new Node<E>();

            f.next.setContents(e);
        }
    }


    public String show(){
        /**
         * In this method we create a node and make it equal to the head, the we declare an empty string, while the node is not null
         * then we add the contents of the node to the 'name' string and we iterate and do the same thing again with the other nodes.
         * Once we do this with all the nodes, we return 'name'.
         *
         */

        Node<E> node = head;
        String name = "";
        while (node != null){
            name += node.contents + "\n";
            node = node.next;
        }
        return name;
    }



    public int size(){
        /**
         * In this method we create an integer called numb and give it the value of 1, then we declare a node and make it equal to
         * the head, if the node is null the we return 0, while the next node is not null we increment num by one and iterate to the
         * next node. Once we finish from this loop we return num.
         */


        int num = 1;
        Node<E> node = head;
        if (node == null){
            return 0;
        }
        while(node.next != null){
            num++;
            node = node.next;
        }
        return  num;
    }

    public String reset(LL<E> a){
        /**
         * In this method we see if the head is null, if yes then we return a string saying the following 'The list is already empty',
         * if no then we make the head equal to null then we return the following string 'The list has been cleared'.
         */

        if (head == null)
            return "The list is already empty";
        else {
            head = null;
            return "The list has been cleared";
        }
    }


    // DESCENDING - Candidates

    public void selectionSort(LL<E> a) throws CloneNotSupportedException{
        /**
         * In this method we create a for loop, in it we declare an integer called sp make it equal to 0, then if sp is less than the
         * size of the linked list a - 1 we increment it. In the body of the for loop we declare an integer and call it smallestIndex and
         * make it equal to sp, then we create another for loop, in it we declare an integer i and make it equal to sp+1, then if i is
         * less than the size of the list a we increment i. In the body of the second for loop we compare between the object 'E' in the
         * list a with the index i and the object in the list a with the index smallestIndex and we check iof that comparison will
         * create a value that is bigger than 0, if yes then we make the smallestIndex equal to i. In the first for loop we check if
         * smallestIndex is not equal to sp, if yes then we create a node called swap and make it equal to the contents of the cloned
         * node with the index of sp, then we set the contents of the object with the index sp to be the contents of the cloned node
         * with the index smallestIndex, we also set the contents of the object with the index smallestIndex to be the contents of the
         * swap node.
         */
        for(int sp=0;sp<a.size()-1;sp++){
            int smallestIndex=sp;
            for(int i=sp+1;i<a.size();i++)
                if(a.get(i).compareTo(a.get(smallestIndex)) > 0)
                    smallestIndex=i;
            if(smallestIndex!=sp) {
                Node<E> swap= (Node<E>) a.getNode(sp).clone();
                set(sp,  ((Node<E>) getNode(smallestIndex).clone()).getContents());
                set(smallestIndex, swap.getContents());
                // a[sp]=a[smallestIndex];
                // a[smallestIndex]=swap;
            }
        }
    }

    // ASCENDING
    public void insertionSort(LL<E> a){
        /**
         * In this method we create a for loop, in it we declare an integer called e and we make it equal to 1, if it is less than
         * a.size then we increment it. In the body of the for loop we declare an E called elem and we make it equal to the E with the
         * index e, then we declare and integer i, then we create a for loop, in it we make i equal to e, if i is bigger or equal to
         * 1 and the E that has the index i-1 compared to elem have a difference that is bigger than 0 then we decrement i.
         * In the first for loop we get the node with the index i and we set its contents to elem.
         */
        for(int e=1;e<a.size();e++){
            E elem=a.get(e);
            int i;
            for(i=e;i>= 1 && a.get(i-1).compareTo(elem) > 0;i--)
                a.getNode(i).setContents(a.getNode(i-1).getContents());

            a.getNode(i).setContents(elem);
//            a[i]=a[i-1];
//            a[i]=elem;
        }
    }




    public E get(int index){
        /**
         * In this method we check if the index that the user provided is 0, if yes then we return the contents of the head,
         * else we check if the index is less than the size, if yes the we create a node called temp and we make it equal to head,
         * then we create an integer called counter an we make it equal to 0, then while the counter is less than the index we go
         * to the next node and increment the counter. Once we reach the right node we return its contents. If the index is not 0
         * and it is not less than the size then we return null.
         */
        if (index == 0)
            return head.getContents();
        else {
            if (index < size()){
                Node<E> temp = head;
                int counter = 0;
                while (counter < index){

                    temp = temp.next;
                    counter++;
                }

                return temp.getContents();
            }
        }
        return null;
    }





    public void set(int index, E e) {
        /**
         * In this method we check if the index that the user provided is 0, if yes then we set the contents of the head to e,
         * else we check if the index is less than the size, if yes the we create a node called temp and we make it equal to head,
         * then we create an integer called counter an we make it equal to 0, then while the counter is less than the index we go
         * to the next node and increment the counter. Once we reach the right node we set its contents to e.
         */
        if (index == 0)
            head.setContents(e);
        else {
            if (index < size()){
                Node<E> temp = head;
                int counter = 0;
                while (counter < index){
                    temp = temp.next;
                    counter++;
                }
                temp.setContents(e);
            }
        }
    }





    public Node<E> getNode(int index){
        /**
         * In this method we check if the index that the user provided is 0, if yes then we return the head,
         * else we check if the index is less than the size, if yes the we create a node called temp and we make it equal to head,
         * then we create an integer called counter an we make it equal to 0, then while the counter is less than the index we go
         * to the next node and increment the counter. Once we reach the right node we return it. If the index is not 0
         * and it is not less than the size then we return null.
         */
        if (index == 0)
            return head;
        else {
            if (index < size()){
                Node<E> temp = head;
                int counter = 0;
                while (counter < index){

                    temp = temp.next;
                    counter++;
                }

                return temp;
            }
        }
        return null;
    }



    public void setNode(int index, Node<E> node){
        if (index == 0)
            head = node;
        else {
            if (index < size()){
                Node<E> temp = head;
                int counter = 0;
                while (counter < index){
                    temp = temp.next;
                    counter++;
                }
                temp = node;
            }
        }
    }




    public void removeByIndex(int index){
        /**
         * In this method we create a node and we make it equal to head, if node is not null and if the index is less than the size
         * we check if the index is 0 , if yes then we make the head equal to the next node, otherwise we create an integer called counter and
         * we make it equal to 0, while counter is less than index -1 we make node equal to the next node and we increment the counter
         * after the while loop is finished we make the next node equal to node.next.next
         */
        Node<E> node = head;


        if (node != null && index < size()){


            if (index == 0){
                head = node.next;
            }
            else{
                int counter=0;
                while (counter < index -1){
                    node = node.next;
                    counter++;
                }

                node.next = node.next.next;
            }
        }
    }


    public void delete(E obj){
        Node<E> node = head;


        if (node != null){


            if (node.getContents().equals(obj)){
                head = node.next;
            }
            else{
                while (node.next != null){
                    if (node.next.getContents().equals(obj)){
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
            }
        }

    }




    public void updateByIndex(int index, E e){
        /**
         * In this method we create a node and we make it equal to head, if node is not null and if the index is less than the size
         * we check if the index is 0 , if yes then we set the contents of head to e, otherwise we create an integer called counter and
         * we make it equal to 0, while counter is less than index -1 we make node equal to the next node and we increment the counter
         * after the while loop is finished we set the contents of node.next to e.
         */
        Node<E> node = head;


        if (node != null && index < size()){


            if (index == 0){
                head.setContents(e);
            }
            else{
                int counter=0;
                while (counter < index -1){
                    node = node.next;
                    counter++;
                }

                node.next.setContents(e);
            }
        }
    }



    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("app.xml"));
        head = (Node<E>) is.readObject();
        is.close();
    }

    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("app.xml"));
        out.writeObject(head);
        out.close();
    }




    @Override
    public Iterator<E> iterator() {
        return new FunkyIterator<E>(head);
    }

    @Override
    public void forEach(Consumer<? super E> action) {

    }

    @Override
    public Spliterator<E> spliterator() {
        return null;
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
