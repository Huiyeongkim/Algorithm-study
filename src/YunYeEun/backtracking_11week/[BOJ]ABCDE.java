import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int people = Integer.parseInt(st.nextToken());
		int num = Integer.parseInt(st.nextToken());
		int first , second;
		int count =1;

		arr = new ArrayList[people];
		visited = new boolean[people];
		for(int i=0;i<people;i++) {
			arr[i] = new ArrayList<Integer>();
		
		}
		for(int i=0;i<num;i++) {
			 st = new StringTokenizer(br.readLine());
			 first =  Integer.parseInt(st.nextToken());
			 second =  Integer.parseInt(st.nextToken());
			 arr[first].add(second);
			 arr[second].add(first);
			// System.out.println(i+","+arr[i]);
		}
		
		for(int i=0;i<people;i++) {
			//visited 다시 F로 원위치 함수
		//	visitedBack();
			check(i,1); //0~7까지 차례로 진행 
			if (result==1) break;
			
		}
		
		System.out.println(result);

	}
	
	public static void visitedBack() {
		for(int i=0;i<visited.length;i++) {
			visited[i]= false;
		}
	}
	
	public static void check(int e,int count) {
		if(count ==5) {
			result =1;
			return;
		}
		visited[e] = true;
		
		for(int i:arr[e]) {
			if(!visited[i]) {
			//	visited[i] = true;
				check(i,count+1);
			}
		
		}
		visited[e] = false;
	}

}

