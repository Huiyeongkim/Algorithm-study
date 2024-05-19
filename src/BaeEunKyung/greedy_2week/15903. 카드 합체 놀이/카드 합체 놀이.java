import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sn = new StringTokenizer(br.readLine());

		Long n = Long.parseLong(sn.nextToken());
		Long m = Long.parseLong(sn.nextToken());
		List<Long> list = new ArrayList<>();
		sn = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			list.add(Long.parseLong(sn.nextToken()));
		}

		Long min1, min2 = 0L;
		for (int i = 0; i < m; i++) {
			Collections.sort(list);
			min1 = list.get(0);
			min2 = list.get(1);

			list.set(0, min1 + min2);
			list.set(1, min1 + min2);
		}

		Long sum =0L;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i);
		}

		bw.write(sum + "\n");
		bw.flush();
		bw.close();
	}
}