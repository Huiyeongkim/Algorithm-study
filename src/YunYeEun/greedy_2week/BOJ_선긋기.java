import java.io.*;
import java.util.*;

public class bj_2170 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
	//	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		//배열 안 리스트
		node[] arr = new node[n];
	
		//배열 안 list 초기화 , 값 넣기 
		for(int i=0;i<n;i++) {		
			arr[i] = new node(i, i);
			st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
	          int y = Integer.parseInt(st.nextToken());
	          arr[i] = new node(x, y);
		}
		//정렬
		Arrays.sort(arr, new Comparator<>(){

		
			@Override
			public int compare(node o1, node o2) {
				if(o1.x == o2.x)return o1.y-o2.y; 
				return o1.x - o2.x;
			}
			
		});

		int first = arr[0].x;
		int last = arr[0].y;
		int result = 0;
	
		for(int i=1;i<n;i++) {
			int nowFirst = arr[i].x;
			int nowLast = arr[i].y;
			
			if(nowFirst<= last) {
				if(nowLast <= last) continue;
				else 	last = nowLast;
			}else {
				result += (last - first);
				first = nowFirst;
				last = nowLast;
			}
			
		}
		
		result += (last - first);
		System.out.println(result);

	}
	
	public static class node{
		int x;
		int y;
		
		public node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

}
