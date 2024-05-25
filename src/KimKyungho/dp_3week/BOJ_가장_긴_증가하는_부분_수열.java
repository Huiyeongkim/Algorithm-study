package dp_3week;

import java.util.*;
import java.io.*;

public class BOJ_가장_긴_증가하는_부분_수열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N+1];  // 수열
        int dp[] = new int[N+1];  // dp

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;  // 일단 dp값들은 최소 1
        }
        int max = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {  // arr의 현재값이 이전 값보다 크면
                    // 각 i에 대해 가능한 모든 j를 검사하고, 그 중 가장 긴 증가하는 부분 수열의 길이를 dp[i]에 다시 저장하므로
                    // max()로 dp[i]를 계속 비교함
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);  // 최댓값 저장
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
    }
}
