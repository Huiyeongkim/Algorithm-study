import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Long> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		long[] arr = new long[N];
		long[] result = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());

		//long start1 = System.currentTimeMillis();
		for(int i=0;i<N;i++) arr[i] =  Long.parseLong(st.nextToken());
		Arrays.fill(result, -1);
		
		for(int i=N-1;i>=0;i--) {
			long now = arr[i];
			
			while(!stack.isEmpty()  && stack.peek()<=now) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) result[i] = stack.peek();
			
			
			stack.push(now);
		}

//		stack.push(arr[N-1]);
//		
//		for(int i=N-2;i>=0;i--) {
//			if(stack.peek() > arr[i] && !stack.isEmpty()) { //
//				result[i] = stack.peek();
//				stack.push(arr[i]);
//				
//			}else if(stack.peek() < arr[i] && !stack.isEmpty()) {
//				stack.pop();
//			//	result[i] = stack.peek();				
//				stack.push(arr[i]);
//			}else {
//				result[i] = stack.peek();
//			}
//			
//			
//		}
//		
		
		for(long i : result) System.out.print(i+" ");

	//	long end1 = System.currentTimeMillis();
		
		//System.out.println((end1-start1)/1000.0);
	}
}
