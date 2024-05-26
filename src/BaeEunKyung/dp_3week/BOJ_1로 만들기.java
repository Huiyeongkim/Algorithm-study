package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q1463 {
	static int[] dp;
	// public static int calc(int num) {
	// 	if(dp[num] == 0) {
	// 		if (num % 6 == 0) { //2와 3으로 나누어떨어지는 경우 -> 셋 다 가능
	// 			dp[num] = Math.min(calc(num / 3), Math.min(calc(num / 2), calc(num - 1))) + 1;
	// 		} else if (num % 3 == 0) { //3으로 나누어떨어지는 경우 -> 2개
	// 			dp[num] = Math.min(calc(num / 3), calc(num - 1)) + 1;
	// 		} else if (num % 2 == 0) { //2로 나누어떨어지는 경우 -> 2개
	// 			dp[num] = Math.min(calc(num / 2), calc(num - 1)) + 1;
	// 		} else {//-1만
	// 			dp[num] = calc(num - 1) + 1;
	// 		}
	// 	}
	// 	return  dp[num];
	// }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		// dp = new int[num + 1];
		// dp[0] = 0;
		// dp[1] = 0;


		dp = new int[num + 1];

		dp[1] = 0; // 1은 0번의 연산으로 만들 수 있음

		for (int i = 2; i <= num; i++) {
			dp[i] = dp[i - 1] + 1; // 기본적으로 -1 연산을 하는 경우
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		bw.write(dp[num] + "\n");
		bw.flush();
		bw.close();
	}
}
