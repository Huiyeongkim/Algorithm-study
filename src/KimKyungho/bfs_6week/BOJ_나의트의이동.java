package bfs_6week;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_나의트의이동 {
    static int n;  // 체스판 크기
    static int[][] map;  // 게임판
    static boolean[][] visited;  // 방문
    static int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int [] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int nowX, nowY;  // 현재 위치 칸
    static int desX, desY;  // 이동하려는 칸

    // bfs로 최소 이동 횟수 계산
    static void bfs(int x, int y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {x, y});  // 시작 지점을 큐에 추가
        map[x][y] = 0;  // 시작 지점은 이동 횟수가 0

        while (!queue.isEmpty()) {
            int[] now = queue.poll();  // 큐에서 현재 위치를 꺼냄
            int nowX = now[0];
            int nowY = now[1];

            // 나이트의 8가지 이동 방향을 모두 확인
            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // 체스판을 벗어나지 않고, 방문하지 않은 위치인 경우
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;  // 방문 처리
                    map[nextX][nextY] = map[nowX][nowY] + 1;  // 이동 횟수를 1 증가시켜 저장
                    queue.add(new int[]{nextX, nextY});  // 다음 위치를 큐에 추가
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());  // 게임판 한 변 칸 수
            map = new int[n][n];
            visited = new boolean[n][n];
            st = new StringTokenizer(br.readLine());
            nowX = Integer.parseInt(st.nextToken());
            nowY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            desX = Integer.parseInt(st.nextToken());
            desY = Integer.parseInt(st.nextToken());

            visited[nowX][nowY] = true;  // 시작 지점을 방문 처리
            bfs(nowX, nowY);
            bw.write(map[desX][desY] + "\n");
        }
        bw.flush();
        bw.close();
    }
}
