package bfs_6week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_토마토 {

    static int N, M;
    static int [][] graph;
    static boolean[][] visited;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    // 네 방향을 탐색하기 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count = 0;  // 최소 날짜

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                if (graph[i][j] == 1) { // 1일 경우 큐에 삽입
                    queue.add(new int[]{i, j});
                }
            }
        }
        bw.write(bfs() + "");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (graph[nx][ny] == 0) {
                        queue.add(new int[]{nx, ny});
                        graph[nx][ny] = graph[cx][cy] + 1; // 새로 추가된 곳은 원래 있던 수 + 1
                    }
                }

            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) { // 그래프안에 0 이 존재하면 답은 -1
                    return -1;
                }
                // 그래프의 날짜중에 가장 큰 수를 찾으면 그것이 최종날짜
                count = Math.max(count, graph[i][j]);
            }
        }
        // 저장될 때부터 모든 토마토가 익어익는상태라면
        if (count == 1) {
            return 0;
        } else { // 아닐 경우 최종날짜 - 1 출력
            return count-1;
        }
    }
}
