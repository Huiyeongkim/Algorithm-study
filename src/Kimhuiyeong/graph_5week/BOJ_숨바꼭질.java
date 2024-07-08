import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        dist[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[current] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int num = 1;
        int maxDist = 0;
        int count = 0;
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                num = i;
                count = 1;
            } 
            else if (dist[i] == maxDist) {
                if (i < num) {
                    num = i;
                }
                count++;
            }
        }
        System.out.println(num + " " + maxDist + " " + count);
    }
}
