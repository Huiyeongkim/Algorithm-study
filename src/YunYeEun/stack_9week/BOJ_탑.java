import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
예를 들어 높이가 6, 9, 5, 7, 4인 다섯 개의 탑이 수평 직선에 일렬로 서 있고, 모든 탑에서는 주어진 탑 순서의 반대 방향(왼쪽 방향)으로 동시에 레이저 신호를 발사한다고 하자. 
그러면, 높이가 4인 다섯 번째 탑에서 발사한 레이저 신호는 높이가 7인 네 번째 탑이 수신을 하고, 높이가 7인 네 번째 탑의 신호는 높이가 9인 두 번째 탑이,
높이가 5인 세 번째 탑의 신호도 높이가 9인 두 번째 탑이 수신을 한다. 높이가 9인 두 번째 탑과 높이가 6인 첫 번째 탑이 보낸 레이저 신호는 어떤 탑에서도 수신을 하지 못한다.
탑들의 개수 N과 탑들의 높이가 주어질 때, 각각의 탑에서 발사한 레이저 신호를 어느 탑에서 수신하는지를 알아내는 프로그램을 작성하라.

 5
 6  9  5  7  4  ->  0 0 2 2 4
[x][x][9][9][7]

*/


public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] result = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
    
		//input
    for(int i=0;i<N;i++) arr[i] = Long.parseLong(st.nextToken());

    
		for(int i=0;i<N;i++) {
			
			long now = arr[i];
      
			while(!stack.isEmpty()) {
				if(arr[stack.peek()] < now) stack.pop();	 //출력값이 인덱스니까, stack에 인덱스 쌓는다. 
				else break;	
			}
      
			if(!stack.isEmpty()) result[i] = stack.peek()+1; //인덱스가 0부터니까 기준 맞추기. 
      
			stack.push(i); 
			
		}
		
		//output
		for(long i : result) System.out.print(i+" ");

		
	}
}
