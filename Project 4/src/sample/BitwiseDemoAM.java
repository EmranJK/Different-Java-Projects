package sample;

public class BitwiseDemoAM {
    //byte[] am1=new byte [8]; //Max of 8 nodes using byte primitive
    //int[] am2=new int [32]; //Max of 32 nodes using int primitive
    //long[] am3=new long [64]; //Max of 64 nodes using long primitive

    public static void connectUndirected(byte[] am, int a, int b){
        am[a]= (byte) (am[a] | (0b10000000 >>> b));
        am[b]= (byte) (am[b] | (0b10000000 >>> a));
    }

    public static boolean isConnected(byte[] am, int a, int b)
    {
        return (am[a] & (0b10000000 >>> b))!=0; //or 0x80 or 128
    }

    public static void connectUndirected(int[] am, int a, int b){
        am[a]= (am[a] | (0x80000000 >>> b));
        am[b]= (am[b] | (0x80000000 >>> a));
    }

    public static boolean isConnected(int[] am, int a, int b)
    {
        return (am[a] & (0x80000000 >>> b))!=0;
    }

//    public static void main(String[] args){
//        int[] am1=new int [10];
//
//        connectUndirected(am1,6,1);
//        connectUndirected(am1,0,1);
//        connectUndirected(am1,5,1);
//        connectUndirected(am1,0,5);
//        connectUndirected(am1,4,0);
//        connectUndirected(am1,5,7);
//        connectUndirected(am1,5,3);
//        connectUndirected(am1,3,2);
//        connectUndirected(am1,9,7);
//        connectUndirected(am1,3,8);
//        connectUndirected(am1,4,8);
//
//        for(int a=0;a<10;a++)
//            for(int b=a;b<10;b++)
//                if(isConnected(am1,a,b)) System.out.println(a+" is connected to "+b);
//    }
}
