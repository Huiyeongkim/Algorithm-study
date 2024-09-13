###stack
## 정의 : LIFO (Last In, First Out) 구조를 따르는 자료구조
## 주요 연산 : 
push(푸시): 스택에 데이터를 추가하는 연산.
pop(팝): 스택에서 가장 최근에 추가된 데이터를 제거하고 반환하는 연산.
peek(또는 top): 스택의 맨 위에 있는 데이터를 제거하지 않고 확인하는 연산.
isEmpty: 스택이 비어 있는지 확인하는 연산.
## 구현 : array , linked list 사용

# 1. 오큰 수 

'''
  for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {  // 스택이 비어있지 않으면서, 인덱스 i에 해당되는 배열의 값이 스택 꼭대기에 있는 인덱스에 해당하는 배열의 값보다 크면? -> A_i 보다 큰 수 중
                answer[stack.pop()] = arr[i];  // 스택에서 pop한 인덱스에 해당되는 위치에 arr[i] 값을 대입
            }  // 하고 while문을 반복하여 그 이전 값에 대해서도 진행
            stack.push(i);  // 스택에 인덱스를 push
        
        while (!stack.isEmpty()) {  // 위에서 대입되지 않은 인덱스에 해당되는 배열의 값에는 -1을 대입
            answer[stack.pop()] = -1;
        }
'''

# 2. 스택 수열 
'''
for (int i = 0; i < N; i++) {
            value = Integer.parseInt(br.readLine());  // 수를 입력받고,

            // 입력받은 수가 나올 때까지 스택에 num을 1부터 입력받아 스택에 push한다.
            for (; num <= value; num++) {
                stack.push(num);
                result.add("+");
            }

            // 해당 숫자(입력받은 숫자)가 나오면 pop한다.
            if (stack.peek() == value) {
                stack.pop();
                result.add("-");
            } else break;  // 해당 값이 아니면 바로 오류 처리로 break
        }
  '''

# 3. 옥상 정원 꾸미기

'''
  for(int i=0; i<N; i++) {

            int height = Integer.parseInt(br.readLine());

            while(!stack.isEmpty()) {

                if(stack.peek() <= height) {
                    // i번째 빌딩보다 낮거나 같은 애들은 빼버린다.
                    stack.pop();
                }
                else break;
            }
            cnt += stack.size(); //스택 사이즈를 더함으로써, 벤치마킹 가능한 개수를 더해준다.
            stack.push(height); //i번째 빌딩의 높이를 넣어준다.
        }
'''
