import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		Map<Long, Integer> map = new HashMap<>();
		long n;
		long max = -1;
		long maxKey = -1;

		for (int i = 0; i < num; i++) {
			n = Long.parseLong(br.readLine());
			if (!map.containsKey(n)) {
				map.put(n, 1);
			} else {
				map.put(n, map.get(n) + 1);
			}

			if (map.get(n) > max || (map.get(n) == max && n < maxKey)) {
				max = map.get(n);
				maxKey = n;
			}
		}

		bw.write(maxKey + "\n");
		bw.flush();
		bw.close();
	}
}