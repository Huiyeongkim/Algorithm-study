import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        long[] dp = new long[N+1];
        dp[1] = 1;
        if (N>=2) dp[2] = 2;
        for (int i=3; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2])%10007;
        }
        System.out.println(dp[N]);
    }
}
