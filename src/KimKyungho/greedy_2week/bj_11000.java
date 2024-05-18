package greedy_2week;

import java.util.*;
import java.io.*;

public class bj_11000 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {  // 시작 시간을 기준으로 오름차순으로 정렬하고, 만약 시작 시간이 같다면 종료 시간을 기준으로 오름차순 한다.
            public int compare(int [] o1, int [] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];  // 시작 시간이 같으면 종료 시간을 기준으로 오름차순
                } else {
                    return o1[0] - o2[0];  // 시작 시간을 기준으로 오름차순
                }
            }
        });

        Queue<Integer> queue = new PriorityQueue<>();
        queue.offer(arr[0][1]);  // 우선순위 큐에 배열의 첫번째 강의의 종료 시간을 넣는다.

        for (int i = 1; i < n; i++) {  // queue 안에 있는 가장 첫 수업의 종료 시간과 이 후 두번째 수업부터의 시작 시간을 비교.
            if (queue.peek() <= arr[i][0]) {  // 만약에 수업이 끝난 직후 도는 수업이 끝난 후에 다른 수입이 있다면 (즉, T_i ≤ S_j 일 경우 i 수업과 j 수업은 같이 들을 수 있다.)
                queue.poll();  // queue에서 이전 수업을 빼고 (queue 내부의 개수가 강의실 개수이므로 이전 수업 이후에 다른 수입 진행이 가능하다면 이전 수업을 제외하는게 효율적이다)
            }
            queue.offer(arr[i][1]); // 현재 수업의 종료 시간을 다시 넣는다.
        }
        int cnt = queue.size();
        bw.write(cnt+"");
        bw.flush();
        bw.close();
    }
}