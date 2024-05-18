import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1.length() != o2.length()) {
                return o1.length() - o2.length();
            } else {
                int sum1 = 0;
                int sum2 = 0;

                for (int k = 0; k < o1.length(); k++) {
                    if (o1.charAt(k) >= '0' && o1.charAt(k) <= '9') {
                        sum1 += o1.charAt(k) - '0';
                    }
                    if (o2.charAt(k) >= '0' && o2.charAt(k) <= '9') {
                        sum2 += o2.charAt(k) - '0';
                    }
                }

                if (sum1 != sum2) {
                    return sum1 - sum2;
                } else {
                    return o1.compareTo(o2);
                }
            }
        });

        for (String array : arr) {
            System.out.println(array);
        }
    }
}
