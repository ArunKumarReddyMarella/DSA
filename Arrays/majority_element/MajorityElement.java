package majority_element;

public class MajorityElement {
    static int maxOccuredElement(int arr[]){
        int majorityElementIndex = 0;
        int count = 1;
        int n = arr.length; 
        for(int i=1;i<n;i++){
            if(arr[majorityElementIndex]==arr[i])
                count++;
            else
                count--;
            if(count == 0){
                majorityElementIndex = i;
                count = 1;
            }
        }
        int occurence = 0;
        for(int i=0;i<n;i++)
            if(arr[majorityElementIndex]==arr[i])
                occurence++;
        if(occurence >= n/2)
            return majorityElementIndex;
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {1,1,1,2,2};
        int majorityElementIndex = maxOccuredElement(arr);
        if(majorityElementIndex >= 0)
            System.out.println("Majority element: "+arr[majorityElementIndex]);
        else
            System.out.println("No Majority Element");
    }
}
