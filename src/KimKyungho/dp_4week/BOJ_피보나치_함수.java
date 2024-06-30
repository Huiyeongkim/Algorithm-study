package dp_4week;

import java.io.*;

/**
 * 기존의 피보나치 수열 푸는 방식대로 풀면 시간초과.
 * 1003
 */
public class BOJ_피보나치_함수 {

    static Integer[][] dp = new Integer[41][2];  // 0출력 1출력
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        dp[0][0] = 1;  // n=0 일 때, 0의 호출 횟수
        dp[0][1] = 0;  // n=0 일 때, 1의 호출 횟수
        dp[1][0] = 0;  // n=1 일 때, 0의 호출 횟수
        dp[1][1] = 1;  // n=1 일 때, 1의 호출 횟수

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            bw.write(dp[n][0] + " " + dp[n][1] + "\n");
        }

        bw.flush();
        bw.close();

    }

    public static Integer[] fibonacci(int n) {
        // n에 대한 0, 1의 호출 횟수가 없을 떄(탐색하지 않은 값일 때)
        if (dp[n][0] == null || dp[n][1] == null) {
            // 각 n에 대한 0 호출 횟수와 1 호출 횟수를 재귀호출한다.
            dp[n][0] = fibonacci(n-1)[0] + fibonacci(n-2)[0];
            dp[n][1] = fibonacci(n-1)[1] + fibonacci(n-2)[1];
        }
        return dp[n];
    }
}
