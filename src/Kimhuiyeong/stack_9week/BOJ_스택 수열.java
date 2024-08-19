import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        Stack<Integer> stack = new Stack<>();

        while (n > 0) {
            int a = Integer.parseInt(br.readLine());
            if (a > start) {
                for (int i = start + 1; i <= a; i++) {
                    stack.push(i);
                    sb.append("+\n"); 
                }
                start = a;
            } else if (stack.peek() != a) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-\n");
            n--;
        }
        System.out.print(sb.toString()); 
    }
}
