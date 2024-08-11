
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int r,c;
	static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new  StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		r  = Integer.parseInt(st.nextToken());
		c  = Integer.parseInt(st.nextToken());
		result = 0;
		int size = (int)Math.pow(2, N);
		
		makeZ(size,0,0);
		
		System.out.println(result);
		
	}
	
	public static void makeZ(int size,int row,int col) {
			//System.out.println("row,col,result"+row+","+col+","+result);
			if(row==r && col==c) return;
			int newSize = size/2;
			//System.out.println("nowSize : "+newSize);
			if(newSize==1) {
				if(row!=r) result+=2;
				if(col!=c) result +=1;
				return ;
			}
			if(r<row+newSize) {
				if(c<col+newSize) {//1
					//System.out.println(1);
					makeZ(newSize,row,col);
				}else {//2
					//System.out.println(2);
					result+= newSize*newSize*1;
					makeZ(newSize,row,col+newSize);
				}
			}else {
				if(c<col+newSize) {//3
					//System.out.println(3);
					result+=newSize*newSize*2;
					makeZ(newSize,row+newSize,col);
				}else {//4
					//System.out.println(4);
					result+=newSize*newSize*3;
					makeZ(newSize,row+newSize,col+newSize);
				}	
			}
		
			
	
}
		
		
		
			
}
