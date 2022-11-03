import java.util.*;
import java.io.*;
public class PrimeFactors {
    static List<Integer> primeFactors_root(int number){
        List<Integer> result = new ArrayList<Integer>();
        if(number <= 1)
            return result;
        for(int i=2;i*i <= number;i++){
           while(number%i==0){
            result.add(i);
            number=number/i;
           }
        }
        // test case number=84
        if(number > 1)
            result.add(number);
        return result;
    }

    static List<Integer> primeFactors_eff(int number){
        List<Integer> result = new ArrayList<Integer>();
        if(number <= 1)
			return result;

		while(number % 2 == 0)
		{
            result.add(2);
			number = number / 2;
		}

		while(number % 3 == 0)
		{
            result.add(3);
			number = number / 3;
		}

		for(int i=5; i*i<=number; i=i+6)
		{
			while(number % i == 0)
			{
                result.add(i);
				number = number / i;
			}

			while(number % (i + 2) == 0)
			{
                result.add(i+2);
				number = number / (i + 2);
			}
		}
		if(number > 3)
			result.add(number);
        return result;
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
            pw.println("Prime Factors of "+number+" : " + primeFactors_eff(number));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
