// 수열 A가 주어졌을 때, 그 수열의 증가하는 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.

// 예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에 합이 
//   가장 큰 증가하는 부분 수열은 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 이고, 합은 113이다.
// A = {1,8,2,3,9} ,합은 18
//9에서 나오는 경우의 수는 {1,8},{1,2,3} 

import java.io.*;
import java.util.*;

/**
 * bj
 */
public class Main {
   
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
       int n   = Integer.parseInt(br.readLine());
       int[] arr = new int[n];
       int[] dp = new int[n];
     
       StringTokenizer st = new StringTokenizer(br.readLine());
       for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
       dp = arr.clone();
    
       for(int i=0;i<n;i++){
          int min = 0;
          for(int j=0;j<i;j++){
              //낮은 원소중 가장 큰 값의 합
              if(arr[i]>arr[j])  min = Math.max(min,dp[j]);
          }
          dp[i]+=min; //자기 원소 + 자기보다 낮은 원소에서 가장 큰 dp값을 가지고 있는 걸 더한다. 
       }

       System.out.println(Arrays.stream(dp).max().getAsInt());
       
       
        
        
    }

    }

    
       
