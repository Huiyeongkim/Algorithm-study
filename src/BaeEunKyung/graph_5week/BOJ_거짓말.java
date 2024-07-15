import java.util.*;
import java.io.*;

class Main {
    static List<Integer>[] party;
    static int n;
    static int m;
    static boolean[] know;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int fr = Integer.parseInt(st.nextToken());
        know = new boolean[n + 1];
        for (int i = 0; i < fr; i++) {
            know[Integer.parseInt(st.nextToken())] = true;
        }

        party = new ArrayList[m];
        for (int i = 0; i < m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int partySize = Integer.parseInt(st.nextToken());
            int fPerson = Integer.parseInt(st.nextToken());
            party[i].add(fPerson);
            for (int j = 1; j < partySize; j++) {
                int person = Integer.parseInt(st.nextToken());
                party[i].add(person);
                union(fPerson, person);
            }
        }

        int result = 0;
        for (int i = 0; i < m; i++) {
            boolean canLie = true;
            for (int person : party[i]) {
                if (know[find(person)]) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) {
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (parent[x] == x || know[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    static void union(int x, int y) { //union-find
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (know[rootX]) {
                parent[rootY] = rootX;
            } else if (know[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
            }
        }
    }
}
