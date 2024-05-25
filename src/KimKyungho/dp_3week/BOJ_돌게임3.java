package dp_3week;

import java.util.*;
import java.io.*;

public class BOJ_돌게임3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int [1001];

        arr[1] = 1;  // sk
        arr[2] = 2;  // cy
        arr[3] = 1;  // sk
        arr[4] = 1;  // sk
        for (int i = 5; i <= n; i++) {
            if (arr[i-1] % 2 == 0 || arr[i-3] % 2 == 0 || arr[i-4] % 2 == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 2;
            }

        }

        if (arr[n] % 2 == 0) {
            bw.write("CY");
        } else {
            bw.write("SK");
        }
        bw.flush();
        bw.close();
    }
}
