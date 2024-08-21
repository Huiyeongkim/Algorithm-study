# 3주차: DP (1463, 11053, 9657, 9251, 2293) Review


작성자 : 배은경


## 1463:  1로 만들기

→ top down 방식 사용시 시간 초과 에러 발생(재귀, 메모이제이션)
→ bottom-up방식 사용이 더 안전(반복문 사용해 중복 없이 효율적)

```java
dp = new int[num + 1]; 
dp[1] = 0;

for (int i = 2; i <= num; i++) {  //bottom-up방식
	dp[i] = dp[i - 1] + 1;
        if (i % 6 == 0) {
		dp[i] = Math.min(dp[i / 3] + 1, Math.min(dp[i], dp[i / 2] + 1));
	} else if (i % 2 == 0) {
		dp[i] = Math.min(dp[i], dp[i / 2] + 1);
	} else if (i % 3 == 0) {
		dp[i] = Math.min(dp[i], dp[i / 3] + 1);
	}
}
```

## 11053: 가장 긴 증가하는 부분 수열
- LIS(Longest Increasing Subsequence의 약자) 문제
점화식 : dp[i] = max(dp[i], dp[j] + 1)
```java
int maxLeng = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			maxLeng = Math.max(maxLeng, dp[i]);
		}
```
ex2) 
Arrays.stream(result).max().getAsInt() //array Max 찾는 함수
```java
for(int i=1;i<n;i++) {        // 20 , 10 , 30      , 20    , 50
         for(int j=i-1;j>=0;j--) {//   10 , x  , 10 20 10, 10 10 , 20 30 10 20 10
            if(arr[i] > arr[j]) {// 20 > 10 
               result[i] = Math.max(result[i],result[j]+1); // result[1] = max( 1, 1+1); 
            }
         }
      }
      bw.write(Arrays.stream(result).max().getAsInt()+"\n");
    
```

## 9657: 돌 게임 3
```java
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
```

## 9251: LCS
Math.max로 두 값중 더 큰 값 반환
dp[i][j]는 dp[i-1][j]와 dp[i][j-1] 중 큰 값을 가짐.
```java
 int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length() ; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
```

## 2293: 동전 1
```java
   dp[0] = 1;  // 초기값

        for (int i = 0; i < n; i++) {  
            for (int j = 1; j <= k; j++) { 
                if (j >= coin[i]) {
                    dp[j] += dp[j-coin[i]];
                }
            }
        }
```
