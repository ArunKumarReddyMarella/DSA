import java.io.*;
import java.util.*;

class CountTrailingZeros {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
	static int countTrailingZeros(int n)
	{
		int res = 0;

		for(int i=5; i<=n; i=i*5)
		{
			res = res + (n / i);
		}

		return res;
	}

	public static void main (String[] args) throws IOException{
        System.out.println("Enter the number");
        StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());

		System.out.println(countTrailingZeros(number));

	}
}