import java.util.*;
import java.io.*;
public class PowerOfNumbers{
    static int mod = 1000000007;
    static int reverseNumber(int number){
        int result = 0;
        while(number > 0){
            result = result*10 + number%10;
            number = number / 10;
        }
        return result;
    }
    static long power(int N,int R)
    {
        //Your code here
        //long result = 1;
        // for(int i=0;i<R;i++){
        //     result = (result * N)%mod;
        // }
        //-------------------------------------

        
    //   if(R==0)
    //   {
    //       return 1;
    //   }
    //   long temp=power(N,R/2);
    //   temp=(temp*temp)%1000000007;
       
    //   if(R%2==0)
    //   {
    //       return temp%1000000007;
    //   }
    //   else
    //   {
    //       return (temp*N)%1000000007;
    //   }
        //--------------------------------------------
        
        long result=1;
        long b = N;
        while(R>0){
            if((R&1) == 1)
                {
                    result = (result%mod * b%mod)%mod;
                }
            b =((b%mod)*(b%mod))%mod;
            R = R>>1;
        }
        return result;
        //----------------------------------------------------  
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
                int reversedNumber = reverseNumber(number);
                pw.println(number+" to the power of "+reversedNumber+" is: "+power(number,reversedNumber));
            }
            pw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}