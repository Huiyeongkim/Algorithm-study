import java.util.*;
import java.lang.*;
import java.io.*;

//LCS(Longest Common Subsequence, 최장 공통 부분 수열)문제는 두 수열이 주어졌을 때,
//모두의 부분 수열이 되는 수열 중 가장 긴 것을 찾는 문제이다.
//예를 들어, ACAYKP와 CAPCAK의 LCS는 ACAK가 된다.

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      char[] word1 = br.readLine().toCharArray();
      char[] word2 = br.readLine().toCharArray();
      int[][] matrix = new int[word1.length+1][word2.length+1];

      for(int i=1;i<=word1.length;i++){
          for(int j=1;j<=word2.length;j++){
              if(word1[i-1] == word2[j-1]) matrix[i][j] = matrix[i-1][j-1] +1;// 같으면 좌측대각선 +1로 연장시킴
              else matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]); //다르면 근처(좌,위)의 값 중 큰 것을 고대로 받음
          }
           
      }

     System.out.println(matrix[word1.length][word2.length]);

      
   }
}
