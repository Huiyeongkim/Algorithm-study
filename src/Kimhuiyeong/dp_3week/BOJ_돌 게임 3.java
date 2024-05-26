import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Boolean[] dp = new Boolean[N+1];
        if (N >= 1) dp[1] = true; // 상근
        if (N >= 2) dp[2] = false; // 창영
        if (N >= 3) dp[3] = true; // 상근
        if (N >= 4) dp[4] = true; // 상근
        // dp[5] = true; // 3 1 1
        // dp[6] = true; // 4 1 1   3 3
        // dp[7] = false; // 4 3    4 1 1 1

        for (int i = 5; i <= N; i++) { // 나머지 부분 채우기
            dp[i] = !dp[i - 1] || !dp[i - 3] || !dp[i - 4]; // 셋 다 false 여야 false로 출력
        }

        // 결과 출력
        if (dp[N]) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
}
