package dfs_7week;

import java.io.*;
import java.util.*;

/*
- 정점과 간선의 정보를 이용해서 출발 정점에서 각 정점을 방문하는 순번을 결과로 출력한다.
- 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
- 인접 정점은 내림차순으로 방문한다.
 */
public class BOJ_알고리즘수업_깊이우선탐색2 {

    static int N, M, R, count = 1;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//그래프 저장 리스트 : 이중 ArrayList
    static boolean[] visited;
    static int[] result;	//각 정점 순번 저장 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 정점의 수
        M = Integer.parseInt(st.nextToken());  // 간선의 수
        R = Integer.parseInt(st.nextToken());  // 시작 정점

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        result = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 간선은 무방향 그래프
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(R);

        for(int i = 1; i <= N; i++)
            bw.write(result[i] + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;  // 방문 저장
        result[start] = count++;  // 순번 저장
        Collections.sort(graph.get(start), Collections.reverseOrder());	 // 내림차순 정렬 -> 인접 정점은 내림차순으로 방문한다.
        for( Integer value : graph.get(start)) {  // 현재 정점 인접한 정점 탐색
            if(!visited[value]) {
                dfs(value);
            }
        }
    }
}
