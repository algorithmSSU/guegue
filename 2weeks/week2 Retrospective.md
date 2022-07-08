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
