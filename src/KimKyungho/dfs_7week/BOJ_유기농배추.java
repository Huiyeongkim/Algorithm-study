package dfs_7week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_유기농배추 {

    static int T, M, N, K;
    static int [][] graph;
    static boolean[][] visited;
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    // 네 방향을 탐색하기 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;  // 최소 날짜

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            count = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());  // 가로
            M = Integer.parseInt(st.nextToken());  // 세로
            K = Integer.parseInt(st.nextToken());  // 배추 개수
            graph = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int n = Integer.parseInt(st.nextToken());
                int m = Integer.parseInt(st.nextToken());
                graph[n][m] = 1;
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (graph[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);  // 배추가 있는 곳이며, 방문하지 않은 곳에서 dfs를 하여 해당 위치를 기준으로 방문 처리하고,
                        //bfs(a, b);
                        count++;  // 지렁이 한 마리로 커버 가능한 연결된 배추의 묶음? 카운트
                    }
                }
            }
            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;  // 방문 처리

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];
            // 범위 내에 있고, 방문하지 않았으며, 배추가 있는 곳이면(1)
            if (cx >= 0 && cy >= 0 && cx < N && cy < M && !visited[cx][cy] && graph[cx][cy] == 1) {
                dfs(cx, cy);
            }
        }
    }
    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;  // 방문처리

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny] && graph[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});  // 큐에 새로운 좌표 추가
                }
            }
        }
    }
}
