package smallest_positive_integer;
class SmallestPositiveMissingNumber{
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // swap positions of elements within the range to their respective positions until write elements to the current position 
        for(int i=0;i<size;i++){
            int ele = arr[i];
            int place = ele - 1;
            if(place<size && place>=0 && ele!=arr[place]){
                swap(arr,place,i);
                i--; // Decrement i so place point to same position until write element comes
            }
        }
        for(int i=0;i<size;i++)
            if(arr[i]!=(i+1))
                return i+1;
        return size+1;
    }
    public static void main(String[] args) {
        int arr[] = {0,-10,1,3,-20};
        System.out.println(missingNumber(arr, arr.length));
    }
}