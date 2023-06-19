package sorting.merge3sortedarrays;

import java.util.ArrayList;

class Merge3SortedArrays{



    public static void main(String[] args)
    {
        int[] A = { 1, 2, 3, 52 };
        int[] B = { 6, 7, 8, 9 };
        int[] C = { 10, 11, 12 };
 
        ArrayList<Integer> final_ans
            = merge3sorted(A, B, C);
        printeSorted(final_ans);
    }
    private static ArrayList<Integer> merge3sorted(int[] a, int[] b, int[] c) {
        ArrayList<Integer> sortedArray = new ArrayList<>();
        int al=a.length,bl=b.length,cl=c.length;
        int ap=0,bp=0,cp=0;
        while(ap<al || bp<bl || cp<cl){
            int av = Integer.MAX_VALUE;
            int bv = Integer.MAX_VALUE;
            int cv = Integer.MAX_VALUE;

            if(ap<al)
                av=a[ap];
            if(bp<bl)
                bv=b[bp];
            if(cp<cl)
                cv=c[cp];

            if(av <= bv && av <= cv){
                sortedArray.add(av);
                ap++;
            }
            else if(bv <= av && bv <= cv){
                sortedArray.add(bv);
                bp++;
            }
            else if(cv <= av && cv <= bv){
                sortedArray.add(cv);
                cp++;
            }

        }
        return sortedArray;
    }
    // A utility function to print array list
    static void printeSorted(ArrayList<Integer> list)
    {
        for (Integer x : list)
            System.out.print(x + " ");
    }
}