package pattern_searching;

public class PatternSearching{
    public static boolean searchPattern(String str, String pat) {
        int strSize = str.length();
        int patSize = pat.length();
        if(patSize > strSize)
            return false;
            
        for(int i=0;i<strSize-patSize+1;i++){
            int j = 0;
            for(;j<patSize;j++){
                if(str.charAt(i+j) != pat.charAt(j))
                    break;
            }
            if(j == patSize-1)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.oout.println(searchPattern("abcdefh","bcd"));
    }
}