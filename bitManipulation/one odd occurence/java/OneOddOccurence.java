import java.util.*;
import java.io.*;
public class OneOddOccurence {
    //O(nxn,1)
    private static int findOdd_naive(int[] numbers){
        int n=numbers.length;
        for(int i = 0; i < n; i++)
        {
            int count = 0;
            for(int j = 0; j < n; j++)
            {
                if(numbers[i] == numbers[j])
                    count++;
            }
            if(count % 2 != 0)
                return numbers[i];   
        }
        return 0;
    }

    //HashSet O(n,n)

    //O(n,1)
    private static int findOdd_eff(int[] numbers){
        int result = 0;
        for(var x: numbers){
            result^= x;
        }
        return result;
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
            pw.println("Odd number is " +findOdd_eff(numbers));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
