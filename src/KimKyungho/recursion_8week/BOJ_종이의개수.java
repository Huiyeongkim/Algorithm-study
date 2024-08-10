package recursion_8week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_종이의개수 {

    static int N;
    static int [][] arr;
    static int [] answer = new int[3];  // -1, 0, 1


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cut(0, 0, N);
        for (int i = 0; i < 3; i++) {
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static void cut(int x, int y, int size) {
        // 다 같은 숫자면 더하기
        if (numCheck(x, y, size)) {
            if (arr[x][y] == -1) {
                answer[0]++;
            } else if (arr[x][y] == 0) {
                answer[1]++;
            } else {
                answer[2]++;
            }
        } else {  // check가 false면? (다른 숫자가 포함되어 있으면) ->  9분할 진행
            int newSize = size / 3;

            // 왼쪽 위부터 오른쪽 아래로 cut()를 진행하며 분할을 진행
            cut(x, y, newSize);  // 1
            cut(x, y + newSize, newSize);  // 2
            cut(x, y + newSize * 2, newSize);  // 3

            cut(x + newSize, y, newSize);  // 4
            cut(x + newSize, y + newSize, newSize);  // 5
            cut(x + newSize, y + newSize * 2, newSize);  // 6

            cut(x + newSize * 2, y, newSize);  // 7
            cut(x + newSize * 2, y + newSize, newSize);  // 8
            cut(x + newSize * 2, y + newSize * 2, newSize);  // 9
        }
    }

    public static boolean numCheck(int x, int y, int size) {
        int start = arr[x][y];
        boolean check = true;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                // start(시작점)와 각 칸에 표기된 수를 비교하여 다르면 false를 반환
                if (start != arr[i][j]) {
                    check = false;
                    break;
                }
            }
        }
        return check;
    }
}
