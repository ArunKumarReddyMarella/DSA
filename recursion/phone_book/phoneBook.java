package phone_book;

import java.util.ArrayList;


public class phoneBook {
    static ArrayList<String> result = new ArrayList<>();
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[])
    {
        String[] map = {
            "",
            "",
            "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        String curStr ="";
        int at =0;
        dfs(a,at,map,curStr);
        return result;
    }
    
    static void dfs(int[] a,int at, String[] map,String curStr){
        if(at >= a.length){
            result.add(curStr.toString());
            return;
        }
        for(int i = 0; i < map[a[at]].length(); i++){
            dfs(a, at+1, map, curStr+map[a[at]].charAt(i));
        }
    }
    public static void main(String[] args) {

        //int[] a = {2,3,4};
        int[] a = {5,8,8,9,8};
        System.out.println(possibleWords(a));
    }
}
