import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 1; i < N; i++) {
            while (!stack.empty() && arr[i] > arr[stack.peek()]) {
                res[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            res[stack.pop()] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            bw.write(res[i]+" ");
        }
        bw.flush();
    }
}
