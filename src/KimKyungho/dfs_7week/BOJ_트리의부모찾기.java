package dfs_7week;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_트리의부모찾기 {

    static int N;
    static List<List<Integer>> adjList;  // 인접 리스트
    static boolean[] visited;
    static int[] parents;  // 부모

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();  // 인접 리스트 생성
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }
        visited = new boolean[N + 1];
        parents = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(1); // 루트 노드를 1로 설정하고 시작

        for (int i = 2; i <= N; i++) {
            bw.write(parents[i] + "\n");
        }
        bw.flush(); bw.close();
    }

    private static void dfs(int now) {
        System.out.println();
        visited[now] = true;  // 현재 노드를 방문 처리
        System.out.println("dfs(" + now + "),  visited[" + now + "] = " + visited[now]);

        // 인접 리스트 순회 -> dfs에서 특정 노드를 탐색하기 위해서는 항상 그 노드의 부모 노드를 거치게 된다.
        for (int node : adjList.get(now)) {
            System.out.println("node = " + node + ",  visited[" + node + "] = " + visited[node]);
            if (!visited[node]) {  // 방문하지 않은 노드라면?
                parents[node] = now;  // 인접 노드의 부모를 현재 노드로 설정하고
                System.out.println("parents[" + node + "] = " + parents[node] + "  ->  " + node + "의 부모는 " + parents[node]);
                dfs(node);// 인점 노드 방문
            }
        }
    }
}

/*
7
1 6
6 3
3 5
4 1
2 4
4 7

dfs(1),  visited[1] = true
node = 6,  visited[6] = false
parents[6] = 1  ->  6의 부모는 1

dfs(6),  visited[6] = true
node = 1,  visited[1] = true
node = 3,  visited[3] = false
parents[3] = 6  ->  3의 부모는 6

dfs(3),  visited[3] = true
node = 6,  visited[6] = true
node = 5,  visited[5] = false
parents[5] = 3  ->  5의 부모는 3

dfs(5),  visited[5] = true
node = 3,  visited[3] = true
node = 4,  visited[4] = false
parents[4] = 1  ->  4의 부모는 1

dfs(4),  visited[4] = true
node = 1,  visited[1] = true
node = 2,  visited[2] = false
parents[2] = 4  ->  2의 부모는 4

dfs(2),  visited[2] = true
node = 4,  visited[4] = true
node = 7,  visited[7] = false
parents[7] = 4  ->  7의 부모는 4

dfs(7),  visited[7] = true
node = 4,  visited[4] = true
4
6
1
3
1
4

 */