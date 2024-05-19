import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
 
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer sn;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int lastNum; 
        int sum; 

        for (int i = 0; i < N; i++) {
            sn = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(sn.nextToken());
            arr[i][1] = Integer.parseInt(sn.nextToken());
        }
 
        Arrays.sort(arr, new Comparator<int[]>() { 
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                else
                    return o1[0] - o2[0];
            }
        });
 
        lastNum = arr[0][1]; 
        sum = arr[0][1] - arr[0][0]; 
 
        for (int i = 1; i < N; i++) {
            if (arr[i][0] <= lastNum) { 
                if (arr[i][1] >= lastNum)
                    sum += arr[i][1] - lastNum; 
                else
                    continue;
            } else {
                sum += arr[i][1] - arr[i][0]; 
            }
            lastNum = arr[i][1]; 
        }
        bw.write(String.valueOf(sum)); 
        bw.flush();
        bw.close();
    }
}
