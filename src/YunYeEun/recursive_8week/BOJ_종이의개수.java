import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] matrix;
	static int zero=0;
	static int one =0;
	static int minus =0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		matrix = new int[n][n];
		StringTokenizer st;
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recursive(0,0,n);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	
	public static void recursive(int row,int col, int size) {
		if(check(row,col,size)) {
			switch(matrix[row][col]) {
			case 1: 
				one++; return;
			case 0 : 
				zero++; return;
			case -1 :
				minus++; return;
			}
		}
		
		int nowSize = size/3;
		//1
		recursive(row,col,nowSize);
		//2
		recursive(row+nowSize,col,nowSize);
		//3
		recursive(row+(2*nowSize),col,nowSize);
		//4
		recursive(row,col+nowSize,nowSize);
		//5
		recursive(row+nowSize,col+nowSize,nowSize);
		//6
		recursive(row+(2*nowSize),col+nowSize,nowSize);
		//7
		recursive(row,col+(2*nowSize),nowSize);
		//8
		recursive(row+nowSize,col+(2*nowSize),nowSize);
		//9
		recursive(row+(2*nowSize),col+(2*nowSize),nowSize);
		
	}
	
	public static boolean check(int row,int col, int size) {
		int now = matrix[row][col];
		for(int i=row;i<row+size;i++) {
			for(int j=col;j<col+size;j++) {
				if(now != matrix[i][j]) return false;
			}
		}
		
		return true;
	}

}
