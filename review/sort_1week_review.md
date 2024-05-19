# 1주차: 정렬(1431, 2910, 7795, 10825) Review

## 1431: 시리얼 번호

조건이 여러 개 있으므로 Comparator를 이용해서 풀면 됨.
- return o1 - o2 (o1.compareTo(o2)) : 오름차순 정렬
- return o2 - o1 (o2.compareTo(o1)) : 내림차순 정렬

```java
list.sort((o1, o2) -> {
    if (o1.length() != o2.length()) { //길이비교
        return o1.length() - o2.length();
    } else {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < o1.length(); i++) {
            if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') {
                sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
            }
        }
        for (int i = 0; i < o2.length(); i++) {
            if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
            }
        }
        if (sum1 == sum2)
            return o1.compareTo(o2);
        return sum1 - sum2;
    }
});
```
```java
Arrays.sort(arr, new Comparator<String>(){
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) { 
            int sum1 = 0
            int sum2 = 0;
            for (int i = 0; i < o1.length(); i++) {
                if (o1.charAt(i) <= '9' && o1.charAt(i) >= '0') { 
                    sum1 += Integer.parseInt(String.valueOf(o1.charAt(i)));
                }
            }
            for (int i = 0; i < o2.length(); i++) {
                if (o2.charAt(i) <= '9' && o2.charAt(i) >= '0') {
                    sum2 += Integer.parseInt(String.valueOf(o2.charAt(i)));
                }
            }
            if (sum1 == sum2) { 
                return o1.compareTo(o2);
            } else {
                return sum1 - sum2;
            }
        } else {
            return o1.length() - o2.length();
        }
    }
});
```


## 2910: 빈도 정렬

### ex1) 144ms
"만약, 수열의 두 수 X와 Y가 있을 때, X가 Y보다 수열에서 많이 등장하는 경우에는 X가 Y보다 앞에 있어야 한다. 만약, 등장하는 횟수가 같다면, <b>먼저 나온 것이 앞에 있어야 한다.</b>" 라는 조건이 있으므로 빈도수가 같다면 먼저 등장한 숫자가 앞으로 나오도록 해야 한다.
따라서 LinkedHashMap을 사용한다.
> <b>LinkedHashMap</b><br>
> : Map에 입력된 순서를 기억하는 자료구조 → 등장하는 횟수가 같다면 먼저 나온 것이 앞에 있어야 한다는 조건을 위해 사용
```java
HashMap<Integer, Integer> map = new LinkedHashMap<>();  // <입력값, 개수>
st = new StringTokenizer(br.readLine());
for (int i = 0; i < n; i++) {
    int num = Integer.parseInt(st.nextToken());
    // map 안에 num이 있으면 기본 값에 +1을 하여 저장하고 없으면 새로 값을 추가
    if (map.containsKey(num)) {
        map.put(num, map.get(num)+1);
    } else {
        map.put(num, 1);  
    }
}
```
1431번과 마찬가지로 Comparator를 사용해서 정렬

정렬된 리스트를 Iterator를 통해 StringBuilder에 저장하고 출력
><b>Iterator</b><br>
> : 컬렉션 프레임워크(List, Set, Map, Queue 등)에서 값을 가져오거나 삭제할 때 사용
```java
StringBuilder sb = new StringBuilder();
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    Integer e = it.next();
    for (int i = 0; i < map.get(e); i++) { 
        sb.append(e + " ");
    }
}
    
```
### ex2) 232ms
아래의 코드는 HashMap을 이용한 방법으로 `map.put(k[i], map.getOrDefault(k[i], 0)+1);`에서 getOrDefault를 사용하여 값 추가 조건을 처리했다.
> <b>getOrDefault</b><br>
> : Java의 Map 인터페이스에 포함된 메서드로, 주어진 키에 대응하는 값을 반환하되, 해당 키가 맵에 없을 경우에는 기본값을 반환한다.
```java
Map<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int[] k = new int[N];
        for (int i = 0; i < N; i++) {
            k[i] = Integer.parseInt(st.nextToken());
            map.put(k[i], map.getOrDefault(k[i], 0)+1);
        }
```
### ex3) 212ms
아래의 코드는 빈도에 따라 정렬된 결과를 rslt 리스트에 저장하는 과정이다. max와 maxKey를 사용하여 가장 빈도가 높은 숫자를 찾고, 빈도가 같을 경우 원래 순서를 비교하여 먼저 나온 것을 선택한다. iList에서 최대 빈도의 숫자를 제거하고, map에서도 제거한다.
```java
Collections.sort(iList);
while (map.size() > 0) {
    long max = -1;
    long maxKey = -1;
    for (int idx = 0; idx < iList.size(); idx++) {
        if (max < map.get(iList.get(idx))) {
            max = map.get(iList.get(idx));
            maxKey = iList.get(idx);
        } else if (max == map.get(iList.get(idx))) {
            if (rank.indexOf(maxKey) > rank.indexOf(iList.get(idx))) {
                maxKey = iList.get(idx);
                max = map.get(maxKey);
            }
        }
    }
    for (int i = 0; i < map.get(maxKey); i++) {
        rslt.add(maxKey);
        iList.remove(maxKey);
    }
    map.remove(maxKey);
}

```


