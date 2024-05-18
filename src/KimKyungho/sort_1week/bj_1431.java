import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;

public class bj_1431 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String [] arr = new String [N];

        for (int i = 0; i < N; i++) {
            arr [i] = sc.next();
        }

        Arrays.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {  // 1.
                    int sum1 = 0, sum2 = 0;
                    for (int i = 0; i < o1.length(); i++) {  // 문자열 길이만큼 돌리는데
                        if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {  // 문자열을 문자 단위로 자른게 숫자면
                            sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));  // 정수로 변환해서 더하면서 자리합을 구함
                        }
                    }
                    for (int i = 0; i < o2.length(); i++) {
                        if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                            sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                        }
                    }
                    if (sum1 == sum2) {  // 2.
                        // 3. 사전순으로 비교 -> 오름차순
                        return o1.compareTo(o2);  // 문자열의 경우 compareTo()를 사용. 수치형 데이터의 경우 o1 - o2를 사용
                    } else {
                        // 2. A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저 온다.(숫자만 더함)
                        return sum1 - sum2;  // 반환값이 음수라면 o1이 o2보다 앞에 오도록 정렬됨(sum1이 sum2보다 작을 때 발생함)
                    }
                } else {
                    return o1.length() - o2.length();
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i]);
        }
    }
}