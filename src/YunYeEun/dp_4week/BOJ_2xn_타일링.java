import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main {

	public static void main(String[] args) throws IOException {

//   2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
// 아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	     BufferedWriter sb = new BufferedWriter(new OutputStreamWriter(System.out));
	     StringBuilder SB = new StringBuilder();
	   
	     int t = Integer.parseInt(br.readLine());
	    
	     int[] d = new int[t+1];
	     d[0] = 1;
	     d[1] = 1;
	    
	     for(int i=2;i<=t;i++)  d[i] = (d[i-1] + d[i-2])%10007;
	     System.out.println(d[t]);
	    
	}
}
