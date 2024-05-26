import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int K;
    static int N;
    static List<Integer> dp = new ArrayList<>();
    static int[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //종류
        K = sc.nextInt(); //값
        coin = new int[N];
        for (int i = 0; i < N; i++)  coin[i] = sc.nextInt();
        solve();
    }

    public static void solve() {

        dp.add(0); 
        for (int i = 0; i < K; i++) {
            dp.add(0);
        }

        dp.set(0,1); //0에서 경우의수가 1임. 수정. 
        
        for (int i = 0; i < N; i++) { 
            for (int j = coin[i]; j <= K; j++) {
                dp.set(j, dp.get(j) + dp.get(j - coin[i])); //값 갱신 시키기 
            }
        }

      //0  1 2 3 4 5 6 7 8 9 10
      //-----------------------
    //  1  1 1 1 1 1 1 1 1 1 1 1 
   //   2  1 1 2 2 3 3 4 4 5 5 6
    //  5  1 1 2 2 3 4 5 6 7 8 10

        System.out.println(dp.get(K));
    }
}
