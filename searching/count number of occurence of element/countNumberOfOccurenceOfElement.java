import java.io.PrintStream;
import java.util.Scanner;

class countNumberOfOccurenceOfElement {
    /**
     *
     */
    private static final PrintStream OUT = System.out;

    static int Lsearch(int[] arr, int target) {
        int l = 0, h = arr.length - 1;
        int f = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == target) {
                /*
                 * if(m!=0 && arr[m]==arr[m-1]){ h=m-1; } else return m;
                 */
                f = m;
                h = m - 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else
                h = m - 1;
        }
        return f;
    }

    static int Rsearch(int[] arr, int target) {
        int l = 0, h = arr.length - 1, last = -1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (arr[m] == target) {
                /*
                 * if(m!=n && arr[m]==arr[m+1]){ l=m+1; } else return m;
                 */
                last = m;
                l = m + 1;
            } else if (arr[m] < target) {
                l = m + 1;
            } else
                h = m - 1;
        }
        return last;
    }

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int l = Lsearch(arr, k);
            int r = Rsearch(arr, k);
            if (l == -1 || r == -1)
                OUT.println(0);
            else
                OUT.println(r - l + 1);
        }
        sc.close();
    }
}