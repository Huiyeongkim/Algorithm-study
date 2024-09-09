import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parents;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        parents = new int[p];
        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            parents[i] = i;
        }

        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[2] - o1[2]));
        for (int i = 0; i < w; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int result = 0;
        while (find(c) != find(v)) {
            int[] arr = queue.poll();
            if (find(arr[0]) != find(arr[1])) {
                union(arr[0], arr[1]);
                result = arr[2];
            }
        }
        System.out.println(result);
    }

    static int find(int x) {
        if (parents[x] == x) return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parents[px] = py;
    }
}
