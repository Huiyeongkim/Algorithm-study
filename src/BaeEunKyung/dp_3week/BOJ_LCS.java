package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] a = br.readLine().toCharArray();
		char[] b = br.readLine().toCharArray();
		int[][] dp = new int[a.length + 1][b.length + 1];

		for (int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				dp[i][j] = -1;
			}
		}
		int rslt = LCS(a, b, dp, a.length - 1, b.length - 1);
		bw.write(rslt + "\n");
		bw.flush();
		bw.close();
	}

	public static int LCS(char[] a, char[] b, int[][] dp, int al, int bl) {
		if(al == -1 || bl == -1) {
			return 0;
		}

		if(dp[al][bl] == -1) {
			dp[al][bl] = 0;
			//같을 때 -> 값을 +1 해서 재귀 값 저장
			if(a[al] == b[bl]) {
				dp[al][bl] = LCS(a, b, dp, al - 1, bl - 1) + 1;
			}

			// 같지 X-> LCS(dp)[al-1][bl]와 LCS(dp)[al, bl-1] 중 큰 값
			else {
				dp[al][bl] = Math.max(LCS(a, b, dp, al - 1, bl), LCS(a, b, dp, al, bl - 1));
			}
		}
		return dp[al][bl];
	}
}
