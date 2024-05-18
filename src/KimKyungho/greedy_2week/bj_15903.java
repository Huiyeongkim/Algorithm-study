package greedy_2week;

import java.io.*;
import java.util.*;

public class bj_15903 {
    // Long 타입으로 해야됨
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        long sum;
        long result = 0;
        long a, b;


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 카드 개수
        int m = Integer.parseInt(st.nextToken());  // 합체 횟수

        Queue<Long> queue = new PriorityQueue<>();  // 매 횟수마다 작은것 부터 뽑기 위해 우선순위 큐 사용

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {  // 합체할 때마다 가장 작은 수 두 개를 뽑아서 더하고 다시 두 개를 넣는다.
            a = queue.poll();  // 빼고
            b = queue.poll();  // 빼고
            sum = a + b;  // 더하고
            queue.offer(sum);  // 다시 넣고
            queue.offer(sum);  // 다시 넣고
        }

        for (int i = 0; i < n; i++) {
            result += queue.poll();
        }

        bw.write(result + "");
        bw.flush();
        bw.close();
    }
}