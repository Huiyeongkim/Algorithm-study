package etc;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
 
public class Main {
	static char[][] matrix;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
 
		matrix = new char[N][N];
        
		star(0, 0, N, false);
 
		//output
		for (int i = 0; i < N; i++) {
			bw.write(matrix[i]);
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
 
	static void star(int x, int y, int n, boolean blank) {
 		//n 은 지금 사이즈 
		// 공백
		if (blank) {
			for (int i = x; i < x + n; i++) {
				for (int j = y; j < y + n; j++) {
					matrix[i][j] = ' ';
				}
			}
			return;
		}
		//base case
		if (n == 1) {
			matrix[x][y] = '*';
			return;
		}
		
		//recursive case
		int nowsize = n/ 3;
		int count = 0;
		//가로 3등분, 세로 3등분 총 9등분한다. 
		for (int i = x; i < x + n; i += nowsize) { 
			for (int j = y; j < y + n; j += nowsize) {
				count++;
				if (count == 5) { // 공백 칸일 경우
					star(i, j, nowsize, true);
				} else { //계속 쪼개서 사이즈가 1일때 별찍기. 
					star(i, j, nowsize, false);
				}
			}
		}
	}
}
