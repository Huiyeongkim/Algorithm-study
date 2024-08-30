package backtracking_11week;

import java.io.*;

/**
 * N * N의 체스판 위에 퀸 N개를 서로 공격하지 않게 놓아야 함 => 가능한 방법의 수
 * 일차원 배열 사용하는게 더 간단한듯
 */

public class BOJ_NQueen {

    private static int N; // 체스판 크기
    private static int[][] board; // 체스판 배열
    private static int solutions; // 가능한 해결책 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        solutions = 0;

        solveNQueen(0);
        bw.write(solutions + "");
        bw.flush();
        bw.close();
    }

    private static void solveNQueen(int row) {
        if (row == N) {
            solutions++; // 모든 퀸이 배치되면 해결책 수 증가
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1; // 퀸 배치
                solveNQueen(row + 1); // 다음 행으로 이동
                board[row][col] = 0; // 백트래킹을 위해 퀸 제거
            }
        }
    }

    private static boolean isSafe(int row, int col) {
        // 같은 열에 퀸이 있는지 확인
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        // 왼쪽 대각선 위(row-1(위), col-1(왼))로 퀸이 있는지 확인
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 오른쪽 대각선 위(row-1(위), col+1(오))로 퀸이 있는지 확인
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
