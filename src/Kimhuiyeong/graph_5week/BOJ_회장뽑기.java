import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], N*N);
            dist[i][i] = 0;
        }

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == -1) break;
            int b = Integer.parseInt(st.nextToken());
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        // Floyd-Warshall
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] score = new int[N + 1];
        int minScore = N*N;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) score[i] = Math.max(score[i], dist[i][j]);
            }
            minScore = Math.min(minScore, score[i]);
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (score[i] == minScore) {
                answer.add(i);
            }
        }

        // 결과 출력
        System.out.println(minScore + " " + answer.size());
        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}
