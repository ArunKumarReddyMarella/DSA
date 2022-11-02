import java.io.*;
import java.util.*;
public class LCMofNumbers{
    static int gcd(int x, int y){
        if(y==0)
            return x;
        else
            return gcd(y,x%y);
    }
    static int lcm(int a, int b){
        return (a*b)/gcd(a,b);
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
			pw.println("LCM of "+number1+" and "+number2+" : "+lcm(number1, number2));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}