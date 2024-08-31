package backtracking_11week;

import java.io.*;
import java.util.StringTokenizer;

/**
 * - 같은 행에 있는 원소들 중 중복이 있으면 안됨
 */
public class BOJ_스도쿠 {

    static int [][] arr = new int[9][9];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sudoku(0, 0);


    }

    private static void sudoku(int row, int col) throws IOException {

        // 현재 진행 중인 행이 마지막까지 다 채워줬다면, 다음 행의 첫 번째 열부터 시작
        if (col == 9) {
            sudoku(row + 1, 0);
            return;
        }

        // 행과 열이 모두 채워지면 출력 후 종료
        if (row == 9) {  // row가 9면 인덱스 범위를 벗어남으로서 종료
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    //bw.write(arr[i][j] + " ");
                    sb.append(arr[i][j]).append(" ");
                }
                //bw.write("\n");
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // 만약, 해당 위치의 값이 0이라면(값을 채워야 하므로) 1부터 9까지 중 가능한 수를 탐색
        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                // 1부터 9까지의 수를 모두 넣어보면서 스도쿠의 중복 조건에 걸리지 않는지 검사
                if (possibility(row, col, i)) {
                    arr[row][col] = i;
                    sudoku(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }
        sudoku(row, col + 1);  // 행의 다음 칸(열 이동)으로 이동
    }

    private static boolean possibility(int row, int col, int value) {

        // 같은 행에 있는 원소들 중 중복되는 원소가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) return false;
        }

        // 같은 열에 있는 원소들 중 중복되는 원소가 있는지 확인
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) return false;
        }

        // 3x3 부분의 첫 번째 칸의 좌표
        int set_row = (row / 3) * 3;  // value가 속한 3x3의 첫 번째 칸
        int set_col = (col / 3) * 3;  // value가 속한 3x3의 첫 번째 칸

        // 3x3의 각 칸의 값과 value 값을 비교하면서 같은게 있으면 false를 리턴 -> 중복이 있으면 안됨
        for (int i = set_row; i < set_row + 3; i++) {  // 3x3의 행 이동
            for (int j = set_col; j < set_col + 3; j++) {  // 3x3의 열 이동
                if (arr[i][j] == value) return false;
            }
        }

        return true;
    }
}
