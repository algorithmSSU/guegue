# week5 Retrospective

---

# Level2

---

일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

```
1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
```

예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- 현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
- 인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
- location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

![Untitled](https://user-images.githubusercontent.com/62997391/183292876-1736c6bd-183a-4a27-aff9-d32f8365da67.png)


### 입출력 예 설명

예제 #1

문제에 나온 예와 같습니다.

예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.

### My Solution

```java
class Solution {
    public int solution(int[] priorities, int location) {
        int sequence = 1;
        int target = priorities[location];
        
        
        /*
        target보다 큰 수 개수 검사
        가장 뒤에 있는 큰 수 인덱스 탐색
        location 기준으로 양 옆에 target 과 같은 수 개수 검사
        */
        boolean bigger = false;
        int biggerCount = 0;
        int latestBiggerIdx = 0;
        int sameValueCountBeforeLocation = 0;
        for(int i = 0 ; i < priorities.length; i++){
            if(target < priorities[i]){
                bigger = true;
                biggerCount++;
                latestBiggerIdx = i;   
            }
            if(i < location && target == priorities[i])
                sameValueCountBeforeLocation++;
        }
        
        if(bigger){
            //target보다 큰 수 개수만큼 ++
            sequence += biggerCount;
            
            //가장 뒤에 있는 큰 수의 idx가 location보다 작으면
            if(latestBiggerIdx < location){
                for(int i = latestBiggerIdx; i < location; i++){
                    if(priorities[i] == target)
                        sequence++;
                }
                return sequence;
            }else{
                for(int i = latestBiggerIdx; i < priorities.length; i++){
                    if(priorities[i] == target)
                        sequence++;
                }
                return sequence;
            }
        }else{
            return sequence + sameValueCountBeforeLocation;
        }
    }
}
```

if로 예외처리만 해줘서 풀었는데 접근 자체를 잘못함. 해당 방식으로 코드를 짜면 딱 한 번의 기회만 있음 (차라리 재귀적으로 짰으면 맞았을 수도.. 그래서 다른 방식을 생각해봤음)

```java
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    static int solution(int[] priorities, int location) {
        int sequence = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if(priorities[i] == pq.peek()){
                    if(i == location)
                        return sequence;
                    pq.poll();
                    sequence++;
                }
            }
        }
        return -1;
    }
}
```

---

# **뉴스 클러스터링**

여러 언론사에서 쏟아지는 뉴스, 특히 속보성 뉴스를 보면 비슷비슷한 제목의 기사가 많아 정작 필요한 기사를 찾기가 어렵다. Daum 뉴스의 개발 업무를 맡게 된 신입사원 튜브는 사용자들이 편리하게 다양한 뉴스를 찾아볼 수 있도록 문제점을 개선하는 업무를 맡게 되었다.

개발의 방향을 잡기 위해 튜브는 우선 최근 화제가 되고 있는 "카카오 신입 개발자 공채" 관련 기사를 검색해보았다.

- 카카오 첫 공채..'블라인드' 방식 채용
- 카카오, 합병 후 첫 공채.. 블라인드 전형으로 개발자 채용
- 카카오, 블라인드 전형으로 신입 개발자 공채
- 카카오 공채, 신입 개발자 코딩 능력만 본다
- 카카오, 신입 공채.. "코딩 실력만 본다"
- 카카오 "코딩 능력만으로 2018 신입 개발자 뽑는다"

기사의 제목을 기준으로 "블라인드 전형"에 주목하는 기사와 "코딩 테스트"에 주목하는 기사로 나뉘는 걸 발견했다. 튜브는 이들을 각각 묶어서 보여주면 카카오 공채 관련 기사를 찾아보는 사용자에게 유용할 듯싶었다.

유사한 기사를 묶는 기준을 정하기 위해서 논문과 자료를 조사하던 튜브는 "자카드 유사도"라는 방법을 찾아냈다.

자카드 유사도는 집합 간의 유사도를 검사하는 여러 방법 중의 하나로 알려져 있다. 두 집합 `A`, `B` 사이의 자카드 유사도 `J(A, B)`는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

예를 들어 집합 `A` = {1, 2, 3}, 집합 `B` = {2, 3, 4}라고 할 때, 교집합 `A ∩ B` = {2, 3}, 합집합 `A ∪ B` = {1, 2, 3, 4}이 되므로, 집합 `A`, `B` 사이의 자카드 유사도 `J(A, B)` = 2/4 = 0.5가 된다. 집합 A와 집합 B가 모두 공집합일 경우에는 나눗셈이 정의되지 않으니 따로 `J(A, B)` = 1로 정의한다.

자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다. 다중집합 `A`는 원소 "1"을 3개 가지고 있고, 다중집합 `B`는 원소 "1"을 5개 가지고 있다고 하자. 이 다중집합의 교집합 `A ∩ B`는 원소 "1"을 min(3, 5)인 3개, 합집합 `A ∪ B`는 원소 "1"을 max(3, 5)인 5개 가지게 된다. 다중집합 `A` = {1, 1, 2, 2, 3}, 다중집합 `B` = {1, 2, 2, 4, 5}라고 하면, 교집합 `A ∩ B` = {1, 2, 2}, 합집합 `A ∪ B` = {1, 1, 2, 2, 3, 4, 5}가 되므로, 자카드 유사도 `J(A, B)` = 3/7, 약 0.42가 된다.

이를 이용하여 문자열 사이의 유사도를 계산하는데 이용할 수 있다. 문자열 "FRANCE"와 "FRENCH"가 주어졌을 때, 이를 두 글자씩 끊어서 다중집합을 만들 수 있다. 각각 {FR, RA, AN, NC, CE}, {FR, RE, EN, NC, CH}가 되며, 교집합은 {FR, NC}, 합집합은 {FR, RA, AN, NC, CE, RE, EN, CH}가 되므로, 두 문자열 사이의 자카드 유사도 `J("FRANCE", "FRENCH")` = 2/8 = 0.25가 된다.

### **입력 형식**

- 입력으로는 `str1`과 `str2`의 두 문자열이 들어온다. 각 문자열의 길이는 2 이상, 1,000 이하이다.
- 입력으로 들어온 문자열은 두 글자씩 끊어서 다중집합의 원소로 만든다. 이때 영문자로 된 글자 쌍만 유효하고, 기타 공백이나 숫자, 특수 문자가 들어있는 경우는 그 글자 쌍을 버린다. 예를 들어 "ab+"가 입력으로 들어오면, "ab"만 다중집합의 원소로 삼고, "b+"는 버린다.
- 다중집합 원소 사이를 비교할 때, 대문자와 소문자의 차이는 무시한다. "AB"와 "Ab", "ab"는 같은 원소로 취급한다.

### **출력 형식**

입력으로 들어온 두 문자열의 자카드 유사도를 출력한다. 유사도 값은 0에서 1 사이의 실수이므로, 이를 다루기 쉽도록 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력한다.

![Untitled 1](https://user-images.githubusercontent.com/62997391/183292879-c45e083b-2bd1-4249-b562-13cd67a7e943.png)


### My Solution

```java
import java.util.ArrayList;

public class Programmers_clustering {
    public static void main(String[] args) {
        String str1 = "E=M*C^2";
        String str2 = "e=m*c^2";


//        solution(str1, str2);
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        //둘 다 소문자화
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String newStr1 = "";
        String newStr2 = "";

        // 두 글자씩 끊어서 배열 만들기
        ArrayList<String> divideStr1 = new ArrayList<>();
        ArrayList<String> divideStr2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            divideStr1.add(str1.substring(i, i + 2));
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            divideStr2.add(str2.substring(i, i + 2));
        }

        //str1, str2 둘 다 유효한 문자로 바꾸기 (특수 문자 제거)
        for (int j = divideStr1.size() - 1; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                if (divideStr1.get(j).charAt(i) - 'a' < 0 || divideStr1.get(j).charAt(i) - 'a' >= 26) {
                    divideStr1.remove(divideStr1.get(j));
                    break;
                }
            }
        }
        for (int j = divideStr2.size() - 1; j >= 0; j--) {
            for (int i = 0; i < 2; i++) {
                if (divideStr2.get(j).charAt(i) - 'a' < 0 || divideStr2.get(j).charAt(i) - 'a' >= 26) {
                    divideStr2.remove(divideStr2.get(j));
                    break;
                }
            }
        }
        // 교집합 구하기
        ArrayList<String> bothStr = new ArrayList<>();
        for (String tmp1 : divideStr1) {
            for (String tmp2 : divideStr2) {
                if (tmp1.equals(tmp2)) {
                    bothStr.add(tmp1);
                    break;
                }
            }
        }

        // 합집합 구하기
        ArrayList<String> unionStr = new ArrayList<>(divideStr1);
        for (String tmp : bothStr) {
            divideStr2.remove(tmp);
        }
        unionStr.addAll(divideStr2);

        //자카드 유사도 구하기
        double answer = 0;
        if (unionStr.size() != 0)
            answer = bothStr.size() / (unionStr.size() * 1.0);
        else
            answer = 1;

        return (int) (answer * 65536);
    }
}
```

---

### **문제 설명**

0과 1로 이루어진 어떤 문자열 x에 대한 이진 변환을 다음과 같이 정의합니다.

1. x의 모든 0을 제거합니다.
2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.

예를 들어, `x = "0111010"`이라면, x에 이진 변환을 가하면 `x = "0111010" -> "1111" -> "100"` 이 됩니다.

0과 1로 이루어진 문자열 s가 매개변수로 주어집니다. s가 "1"이 될 때까지 계속해서 s에 이진 변환을 가했을 때, 이진 변환의 횟수와 변환 과정에서 제거된 모든 0의 개수를 각각 배열에 담아 return 하도록 solution 함수를 완성해주세요.

---

### 제한사항

- s의 길이는 1 이상 150,000 이하입니다.
- s에는 '1'이 최소 하나 이상 포함되어 있습니다.


### 입출력 예 설명

입출력 예 #1

- "110010101001"이 "1"이 될 때까지 이진 변환을 가하는 과정은 다음과 같습니다.

![Untitled 3](https://user-images.githubusercontent.com/62997391/183364398-d1cbfce9-1b56-4b58-ad9a-5ca7855e0a1a.png)


• 3번의 이진 변환을 하는 동안 8개의 0을 제거했으므로, `[3,8]`을 return 해야 합니다.

### My Solution

```java
public static int[] solution(String s) {
        ArrayList<Integer> answer = new ArrayList<>();

        while (s.length() != 1) {
            // 문자열 안에 0 제거
            String tmpS = "";
            int oneCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    oneCount++;
                    tmpS += "1";
                }
            }

            // 제거된 0 개수 저장
            answer.add(s.length() - tmpS.length());

            s = Integer.toBinaryString(tmpS.length());
        }

        // ArrayList to Integer Array
        int[] realAnswer = new int[2];
        realAnswer[0] = answer.size();

        //총합 계산
        int sum = 0;
        for(int i : answer)
            sum += i;
        realAnswer[1] = sum;

        return realAnswer;
    }
```

---

n개의 음이 아닌 정수들이 있습니다. 이 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다. 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.

![Untitled 4](https://user-images.githubusercontent.com/62997391/183364425-9b07b578-7ea4-4da7-b7e4-145c3af82e1c.png)


사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return 하도록 solution 함수를 작성해주세요.

### 제한사항

- 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
- 각 숫자는 1 이상 50 이하인 자연수입니다.
- 타겟 넘버는 1 이상 1000 이하인 자연수입니다.

![Untitled 5](https://user-images.githubusercontent.com/62997391/183364457-55bbb3ff-88fc-4d5c-b709-2c6ad7e86c9d.png)

### 입출력 예 설명

**입출력 예 #1**

문제 예시와 같습니다.

**입출력 예 #2**

![Untitled 6](https://user-images.githubusercontent.com/62997391/183364475-41a91013-e47b-490f-b907-eb79bfb6f021.png)


### My Solution

```java
public static int solution(int[] numbers, int target) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);

        for(int i : numbers){
            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int j : arrayList){
                tmpList.add(j + i);
                tmpList.add(j - i);
            }
            arrayList = tmpList;
        }

        for(int i : arrayList){
            if(i == target)
                answer++;
        }
        return answer;
    }
```
