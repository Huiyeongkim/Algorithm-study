
import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] nowumnCheck;
	static boolean[] rightUpCheck;
	static boolean[] leftDownCheck;
	static int cnt=0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine()); //범위
		
		nowumnCheck = new boolean[N];
		rightUpCheck = new boolean[2*N-1];
		leftDownCheck =  new boolean[2*N-1];
		
		if(N==1) {
			bw.write(1+"\n");
			bw.flush();
			bw.close();
			return;
		}
		
		
	
		backtracking(0);
		
		bw.write(cnt+"\n");
		bw.flush();
		bw.close();
		
		

	
	}
	
	
	
	public static void backtracking(int now)  {
		//끝까지 오면 
		if(now == N) {
			cnt++;
			return; 
		}
	
		for(int i=0;i<N;i++) { //col
			
			if(nowumnCheck[i] || rightUpCheck[i+now] || leftDownCheck[now-i+N-1]) continue;
			
			//	System.out.println(now+","+i);
				nowumnCheck[i] = true;
				rightUpCheck[i+now] = true;
				leftDownCheck[now-i+N-1] = true;
				now++;
				backtracking(now);
				now--;
				nowumnCheck[i] = false;
				rightUpCheck[i+now] = false;
				leftDownCheck[now-i+N-1] = false;
					
			
			
		}
		
		
		return;
	}
	
		
		
	
}
