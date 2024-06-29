package dp_4week;

import java.io.*;
import java.util.StringTokenizer;

// 11055
public class BOJ_가장_큰_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[] dp = new int [n+1];
        int[] arr = new int [n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i];  // 자신의 값을 dp[i]에 저장
            for (int j = 1; j < i; j++) {  // i의 이전값들 까지의 값들 중 LIS
                //System.out.println(dp[j]);
                if (arr[j] < arr[i]) {  // arr[i]의 값보다 이전 값들인 arr[j] 값이 작아야 LIS 일단 성립
                    // 증가 수열 -> dp값 갱신
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);  // 현재 위치인 arr[i]의 값과 i 이전 값까지 더한 값인 dp[j]를 더한 값과, 자신의 현재 값을 비교하여 최대값
                }
            }
        }

        int max = -1;
        for (int i : dp) {
            if (i > max) max = i;
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
