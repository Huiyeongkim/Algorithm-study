import java.io.*;
import java.util.*;

public class bj_2910 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());  // 문자열을 끊어서 받기 위한 StingTokenizer
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // LinkedHashMap 생성 - 값에 대한 빈도수 저장 & 순서 보장
        HashMap<Integer, Integer> map = new LinkedHashMap<>();  // <입력값, 개수>
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());  // 문자열로 받은 값을 숫자로 변환
            // map 안에 num이 있으면 기본 값에 +1을 하여 저장
            // 없으면 새로 값을 추가
            if (map.containsKey(num)) {
                map.put(num, map.get(num)+1);  // 있으면 map에서 num에 대한 값을 가져와서 +1
            } else {
                map.put(num, 1);  // 새로운 값이 들어가므로 value:1
            }
        }

        // 키를 모두 ArrayList에 저장
        List<Integer> list = new ArrayList<>(map.keySet());  // map의 key들을 저장

        // Comparator를 사용하여 list의 키의 값들을 내림차순으로 정렬
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2).compareTo(map.get(o1));  // list의 o1을 map의 키값으로 한 value값을(숫자의 개수) 비교
            }
        });

        StringBuilder sb = new StringBuilder();  // 결과값 출력

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer e = it.next();
            for (int i = 0; i < map.get(e); i++) {  // e에 대한 value 값만큼 반복 -> 값의 횟수만큼 반복
                sb.append(e + " ");
            }
        }
        System.out.println(sb);
    }
}