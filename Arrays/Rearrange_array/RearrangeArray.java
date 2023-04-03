package Rearrange_array;

public class RearrangeArray {
    // Dividend = Quotient*Divisor + Reminder
    //Dividend / Divisor = Quotient
    //Dividend % Divisor = Reminder
    //store 2 values at a time

    static void arrange(long arr[], int n)
    {
        for(int i=0;i<n;i++){
            long x = arr[i];
            long y= arr[(int)x];
            //encoding the value
            arr[i] = x+(y%n)*n;
        }
        //decoding
        for(int i=0;i<n;i++)
            arr[i] = arr[i] / n;
    }
    public static void main(String[] args) {
        long[] arr = {4,0,2,1,3};
        arrange(arr, 5);
        for(int i=0;i<5;i++)
            System.out.print(arr[i]+" ");
    }
}
