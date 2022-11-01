import java.io.*;
import java.util.*;

public class GCDOfNumbers {
    static int gcd_iterative(int a, int b){
        while(a!=b){
            if(a>b)
                a-=b;
            else
                b-=a;
        }
        return a;
    }
    static int gcd_recursive(int a, int b){
        if(b==0) return a;
        return gcd_recursive(b,a%b);
    }
    public static void main(String[] args) {
        FileInputStream fis;
		FileOutputStream fos;
		BufferedReader br;
		PrintWriter pw;
		StringTokenizer st;


		try{
		fis = new FileInputStream("input.txt");
		fos = new FileOutputStream("output.txt");

		br = new BufferedReader(new InputStreamReader(fis));
		
		pw = new PrintWriter(fos);
		String line;

		while((line=br.readLine())!=null){
			st = new StringTokenizer(line);
			int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
			pw.println("GCD Iterative of "+number1+" and "+number2+" : "+gcd_iterative(number1, number2));
            pw.println("GCD Recursive of "+number1+" and "+number2+" : "+gcd_recursive(number1, number2));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
