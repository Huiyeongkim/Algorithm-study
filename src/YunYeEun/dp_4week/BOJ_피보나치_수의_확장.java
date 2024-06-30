import java.io.*;
// 첫째 줄에 F(n)이 양수이면 1, 0이면 0, 음수이면 -1을 출력한다. 둘째 줄에는 F(n)의 절댓값을 출력한다. 
//   이 수가 충분히 커질 수 있으므로, 절댓값을 1,000,000,000으로 나눈 나머지를 출력한다.

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
       int n = Integer.parseInt(br.readLine());
       int c = Math.abs(n); //절댓값 
       int arr[] = new int[c+1]; //절댓값으로 배열크기 선언해야함. 
       //quit
       if(n==0 ||  n==1) {
        System.out.print(n+"\n"+n);
        return ;
       }
       arr[1] = 1;  //배열 기본세팅 , 이걸 //quit 앞에 두면 index오류난다. 왜.. ?
       if (n<0 && n%2 ==0) System.out.println(-1);//음수면서 짝수면 결과값이 마이너스임. 
       else System.out.println(1);
       //buttom up 
       for(int i=2;i<=c;i++) arr[i] = (arr[i-1]+arr[i-2])%1000000000; //기존 피보나치 함수 사용. 
      //나머지를 출력한다. 라고 문제가 나오면 매 답마다 나머지로 하라는 말 
        
       System.out.println(arr[c]);

    }

    
       
}
