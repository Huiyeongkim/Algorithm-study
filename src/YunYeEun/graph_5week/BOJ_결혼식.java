import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

// 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 
// 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다. 상근이의 학번은 1이다.
// 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 
// 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
  
// 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다.
// 다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다. 
// 6            -> 3
// 5
// 1 2
// 1 3
// 3 4
// 2 3
// 4 5

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int num = Integer.parseInt(br.readLine());
		int relation = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[num+1]; //중복제외 
		visited[1] = true; //상근이는 제외 
		int countFriends = 0; //결과 
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer>[] list = new ArrayList[num+1];
		
		for(int i=0;i<list.length;i++) list[i] = new ArrayList<Integer>();
		
		for(int i=0;i<relation;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p1 = Integer.parseInt(st.nextToken());
			int p2 = Integer.parseInt(st.nextToken()); 
      //양방향 그래프 입력 
	    list[p1].add(p2);
			list[p2].add(p1);
			
      //p1 이나 p2가 1(상근)이면 , -> 큐에 넣고, 친구 수 올리기. 
			if(p1==1 && !visited[p2]) {
				countFriends++;
				q.add(p2); //p1 이 1이면 p2는 상근이 친구
				visited[p2] = true;
			}else if(p2==1 && !visited[p1]) {
				countFriends++;
				q.add(p1); //if p2 is 1 , p1 is 상근친구
				visited[p1] = true;
			}
			
		
		}
	
			while(!q.isEmpty()) {
				int now = q.poll(); //상근이 친구들, 예시 기준 : 2, 3
				
				for(int i=0;i<list[now].size();i++) { //예시 기준 list[2],list[3]안의 친구들까지만 카운트
					int friend = list[now].get(i);
					if(!visited[friend]) {
						countFriends++;
			      visited[friend] = true;
					}
				}
			}
			
			System.out.println(countFriends);
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
