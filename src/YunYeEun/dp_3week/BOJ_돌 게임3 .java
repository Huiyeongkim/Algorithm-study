
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
//	돌 게임은 두 명이서 즐기는 재밌는 게임이다.
//	탁자 위에 돌 N개가 있다. 상근이와 창영이는 턴을 번갈아가면서 돌을 가져가며, 
//돌은 1개, 3개 또는 4개 가져갈 수 있다. 마지막 돌을 가져가는 사람이 게임을 이기게 된다.
//	두 사람이 완벽하게 게임을 했을 때, 이기는 사람을 구하는 프로그램을 작성하시오. 게임은 상근이가 먼저 시작한다.
	public static void main(String[] args) throws  IOException {
		//상근 = 1, 창영 = 0
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		
		int[] repeat = {4,3,1};
		int[] setting  = {0,1,0,1,1};//n이 1~4까지 세팅해놓기 ,  setting arr[1,3,4] = sk ,  arr[2] = cy
		int[] arr = new int[n+1];		
		for(int i=1;i<=n;i++) {
			if(i >4) break;
			arr[i] = setting[i]; //집어넣기, n이 4보다 작을 경우 오류 방지 위함. 
		}
		
		int end =0;
		if(n > 4) {//n이 4 이하이면 들어올 필요없음. 
			for(int k=5;k<=n;k++) { 
				L00p1://SK turn 
				for(int i=0;i<3;i++) {  
					end =0;
					int now = k - repeat[i] ; //n-4 , n-3 , n-1순 		
					int j=0;
					Loop2:
					for(j=0;j<3;j++) {//CY turn 
						int nowMinusCY = now - repeat[j];
						if(nowMinusCY < 0 ) {
							end++;
						}else if(nowMinusCY == 0) break Loop2; //CY WIN
						else {
							arr[k] = arr[nowMinusCY]; //마무리 
							if(arr[k] == 0) break Loop2; 
							end++;
						}
					}
					if(end == 3) { //SK가 무사히 한바퀴 이겼다. 
						arr[k] = 1;
						break L00p1;
					}
					
				}
			}

		}
		
		//output
		if(arr[n] == 1) System.out.println("SK");
		else System.out.println("CY");
	
	}

}
