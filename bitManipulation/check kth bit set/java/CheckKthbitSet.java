import java.util.*;
import java.io.*;
public class CheckKthbitSet {
    private static boolean isKthbitSet(int number,int k){
        if(k < 0)
            return false;
        //left shift
        // if ((number & (1 << (k - 1))) != 0)
		// 	return true;
		// return false;

        // right shift
        if (((number >> (k - 1)) & 1) == 1) 
		    return true; 
		return false;
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
            int k = Integer.parseInt(st.nextToken());
            pw.println("bit in position " + k + " of number " + number+" is "+isKthbitSet(number, k));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
