package print_all_permutations;

public class permutationsOfString {
    public static void main(String[] args) {
        String str = "abc";
        permutation(str,0);
    }


    private static void permutation(String str, int ind) {
        if(ind == str.length()-1){
            System.out.println(str);
            return;
        }

        for(int i = ind; i<str.length();i++){
            str = swap(str,ind,i);
            permutation(str, ind+1);
            str = swap(str,ind,i);
        }
    }

    private static String swap(String str, int ind, int i) {
        char[] strC = str.toCharArray();
        char c = strC[ind];
        strC[ind] = strC[i];
        strC[i] = c;

        return new String(strC);
    }
}
