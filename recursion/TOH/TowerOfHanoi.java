package TOH;

public class TowerOfHanoi {
    public static void main(String[] args) {
        toh(3,'A','B','C');
        System.out.println();

    }
    //T(1)=1
    //T(n)=2T(n-1)+1
    //T(n)=2^n -1
    private static void toh(int i, char a, char b, char c) {
        if(i==1){
            System.out.println("move 1 from "+a+" to "+c);
            return;
        }
        toh(i-1,a,c,b);
        System.out.println("Move " + i + " from " +  a + " to " + c); 
        toh(i-1,b,a,c);
    }
}
