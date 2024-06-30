Dynamic Programming을 사용해 풀어야 하는 문제

→ 피보나치 수열과 같이 중복되는게 많고, 최적 부분 만족하면 DP로 풀기.

- 1로 만들기 문제
    
     → top down 방식 사용시 시간 초과 에러 발생(재귀, 메모이제이션)
     → bottom-up방식 사용이 더 안전(반복문 사용해 중복 없이 효율적)
    
- 가장 긴 증가하는 부분 수열 → LIS(Longest Increasing Subsequence의 약자)
    
    Arrays.stream(result).max().getAsInt() //array Max 찾는 함수
    점화식 : dp[i] = max(dp[i], dp[j] + 1)

  
		int num = Integer.parseInt(br.readLine());
		dp = new int[num + 1];

		dp[1] = 0;

		for (int i = 2; i <= num; i++) {  //bottom-up 방식
			dp[i] = dp[i - 1] + 1; 
            		if (i % 6 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i], dp[i / 2] + 1));
			} else if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			} else if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		} 
