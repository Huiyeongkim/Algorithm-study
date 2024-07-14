package bfs_6week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_단지번호붙이기 {

    static int N;
    static char [][] graph;
    static boolean[][] visited;
    // 네 방향을 탐색하기 위한 방향 벡터
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static List<Integer> aptCnt;  // 단지 내 아파트 수 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            graph[i] = line.toCharArray();
        }

        visited = new boolean[N][N];
        aptCnt = new ArrayList<>();

        int groupCnt = countGroup();  // 총 단지수 저장
        Collections.sort(aptCnt);  // 오름차순 정렬
        bw.write(groupCnt + "\n");
        for (int i = 0; i < aptCnt.size(); i++) {
            bw.write(aptCnt.get(i) + "\n");
        }
        bw.flush();
        bw.close();
    }

    static int countGroup() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && graph[i][j] == '1') {  // 방문하지 않은 집이면서, 집이 있는 곳(1)이면?
                    bfs(i, j);  // 집을 시작점으로 bfs 시작
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;  // 방문처리
        int cnt = 1;  // 현재 집부터 시작하므로 1부터 시작하여 집 개수 계산

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] == '1') {  // 다음 위치가 그래프 범위 내에 있고, 방문하지 않은 경우, 그리고 graph가 1(집이 있는 곳)이면?
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});  // 큐에 새로운 좌표 추가
                    cnt++;
                }
            }
        }
        aptCnt.add(cnt);
    }
}
