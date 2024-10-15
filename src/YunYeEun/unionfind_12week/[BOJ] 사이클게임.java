import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent ;
	static boolean[] cycle;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int result = 0;
		int N = Integer.parseInt(st.nextToken()); //num 범위
		int M = Integer.parseInt(st.nextToken()); //size 
		parent = new int[N];
		
		for(int i=0;i<N;i++) parent[i] = i;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a  = Integer.parseInt(st.nextToken()); 
			int b  = Integer.parseInt(st.nextToken()); 
			//System.out.println(a+","+b+","+i);
			union(Math.min(a, b),Math.max(a, b));
			cycle = new boolean[N];
			if(cycle(a,1)) {
				result = i+1;
				
				break;
			}
			
		}
		
	bw.write(result+"\n");
	bw.flush();
	bw.close();
	}
	
	public static boolean cycle(int now,int count) {
		//시작 == 끝이면 cycle 
	//	System.out.println(now+", count : "+ count);
		if(parent[now] == now) return false;
		
		if(!cycle[parent[now]]) {
			cycle[parent[now]] = true;
			count++;
			return cycle(parent[now],count);
		}else {
			if(parent[now] != now && count >2) {
				//System.out.println("cycle");
				return true;
			}
		}
		
		
		return false;
	}
	
	//합쳐 
	public static void union(int a,int b) {
		
		int pA = find(a);
		int pB = find(b);
		
		if(pA < pB) {
			parent[b] = a;
			
		}else if(pA == pB) {
			parent[a] = b;
	
		}

		
		
		
//		System.out.println("parent arr");
//		for(int i=0;i<parent.length;i++) {
//			System.out.print(parent[i]+" ");
//		}
//		System.out.println();
	}
	//제일 윗대가리 찾아 
	public static int find(int a) {
		if(parent[a] == a ) return a;
		return find(parent[a]);
	}
	
	/*
	 * 
10 7
0 1
1 2
2 3
3 4
4 5
5 6
6 0
	 * */

}
