import java.util.*;
import java.io.*;
public class CountSetBits {
    //O(bits)
    private static int countSetBits_naive(int number){
        int result = 0;
        while(number > 0){
            if(number % 2 == 1){
                result++;
            }
            number/=2;
        }
        return result;
    }

    //Beian Kerningam's algorithm
    //O(set bits)
    private static int countSetBits_eff(int number){
        int result = 0;
        while(number > 0){
            result++;
            number=number&(number-1);
        }
        return result;
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
            pw.println("number of set bits in " + number + " is "+countSetBits_eff(number));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
        System.out.println(countSetBits_eff(0));
    }    
}
