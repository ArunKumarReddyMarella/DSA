class findRightBoundIndexInSortedArray{
    static int search(int[] arr,int target){
        int l=0,h=arr.length-1,n=h,last=-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(arr[m]==target){
                /*if(m!=n && arr[m]==arr[m+1]){
                    l=m+1;
                }
                else
                    return m;*/
                last=m;
                l=m+1;
            }
            else if(arr[m]<target){
                l=m+1;
            }
            else
                h=m-1;
        }
        return last;
    }
    public static void main(String[] args) {
        int[] arr={0,1,1,3,3,3,3,4,5,5,5,6};
        int target=1;
        System.out.println(search(arr,target));
    }
}