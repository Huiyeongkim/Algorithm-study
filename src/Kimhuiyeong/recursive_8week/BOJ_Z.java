import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// BOJ_Z (1074번)
// 한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.
// N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(Z(N, r, c));
    }

    public static long Z(int N, int r, int c) {
        int size = (int) Math.pow(2, N);
        long answer = 0;
        while (size > 1) {
            size = size/2;
            if (r < size && c >= size) { // 왼쪽 아래칸
                answer += size * size;
                c -= size;
            } else if (r >= size && c < size) { // 오른쪽 위칸
                answer += 2 * size * size;
                r -= size;
            } else if (r>=size && c >= size) { // 오른쪽 아래칸
                answer += 3 * size * size;
                r -= size;
                c -= size;
            }
        }
        return answer;
    }
}
