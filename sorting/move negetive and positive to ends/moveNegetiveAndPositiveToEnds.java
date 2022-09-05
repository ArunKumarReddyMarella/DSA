class moveNegetiveAndPositiveToEnds {
    static void solve(int[] ar) {
        int n = ar.length;
        int i = 0;
        int j = 0;
        while (j < n) {
            if (ar[j] < 0) {
                int temp = ar[j];
                ar[j] = ar[i];
                ar[i] = temp;
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 10, 2, -5, 3, 0, -1 };
        solve(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}