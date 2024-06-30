import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // DP 배열 초기화
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
        }

        // DP 배열 계산
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) { // i 이전 배열 탐색
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]); 
                }
            }
        }

        int maxSum = 0;
        for (int i = 0; i < N; i++) {
            maxSum = Math.max(maxSum, dp[i]);
        }

        System.out.println(maxSum);
    }
}
