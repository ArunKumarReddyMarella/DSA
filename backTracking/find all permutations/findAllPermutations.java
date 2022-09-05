import java.util.*;
public class findAllPermutations
{
  static class Result {
  static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);        
  }
  static int ind=0;
static void solve(String str,String[] permutations,int i){
  if(str.length()==i+1){
    permutations[ind++]=str;
    return;
  }
  for(int j=i;j<str.length();j++){
    str=swap(str,i,j);
    solve(str,permutations,i+1);
    str=swap(str,i,j);
  }
}
static void allPermutations(String str, String permutations[]){
  solve(str,permutations,0);
}
}
  public static void main(String[] args)
  {
    String str;
    Result o1 = new Result();
    try (Scanner sc = new Scanner(System.in)) {
      str = sc.next();
    }
    int n = 1;
    for (int i = 2; i <= str.length(); i++)
        n *= i;
    String[] permutations = new String[n];
    o1.allPermutations(str, permutations);
    Arrays.sort(permutations);
    for (int i=0; i<n; i++)
        System.out.println(permutations[i]);
  }
}