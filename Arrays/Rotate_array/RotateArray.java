package Rotate_array;

public class RotateArray {
    static void reverse(int arr[],int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    //Function to rotate an array by d elements in counter-clockwise direction. 
    static void rotateArr(int arr[], int d, int n)
    {
        d=d%n;
        //d=n-d; //for clockwise rotation
        reverse(arr,0,d-1);
        reverse(arr,d,n-1);
        reverse(arr,0,n-1);
        
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int d = 2;
        rotateArr(arr, d, 5);
        for(int i : arr)
            System.out.print(i+" ");
    }
}
