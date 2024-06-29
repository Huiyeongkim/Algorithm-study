package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class q2293 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sn = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(sn.nextToken());
		int k = Integer.parseInt(sn.nextToken());

		int[] coin = new int[n + 1];
		int[] cnt = new int[k + 1];
		cnt[0] = 1;

		for(int i = 1; i<=n; i++)
			coin[i] = Integer.parseInt(br.readLine());

		for(int i = 1; i <= n; i++){
			for(int j = coin[0]; j <= k; j++){
				if(j<coin[i])
					continue;
				cnt[j] += cnt[j-coin[i]];
			}
		}

		bw.write(cnt[k] + "\n");
		bw.flush();
		bw.close();
	}
}
