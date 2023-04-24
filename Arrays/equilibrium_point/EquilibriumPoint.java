package equilibrium_point;

public class EquilibriumPoint{
    static boolean ePoint(int arr[]){
        int total_sum = 0;
        int size = arr.length;
        for(int i=0;i<size;i++)
            total_sum+=arr[i];
        int left_sum = 0;
        for(int i=0;i<size;i++){
            total_sum -= arr[i];
            if(total_sum == left_sum)
            {
                System.out.println(i);
                return true;
            }
            left_sum+=arr[i];
        }
        return false;
    }
    public static void main(String[] args) {
        int arr[] = {3,4,8,-9,9,7};
        System.out.println(arr);
    }
}