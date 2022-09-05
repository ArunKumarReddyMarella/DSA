class findLeftBoundIndexInSortedArray{
    static int search(int[] arr,int target){
        int l=0,h=arr.length-1;
        int f=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==target){
                /*if(m!=0 && arr[m]==arr[m-1]){
                    h=m-1;
                }
                else
                    return m;*/
                f=m;
                h=m-1;
            }
            else if(arr[m]<target){
                l=m+1;
            }
            else
                h=m-1;
        }
        return f;
    }
    public static void main(String[] args) {
        int[] arr={0,1,1,3,3,3,3,4,5,5,5,6};
        int target=4;
        System.out.println(search(arr,target));
    }
}