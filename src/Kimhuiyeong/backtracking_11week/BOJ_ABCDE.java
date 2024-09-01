import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean status;
    static List<Integer>[] list;
    static boolean[] visited;
    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        status = false;
        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            DFS(i, 1);
            if (status) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static void DFS( int idx, int depth){
        if (depth == 5) {
            status = true;
            return;
        }
        visited[idx] = true;
        for (int nxt : list[idx]) {
            if (!visited[nxt]) {
                DFS(nxt, depth + 1);
            }
        }
        visited[idx] = false;
    }
}
