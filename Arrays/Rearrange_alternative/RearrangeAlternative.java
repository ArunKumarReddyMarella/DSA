package Rearrange_alternative;

public class RearrangeAlternative {
    public static void rearrange(long arr[], int n){
        //max is defined as max of all elements ex:10^9+7
        long max = arr[n-1]+1;
        int maxInd = n-1;
        int minInd = 0;
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                arr[i] = arr[i]+(arr[maxInd]%max)*max;
                maxInd--;
            }
            else{
                arr[i] = arr[i]+(arr[minInd]%max)*max;
                minInd++;
            }
        }
        for(int i=0;i<n;i++)
            arr[i] /= max;
    }
    public static void main(String[] args) {
        long arr[] = {1,2,3,4,5};
        rearrange(arr, arr.length);
        for(long i:arr){
            System.out.print(i+" ");
        }
    }
}
