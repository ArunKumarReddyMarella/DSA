import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PalindromeNumber{
    static boolean isPalindromeNumber(int number){
        int reverse = 0;
        int temp_number = number;
        while(temp_number > 0){
            int reminder = temp_number % 10;
            reverse = reverse*10 + reminder;
            temp_number = temp_number / 10;
        }
        return (reverse == number);
    }

    public static void main(String[] args) throws Exception {
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
                if(isPalindromeNumber(number)){
                    pw.println(number+" is a palindrome number");
                }
                else{
                    pw.println(number+" is not a palindrome number");
                }
            }
            pw.close();
            }
            catch (Exception e) {
                e.printStackTrace();
        }
        

    }
}