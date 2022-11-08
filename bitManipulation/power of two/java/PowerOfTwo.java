import java.util.*;
import java.io.*;
public class PowerOfTwo {
    //O(bits)
    private static boolean isPowerOfTwo_naive(int number){
        if(number <= 0) return false;
        while(number > 1){
            if(number % 2 != 0)
                return false;
            number= number>>1;
        }
        return true;
    }

    //O(1)
    private static boolean isPowerOfTwo_eff(int number){
        if(number <= 0)
            return false;
        if((number & (number - 1)) == 0)
            return true;
        return false;
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
			int number = Integer.parseInt(st.nextToken());
            if(isPowerOfTwo_eff(number))
                pw.println("number "+number+" is power of two");
            else
                pw.println("number "+number+" is not power of two");
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