## 7795: 먹을 것인가 먹힐 것인
### ex1) A와 B 둘다 내림차순 정렬을 하고, A가 B보다 더 큰 값을 발견하면 결과에 값 더하고 break 한다. 1012~1192ms
```java
int count = 0;
Arrays.sort(Narr);
for (int j = 0; j < N; j++) {
    for (int k = 0; k < M; k++) {
        if (Narr[j] > Marr[k]) count++;
        else 
            break;
    }
}
```

### ex2) 이분탐색 사용 468~708ms??
><b>이진탐색(이분탐색)</b><br>
> : 이진 탐색은 정렬되어 있는 리스트에서 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 방법이다.<br>
> (left, mid, right)를 사용하며 찾아야 하는 수의 범위 중 가운데의 값과 찾고자 하는 값을 비교하여 대소관계에 따라 특정 구간으로 이동하는 것을 반복한다.<br>
> 이분 탐색의 시간복잡도는 O(log N)으로 원하는 수를 찾을 때까지 탐색을 할 때마다 탐색 범위가 절반씩 줄어든다. 따라서 탐색 범위는 N, N/2, N/4, ..., 1 이 된다.

```java
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
```

## 10825: 국영수

Comparator를 사용해서 각 각 정렬 기준을 맞추어 주면 된다.

### ex1) List를 사용해서 입력을 받은 경우  800ms
```java
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
```

### ex2-1) 2차원 배열을 사용해서 입력을 받은 경우  1916ms
```java
String [][] arr = new String[N][4];  // 2차원 배열

for (int i = 0; i < N; i++) {
    arr[i] = br.readLine().split(" ");  // 이름 국어 영어 수학
}

Arrays.sort(arr, new Comparator<String[]>() {
    @Override
    public int compare(String[] o1, String[] o2) {
        if (o1[1].equals(o2[1])) {  // 국어
            if (o1[2].equals(o2[2])) {  // 영어
                if (o1[3].equals(o2[3])) {  // 수학
                    return o1[0].compareTo(o2[0]);
                } else {
                    return Integer.compare(Integer.parseInt(o2[3]), Integer.parseInt(o1[3]));
                }
            } else {
                return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
            }
        } else {
            return Integer.compare(Integer.parseInt(o2[1]), Integer.parseInt(o1[1]));
        }
    }
});
```
### ex2-2)  1832ms
```java
String[][] arr = new String[N][4];

for (int i=0; i<N; i++) {
    st = new StringTokenizer(br.readLine());
    arr[i][0] = st.nextToken();
    arr[i][1] = st.nextToken();
    arr[i][2] = st.nextToken();
    arr[i][3] = st.nextToken();
}

Arrays.sort(arr, ((o1, o2) -> {
    if (Integer.parseInt(o2[1]) < Integer.parseInt(o1[1])) return -1;
    else if (Integer.parseInt(o2[1]) == Integer.parseInt(o1[1])) {
        if (Integer.parseInt(o2[2]) > Integer.parseInt(o1[2])) return -1;
        else if (Integer.parseInt(o2[2]) == Integer.parseInt(o1[2])) {
            if (Integer.parseInt(o2[3]) < Integer.parseInt(o1[3])) return -1;
            else if (Integer.parseInt(o2[3]) == Integer.parseInt(o1[3])) return o1[0].compareTo(o2[0]);
        }
    }
    return 1;
}));
```