package sample;


public class MegaHashSC4<E extends Comparable> {
    LL<E>[] hashTable;


    public MegaHashSC4(int size) {
        /**
         * In this method we make make hashtable equal to a casted linked list with the size of 'size', the we create a for loop,
         * in it we say for int i is equal to 0, as long as i is less than the length of the hashtable we increment i, in the body
         * of the for loop we make the element of hashTable with the index i equal to a new linked list.
         */
        hashTable = (LL<E>[]) new LL[size]; //Zeros (default) indicate empty slots
        for (int i = 0; i < hashTable.length; i++) {
            hashTable[i] = new LL<E>();
        }
    }

    public int hashFunction(int key) {
        /**
         * In this method we return key % hashtable.length
         */
        return key % hashTable.length;
    }

    public int hashFunction(E key) {
        /**
         * In this method we return the absolute value of key.hashCode % hashTable.length
         */
        return Math.abs(key.hashCode()) % hashTable.length;
    }



    public void add(E item, int key) { //Add method using separate int key
        /**
         * In this method we create an integer called chain and we make it equal to hashFunction of the key that the user provided.
         * Then we add the item that the user provided to the linked list of the index chain
         */
        int chain = hashFunction(key);
        hashTable[chain].add(item);
    }





    public LL<E> get(int key) {
        /**
         * In this method we create an integer called index and we make it equal to hashFunction of the key that the user provided.
         * Then we return the linked list with index 'index'
         */
        int index = hashFunction(key);
        return hashTable[index];
    }



    public void displayHashTable() {
        /**
         * In this method we create a for loop, in it we say for integer i equal to 0, as long as i is less than hashTable.length,
         * increment i,  in the body of the for loop we print i, the we declare a linked list called temp and we make it equal to
         * the linked list with the index i in hashTable, if temp is not null then we show it.
         */
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Slot " + i + ":\n------------");

            LL<E> temp = hashTable[i];

            if (temp != null) {
                System.out.println(temp.show());
            }

        }

    }

    public void remove(int hashIndex, int listIndex) {
        /**
         * In this method we get to the linked list with the index hashIndex and we remove from it the element with the index 'listIndex'.
         */
        hashTable[hashIndex].removeByIndex(listIndex);

    }
}
