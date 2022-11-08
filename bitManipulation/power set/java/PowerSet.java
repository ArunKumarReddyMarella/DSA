import java.util.*;
import java.io.*;
public class PowerSet {
    private static String[] generatePowerSet(String str){
        int len=str.length();
        int n =(int)Math.pow(2,len); 
        String[] result = new String[n];

        for(int i=0;i<n;i++){
            String temp = "";
            for(int j=0;j<len;j++){
                if( (i & (1 << j))!=0 )
                    temp+=str.charAt(j);
            }
            result[i]=temp;
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
		fis = new FileInputStream("./../input.txt");
		fos = new FileOutputStream("./../output.txt");

		br = new BufferedReader(new InputStreamReader(fis));
		
		pw = new PrintWriter(fos);
		String line;

		while((line=br.readLine())!=null){
			st = new StringTokenizer(line);
			String word = st.nextToken().trim();
            String[] result = generatePowerSet(word);
            pw.println("power set of "+ word+ " is [");
            for(String temp : result){
                pw.println(temp);
            }
            pw.println("]");
            pw.println("---------------------------------------------------------------------------------");
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
}
