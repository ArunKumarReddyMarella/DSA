package searching.maximum_water_between_two_buildings;

public class MaxWater {
    static int maxWater(int arr[], int n) 
    { 
        //Your code here
        int result = 0;
        int l=0,h=n-1;
        while(l<=h){
            result=Math.max(result,(h-l-1)*Math.min(arr[l],arr[h]));
            if(arr[l]<=arr[h])
                l++;
            else
                h--;
        }
        return result;
    } 
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(maxWater(arr, 10));
    }
}
