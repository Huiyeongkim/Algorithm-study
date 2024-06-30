package com.example.algorithm0.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_피보나치수의확장 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long[] fn = new long[1000001];
		int num = Integer.parseInt(br.readLine());
		int rslt;
		if(num < 0 && num % 2 == 0) {
			rslt = -1;
		} else if (num == 0) {
			rslt = 0;
		}else {
			rslt = 1;
		}
		bw.write(rslt + "\n");

		if(num < 0) {
			num *= -1;
		}
		fn[0] = 0;
		fn[1] = 1;

		for (int i = 2; i <= num; i++) {
			fn[i] = (fn[i - 1] + fn[i - 2])% 1000000000;
		}
		bw.write(fn[num] + "\n");

		bw.flush();
		bw.close();
	}
}
