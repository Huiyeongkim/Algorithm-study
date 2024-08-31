package backtracking_11week;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * 인접 연결리스트에 양방향 연결해서 친구 관계를 생성
 *
 */
public class BOJ_ABCDE {

    static int N, M;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean [] visited;
    static boolean isExist = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());  // 사람 수
        M = Integer.parseInt(st.nextToken());  // 친구 관계 수

        adj = new ArrayList<>(); // 인접 연결리스트 사용
        for (int i = 0; i < N; i++) {  // 사람 번호 : 0번 ~ N-1번
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {  // 친구 관계 입력받고, 양방향 연결
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, 1);
            if (isExist) break;
        }

        if (isExist) {
            bw.write(1 + "");
        } else {
            bw.write(0 + "");
        }
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {  // A -> B -> C -> D -> E 관계 완성
            isExist = true;
            return;
        }

        visited[start] = true;
        for (Integer i : adj.get(start)) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }

            if (isExist) {
                return;
            }
        }
        visited[start] = false;  // dfs로 깊이 들어갔는데 ABCDE 관계가 아니면, 방문한 지점을 모두 false로 변경
    }
}
