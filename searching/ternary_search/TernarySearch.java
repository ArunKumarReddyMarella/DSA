public class TernarySearch{
    static int ternarySearch_recursive(int l, int r, int key, int ar[]) 
    { 
    if (r >= l) 
    { 
        // Find mid1 and mid2 
        int mid1 = l + (r - l) / 3; 
        int mid2 = r - (r - l) / 3; 
  
        // Check if key is present at any mid 
        if (ar[mid1] == key)  
        { 
            return mid1; 
        } 
        if (ar[mid2] == key) 
        { 
            return mid2; 
        } 
  
        // Since key is not present at mid, 
        // check in which region it is present 
        // then repeat the Search operation 
        // in that region 
        if (key < ar[mid1])  
        { 
  
            // The key lies in between l and mid1 
            return ternarySearch_recursive(l, mid1 - 1, key, ar); 
        } 
        else if (key > ar[mid2])  
        { 
  
            // The key lies in between mid2 and r 
            return ternarySearch_recursive(mid2 + 1, r, key, ar); 
        } 
        else
        { 
  
            // The key lies in between mid1 and mid2 
            return ternarySearch_recursive(mid1 + 1, mid2 - 1, key, ar); 
        } 
    } 
  
    // Key not found 
    return -1; 
    } 
    static int ternarySearch_iterative(int l, int r, int key, int ar[]) 
    { 
    while (r >= l) { 
  
        // Find mid1 and mid2 
        int mid1 = l + (r - l) / 3; 
        int mid2 = r - (r - l) / 3; 
  
        // Check if key is present at any mid 
        if (ar[mid1] == key) { 
            return mid1; 
        } 
        if (ar[mid2] == key) { 
            return mid2; 
        } 
  
        // Since key is not present at mid, 
        // check in which region it is present 
        // then repeat the Search operation 
        // in that region 
  
        if (key < ar[mid1]) { 
  
            // The key lies in between l and mid1 
            r = mid1 - 1; 
        } 
        else if (key > ar[mid2]) { 
  
            // The key lies in between mid2 and r 
            l = mid2 + 1; 
        } 
        else { 
  
            // The key lies in between mid1 and mid2 
            l = mid1 + 1; 
            r = mid2 - 1; 
        } 
    } 
  
    // Key not found 
    return -1; 
    } 
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        int n = arr.length;
        System.out.println(ternarySearch_recursive(0,n-1,6,arr));
        System.out.println(ternarySearch_recursive(0,n-1,11,arr));
        System.out.println(ternarySearch_iterative(0,n-1,10,arr));
        System.out.println(ternarySearch_iterative(0,n-1,12,arr));
    }
}