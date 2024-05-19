import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Room implements Comparable<Room> {  
		int sTime;
		int eTime; 

		public Room(int sTime, int eTime) {
			this.sTime = sTime;
			this.eTime = eTime;
		}

		// 종료 시간이 같으면 시작 시간이 더 빠른거를 먼저
		@Override
		public int compareTo(Room o) {
			if (eTime == o.eTime) return sTime - o.sTime;
			return eTime - o.eTime;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer sn;
		Room[] meetings = new Room[num];

		for(int i = 0; i < num; i++) {
			sn = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(sn.nextToken());
			int end = Integer.parseInt(sn.nextToken());
			meetings[i] = new Room(start, end);
		}

		Arrays.sort(meetings); 
		int cnt = 0;
		int time = 0; 
		for (int i = 0; i < num; i++) {
			if (time <= meetings[i].sTime) {
				cnt++;
				time = meetings[i].eTime;
			}
		}
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

}
