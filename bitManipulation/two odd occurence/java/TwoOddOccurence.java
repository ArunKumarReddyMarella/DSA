import java.util.*;
import java.io.*;

public class TwoOddOccurence {
    //O(nxn)
    private static String findOdds_naive(int[] numbers){
        String result="";
        for(int i = 0; i < numbers.length; i++)
        {
            int count = 0;
            
            for(int j = 0; j < numbers.length; j++)
            {
                if(numbers[i] == numbers[j])
                    count++;
            }
            
            if(count % 2 != 0)
                result=result+numbers[i]+" ";
            
        }
        return result;
    }

    private static String findOdds_eff(int[] numbers){
        int xor = 0;
        for(int i:numbers){
            xor ^= i;
        }

        //LSB
        int k= xor & (~(xor-1));
        int result1=0,result2=0;
        for(int i:numbers){
            if((k & i) !=0)
                result1 ^= i;
            else
                result2 ^= i;
        }
        return (result1+" "+result2);
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
            pw.println("Odd numbers are " +findOdds_eff(numbers));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
