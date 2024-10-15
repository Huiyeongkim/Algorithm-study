import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;
	
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	//군사 이동
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int c =  Integer.parseInt(st.nextToken());
		int v =  Integer.parseInt(st.nextToken());
		int result = 0;
		parent = new int[p];
		for(int i=0;i<p;i++) parent[i] = i;
		Queue<int[]> queue = new PriorityQueue<>(((o1,o2)->o2[2]-o1[2]));
		
		
		for(int i=0;i<w;i++) {
			 st = new StringTokenizer(br.readLine());
			 int n1 = Integer.parseInt(st.nextToken());
			 int n2 = Integer.parseInt(st.nextToken());
			 int width = Integer.parseInt(st.nextToken());
			 int[] line = {n1,n2,width};
			 queue.add(line);
		}
		
		while(find(c) != find(v)) {
			int[] arr = queue.poll();
			if(find(arr[0]) != find(arr[1])) {
				union(arr[0],arr[1]);
				result = arr[2];
			}
		}
		
		System.out.println(result);
	}
	
	static int find(int x) {
		if(parent[x] ==x) return x;
		return parent[x] = find(parent[x]);
	}
		
	static void union(int x , int y) {
		int parentX = find(x);
		int parentY = find(y);
		if(parentX != parentY) parent[parentX] = parentY;
	}
	
	
}
