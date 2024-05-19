import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Room implements Comparable<Room> {
		int sTime;
		int eTime;

		public Room(int sTime, int eTime) {
			this.sTime = sTime;
			this.eTime = eTime;
		}

		@Override
		public int compareTo(Room o) {
			if (this.sTime == o.sTime) {
				return this.eTime - o.eTime;
			}
			return this.sTime - o.sTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = Integer.parseInt(br.readLine());
		Room[] meetings = new Room[num];

		for (int i = 0; i < num; i++) {
			StringTokenizer sn = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(sn.nextToken());
			int end = Integer.parseInt(sn.nextToken());
			meetings[i] = new Room(start, end);
		}

		Arrays.sort(meetings);

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		pq.add(meetings[0].eTime);

		for (int i = 1; i < num; i++) {
			if (meetings[i].sTime >= pq.peek()) {
				pq.poll();
			}
			pq.add(meetings[i].eTime);
		}

		// 필요한 강의실의 개수는 큐에 남아있는 종료 시간의 개수
		bw.write(pq.size() + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
