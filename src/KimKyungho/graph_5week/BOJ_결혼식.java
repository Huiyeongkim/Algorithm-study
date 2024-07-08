package graph_5week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 5567
public class BOJ_결혼식 {

    static int N, M;
    static int[] distance;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N + 1];  // 거리
        Arrays.fill(distance, -1);  // -1로 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a_i = Integer.parseInt(st.nextToken());
            int b_i = Integer.parseInt(st.nextToken());
            graph[a_i].add(b_i);  // 무방향 그래프이므로 양방향 그래프로 설정해줘야 함.
            graph[b_i].add(a_i);
        }

        int cnt = bfs(1);
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
    private static int bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);  // 상근이의 위치는 항상 1
        distance[start] = 0;  // 거리는 0
        int cnt = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (distance[now] >= 1 && distance[now] <= 2) cnt++;  // 1인 경우는 친구인 경우이고, 2인 경우는 친구의 친구인 경우.

            for (int next : graph[now]) {
                if (distance[next] != -1) continue;  // 다음 노드가 이미 방문한 헛간이면 pass
                queue.add(next);
                distance[next] = distance[now] + 1;
            }
        }

        return cnt;
    }
}
