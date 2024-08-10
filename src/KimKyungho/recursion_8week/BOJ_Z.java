package recursion_8week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_Z {
    static int N, r, c, cnt;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int n = (int)Math.pow(2, N);  // 한 변의 길이 2^N

        cut(n, r, c);  // (한 변의 길이, row, column)
        bw.flush();
        bw.close();
    }

    /**
     * 4등분
     * 문제의 첫 번째 그림인 2^1 * 2^1을 연결해서 한 것이므로 끝까지 들어가야 됨.
     * 1 | 2
     * ------
     * 3 | 4
     */
    public static void cut(int size, int r, int c) throws IOException {
        if (size == 1) {
            bw.write(cnt + "");
            return;
        }
        int half = size / 2;  // 4등분 했을 때, 각 사분면의 한 변의 길이
        /**
         * 각 사분면의 첫 좌표
         * - 1사분면 = (0, 0)
         * - 2사분면 = (0, 0+half)
         * - 3사분면 = (0+half, 0)
         * - 4사분면 = (0+half, 0+half)
         * r과 c는 각 좌표에 +half 한 값보다 작아야 함.
         */
        if (r < half && c < half) {  // 1 사분면
            cnt += half * half * 0;
            cut(half, r, c);
        } else if (r < half && c < half+half) {  // 2사분면
            cnt += half * half * 1;  // 1사분면의 칸수의 합을 cnt에 더해주고,
            cut(half, r, c - half);  // 1사분면의 위치로 재귀하여 다시 진행 (cnt에 이미 이전의 수들은 누적했으므로 c-half을 함으로써 위치만? 이동하여 다시 진행)
        } else if (r < half+half && c < half) {  // 3사분면
            cnt += half * half * 2;  // 1사분면 + 2사분면의 칸수의 합을 cnt에 저장
            cut(half, r - half, c);  // 3사분면에서 이어서 진행하지만 r-half을 함으로써 1사분면의 위치에서 재귀 진행
        } else if (r < half+half && c < half+half) {  // 4사분면
            cnt += half * half * 3;  // 1사분면 + 2사분면 + 3사분면의 칸수의 합을 cnt에 저장
            cut(half, r - half, c - half);  // 4사분면에서 이어서 진행하겠지만 r-half, c-half으로 1사분면에서 재귀 진행
        }
    }
}
