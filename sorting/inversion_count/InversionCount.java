package sorting.inversion_count;

public class InversionCount {
    public static void main (String[] args) 
    {
        int a[] = new int[]{10,5,30,15,7};
	    int l=0,r=4;
        
        int count = inverseAndMergeSort(a,l,r);
        System.out.println(count);
    }
    
    static int mergeAndCount(int arr[], int l, int m, int h){
        int c = 0;
        int n1=m-l+1, n2=h-m;
        int[] left=new int[n1];int[]right=new int[n2];
        for(int i=0;i<n1;i++)
            left[i]=arr[i+l];
        for(int j=0;j<n2;j++)
            right[j]=arr[m+1+j];    
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j])
                arr[k++]=left[i++];
            else{
                arr[k++]=right[j++];
                c+=n1-i;
            }
        }
        while(i<n1)
            arr[k++]=left[i++];
        while(j<n2)
            arr[k++]=right[j++];  
        return c;  
    }
    
    static int inverseAndMergeSort(int arr[],int l,int r){
        int c=0;
        if(r>l){
            int m=l+(r-l)/2;
            c+=inverseAndMergeSort(arr,l,m);
            c+=inverseAndMergeSort(arr,m+1,r);
            c+=mergeAndCount(arr,l,m,r);
        }
        return c;
    }
}
