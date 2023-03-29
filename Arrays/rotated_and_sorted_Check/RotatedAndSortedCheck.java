package rotated_and_sorted_Check;

public class RotatedAndSortedCheck {
    public static boolean checkRotatedAndSorted(int arr[], int num){
        if(num==1)
            return true;
        
        // Your code here
        int fbreaks = 0;
        int bbreaks = 0;
        for(int i=1;i<num;i++){
            if(arr[i]<arr[i-1])
                fbreaks++;
            if(arr[i]>arr[i-1])
                bbreaks++;
        }
        boolean fcheck,bcheck;
        if((fbreaks >1 || fbreaks == 0) || arr[num-1] > arr[0])
            fcheck = false;
        else
            fcheck = true;
            
        if((bbreaks > 1 || bbreaks == 0) || arr[num-1] < arr[0])
            bcheck = false;
        else
            bcheck = true;
            
        return fcheck || bcheck;
    }
    
    public static void main(String[] args) {
        int[] arr = {3,4,1,5};
        System.out.println(checkRotatedAndSorted(arr, 4));
    }
}
