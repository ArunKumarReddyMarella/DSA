class sort012 {
    public static void Sort012(int a[], int n) {
        // code here
        int i = 0, j = 0, k = a.length - 1;
        while (j <= k) {
            if (a[j] == 0) {
                int temp = a[j];
                a[j] = a[i];
                a[i] = temp;
                i++;
                j++;
            } else if (a[j] == 2) {
                int temp = a[j];
                a[j] = a[k];
                a[k] = temp;
                k--;
            } else
                j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 1, 2 };
        Sort012(arr, 5);
        for (int i = 0; i < 5; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
