	//620ms
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

	static int[][] matrix;
	static boolean[][] visited;
	static Queue<index> q = new LinkedList<>();
	static int m,n,size,newSize,days;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st  = new StringTokenizer(br.readLine());
		 m = Integer.parseInt(st.nextToken());
		 n = Integer.parseInt(st.nextToken());
		matrix = new int[n][m];
		visited = new boolean[n][m];
		 days = 0; //result 
		 size =0;
		 newSize = 0;
		
		//input
		for(int i=0;i<n;i++) {
			st  = new StringTokenizer(br.readLine());
			
			for(int j=0;j<m;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
				if(matrix[i][j] == -1) visited[i][j] = true; //빈칸은 이미 지나감 이랑 같음 처리한다.
				if(matrix[i][j] == 1) {
					q.add(new index(i,j)); 	//첫 1들 한번에 큐에 넣기 . 
					visited[i][j] = true;
				}
				if(matrix[i][j] == 0 ) days=-1;
			}
		}
		
	
		if(days == 0 ) {
			System.out.println(0);
			return ;
		}
		
		
		size = q.size();
		BFS();
		
		
		
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j]) { //못 건든 곳 있으면 -1 
					System.out.println(-1);
					return;
				}
			
			}
			
		}
		
		System.out.println(days);
		
	}
	
	
	static void BFS() {
		int[] position = {-1,0,1,0,0,-1,0,1};
		
		while(!q.isEmpty()) {
			index now = q.poll();
			size--;
			for(int i=0;i<8;i+=2) { //2개가 쌍이니까 두칸씩 이동한다. 
				
				int A = now.a+position[i];
				int B = now.b+position[i+1];
				if(0<=A && A<= n-1 && 0<=B && B<=m-1) { //index 넘어가지 않게 , 
					if(matrix[A][B] == 0 && !visited[A][B]) {
							q.add(new index(A,B));
							newSize++;
							visited[A][B] = true;
					}
				}
			}
			if(size == 0) {
				days++;
				size = newSize;
				newSize = 0;
			}
		
			
		}
	}
	
	static public class index{
		
		int a;
		int b;
		
		
		public index(int a,int b) {
			this.b = b;
			this.a = a;
		}
		
	}
	
}
