import java.util.*;
import java.io.*;
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
  public static void main(String[] args) throws Exception
  {
    FileInputStream fis = new FileInputStream("input.txt");
    FileOutputStream fos = new FileOutputStream("output.txt");

    BufferedReader br = new BufferedReader(new InputStreamReader(fis));
    StringTokenizer st = new StringTokenizer(br.readLine());


    PrintWriter pw = new PrintWriter(fos);



    String str;
    Result o1 = new Result();
    str = st.nextToken();
    int n = 1;
    for (int i = 2; i <= str.length(); i++)
        n *= i;
    String[] permutations = new String[n];
    o1.allPermutations(str, permutations);
    Arrays.sort(permutations);
    for (int i=0; i<n; i++)
        pw.println(permutations[i]);
    pw.close();
  }
}