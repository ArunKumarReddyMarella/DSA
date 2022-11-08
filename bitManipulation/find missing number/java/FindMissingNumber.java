import java.util.*;
import java.io.*;;
public class FindMissingNumber {
    private static int findMissingNumber(int[] numbers){
        int x1 = numbers[0];
		int x2 = 1;
		// For xor of all the elements in array
		for (int i = 1; i < numbers.length; i++)
			x1 = x1 ^ numbers[i];
		// For xor of all the elements from 1 to n+1
		for (int i = 2; i <= numbers.length + 1; i++)
			x2 = x2 ^ i;
		return (x1 ^ x2);
    }
    public static void main(String[] args) {
        FileInputStream fis;
		FileOutputStream fos;
		BufferedReader br;
		PrintWriter pw;


		try{
		fis = new FileInputStream("./../input.txt");
		fos = new FileOutputStream("./../output.txt");

		br = new BufferedReader(new InputStreamReader(fis));
		
		pw = new PrintWriter(fos);
		String line;

		while((line=br.readLine())!=null){
            int[] numbers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            pw.println("Misssing number is " +findMissingNumber(numbers));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
