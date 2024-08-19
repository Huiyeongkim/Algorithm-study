package stack_9week;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BOJ_스택수열 {

    static int N, value;

    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br. readLine());

        List<String> result = new ArrayList(N*2);
        stack = new Stack<>();



        int num = 1;
        for (int i = 0; i < N; i++) {
            value = Integer.parseInt(br.readLine());  // 수를 입력받고,

            // 입력받은 수가 나올 때까지 스택에 num을 1부터 입력받아 스택에 push한다.
            for (; num <= value; num++) {
                stack.push(num);
                result.add("+");
            }

            // 해당 숫자(입력받은 숫자)가 나오면 pop한다.
            if (stack.peek() == value) {
                stack.pop();
                result.add("-");
            } else break;  // 해당 값이 아니면 바로 오류 처리로 break
        }


        int cnt_push = Collections.frequency(result, "+");  // + 의 개수
        int cnt_pop = Collections.frequency(result, "-");  // - 의 개수

        // +와 -의 개수가 같으면 출력, 다르면 NO
        if (cnt_push == cnt_pop) {
            for (String s : result) {
                bw.write(s + "\n");
            }
        } else bw.write("NO");

        bw.flush();
        bw.close();
    }
}
