
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static boolean[] visited ;
	static int[] result;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n = Integer.parseInt(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		tree = new ArrayList[n+1];
		visited = new boolean[n+1];
		result = new int[n+1];
		StringTokenizer st;
		
		for(int i=0;i<tree.length;i++) tree[i] = new ArrayList<>();
		
		for(int i=0;i<n-1;i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());
			
			tree[first].add(second);
			tree[second].add(first);
			
			
		}
		
		DFS(1);
		
		for(int i=2;i<=n;i++) {
			System.out.println(result[i]);
		}
		
	}
	
	static void DFS(int num) {
		visited[num] = true;
		for(int i: tree[num]) {
			if(!visited[i]) {
				result[i] = num;
				DFS(i);
				
			}
		}
	}

}
