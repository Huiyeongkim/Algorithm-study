import java.io.*;
import java.util.*;

public class Main {
	static int[][] matrix=new int[9][9];
	static 	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
	
		backtracking(0,0);
		bw.flush();
		bw.close();
		}
	
	
	
	public static void backtracking(int row,int col) throws IOException  {
		//가로 끝까지 오면 다음 줄로 내려간다. 
		if(col == 9) {
			backtracking(row+1,0);
			return;
		}
		
		//세로까지 다 오면 끝. 출력 
		if(row == 9) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					bw.write(matrix[i][j]+" ");
				}
				bw.write("\n");
			}
		
			return;
		}
		
		
		//0 발견
		if(matrix[row][col] == 0) {
			for(int i=0;i<9;i++) { //1~9까지 맞는 숫자 넣는다. 
				if(check(row,col,i+1)) {
					matrix[row][col] = i+1; //값 대입
					backtracking(row,col+1); //다음칸 이동 
					
				}
			}
            matrix[row][col] =0; //다시 복구 
			return;
		}
		
		//아무일 없으면 다음으로 넘어감. 
		backtracking(row,col+1);
		return;
	}
	
	public static boolean check(int row,int col , int num) {
	
		for(int i=0;i<9;i++) {
			//가로 체크
			if(matrix[row][i] == num) return false;
			//세로 체크
			if(matrix[i][col] == num) return false;
		}
		
		//3*3 check
		int newRow = (row/3)*3; //0,3,6으로만 되도록 
		int newCol = (col/3)*3;
		
		for (int i = newRow; i < newRow + 3; i++) { //0,1,2 | 3,4,5 | 6,7,8
			for (int j = newCol; j < newCol + 3; j++) {//0,1,2 | 3,4,5 | 6,7,8
				if(matrix[i][j] == num) return false;
			}
		}
		
		
		return true;
			
		
		
	}
	
		
		
	
}
