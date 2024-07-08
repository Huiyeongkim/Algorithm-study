import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int max = 251;
        
        int[][] friend = new int[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                friend[i][j] = max;
            }
        }
        
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            if(n1 == -1 && n2 == -1) break;
            friend[n1][n2] = 1;
            friend[n2][n1] = 1;
        }
        
        for(int k = 1; k <= n; k++) {
            friend[k][k] = 1;
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(friend[i][j] > friend[i][k] + friend[k][j]) {
                        friend[i][j] = friend[i][k] + friend[k][j];
                    }
                }
            }
        }
        
        int[] scores = new int[n + 1];
        int min = Integer.MAX_VALUE; 
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                scores[i] = Math.max(scores[i], friend[i][j]);
            }
            min = Math.min(min, scores[i]);
        }
        
        ArrayList<Integer> list = new ArrayList<>(); 
        for(int i = 1; i <= n; i++) {
            if(scores[i] == min) list.add(i);
        }
        
        bw.write(min + " " + list.size() + "\n");
        for(int temp : list) {
            bw.write(temp + " ");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}    
