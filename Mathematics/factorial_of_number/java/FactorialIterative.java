import java.io.*;
import java.util.*;

public class FactorialIterative {
    static Integer factorial(int number) {
       Integer result = 1;
       while(number > 0){
        result*= number--;
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
            fis = new FileInputStream("input.txt");
            fos = new FileOutputStream("output.txt");
    
            br = new BufferedReader(new InputStreamReader(fis));
            
            pw = new PrintWriter(fos);
            String line;
            while((line = br.readLine() ) != null){
                st = new StringTokenizer(line);
                int number = Integer.parseInt(st.nextToken());
                pw.println("factorial of " + number +" is "+factorial(number));
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
