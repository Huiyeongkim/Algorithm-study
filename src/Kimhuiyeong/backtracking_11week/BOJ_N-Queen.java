import java.io.*;

public class Main {
    static int N, count;

    static int[] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        DFS(0);
        System.out.println(count);
    }
    public static void DFS(int depth) {
        if (depth == N) {
            count++;
            return;
        }
        for (int i=0; i<N; i++) {
            arr[depth] = i;
            if (pro(depth)==1) {
                DFS(depth + 1);
            }
        }
    }
    public static int pro(int depth) {
        for (int i = 0; i < depth; i++) {
            if (arr[depth] == arr[i] || depth - i == Math.abs(arr[depth] - arr[i])) {
                return 0;
            }
        }
        return 1;
    }
}
