import java.util.*;
import java.io.*;

public class PowerOfNumber {
    private static int power_naive(int x, int y) {
        if(y==0)
            return 1;
        if(x==1)
            return x;
        if(x==-1)
            if(y%2==0)
                return 1;
            else
                return -1;
        int result = 1;
        for(int i=0; i< y; i++)
            result*=x;
        return result;
    }
    //O(logn,logn)
    private static int power_rec(int x, int y){
        if(y==0)
            return 1;
        if(x==1)
            return x;
        if(x==-1)
            if(y%2==0)
                return 1;
            else
                return -1;
        int result = power_rec(x, y/2);
        if(y%2==0)
            return result*result;
        return result*result*x;
    }
    //O(logn,1)
    //Binary Exponentiation
    //2p10=2p8 x 2p2
    private static int power_iter(int x, int y){
        if(y==0)
            return 1;
        if(x==1)
            return x;
        if(x==-1)
            if(y%2==0)
                return 1;
            else
                return -1;
        int res = 1;
        while(y>0){
            if(y%2!=0)
                res*=x;
            x*=x;
            y/=2;
        }
        return res;
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
			int number1 = Integer.parseInt(st.nextToken());
            int number2 = Integer.parseInt(st.nextToken());
            pw.println(number1 +" to the power of "+ number2+" is "+power_iter(number1, number2));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }

}
