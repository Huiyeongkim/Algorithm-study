package stack_9week;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_오큰수 {

    static int N;
    static int[] arr, answer;
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];
        stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {  // 스택이 비어있지 않으면서, 인덱스 i에 해당되는 배열의 값이 스택 꼭대기에 있는 인덱스에 해당하는 배열의 값보다 크면? -> A_i 보다 큰 수 중
                answer[stack.pop()] = arr[i];  // 스택에서 pop한 인덱스에 해당되는 위치에 arr[i] 값을 대입
            }  // 하고 while문을 반복하여 그 이전 값에 대해서도 진행
            stack.push(i);  // 스택에 인덱스를 push
        }

        while (!stack.isEmpty()) {  // 위에서 대입되지 않은 인덱스에 해당되는 배열의 값에는 -1을 대입
            answer[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++ ){
            bw.write(answer[i] + " ");
        }
        bw.flush(); bw.close();
    }
}
