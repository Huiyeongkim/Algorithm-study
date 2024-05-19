import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_1593 {

	public static void main(String[] args) throws IOException {
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int N = Integer.parseInt(br.readLine());
		 int count = 1;
	
		PriorityQueue <int []> q=new PriorityQueue<>(new Comparator<int []>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if (o1[1]==o2[1]) return o1[0]-o2[0];
				return o1[1]-o2[1];
			}
		 });
		
		for(int i =0;i<N;i++) {
		 StringTokenizer st = new StringTokenizer(br.readLine());
			int[] arr = new int[2];
			arr[0] = Integer.parseInt(st.nextToken());
			arr[1] = Integer.parseInt(st.nextToken());
			
			q.add(arr);
		}
		
		int[] arr = q.poll();
		//System.out.println("start with"+ arr[0]+","+arr[1]);
		while(!q.isEmpty()) {
			int[] arr2 = q.poll();
			if(arr[1] <= arr2[0]) {
				count++;
				arr[1] = arr2[1];
				arr[0] = arr2[0];
			}
			
			}
				
				
			
			System.out.println(count);
			
	}
	
}
