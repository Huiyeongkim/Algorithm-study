package backtracking_11week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_N과M3 {

    static int N, M;
    static int [] answer;
    static boolean [] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        answer = new int[M];  // 출력되는 수열
        visited = new boolean[N];  // 방문 여부

        dfs(N, M, 0);
        bw.flush();
        bw.close();
    }

    private static void dfs(int n, int m, int depth) throws IOException {
        if (depth == m) {  // dfs에서의 깊이가 m(수열의 길이)과 같아지면 출력을 하고, 반환
            for (int i : answer) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer[depth] = i + 1;
                dfs(n, m, depth+1);
                visited[i] = false;
            }
        }
    }
}
