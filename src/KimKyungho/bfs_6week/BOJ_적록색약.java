package bfs_6week;
import java.io.*;
import java.util.ArrayDeque;

// 10026
public class BOJ_적록색약 {
    static int N;
    static char[][] graph;  // 색상을 입력받은 2차원 배열
    static boolean[][] visited;  // 방문 여부
    // 네 방향을 탐색하기 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];

        // graph 입력
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line.toCharArray();
        }

        // 적록색약이 아닌 경우
        visited = new boolean[N][N]; // 방문 배열 초기화
        int normal = countRegions(false);

        // 적록색약인 경우
        visited = new boolean[N][N]; // 방문 배열 다시 초기화
        int colorBlindness = countRegions(true);

        bw.write(normal + " " + colorBlindness);
        bw.flush();
        bw.close();
    }

    static int countRegions(boolean colorBlind) {
        int regions = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {  // 방문하지 않은 칸이면
                    bfs(i, j, colorBlind);
                    regions++;  // 구역수 증가
                }
            }
        }
        return regions;
    }

    // BFS로 같은 색 구역을 탐색
    static void bfs(int x, int y, boolean colorBlind) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;  // 시작점 방문 처리
        char startColor = graph[x][y];  // 시작점의 색상

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            // 네 방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                // 그래프 범위 내에 있고, 방문하지 않은 경우
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    if (colorBlind) {  // 적록색약인 경우
                        // 현재 색상이 R 또는 G이고, 다음 색상도 R 또는 G인 경우
                        if ((startColor == 'R' || startColor == 'G') && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) {
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});
                        } else if (graph[nx][ny] == startColor) {  // 만약에 시작 색상(현재 색상)이 B인 경우에는 B만 탐색을 하기 때문에 해당 조건이 필요.
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});
                        }
                    } else {  // 적록색약이 아닌 경우
                        if (graph[nx][ny] == startColor) {  // 현재 색상과 시작 색상이 같은 경우
                            visited[nx][ny] = true;  // 방문 처리
                            queue.add(new int[]{nx, ny});  // 큐에 새로운 좌표 추가
                        }
                    }
                }
            }
        }
    }
}