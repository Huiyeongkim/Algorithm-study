package implementation_10week;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_스마트택시 {
    static int N, M, fuel;  // N*N: 판, M: 승객 수, fuel: 연료
    static int [][] map;  // 지도
    static boolean canGo = true;
    static Node [] start;  // 출발지 좌표
    static Node [] arrival;  // 도착지 좌표

    static int [] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        fuel = Integer.parseInt(st.nextToken());

        map = new int[N + 1][N + 1];
        start = new Node[M + 1];  // 출발지와 도착지의 각 개수는 손님 수와 동일
        arrival = new Node[M + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    map[i][j] = Integer.MAX_VALUE;  // 밑에서 승객 번호를 입력받을 때, 승객 번호와 벽이 1로 겹치므로 벽을 최대 정수 값으로 표현
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int startTaxiRow = Integer.parseInt(st.nextToken());
        int startTaxiCol = Integer.parseInt(st.nextToken());

        // 승객 별 출발지와 도착지 좌표
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int startRow = Integer.parseInt(st.nextToken());
            int startCol = Integer.parseInt(st.nextToken());
            int arrivalRow = Integer.parseInt(st.nextToken());
            int arrivalCol = Integer.parseInt(st.nextToken());

            map[startRow][startCol] = i;  // 승객의 출발지 좌표에 승객 번호를 저장
            start[i] = new Node(startRow, startCol);  // 승객의 출발지 좌표를 저장
            arrival[i] = new Node(arrivalRow, arrivalCol);  // 승객의 도착지 좌표를 저장
        }

        while (M-- > 0) {
            // 각 승객을 찾아가는 부분
            int passenger = findPassenger(startTaxiRow, startTaxiCol);  // bfs

            if (!canGo || passenger == 0) {  // 도착지로 갈 수 없거나 승객이 없을 때,
                bw.write("-1");;
                bw.close();bw.close();
                return;
            }

            // 승객의 위치에서 목적지로 이동
            goToArrival(start[passenger].row, start[passenger].col, arrival[passenger].row, arrival[passenger].col);

            // 택시가 승객의 목적지에 도착하면, 택시의 위치를 저장(최신화)
            startTaxiRow = arrival[passenger].row;
            startTaxiCol = arrival[passenger].col;

            if (!canGo) {
                bw.write("-1");;
                bw.close();bw.close();
                return;
            }
        }
        bw.write(fuel + "");
        bw.close();bw.close();
    }

    /** 택시가 승객의 위치를 찾는 메서드 */
    private static int findPassenger(int startRow, int startCol) {  // 택시의 현재 위치에서 승객을 찾아 bfs
        boolean [][] visited = new boolean[N + 1][N + 1];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startRow, startCol, 0));  // 출발 위치
        visited[startRow][startCol] = true;  // 출발지 방문 처리

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            // 현재 위치가 0이 아닌 경우 (승객을 만나거나, 벽이 있는 경우) -> return
            if (map[now.row][now.col] != 0) {
                fuel -= now.dist;
                if (fuel < 0) {
                    canGo = false;
                }
                int consumerNum = map[now.row][now.col];  // 승객을 만난 경우라면, 승객 번호(map[now.row][now.col])를 저장
                map[now.row][now.col] = 0;  // 승객이 있던 위치를 빈칸 처리

                return consumerNum;
            }
            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dr[i];
                int nextC = now.col + dc[i];

                // 다음 방문할 좌표가 map 안에 위치해야 하고, map[nextR][nextC]에 해당하는 값이 정수 최대값이면 안되고, 방문하지 않은 지점이라면?
                if (nextR >= 1 && nextC >= 1 && nextR <= N && nextC <= N && map[nextR][nextC] != Integer.MAX_VALUE && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;  // 방문처리하고,
                    queue.add(new Node(nextR, nextC, now.dist + 1));  // queue에 추가
                }
            }
        }

        return 0;
    }

    /** 택시가 승객을 태우고 목적지까지 이동하는 메서드 */
    private static void goToArrival(int startRow, int startCol, int arrivalRow, int arrivalCol) {  // 택시가 승객의 위치에서 목적지를 찾기위한 bfs
        boolean [][] visited = new boolean[N + 1][N + 1];
        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startRow, startCol, 0));  // 출발 위치
        visited[startRow][startCol] = true;  // 출발지 방문 처리

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            // 목적지에 도착하면?
            if (now.row == arrivalRow && now.col == arrivalCol) {
                fuel -= now.dist; // 일단 연료 감소
                if (fuel < 0) {  // fuel이 0이면 다음 승객을 태울 수 없음 -> 종료
                    canGo = false;
                }
                fuel += now.dist * 2;  // 승객이 도착지에 내렸으므로 승객이 탑승한 위치부터 도착지까지의 연료 소비량(now.dist) * 2 만큼 충전
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = now.row + dr[i];
                int nextC = now.col + dc[i];

                // 다음 방문할 좌표가 map 안에 위치해야 하고, map[nextR][nextC]에 해당하는 값이 정수 최대값이면 안되고, 방문하지 않은 지점이라면?
                if (nextR >= 1 && nextC >= 1 && nextR <= N && nextC <= N && map[nextR][nextC] != Integer.MAX_VALUE && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;  // 방문처리하고,
                    queue.add(new Node(nextR, nextC, now.dist + 1));  // queue에 추가
                }
            }
        }
        canGo = false;  // 목적지에 도착하지 못함
    }
}
class Node implements Comparable<Node> {
    int row, col, dist;  // row, col, 거리

    @Override
    public int compareTo(Node o) {
        if (this.dist == o.dist) {
            if (this.row == o.row) {
                return this.col - o.col;  // 거리와 row가 같은면 col 오름차순
            }
            return this.row - o.row;  // 거리가 같으면 row 오름차순
        }
        return this.dist - o.dist;  // 거리 오름차순
    }

    public Node(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Node(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
