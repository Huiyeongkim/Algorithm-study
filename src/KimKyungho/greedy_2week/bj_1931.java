package greedy_2week;

import java.util.*;
import java.io.*;

public class bj_1931 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N= Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {  // 서로 겹치지 않는 활동에 대해 종료시간이 빠르면 더 많은 활동을 선택할 수 있는 시간이 많아진다는 것
            @Override
            public int compare(int[] o1, int[] o2) {  // 종료 시간을 기준으로 오름차순
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= arr[i][0]) {  // 이전 종료 시간이 현재 시작 시간보다 작거나 같으면 cnt늘리고 end 현재 회의의 종료시간 저장
                cnt++;
                end = arr[i][1];
            }
        }
        bw.write(cnt + "");
        bw.flush();
        bw.close();
    }
}