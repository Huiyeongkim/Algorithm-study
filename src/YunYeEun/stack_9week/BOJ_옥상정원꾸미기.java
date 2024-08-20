import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] arr;
	static long result=0;
	static Stack<Long> stack;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		stack = new Stack<>();
		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		
		for(int i=0;i<N;i++) {
			long now = Integer.parseInt(br.readLine());
			
			while(!stack.isEmpty()) {
				if(stack.peek() <= now) {
					stack.pop();
				}else break;
			}
			result += stack.size(); //size 1 : now층을 앞선 빌딩 1개가 볼 수 있다. 
			//System.out.println("stack size : "+stack.size());
			stack.push(now);
			
			
		}
		
		System.out.println(result);
	}
}
