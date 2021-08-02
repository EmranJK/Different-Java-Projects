package sample;

public class PalletLL {
    /**
     * The head node will be the first node in the linked list
     */
    PalletNode head;


    @Override
    public String toString() {
        return "AisleLL{" +
                "head=" + head +
                '}';
    }

    public void insert(Pallet al){
        /**
         * In this method we are creating a new node. If the head node value is null then we give it the value of the
         * node that we created and now head contains a value. Then we set the contents of the head node.
         * If the head node is not null then we create a node and give it the value of the head node then we say while the
         * next node is not equal to null set the value of the current node to the value of the next node until we
         * find the last node in the chain and then set its contents.
         */
        PalletNode node = new PalletNode();
        if (head == null) {
            head = node;
            head.setContents(al);
        }
        else{
            PalletNode a = head;
            while (a.next != null) {
                a = a.next;
            }
            a.next = new PalletNode();

            a.next.setContents(al);
        }
    }

    public String show(){
        /**
         * In this method we are creating a node and giving it the value of the head node, then we are declaring an empty
         * string called 'name'. While the node is not equal to null, we change the value of name to the value of the contents
         * of the node and we go to the next node by making the current node equal to the next node. After we reach the last node
         * and append its value to 'name' we return name.
         */
        PalletNode node = head;
        String name = "";
        while (node != null){
            name += node.contents + "\n";
            node = node.next;
        }
        return name;
    }

//    public static String show(AisleLL list){
//        AisleNode node = list.head;
//        String name = "";
//        while (node.next != null){
//            name += node.contents + "\n";
//            node = node.next;
//        }
//        name += node.contents;
//        return name;
//    }

    public int size(){
        /**
         * In this method we declare an integer num and we give it the value of 1. Then we declare a Node and we give it the value of the head node.
         * If node is null then we return zero. If node is not null then it is automatically equals 1. If node is not null, e check
         * if there are any other node by checking if the next node is not null. While the next node is not null we increase the num
         * by 1 and we make node equals the next node. We keep doing this until we reach the last node and we also increase num by 1
         * every time we do this. Once there are no more node left we return num.
         */
        int num = 1;
        PalletNode node = head;
        if (node == null){
            return 0;
        }
        while(node.next != null){
            num++;
            node = node.next;
        }
        return  num;
    }



    public void removeByNumberOfGoods(int num){
        /**
         * In this method we create a node called 'node' and give it the value of the head node. Then we check if the value of
         * node is not null. If it is not null then we check if the number of goods in the contents of the node is equal to the number of goods
         * that the user wants to remove, if yes then we make the node next to the head become the head, if not then while
         * the next node is not null we check if the number of goods in the contents of the next node is the same as what the user is
         * looking for, if yes then we make the next node equal the one after it and we stop the loop. If its not then we
         * keep iterating in the node chain.
         */
        PalletNode node = head;


        if (node != null){


            if (node.contents.getNumberOfGoods() == num){
                head = node.next;
            }
            else{
                while (node.next != null){
                    if (node.next.contents.getNumberOfGoods() == num){
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
            }
        }
    }


    public Pallet searchByNumberOfGoods(int num){
        /**
         * In this method we create a node called 'node' and give it the value of the head node. Then we check if the value of
         * node is not null. If it is not null then we check if the number of goods in the contents of the node is equal to the number of goods
         * that the user is looking for, if yes then we return it, if not then while
         * the next node is not null we check if the number of goods in the contents of the next node is the same as what the user is
         * looking for, if yes then we return it. If its not then we
         * keep iterating in the node chain.
         */
        PalletNode node = head;


        if (node != null){


            if (node.contents.getNumberOfGoods() == num){
                return node.contents;
            }
            else{
                while (node != null){
                    if (node.contents.getNumberOfGoods() == num){
                        return node.contents;

                    }
                    node = node.next;
                }
            }
        }
        return null;
    }




    public PalletLL searchByTypeOfGoods(String product){
        /**
         * In this method we create a linked list called list and a node called 'node' and give it the value of the head node. Then we check if the value of
         * node is not null. If it is not null then we check if the type of goods in the contents of the node is equal to the type of goods
         * that the user is looking for, if yes then we add it to list
         * If its not then we keep iterating in the node chain.
         * At the end we return the list.
         */
        PalletNode node = head;
        PalletLL palletLL = new PalletLL();

        if (node != null){



                while (node != null){
                    if (node.contents.getDescriptionOfGoods().equals(product)){
                        palletLL.insert(node.getContents());

                    }
                    node = node.next;
                }
                return palletLL;
            }

        return null;
    }

    public String reset(PalletLL list){
        /**
         * In this method we check if the head is null, if yes the n the lis tis already empty, no then we set it to null
         * and this will automatically make all the other node in the list equal to null.
         */
        if (head == null)
            return "The list is already empty";
        else {
            head = null;
            return "The list has been cleared";
        }
    }

}
