import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer sn = new StringTokenizer(br.readLine());

		int num = Integer.parseInt(sn.nextToken());
		Long c = Long.parseLong(sn.nextToken());
		Map<Long, Integer> map = new HashMap<>();
		List<Long> iList = new ArrayList<>();
		List<Long> rank = new ArrayList<>();
		List<Long> rslt = new ArrayList<>();
		long n;
		long max = -1;
		long maxKey = -1;

		sn = new StringTokenizer(br.readLine());
		for (int i = 0; i < num; i++) {
			n = Long.parseLong(sn.nextToken());
			iList.add(n);
			if (!map.containsKey(n)) {
				map.put(n, 1);
				rank.add(n);
			} else {
				map.put(n, map.get(n) + 1);
			}
		}
		Collections.sort(iList);
		int idx = 0;

		while ( map.size() > 0) {
			max = -1;
			for(idx = 0; idx < iList.size(); idx++) {
				if (max < map.get(iList.get(idx))) {
					max = map.get(iList.get(idx));
					maxKey = iList.get(idx);
				}else if (max == map.get(iList.get(idx))) {
					//System.out.println("mx=" + rank.indexOf(maxKey) + "map = " + rank.indexOf(iList.get(idx)) + "idx - " + iList.get(idx) + ", max-" + maxKey);
					if(rank.indexOf(maxKey) > rank.indexOf(iList.get(idx))) {
						maxKey = iList.get(idx);
						max = map.get(maxKey);
					}
				}
			}
			//System.out.println(max);

			for(int i = 0; i < map.get(maxKey); i++) {
				rslt.add(maxKey);
				iList.remove(maxKey);
			}
			map.remove(maxKey);
		}

		for(int i = 0; i < rslt.size(); i++) {
			bw.write(rslt.get(i) + " ");
		}
		bw.flush();
		bw.close();
	}
}