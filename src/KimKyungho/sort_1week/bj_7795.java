import java.io.*;
import java.util.*;

public class bj_7795 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); //테스트케이스 수

        for(int t=0;t<T;t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<N;i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0;i<M;i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);
            int temp = 0;
            for(int i=0;i<N;i++) {  // B에 대하여 이분탐색
                int low = 0;
                int high = M-1;  // B의 마지막 인덱스
                int cnt = 0;
                while(low<=high) {
                    int mid = (low+high)/2; //중간값
                    if(B[mid]<A[i]) {  // B의 중간값이 현재 위치의 A값보다 작으면
                        low = mid+1;  // 적절한 위치로 low값 조정
                        cnt = mid+1;  // 인덱스 상으로 현재 mid+1이 A값보다 작은 것의 개수이므로 일단은 cnt에 추가
                    }
                    else
                        high = mid-1;  // 적절한 위치로 high값 조정
                }
                temp+=cnt;
            }
            result.append(temp+"\n");
        }

        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}