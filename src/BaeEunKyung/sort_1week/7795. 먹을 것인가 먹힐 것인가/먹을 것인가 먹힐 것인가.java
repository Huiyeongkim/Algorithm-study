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

		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num; i++) {
			StringTokenizer sn = new StringTokenizer(br.readLine());
			int aNum = Integer.parseInt(sn.nextToken());
			int bNum = Integer.parseInt(sn.nextToken());

			sn = new StringTokenizer(br.readLine());
			List<Integer> aList = new ArrayList<>();
			for (int a = 0; a < aNum; a++) {
				aList.add(Integer.parseInt(sn.nextToken()));
			}
			Collections.sort(aList);

			sn = new StringTokenizer(br.readLine());
			List<Integer> bList = new ArrayList<>();
			for (int b = 0; b < bNum; b++) {
				bList.add(Integer.parseInt(sn.nextToken()));
			}
			Collections.sort(bList);

			int cnt = 0;
			for (int a : aList) {
				cnt += compare(bList, a);
			}
			bw.write(cnt + "\n");
		}

		bw.flush();
		bw.close();
	}

	private static int compare(List<Integer> bList, int num) {
		int left = 0;
		int right = bList.size() - 1;
		int cnt = 0;

		while (left <= right) {
			int mid = (left + right) / 2;
			if (bList.get(mid) < num) {
				cnt = mid + 1; 
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return cnt;
	}
}