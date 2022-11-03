import java.io.*;
import java.util.*;
public class Divisors {
    static List<Integer> getSortedDivisors(int number){
        List<Integer> divisors = new ArrayList<Integer>();
        int i;
        for(i=1;i*i < number;i++){
            if(number % i == 0){
                divisors.add(i);
            }
        }
        // test case number = 6,30
        if (i - (number / i) == 1) {
            i--;
        }
        for(;i>=1;i--){
            if(number%i==0){
                divisors.add(number/i);
            }
        }
        return divisors;
    }
    static List<Integer> getDivisors(int number){
        List<Integer> divisors = new ArrayList<Integer>();
        for(int i=1;i*i<number;i++){
            if(number % i == 0){
                divisors.add(i);
                if(i!=number/i)
                    divisors.add(number/i);
            }
        }
        return divisors;
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
			pw.println("Factors of " + number+" "+getDivisors(number));
            pw.println("Sorted Factors of " + number+" "+getSortedDivisors(number));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }    
}
