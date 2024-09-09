import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N,M;
	static int[] arr;
	static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//	
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); //숫자 범위
		M = Integer.parseInt(st.nextToken()); // 배열 크기 
		arr = new int[M];
		DFS(0);
		bw.flush();
		bw.close();
		
	}
	
	public static void DFS(int size) throws IOException {
		
		if(size == M) {
			for(int i : arr) bw.write(i+" ");
			bw.write("\n");
			
			
			return ;
		}
		
		for(int i=1;i<=N;i++) {
			arr[size] = i;
			size++;
			DFS(size);
			size--;
		}
	
		return;
		
	}

}
