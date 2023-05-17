package searching.count_only_repeated;

public class CountOnlyRepeated {
    static class Pair{
        long x;
        long y;
        
        Pair(long x, long y){
            this.x = x;
            this.y = y;
        }
    }
   //Function to find repeated element and its frequency.
   public static Pair findRepeating(Long arr[],int n)
   {
       //Your code here
       if((n - (arr[n-1] - arr[0])) == 1)
           return new Pair(-1L,-1L);
       
       int start = 0,end = n-1;
       while(start < end){
           int mid = start + (end-start)/2;
           
           if(arr[mid] >= mid + arr[0])
               start = mid + 1;
           else
               end = mid;
       }
       return new Pair(arr[start],n - (arr[n-1] - arr[0]));
   }  

   public static void main(String[] args) {
   int N = 6;
   Long arr[] = {1L,2L,3L,4L,4L,4L};
   Pair p = findRepeating(arr,N);
   System.out.println(p.x+" "+p.y);
   }
}
