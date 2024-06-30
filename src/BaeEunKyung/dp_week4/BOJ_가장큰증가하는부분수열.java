package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_가장큰증가하는부분수열 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		int[] dp = new int[n];
		StringTokenizer sn = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(sn.nextToken());
		}

		int max = 0;
		for (int i = 1; i < n; i++) {
			dp[i] = nums[i];
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j] && dp[i] < dp[j] + nums[i]) {
					dp[i] = nums[i] + dp[j];
				}
			}
			max = Math.max(max, dp[i]);
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}
