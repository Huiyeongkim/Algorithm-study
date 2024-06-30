package dp_4week;

import java.io.*;

// 11726
public class BOJ_2xn_타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(fibonacci(n) + "");
        bw.flush();
        bw.close();
    }

    public static int fibonacci(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        int dp[] = new int[n + 1];
        dp[1] = 1;  // 초기값
        dp[2] = 2;  // 초기값
        for (int i = 3; i <= n; i++) {  // 나머지는 일반적인 피보나치 수열과 동일
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        return dp[n];
    }
}
