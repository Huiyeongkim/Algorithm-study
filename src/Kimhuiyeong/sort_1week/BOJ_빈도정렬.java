import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int[] k = new int[N];
        for (int i = 0; i < N; i++) {
            k[i] = Integer.parseInt(st.nextToken());
            map.put(k[i], map.getOrDefault(k[i], 0)+1);
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue())) {
                int index1 = 0, index2 = 0;
                for (int i = N-1; i >=0; i--) {
                    if (k[i] == o1.getKey()) index1 = i;
                    if (k[i] == o2.getKey()) index2 = i;
                }
                return index1-index2;
            }
            else
                return o2.getValue().compareTo(o1.getValue());
        }));

        for (Map.Entry<Integer, Integer> entry : list) {
            int num = entry.getKey();
            int val = entry.getValue();
            for (int i = 0; i < val; i++)
                System.out.print(num+" ");
        }
    }
}
