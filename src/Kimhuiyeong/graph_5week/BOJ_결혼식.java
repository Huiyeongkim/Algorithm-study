import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] arr = new int[n+1];
        arr[1] = 1;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 1|| b == 1) {
                arr[a] = 1;
                arr[b] = 1;
            }
            else if (arr[a] == 1) {
                arr[b] = 2;
            }
            else if (arr[b] == 1) {
                arr[a] = 2;
            }
        }

        int count = 0;
        for (int i = 2; i <= n; i++) {
            if (arr[i] == 1 || arr[i] == 2) count++;
        }
        System.out.println(count);

    }
}
