package graph_5week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6118 : 440ms
public class BOJ_숨바꼭질 {

    static ArrayList<Integer>[] adjList;  // 인접 리스트를 저장할 배열
    static int N, M;
    static int[] distance;  // 1번 헛간부터 각 헛간까지의 거리를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 헛간의 수(vertex)
        M = Integer.parseInt(st.nextToken());  // 양방향 길의 수(edge)

        adjList = new ArrayList[N+1];  // 각 헛간의 인접 리스트 초기화
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();  // 인접 리스트 초기화
        }

        distance = new int[N + 1];
        Arrays.fill(distance, -1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A_i = Integer.parseInt(st.nextToken());
            int B_i = Integer.parseInt(st.nextToken());
            adjList[A_i].add(B_i);  // A_i와 B_i를 서로 연결(무방향이니까 양방향으로 연결)
            adjList[B_i].add(A_i);
        }

        bfs(1);

        int maxDistance = 0;  // 최대 거리
        int maxDisNum = 0;  // 최대 거리에 있는 헛간의 번호
        int cnt = 0;  // 최대 거리와 동일한 거리를 갖는 헛간의 개수

        for (int i = 1; i <= N; i++) {
            // 현재 헛간[i]의 거리가 최대 거리보다 큰 경우
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];  // 최대 거리를 현재 헛간[i]의 거리로 갱신
                maxDisNum = i;  // 최대 거리를 갖는 헛간의 번호를 현재 헛간[i]로 갱신
                cnt = 1;  // 최대 거리를 갖는 헛간의 개수를 1로 초기화

            // 현재 헛간[i]의 거리가 최대 거리와 같은 경우
            } else if (distance[i] == maxDistance) {
                // 헛간 번호가 현재 저장된 헛간 번호보다 작은 경우
                if (i < maxDisNum) {
                    maxDisNum = i;// 헛간 번호를 더 작은 번호로 갱신 (만약 거리가 같은 헛간이 여러개면 가장 작은 헛간 번호를 출력한다)
                }
                cnt++;  // 그리고 최대 거리를 갖는 헛간의 개수를 증가
            }
        }
        bw.write(maxDisNum + " " + maxDistance + " " + cnt);
        bw.flush();
        bw.close();
    }

    // BFS로 1번 헛간부터 각 헛간까지의 최단 거리를 계산(일반적인 BFS 연산)
    private static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(start);  // 출발 지점을 추가
        distance[start] = 0;  // 출발 지점의 거리는 0

        while (!queue.isEmpty()) {
            int now = queue.poll();  // 꺼내고,

            for (int next : adjList[now]) {
                if (distance[next] != -1) continue;  // 다음 노드가 이미 방문한 곳이면 pass
                // 방문하지 않은 헛간이면?
                queue.add(next);
                distance[next] = distance[now] + 1;
            }
        }
    }
}
