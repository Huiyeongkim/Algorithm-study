package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class q9657 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		int[] dp = new int[1001];
		dp[1] = 1;
		dp[2] = 0;
		dp[3] = 1;
		dp[4] = 1;

		for(int i=5; i < num+1; i++) {
			if((dp[i-1] & dp[i-3] & dp[i-4] ) == 1) { //셋 다 1이면 dp[i] = 0(CY이 이김)이고 3이하면 1
				dp[i] =0;
			}else {
				dp[i] =1;
			}
		}

		if(dp[num]==1) {
			bw.write("SK");
		}else {
			bw.write("CY");
		}

		bw.flush();
		bw.close();
	}
}
