# week2 Retrospective

# Theory

---

# Solving Problem

---

### BOJ11047[그리디]

![Untitled](https://user-images.githubusercontent.com/62997391/177955979-57ee602a-b2d6-4372-97a9-da2d35977b9c.png)

### BOJ1541[그리디]

![Untitled 1](https://user-images.githubusercontent.com/62997391/177955989-c8b05129-e7bc-4368-9e34-6dd7f103d232.png)

**<Analysis before Solving>**

시간제한 | 2초

시간복잡도 | ??? 잘 모르겠음 ㅠ

조건 |

- 식의 값 최소화
- operand가 0으로 시작 가능 (→ 처리 해주기 필수)

**<Retrospective after Solving>**

- operand가 0으로 시작하는 경우도 그냥 Integer.parseInt()로 처리 가능함
- 초반에 nextOperatorIndex method 만들어서 substring 이용하려 했는데 너무 복잡함 (가능하긴 할 듯)

**[Key Point]**

⇒ Stack 자료구조 이용하기
⇒ (-)가 나오면 다음 (+)가 나올 때까지 괄호쳐주면 최소값 도출 가능

⇒ 즉, (+)는 무시하고 tmp에 쭉쭉 += 하다가 (-)나오면 식 결과값에 더하기

**<Others explanation 1>**

- Stack 이용 안함
1. 입력받은 식에 대하여 “-”를 기준으로 Token 나누기
2. 첫번째 token에서 “+”을 기준으로 Token 나누고 operand에 대하여 answer에 더하기
3. 첫번째를 제외하고 나머지 Token에서 “+”을 기준으로 Token 나누고 operand에 대하여 answer에 빼기


---

### BOJ1931[그리디]

![Untitled 2](https://user-images.githubusercontent.com/62997391/178148224-35dba083-5a65-4682-b52c-0716bb03d329.png)

**<Analysis before Solving>**

시간제한 | 2초

시간복잡도 | 회의의 수가 최악의 경우 100,000이기 때문에 O(N*logN)까지 가능? O(N^2)는 안될 거 같음.

조건 | 

- 사용할 수 있는 회의의 최대 개수 찾기
- Map 쓰면 좋을 거 같음 → Map의 Key값에 대하여 정렬한 후 최대가 되는 값 찾아가면 될 듯? → XX
- 무조건 정렬하면 편할 거 같음

**<Retrospective after Solving>**

- 같은 시간(Key)에 대하여 여러 개의 Value가 있을 수 있으므로 Map X인 걸 알았어야 함
- **편협한 틀에 갇혀서 시작시각을 기준으로 소팅할 생각만 했음. 유연하고 열린 사고 가지기**

**[Key Point]**

⇒ Comparator Class 익숙해지기

```java
int[][] meetingTime = new int[N][2];

Arrays.sort(meetingTime, new Comparator<int[]>() {
      @Override
    public int compare(int[] o1, int[] o2) {
        if(o1[1] == o2[1])
            return o1[0] - o2[0];
        else
            return o1[1] - o2[1];
    }
});

for(int i = 0 ; i < N; i++){
    System.out.println("startTime : " + meetingTime[i][0] + " endTime : " + meetingTime[i][1]);
}
```

```java
//return value
/*
<1번째 인덱스 기준으로 오름차순 정렬>
startTime : 1 endTime : 4
startTime : 3 endTime : 5
startTime : 0 endTime : 6
startTime : 5 endTime : 7
startTime : 3 endTime : 8
startTime : 5 endTime : 9
startTime : 6 endTime : 10
startTime : 8 endTime : 11
startTime : 8 endTime : 12
startTime : 2 endTime : 13
startTime : 12 endTime : 14
*/
```

⇒ 종료시각 기준으로 정렬해서 종료가 일찍 되는 거 찾아가면 가장 많은 회의 선택 가능

⇒ 시간 복잡도 계산 했을 때 2중 for문은 안됨을 알았음. Sort 했으니 1중 for문으로 끝낼 생각 염두해 두기
