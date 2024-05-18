package sort_1week;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class bj_10825 {

    public static void main(String[] args) throws IOException {
        /**
         * 국어 점수가 감소하는 순서로
         * 국어 점수가 같으면 영어 점수가 증가하는 순서로
         * 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
         * 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
         */

        //Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //int N = sc.nextInt();
        int N = Integer.parseInt(br.readLine());
        String [][] arr = new String[N][4];  // 2차원 배열

        for (int i = 0; i < N; i++) {
            //arr[i] = sc.next().split(" ");  // 이름 국어 영어 수학
            arr[i] = br.readLine().split(" ");
        }

        /**
         * Comparator -> 함수형 인터페이스, 두 개의 객체를 넘겨받아 그것의 크기 비교를 수행하는 추상메서드인 compare를 구현하도록 강제함
         * : 하나의 숫자의 비교를 통한 정렬이 아니라, [이름 국어 영어 수학]처럼 여러 데이터가 저장된 객체들을 정렬할 때 사용
         * 개발자가 정의한 클래스 객체를 자신이 원하는 인스턴스 변수를 기준으로 정렬할 수 있으며, 오름차순, 내림차순 다차원 배열 정렬 등이 가능하다.
         * 오름차순 정렬 : a - b 또는 a.compareTo(b)
         * 내림차순 정렬 : b - a 또는 b.compareTo(a)
         */
        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                if (o1[1].equals(o2[1])) {  // 국어
                    if (o1[2].equals(o2[2])) {  // 영어
                        if (o1[3].equals(o2[3])) {  // 수학
                            // 4. 모든 점수가 같은 경우 -> 이름이 사전 순으로 증가(이름 오름차순)
                            return o1[0].compareTo(o2[0]); // arr[0] : 문자
                        } else {
                            // 3. 국어와 영어 점수가 같은 경우 -> 수학 점수가 감소(수학 내림차순)
                            return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));  // arr[1~3] : 정수
                        }
                    } else {
                        // 2. 국어 점수가 같은 경우 -> 영어 점수가 증가(영어 오름차순)
                        return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
                    }
                } else {
                    // 1. 국어 점수가 감소(내림차순)하는 순서로
                    return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
                }
            }
        });

        for (int i = 0; i < N; i++) {
            System.out.println(arr[i][0]);
        }
    }
}