package stack_9week;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Stack<Top> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int top_height = Integer.parseInt(st.nextToken());  // 탐의 높이

            if (stack.isEmpty()) {
                sb.append("0 ");  // 스택이 비어있으면, 초기값으로 0을 출력
                stack.push(new Top(i, top_height));  // 첫 번째 탑
            } else {
                while (true) {
                    if (stack.isEmpty()) {  // 초기값이 아니지만 스택이 비어있는 경우 -> 9 같은 경우
                        sb.append("0 ");
                        stack.push(new Top(i, top_height));
                        break;
                    }
                    Top top = stack.peek();
                    if (top.height > top_height) {  // 스택의 꼭대기에 있는 탑이 현재 입력받은 탑의 높이보다 크면?
                        sb.append(top.num + " ");  // 스택 꼭대기의 탑의 번호를 저장
                        stack.push(new Top(i, top_height));  // 현재 입력받은 탑을 스택에 push
                        break;  // 결과를 얻으면 탈출
                    } else {
                        // 스택의 꼭대기에 있는 탑이 현재 입력받은 탑보다 작거나 같으면 무시(제거)
                        stack.pop();
                    }
                }
            }
        }
        bw.write(sb.toString() + "");
        bw.flush();
        bw.close();
    }
    private static class Top {
        int num, height;  // 탑 번호, 탑 높이

        public Top(int num, int height) {
            this.num = num;
            this.height = height;
        }
    }
}

