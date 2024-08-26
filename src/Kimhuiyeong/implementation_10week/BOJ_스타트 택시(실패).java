import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, currentX, currentY, C;
    static int[][] arr;
    static int[][] result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
  
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        currentX = Integer.parseInt(st.nextToken());
        currentY = Integer.parseInt(st.nextToken());


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());

            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            arr[sx][sy] = i + 2;
            arr[ex][ey] = i + 3;
        }

        int count = 0;
        while (count < M) {
            // 최단거리 고객 탐색
            int temp = search(N, arr);
            if (fuel - temp <= 0 || temp == -1) break;

            // 목적지 거리
            int temp2 = goal(N, arr);
            if (fuel - temp2 < 0 || temp2 == -1) break;
            else fuel += temp2 - temp; // fuel = fuel - temp - temp2 + temp2 * 2;

            count++;
        }
        if (count == M) System.out.println(fuel);
        else System.out.println(-1);
    }
