package implementation_10week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_연산자끼워넣기 {

    static int N;
    static int max_value = Integer.MIN_VALUE;
    static int min_value = Integer.MAX_VALUE;
    static int [] number;
    static int [] operator = new int[4];  // + - * /

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        number = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(number[0], 1);

        bw.write(max_value + "\n");
        bw.write(min_value + "");
        bw.flush();
        bw.close();
    }

    public static void dfs(int num, int index) {
        // 마지막 숫자에 도달 -> 최종 연산
        if (index == N) {
            max_value = Math.max(max_value, num);
            min_value = Math.min(min_value, num);
            return;
        }

        // dfs로 전체 탐색하면서 모든 경우의 수를 계산
        for (int i = 0; i < 4; i++) {
            // 연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                // 해당 연산자를 1 감소시킨다.
                operator[i]--;

                switch (i) {

                    case 0: // 더하기일 경우
                        dfs(num + number[index], index + 1);
                        break;
                    case 1: // 빼기일 경우
                        dfs(num - number[index], index + 1);
                        break;
                    case 2: // 곱하기일 경우
                        dfs(num * number[index], index + 1);
                        break;
                    case 3: // 나누기일 경우
                        dfs(num / number[index], index + 1);
                        break;

                }
                // 재귀호출이 종료되면 다시 해당 연산자 개수를 복구한다.
                operator[i]++;
            }
        }
    }
}
