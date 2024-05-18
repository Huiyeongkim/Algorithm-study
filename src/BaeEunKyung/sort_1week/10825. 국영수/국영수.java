import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Student {
        String name;
        int kr, en, mt;

        public Student(String name, int kr, int en, int mt) {
            this.name = name;
            this.kr = kr;
            this.en = en;
            this.mt = mt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kr = Integer.parseInt(st.nextToken());
            int en = Integer.parseInt(st.nextToken());
            int mt = Integer.parseInt(st.nextToken());
            list.add(new Student(name, kr, en, mt));
        }

        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                if (s1.kr != s2.kr) {
                    return Integer.compare(s2.kr, s1.kr);
                } else if (s1.en != s2.en) {
                    return Integer.compare(s1.en, s2.en);
                } else if (s1.mt != s2.mt) {
                    return Integer.compare(s2.mt, s1.mt);
                } else {
                    return s1.name.compareTo(s2.name);
                }
            }
        });

        for (Student student : list) {
            bw.write(student.name + "\n");
        }

        bw.flush();
        bw.close();
    }
}