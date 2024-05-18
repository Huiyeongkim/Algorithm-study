package greedy_2week;

import java.util.*;
import java.io.*;

public class bj_2170 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int arr[][] = new int [N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int o1[], int o2[]) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int length = end - start;
        for (int i = 1; i < N; i++) {
            if (start <= arr[i][0] && end >= arr[i][1]) {  // 선이 완전히 겹치는 경우(포함된 경우)
                continue;
            } else if (arr[i][0] < end) {  // 현재 선의 시작 부분이 이전 선에 포함된다면
                length += arr[i][1] - end;  // 길이에 증가된 길이만큼 추가
            } else {  // 현재 선 밖으로 나간 경우(겹치지 않는 경우)
                length += arr[i][1] - arr[i][0];
            }
            start = arr[i][0];  // 다음 루프에서 비교될 현재 선을 짖정
            end = arr[i][1];
        }

        bw.write(length + "");
        bw.flush();
        bw.close();
    }
}