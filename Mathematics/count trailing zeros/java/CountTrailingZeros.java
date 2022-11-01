import java.io.*;
import java.util.*;

class CountTrailingZeros{

	static int countTrailingZeros(int n)
	{
		int res = 0;
		//counting 5's in n factorial
		for(int i=5; i<=n; i=i*5)
		{
			res = res + (n / i);
		}

		return res;
	}

	public static void main (String[] args) throws Exception{
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

		while((line=br.readLine())!=null){
			st = new StringTokenizer(line);
			int number = Integer.parseInt(st.nextToken());
			pw.println(countTrailingZeros(number));
		}
		pw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}