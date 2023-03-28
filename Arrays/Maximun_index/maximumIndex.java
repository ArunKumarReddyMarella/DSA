package Maximun_index;

public class maximumIndex {
    static int maxIndexDiff_naive(int A[], int N){
        int maxIndex = 0;
        
        for(int i=0;i<N;i++){
            for(int j=N-1;j>=i;j--){
                if(A[j]>=A[i]){
                    maxIndex=Math.max(maxIndex,j-i);
                    break;
                }
            }
        }
        return maxIndex;
    }
    static int maxIndexDiff_eff(int A[], int N) { 
        
        int maxDistance = 0;
        int[] leftMin = new int[N];
        int[] rightMax = new int[N];
        leftMin[0] = A[0];
        rightMax[N-1] = A[N-1];
        for(int i=1;i<N;i++){
            leftMin[i] = Math.min(leftMin[i-1],A[i]);
        }
        for(int i=N-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],A[i]);
        }
        int i=0,j=0;
        while(i<N && j<N){
            if(leftMin[i]<=rightMax[j]){
                maxDistance = Math.max(maxDistance,j-i);
                j++;
            }
            else i++;
        }
        return maxDistance;
    }
    public static void main(String[] args) {
        int N = 9;
        int A[] = {34, 8, 10, 3, 2, 80, 30, 33, 1};
        int B[] = {1,10};
        System.out.println(maxIndexDiff_naive(A, N));
        System.out.println(maxIndexDiff_eff(A, N));
        System.out.println(maxIndexDiff_naive(B, 2));
        System.out.println(maxIndexDiff_eff(B, 2));
    }
    
}
