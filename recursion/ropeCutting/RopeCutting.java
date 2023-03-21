package ropeCutting;
public class RopeCutting{

    public static void main(String[] args) {
        int length = 5;
        int a=2,b=5,c=1;
        System.out.println(maxPeices(length,a,b,c));
        System.out.println(maxPeices(9, 2, 2, 2));
        System.out.println(maxPeices(23, 9, 11, 12));
    }

    private static int maxPeices(int length, int a, int b, int c) {
        if(length == 0)
        {
            return 0;
        }
        if(length < 0)
        {
            return -1;
        }
        int result = Math.max(maxPeices(length-a, a, b, c),Math.max(maxPeices(length-b, a, b, c),maxPeices(length-c, a, b, c)));
        if(result==-1)
        {
            return -1;
        }
        return result+1;
    }
}