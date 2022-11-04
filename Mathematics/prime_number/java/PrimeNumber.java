import java.io.*;
import java.util.*;
public class PrimeNumber {
    static boolean isPrime_root(int number){
        if(number < 2)
             return false;
        if(number < 3)
            return true;
        // n=sqrt(number) in for loop reduce i*i multiplications
        for(int i=2;i*i < number;i++){
            if(number%i == 0)
                return false;
        }
        return true;
    }
    static boolean isPrime_eff(int number){
        if(number == 1)
            return false;
        if(number==2 || number== 3)
            return true;
        if(number%2==0 || number%3==0)
            return false;
        for(int i=5;i*i<=number;i+=6){
            if(number%i==0 || number%(i+2)==0)
                return false;
        }
        return true;
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
			int number = Integer.parseInt(st.nextToken());
            if(isPrime_eff( number) && isPrime_root(number))
			    pw.println(number+" is prime");
            else
                pw.println(number+" is not prime");
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
