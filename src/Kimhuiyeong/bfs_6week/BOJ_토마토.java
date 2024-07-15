import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;
    static int[][] arr;
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) queue.add(new int[]{i, j, 0});
            }
        }
        System.out.println(BFS());

    }

    public static int BFS() {
        int answer = 0;

        while (!queue.isEmpty()) {
            int[] tomato = queue.poll();
            answer = tomato[2];

            for(int j=0; j<4; j++) {
                int ox = tomato[0] + dx[j];
                int oy = tomato[1] + dy[j];

                if (ox >= 0 && oy >= 0 && ox < N && oy < M && arr[ox][oy] == 0) {
                    arr[ox][oy] = 1;
                    queue.add(new int[]{ox, oy, answer+1});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(arr[i][j] == 0) {
                    return -1;
                }
            }
        }
        return answer;
    }
}
