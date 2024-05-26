package com.example.algorithm0.baekjun;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		dp = new int[num + 1];

		dp[1] = 0;

		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1] + 1; // 기본적으로 -1 연산을 하는 경우
            		if (i % 6 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i], dp[i / 2] + 1));
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		bw.write(dp[num] + "\n");
		bw.flush();
		bw.close();
	}
}
