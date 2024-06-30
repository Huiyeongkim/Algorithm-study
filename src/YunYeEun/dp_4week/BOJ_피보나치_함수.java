//첫째 줄에 테스트 케이스의 개수 T가 주어진다.
//각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.
//각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.
//f[3] = f[2] + f[1] = f[1]+f[0] + f[1]
import java.io.*;
public class Main {
    static int zeroArr[];
    static int oneArr[];
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
       int n   = Integer.parseInt(br.readLine());
      //최대 크기가 40. 
       zeroArr = new int[41];  //0 count
       oneArr = new int[41];  //1 count
       zeroArr[0] = 1; oneArr[1]=1; //setting, zero[0] = 1 : fibo[0]은 0이 1개, one[1]=1: fibo[1]은 1이 1개
      
       for(int i=0;i<n;i++){
           int nowNum = Integer.parseInt(br.readLine()); //입력 
           fibonacci(nowNum);
              System.out.print(zeroArr[nowNum]+" "+oneArr[nowNum]+"\n");
       }
    }

    public static void fibonacci(int c){
      for(int i=2;i<=c;i++){
          if(zeroArr[i]==0) zeroArr[i] = zeroArr[i-1]+zeroArr[i-2]; //0 count하는 방법 : 피보나치 함수 
          if(oneArr[i]==0) oneArr[i]= oneArr[i-1]+oneArr[i-2]; //1 count : 피보나치 함수 . 
      }
    }
}
