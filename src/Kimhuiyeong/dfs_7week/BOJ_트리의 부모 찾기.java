import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] visited;
    static int[] arr;
    static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N+1]; // 인접리스트
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        DFS(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(arr[i]);
        }
    }
    public static void DFS(int node) {
        visited[node] = true;

        for (int a : tree[node]) {
            if (!visited[a]) {
                arr[a] = node;
                DFS(a);
            }
        }
    }
}
