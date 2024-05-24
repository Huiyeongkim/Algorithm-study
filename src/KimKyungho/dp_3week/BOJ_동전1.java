package dp_3week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_동전1 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // n가지 종류의 동전
        int k = Integer.parseInt(st.nextToken());  // 가치의 합 k원

        int coin[] = new int[n];
        int dp[] = new int[k+1];

        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;  // 초기값

        for (int i = 0; i < n; i++) {  // 각 동전 종류에 대하여~
            for (int j = 1; j <= k; j++) {  // 1원부터 k원까지의 모든 가치의 합에 대해~
                if (j >= coin[i]) {  // 구해야 하는 가치의 합이 현재 동전의 금액보다 크거나 같다면??
                    // dp[j]에 현재 동전을 사용하여 만들 수 있는 경우의 수를 추가.
                    // dp[j-coin[i]]는 (현재 가치 - 현재 동전의 가치)만큼의 가치를 만드는 경우의 수.
                    dp[j] += dp[j-coin[i]];  // 현재의 동전을 사용하여 j원을 만드는 경우의 수를 추가하는 것.
                }
            }
        }

        bw.write(dp[k] + "");
        bw.flush();
        bw.close();

    }
}
