class moveNegetiveAndPositiveToEndsWithOrder {
    public static void solve(int[] ar) {
        // modified insertion sort
        int n = ar.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (ar[j] >= 0)
                continue;
            i = j;
            int temp = ar[i];
            while (i > 0 && ar[i - 1] >= 0) {
                ar[i] = ar[i - 1];
                i--;
            }
            ar[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ar = { 10, 2, -5, 3, 0, -1 };
        solve(ar);
        for (int i : ar)
            System.out.print(i + " ");
    }
}