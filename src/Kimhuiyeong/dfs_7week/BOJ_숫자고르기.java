import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static boolean[] visited;
    static int[] arr;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (int a : list) {
            System.out.println(a);
        }
    }

    public static void DFS(int start, int target) {
        if (!visited[arr[start]]) {
            visited[arr[start]] = true;
            DFS(arr[start], target);
        }
        if (arr[start] == target) list.add(target);
        visited[start] = false;
    }
}
