
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	 static int M,N,K;
	 static int[][] matrix ;
	 static  boolean[][] visited;
	 
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int times = Integer.parseInt(br.readLine());
		
		while(times-- > 0) {
			StringTokenizer st  = new StringTokenizer(br.readLine());
			 M = Integer.parseInt(st.nextToken());
			 N = Integer.parseInt(st.nextToken());
			 K = Integer.parseInt(st.nextToken());
			 int result =0;
			 matrix =new  int[M][N];
			 visited = new boolean[M][N];
			 
			 //matrix 채우기 
			 for(int k=0;k<K;k++) {
				 st  = new StringTokenizer(br.readLine());
				 int m=Integer.parseInt(st.nextToken());
				 int n=Integer.parseInt(st.nextToken());
			
				 matrix[m][n] = 1;
				
			 }
			 for(int m=0;m<M;m++) {
				 for(int n=0;n<N;n++) {					 
					 if(!visited[m][n] && matrix[m][n] == 1) {
						 result++;
						 visited[m][n] = true;
						 DFS(m,n);						
					 }
				 }
			 }

			 System.out.println(result);	 
		}
	}
	
	static public void DFS(int m,int n) {
		
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int nowM = m+dx[i];
			int nowN = n+dy[i];
			
			if(nowM >= 0 && nowN >= 0  &&nowM<M &&nowN <N) {
				if(!visited[nowM][nowN] && matrix[nowM][nowN] == 1) {
					visited[nowM][nowN] = true;
					DFS(nowM,nowN);	
			
			}
				
			}
			
			
		}
		
		return ;
	}
	
	

	
}
