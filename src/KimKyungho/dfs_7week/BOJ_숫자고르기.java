package dfs_7week;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

/*
- 첫째 줄에서 숫자들을 선택하여 그 아래 둘째 줄의 숫자들이 일치하는지 확인해야 합니다.
- 선택된 숫자들의 집합과 그 바로 아래의 숫자들이 이루는 집합이 일치하도록 해야 합니다.
- 이 조건을 만족하면서 선택된 숫자들의 개수가 최대가 되도록 합니다.
 */
public class BOJ_숫자고르기 {

    static int N, num;
    static int[] graph;
    static boolean[] visited;
    static LinkedList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());  // i번째 인덱스에 값
        }

        visited = new boolean[N + 1];
        result = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            num = i;
            dfs(i);
            visited[i] = false;  // 다른 숫자를 시작점으로하여 다시 dfs를 해야하기 때문에 false 처리
        }
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }
        bw.flush(); bw.close();
    }

    // dfs 로직 : 출발 숫자 -> graph[출발 숫자] -> graph[graph[출발 숫자]]를 반복하다가 출발 숫자를 다시 만나게 되면, 첫째 줄과 둘째 줄의 정수들의 집합이 일치한다고 볼 수 있다.
    static void dfs(int now) {  // 시작 인덱스와 다음 인덱스로 dfs 진행. 다음 노드는 graph[now](graph의 인덱스 i가 현재 노드이고, graph[i]가 다음 노드이므로)
        // 현재 노드의 now 값이 처음 dfs를 시작한 값(num)과 같다면 사이클이 완성된것이므로 result에 추가
        if (graph[now] == num) result.add(num);

        // 다음 노드 검사
        if (!visited[graph[now]]) {  // graph의 현재 노드가 방문하지 않은 곳이라면?
            visited[graph[now]] = true;  // 현재 노드를 방문 처리
            dfs(graph[now]);  // dsf 재귀 호출로 다음 노드를 방문
            visited[graph[now]] = false;  // 재귀 호출 종료 후 방문 처리 해제
        }
    }
}
