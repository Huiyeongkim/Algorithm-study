package dp_3week;

import java.io.*;

public class BOJ_1로만들기 {

    static int dp [];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {  // bottom-up 방식으로 수정
            dp[i] = dp[i-1] + 1;
            if (i % 3 == 0) dp[i] = Math.min(dp[i], recur(i / 3) + 1);  // n이 3으로 나누어 떨어지면, 3으로 나눈다.
            if (i % 2 == 0) dp[i] = Math.min(dp[i], recur(i / 2) + 1);  // n이 2로 나누어 떨어지면, 2로 나눈다.
        }

        //bw.write(recur(n) + "");
        bw.write(dp[n] + "");
        bw.flush();
        bw.close();
    }

    // top-down(재귀 사용) 방식인데 시간초과
    public static int recur(int n) {
        if (n == 1) return 0;  // n이 1이면 더 이상의 연산이 필요 없으므로 0을 반환
        if (dp[n] > 0) return dp[n];  // dp[] 배열 초기값 = 0

        dp[n] = recur(n-1) + 1;  // 1을 빼는 경우
        if (n % 3 == 0) dp[n] = Math.min(dp[n], recur(n / 3) + 1);  // n이 3으로 나누어 떨어지면, 3으로 나눈다.
        if (n % 2 == 0) dp[n] = Math.min(dp[n], recur(n / 2) + 1);  // n이 2로 나누어 떨어지면, 2로 나눈다.

        return dp[n];
    }
}
