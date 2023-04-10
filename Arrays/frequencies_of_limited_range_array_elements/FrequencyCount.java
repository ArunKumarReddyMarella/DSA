package frequencies_of_limited_range_array_elements;

import java.util.Scanner;

public class FrequencyCount {
    //O(n,1)
    public static void frequencyCount(int arr[], int N, int P)
    {
        //swapping value in position with current position and making position value to -1 or decrementing respectively
        //ignore elements by making it 0
        for(int i=0;i<N;i++){
            if(arr[i]>N)
                arr[i]=0;
        }
        for(int i=0;i<N;i++){
            if(arr[i]>=1 && arr[i]<=N){
                int position = arr[i]-1;
                int value = arr[position];
                if(value >= 0){
                    arr[i] = value;
                    arr[position] = -1;
                    i--;
                }
                else{
                    arr[position] -=1;
                    arr[i] = 0;
                }
            }
        }
        for(int i=0;i<N;i++)
            arr[i]*=-1;
//----------------------------------------------------------------------------------------------------//
        //incrementing the each element by max for each occurence 
        int max = P+1;
        //ignore elements by making it 0
        for(int i=0;i<N;i++){
            if(arr[i]>N)
                arr[i]=0;
        }
        for (int i = 0; i < N; i++) {
            if(arr[i]%max==0)
                continue;
            int index = arr[i] % max;
            arr[index-1] += max;
        }
        for (int i = 0; i < N; i++) {
            //decoding to get occurences
            arr[i]=arr[i]/max;
        }
    }
    private static void print(int[] arr) {
        for (var each : arr) {
            System.out.print(each+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int arr[] = new int[N];
    for(int i=0;i<N;i++)
        arr[i] = sc.nextInt();
    int P = sc.nextInt();
    frequencyCount(arr, N, P);
    for (var each : arr) {
        System.out.print(each+" ");
    }
    sc.close();
    }
}
