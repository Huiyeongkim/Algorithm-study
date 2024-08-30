import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static BufferedWriter bw =  new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        DFS(N, M, 0);
        bw.flush();
    }
    public static void DFS(int N, int M, int depth) throws IOException {
        if (depth == M) {
            for (int val : arr) bw.write(val+" ");
            bw.write("\n");
            return;
        }
        for (int i=0; i<N; i++) {
            arr[depth] = i+1;
            DFS(N, M, depth+1);
        }
    }
}
