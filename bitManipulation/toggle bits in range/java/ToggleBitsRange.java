import java.util.*;
import java.io.*;
public class ToggleBitsRange {
    private static int toggle_naive(int number,int left,int right) {
        int res = number;
        for (int i = left; i <= right; i++) {
            // Set bit
            if ((number & (1 << (i - 1))) != 0) {
                // XOR will set 0 to already set
                // bits(a^a=0)
                res = res ^ (1 << (i - 1));
            }
            // unset bits
            else {
                // OR will set'0'bits to 1
                res = res | (1 << (i - 1));
            }
        }
        return res;
    }
    private static int toggle_eff(int number,int left,int right) {
        //int k = (1<<right)-1 ^ (1<<(left-1)-1);
        // or
        int k=(1<<right)-left;
        return number ^ k;
    }
    public static void main(String[] args) {
        FileInputStream fis;
		FileOutputStream fos;
		BufferedReader br;
		PrintWriter pw;
		StringTokenizer st;


		try{
		fis = new FileInputStream("./../input.txt");
		fos = new FileOutputStream("./../output.txt");

		br = new BufferedReader(new InputStreamReader(fis));
		
		pw = new PrintWriter(fos);
		String line;

		while((line=br.readLine())!=null){
			st = new StringTokenizer(line);
			int number =Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            pw.println("Toggle bits of number " + number + " between " + left + " and " + right + " is "+toggle_eff(number, left, right));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
