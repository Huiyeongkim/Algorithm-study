package stack_9week;

import java.io.*;
import java.util.Stack;

public class BOJ_옥상정원꾸미기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        long cnt = 0;  // int로 하면 4%에서 틀렸습니다 -> int의 범위를 훨씬 초과함

        for(int i=0; i<N; i++) {

            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()) {

                if(stack.peek() <= height) {
                    // i번째 빌딩보다 낮거나 같은 애들은 빼버린다.
                    stack.pop();
                }
                else break;
            }
            cnt += stack.size(); //스택 사이즈를 더함으로써, 벤치마킹 가능한 개수를 더해준다.
            stack.push(height); //i번째 빌딩의 높이를 넣어준다.
        }
        bw.write(String.valueOf(cnt));
        bw.close();
    }
}
