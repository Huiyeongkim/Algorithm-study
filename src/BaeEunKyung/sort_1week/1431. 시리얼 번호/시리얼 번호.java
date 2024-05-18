import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		List<String> list = new ArrayList<>();
		//길이순
		//숫자 모든 자릿수 합
		//알파벳 사전순. 숫자 먼저
		for (int i = 0; i < num; i++) {
			list.add(br.readLine());
		}

		list.sort((o1, o2) -> {
			if (o1.length() != o2.length()) { //길이비교
				return o1.length() - o2.length();
			} else {
				int sum1 = 0;
				int sum2 = 0;
				for (int i = 0; i < o1.length(); i++) {
					if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
						sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
					}
				}
				for (int i = 0; i < o2.length(); i++) {
					if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
						sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
					}
				}
				if (sum1 == sum2)
					return o1.compareTo(o2);
				return sum1 - sum2;
			}
		});

		for(int i = 0; i < num; i++) {
			bw.write(list.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}
}