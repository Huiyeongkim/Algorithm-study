package recursion_8week;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_곱셈 {

    static long C;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long result = pow(A, B);
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    /**
     * 분할 정복을 이용한 거듭제곱 계산 함수로 a^b를 계산하면서 중간에 c로 나눈 나머지를 유지하여 숫자가 너무 커지지 않도록 방지(BufferOverflow)
     */
    public static long pow(long A, long exponent) {
        // 지수가 1일 경우 A^1 이므로 A % C를 리턴
        if (exponent == 1) return A % C;

        // 지수의 절반에 해당하는 A^(B/2)를 구한다.
        long temp = pow(A, exponent/2);

        if (exponent % 2 == 1) {
            /**
             * 현재 지수가 홀수인 경우?
             * ex) exponent = 홀수 -> A^exponent = A^(exponent/2) * A^(exponent/2) * A
             * 가 되므로 A를 한 번 더 곱해줘야 한다.
             *
             * return temp * temp * A % C로 진행하면 long 형의 범위를 넘김
             * -> 모듈러 공식 사용 => (a * b) % C = (a % C * b % C) % C
             *  (temp * temp * a) % C = ((temp * temp % C) * (a % C)) % C = (((temp * temp % C) % C) * ((A % C) % C))) % C 인데 (x%C)%C = x%C 이므로
             *  = (temp * temp % C) * (a % C) % C = (temp * temp % C) * a % C 가 됨.
             */
            //return temp * temp * A % C;
            return (temp * temp % C) * A % C;
        }
        // 지수가 짝수 인 경우
        return temp * temp % C;
    }
}
