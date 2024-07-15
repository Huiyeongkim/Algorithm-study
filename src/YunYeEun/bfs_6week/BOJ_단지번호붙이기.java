import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
//   철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
//   여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 
//   대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 
//   지도를 입력하여 단지수를 출력하고, 
//   각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.

public class Main {

	static int[][] matrix;
	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		int danji=0; //단지가 몇개있는지 . 
		List<Integer> result = new ArrayList<>(); //단지의 크기 리스트
		matrix = new int[n][n]; //입력 행렬
		visited = new boolean[n][n];
		
		//input
		for(int i=0;i<n;i++) {
			String num = br.readLine();
			for(int j=0;j<n;j++) {
				matrix[i][j] = num.charAt(j)-'0';
				if(matrix[i][j] == 0) visited[i][j] = true;  //미리 처리한다. 
			}
		}
		
	
		
		//BFS 
		for(int i=0;i<n;i++) {	
			for(int j=0;j<n;j++) {
				if(!visited[i][j] ) {
					result.add(BFS(i,j,n));
					danji++; //한번 들어갈때마다 새로운 단지 생성됨 
				}
			}
		}
		
	
	//output
		System.out.println(danji);
    Collections.sort(result);
		for(int i:result) System.out.println(i);
		
		
		
		
	}
	
	public static int BFS(int a,int b,int matrixSize) {
		int size = 0; //한번들어올때마다 단지의 크기는 리셋 
	  int[] position = {-1,0,1,0,0,-1,0,1}; //상(-1,0) 하(1,0) 좌(-1,0) 우(0,1)
		Queue<index> q = new LinkedList<>();
    
		q.add(new index(a,b)); //첫 인덱스 삽입
		visited[a][b] = true;
		
		while(!q.isEmpty()) {
			
			index i = q.poll();
			size++;
      
      for(int i=0;i<8;i+=2) { //position 2개 원소가 쌍이니까 두칸씩 이동한다. 
				//상하좌우 순서에 맞게 변화된 인덱스, matrix[A][B]
				int A = i.a+position[i];  
				int B = i.b+position[i+1];
				
				if(0<=A && A<= n-1 && 0<=B && B<=n-1) { //index 넘어가지 않게 , 
					if(!nowVisited[A][B] ) {
						q.add(new index(A,B));
						Visited[A][B] = true;
					}
				}
			}

		}
		
		return size;
		
		
	}
	
	static public class index{
		
		int a;
		int b;
		
		public index(int a,int b) {
			this.a = a;
			this.b = b;
		}
		
	}
	
}
