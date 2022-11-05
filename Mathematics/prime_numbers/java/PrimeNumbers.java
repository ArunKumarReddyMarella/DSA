import java.util.*;
import java.io.*;
public class PrimeNumbers {
    static boolean isPrime(int number){
        for(int i=2;i*i <= number;i++){
            if(number % i == 0)
                return false;
        }
        return true;
    }
    static List<Integer> getPrimeNumbers(int number){
        List<Integer> primeNumbers = new ArrayList<Integer>();
        if(number < 2)
            return primeNumbers;
        for(int i=2;i<=number;i++){
            if(isPrime(i))
                primeNumbers.add(i);
        }
        return primeNumbers;
    }
    //O(nloglogn)
    static List<Integer> getPrimeNumber_seive(int number){
        List<Integer> primeNumbers = new ArrayList<Integer>();
        boolean isPrime[] = new boolean[number+1];
        Arrays.fill(isPrime, true);

        if(number < 2)
            return primeNumbers;
        // for(int i=2;i*i<=number;i++){
        //     if(isPrime[i]){
        //         for(int j=2*i;j<=number;j+=i){
        //             isPrime[j]=false;
        //         }
        //     }
        // }
        // for(int i=2;i<isPrime.length;i++){
        //     if(isPrime[i])
        //         primeNumbers.add(i);
        // }

        for(int i=2;i<=number;i++){
            if(isPrime[i]){
                primeNumbers.add(i);
                for(int j=i*i;j<=number;j+=i){
                    isPrime[j]=false;
                }
            }
        }
        return primeNumbers;
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
            pw.println("Prime Numbers upto " + number+" : "+getPrimeNumber_seive(number));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
