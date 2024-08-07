import java.io.*;
import java.util.*;
public class Main {
	static int N,M,R, count = 1;
	static int[] result;	//각 정점 순번 저장 배열
	static boolean[] visited;		//각 정점 방문 확인 배열
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//그래프 저장 리스트

  
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));       
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
        	//리스트 및 배열 초기화
		result = new int[N+1];
		visited = new boolean[N+1];
		for(int i=0;i<=N;i++) graph.add(new ArrayList<>());
			//그래프 값 저장
    for(int i=0;i<M;i++) {
    			st = new StringTokenizer(br.readLine()," ");
    			int u = Integer.parseInt(st.nextToken());
    			int v = Integer.parseInt(st.nextToken());
    			graph.get(u).add(v);
    			graph.get(v).add(u);
		}
    
		dfs(R);		
		for(int i=1;i<=N;i++) 	bw.write(result[i] + "\n");	//각 순번 BufferedWriter 저장
		
		bw.flush();		//결과 출력
		bw.close();
		br.close();
		
	}
  static void dfs(int cur) {
		visited[cur] = true;		//방문 check
		result[cur] = count++;		//순번 저장
		Collections.sort(graph.get(cur), Collections.reverseOrder());	//내림차순 정렬
    
		for( Integer value : graph.get(cur)) {	//현재 정점 인접한 정점 탐색
			if(!visited[value]) {
				dfs(value);
			}
		}
		return;
	}
} 
