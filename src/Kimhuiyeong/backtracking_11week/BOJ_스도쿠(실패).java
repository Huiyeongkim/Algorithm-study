import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        function(0, 0);
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void function(int col, int row) {
        // 찾기 DFS 구현?
    }
    public static boolean possibility(int row, int col, int value) {
        // 같은 행
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        // 같은 열
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        // 3*3 칸
        int row2 = (row / 3) * 3; 
        int col2 = (col / 3) * 3; 

        for (int i = row2; i < row2 + 3; i++) {
            for (int j = col2; j < col2 + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }
        return true; 
    }
}
