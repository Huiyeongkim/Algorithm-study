package ff;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_11053 {
      static int[] arr;
      static int[] result; //각 시작원소에서 수열 길이 
   public static void main(String[] args) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      arr = new int[n];
      result = new int[n]; 
      StringTokenizer st = new StringTokenizer(br.readLine());      
      for(int i=0;i<n;i++)    arr[i] = Integer.parseInt(st.nextToken()); //입력
      Arrays.fill(result, 1); //1로 결과값 채우기 ,. 지금원소 수 . 
      /*
       * 예시 arr = { 10 20 10 30 20 50 }
       */
      
      for(int i=1;i<n;i++) {        // 20 , 10 , 30      , 20    , 50
         for(int j=i-1;j>=0;j--) {//   10 , x  , 10 20 10, 10 10 , 20 30 10 20 10
            if(arr[i] > arr[j]) {// 20 > 10 
               result[i] = Math.max(result[i],result[j]+1); // result[1] = max( 1, 1+1); 
               //갱신될 수 있으니까 break; 하면 안됨. 바로 앞에 것만 비교하는 게 아님. 
               
            }
         }
      }
      //bw.write(Arrays.toString(result)+"\n");
      bw.write(Arrays.stream(result).max().getAsInt()+"\n");

      bw.flush();
      bw.close();
   }
   

}
