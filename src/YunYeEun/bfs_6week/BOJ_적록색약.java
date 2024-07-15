
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/*
적록색약이 아닌 사람이 봤을 때 구역의 수는 총 4개이다. (빨강 2, 파랑 1, 초록 1) 하지만, 
적록색약인 사람은 구역을 3개 볼 수 있다. (빨강-초록 2, 파랑 1)
그림이 입력으로 주어졌을 때, 적록색약인 사람이 봤을 때와 아닌 사람이 봤을 때 구역의 수를 구하는 프로그램을 작성하시오.
*/

public class Main {

	static char[][] matrix;
	static boolean[][] CBvisited;
	static boolean[][] visited;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		n = Integer.parseInt(br.readLine());
		
		List<Integer> result = new ArrayList<>();
		matrix = new char[n][n];
		CBvisited = new boolean[n][n];
		visited = new boolean[n][n];
		int count = 0;
		int CBcount = 0;
		//input
		for(int i=0;i<n;i++) {
			String c = br.readLine();
			for(int j=0;j<n;j++) {
				matrix[i][j] = c.charAt(j);
			}
		}
		
		//색약 없음, 
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!visited[i][j]) {
					BFS(i,j,visited);
					count++;
				}
			}
		}
		
		//R=G 통합 시키기 , 
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j] == 'R') matrix[i][j] = 'G';
				
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(!CBvisited[i][j]) {
					BFS(i,j,CBvisited);
					CBcount++;
				}
			}
		}
		
		
		System.out.println(count +" "+CBcount);
	
		
		
	}
	
	
	static void BFS(int a,int b,boolean[][] nowVisited) {
		int[] position = {-1,0,1,0,0,-1,0,1};
							// a,b  ,a,b, a,b,  a,b
		Queue<index> q = new LinkedList<>();
		q.add(new index(a,b,matrix[a][b]));
	
		//색약없는 q. 
		while(!q.isEmpty()) {
			
			index now = q.poll();
			for(int i=0;i<8;i+=2) { //2개가 쌍이니까 두칸씩 이동한다. 
				
				int A = now.a+position[i];
				int B = now.b+position[i+1];
				
				if(0<=A && A<= n-1 && 0<=B && B<=n-1) { //index 넘어가지 않게 , 
					
					if(now.color == matrix[A][B] && !nowVisited[A][B] ) {
						q.add(new index(A,B,matrix[A][B]));
						nowVisited[A][B] = true;
					}
				}
				
			}
		
		}
	}
	
	static public class index{
		
		int a;
		int b;
		char color;
		
		public index(int a,int b,char color) {
			this.a = a;
			this.b = b;
			this.color = color;
		}
		
	}
	
}
