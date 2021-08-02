package sample;

public class BitwiseDemoIM {

        //byte[] im1=new byte [8]; //Max of 8 edges/links using byte primitive
        //int[] im2=new int [32]; //Max of 32 edges/links using int primitive
        //long[] im3=new long [64]; //Max of 64 edges/links using long primitive

    static int edgeCount=0; //For simplicity (can only do one IM graph in this demo due to this static var
    //but would be easy to use an instance variable instead to support multiple graphs)

    public static void connectUndirected(byte[] im, int a, int b){
        im[a]= (byte) (im[a] | (0b10000000 >>> edgeCount));
        im[b]= (byte) (im[b] | (0b10000000 >>> edgeCount++));
    }

    public static boolean isConnected(byte[] im, int a, int b)
    {
        if(a==b) return false;
        for(int e=0;e<edgeCount;e++)
            if((im[a] & (0b10000000 >>> e))!=0 && (im[b] & (0b10000000 >>> e))!=0) return true;
        return false;
    }

    public static void connectUndirected(int[] im, int a, int b){
        im[a]= (im[a] | (0x80000000 >>> edgeCount));
        im[b]= (im[b] | (0x80000000 >>> edgeCount++));
    }

    public static boolean isConnected(int[] im, int a, int b)
    {
        if(a==b) return false;
        for(int e=0;e<edgeCount;e++)
            if((im[a] & (0x80000000 >>> e))!=0 && (im[b] & (0x80000000 >>> e))!=0) return true;
        return false;
    }

//    public static void main(String[] args){
//        byte[] im1=new byte [8];
//
//        connectUndirected(im1,6,1);
//        connectUndirected(im1,0,1);
//        connectUndirected(im1,5,1);
//        connectUndirected(im1,0,5);
//        connectUndirected(im1,4,0);
//        connectUndirected(im1,5,7);
//        connectUndirected(im1,5,3);
//        connectUndirected(im1,3,2);
//        // connectUndirected(im1,9,7);
//        // connectUndirected(im1,3,8);
//        // connectUndirected(im1,4,8);
//
//        for(int a=0;a<8;a++) //Change 8 to number of nodes used
//            for(int b=a;b<8;b++)
//                if(isConnected(im1,a,b)) System.out.println(a+" is connected to "+b);
//    }
}
