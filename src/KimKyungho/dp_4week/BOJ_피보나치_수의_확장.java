package dp_4week;

import java.io.*;

public class BOJ_피보나치_수의_확장 {

    // 1788
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // n이 짝수인 경우에만 음수
        if (n < 0 && n % 2 == 0) bw.write("-1\n");  // n이 음수이고 짝수인 경우 -> F(n)=음수
        else if(n == 0) bw.write("0\n");
        else bw.write("1\n");

        n = Math.abs(n);  // 어차피 절대값으로 출력해야 되므로(n의 값이 짝수든 홀수든 절댓값은 동일)
        bw.write(fibonacci(n) + "");
        bw.flush();
        bw.close();
    }

    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long[] dp = new long[n+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;  // 일반적인 피보나치와 동일
        }
        return dp[n];
    }
}
