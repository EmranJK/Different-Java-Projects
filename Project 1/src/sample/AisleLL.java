package sample;

public class AisleLL {
    /**
     * The head node will be the first node in the linked list
     */
    AisleNode head;


    @Override
    public String toString() {
        return "AisleLL{" +
                "head=" + head +
                '}';
    }

    public void insert(Aisle al){
        /**
         * In this method we are creating a new node. If the head node value is null then we give it the value of the
         * node that we created and now head contains a value. Then we set the contents of the head node.
         * If the head node is not null then we create a node and give it the value of the head node then we say while the
         * next node is not equal to null set the value of the current node to the value of the next node until we
         * find the last node in the chain and then set its contents.
         */
        AisleNode node = new AisleNode();
        if (head == null) {
            head = node;
            head.setContents(al);
        }
        else{
            AisleNode a = head;
            while (a.next != null) {
                a = a.next;
            }
            a.next = new AisleNode();

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
        AisleNode node = head;
        String name = "";
        while (node != null){
            name += node.contents + "\n";
            node = node.next;
        }
        return name;
    }



    public int size(){
        /**
         * In this method we declare an integer num and we give it the value of 1. Then we declare a Node and we give it the value of the head node.
         * If node is null then we return zero. If node is not null then it is automatically equals 1. If node is not null, e check
         * if there are any other node by checking if the next node is not null. While the next node is not null we increase the num
         * by 1 and we make node equals the next node. We keep doing this until we reach the last node and we also increase num by 1
         * every time we do this. Once there are no more node left we return num.
         */
        int num = 1;
        AisleNode node = head;
       // System.out.println(node.getContents());
        if (node == null){
            return 0;
        }
        while(node.next != null){
            num++;
            node = node.next;
        }
        return  num;
    }



    public void removeByIdentifier(String identifier){
        /**
         * In this method we create a node called 'node' and give it the value of the head node. Then we check if the value of
         * node is not null. If it is not null then we check if the identifier in the contents of the node is equal to the identifier
         * that the user wants to remove, if yes then we make the node next to the head become the head, if not then while
         * the next node is not null we check if the identifier in the contents of the next node is the same as what the user is
         * looking for, if yes then we make the next node equal the one after it and we stop the loop. If its not then we
         * keep iterating in the node chain.
         */
        AisleNode node = head;


        if (node != null){


            if (node.contents.getIdentifier().equals(identifier)){
                head = node.next;
            }
            else{
                while (node.next != null){
                    if (node.next.contents.getIdentifier().equals(identifier)){
                        node.next = node.next.next;
                        break;
                    }
                    node = node.next;
                }
            }
        }
    }


    public Aisle searchByIdentifier(String id){
        /**
         * In this method we create a node called 'node' and give it the value of the head node. Then we check if the value of
         * node is not null. If it is not null then we check if the identifier in the contents of the node is equal to the identifier
         * that the user is looking for, if yes then we return it, if not then while
         * the next node is not null we check if the identifier in the contents of the next node is the same as what the user is
         * looking for, if yes then we return it. If its not then we
         * keep iterating in the node chain.
         */
        AisleNode node = head;


        if (node != null){


            if (node.contents.getIdentifier().equals(id)){
                return node.contents;
            }
            else{
                while (node != null){
                    if (node.contents.getIdentifier().equals(id)){
                        return node.contents;

                    }
                    node = node.next;
                }
            }
        }
        return null;
    }


    public String reset(AisleLL list){
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
