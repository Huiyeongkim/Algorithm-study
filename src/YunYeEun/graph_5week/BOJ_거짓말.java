import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
public class Main {
	static int[] parents;
	static List<Integer> knowTruth;
	public static void main(String[] args) throws NumberFormatException, IOException {
		//build up
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int party = Integer.parseInt(st.nextToken());
		ArrayList<int[]> list = new ArrayList<int[]>();
		int count =0;
		parents = new int[n+1];
		for(int i=1;i<n+1;i++) parents[i] = i;
		
		st = new StringTokenizer(br.readLine());
		int howMany =  Integer.parseInt(st.nextToken());
		if(howMany==0) {
			System.out.println(party);
			return;
		}else {
			knowTruth= new ArrayList<Integer>();
			for(int i=0;i<howMany;i++) {
				knowTruth.add(Integer.parseInt(st.nextToken()));
			}
			
			//System.out.println("truth "+knowTruth);
		}
		
		for(int i=0;i<party;i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int[] temp = new int[size];
			for(int j=0;j<size;j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			list.add(temp);
		}
		
		//start 
		for(int[] arr:list) {
			if(arr.length ==1) continue;
			else {
				for(int i=1;i<arr.length;i++) {
					//System.out.println(arr[i]+","+arr[i+1]+"union in");
					union(arr[0],arr[i]);
				//System.out.println(Arrays.toString(parents));
				}
				
			}
		}
		
	

		loop :
		for(int[] arr:list) {
			for(int i:arr) {
					if(knowTruth.contains(parents[i])) {
						//System.out.println(parents[i]+"is know true"+Arrays.toString(arr));
						 continue loop;
					}
				}
		count++;

		}
		System.out.println(count);
		
		
		
	}
	
	private static void union(int a,int b) {
		
		a = find(a);
		b = find(b);  //대표들
		
		if(a!=b) {
			int small; int large;
			if(knowTruth.contains(a)) {
			
				small = a;
				large = b;
			}else if(knowTruth.contains(b)){
				
				small =b ;
				large = a;
			}else {
				small = Math.min(a, b);
				large = Math.max(a, b);
			}
				
			for(int i=1;i<parents.length;i++) {
				if(i==large) continue;
				if(parents[i] == parents[large]) 
					parents[i] = parents[small];
			}
			
			parents[large] = parents[small];
			//System.out.println(parents[large]+","+large);
		}else {
			return;
		}
		
		
		
		
	
	}
	
	private static int find(int a) {
		if(knowTruth.contains(a)) {
			return parents[a] = a;

		}
		if(parents[a] == a) return a;
		else return parents[a] = find(parents[a]);
	}

}

