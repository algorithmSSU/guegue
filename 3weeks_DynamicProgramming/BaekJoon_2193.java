import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        // set inputs
        int N = Integer.parseInt(br.readLine());
        long[][] array = new long[N+1][2];

        //initialize idx1
        array[1][0] = 0;
        array[1][1] = 1;

        for(int i = 2; i <= N; i++){
            array[i][0] = array[i-1][0] + array[i-1][1];
            array[i][1] = array[i-1][0];
        }

        System.out.println(array[N][0] + array[N][1]);
    }
}
//1, 10, 100, 101, 1000, 1001

/*
이친수
실버3
2 sec

[문제]
0과 1로만 이루어진 수를 이진수라 한다. 이러한 이진수 중 특별한 성질을 갖는 것들이 있는데, 이들을 이친수(pinary number)라 한다. 이친수는 다음의 성질을 만족한다.

이친수는 0으로 시작하지 않는다.
이친수에서는 1이 두 번 연속으로 나타나지 않는다. 즉, 11을 부분 문자열로 갖지 않는다.
예를 들면 1, 10, 100, 101, 1000, 1001 등이 이친수가 된다. 하지만 0010101이나 101101은 각각 1, 2번 규칙에 위배되므로 이친수가 아니다.

N(1 ≤ N ≤ 90)이 주어졌을 때, N자리 이친수의 개수를 구하는 프로그램을 작성하시오.

[입력]
첫째 줄에 N이 주어진다.

[출력]
첫째 줄에 N자리 이친수의 개수를 출력한다.
 */

/*
[사고의 흐름]
------------------------------------------------------------------------------------------
N이 90까지니까 String으로 다뤄야 할 듯?
subProblem으로 다뤄질 수 있고 중복되니까 DP 가능 -> Bottom-up 방식으로 조지면 될 거 같음
시작을 1로 해야하니깐 인덱스 1번엔 1만 넣고 시작! -> 조건 1번 생각 안해도 됨
조건 2번 만족해야하므로 마지막이 0이냐 1이냐로 분기 나눠서 처리해주기 -> 0이면 0, 1 추가해주고 1이면 0 추가 해주기ㅋ
이후 N자리수에 해당하는 인덱스의 ArrayList.size() 출력
=> 메모리 초과 뜸
------------------------------------------------------------------------------------------
메모리 초과 뜨니까 끝자리만 저장하고 N자리 이친수 개수 저장하는 int[] 따로 만들어주기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // set inputs
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] numLists = new ArrayList[N+1];
        for(int i = 1 ; i < numLists.length; i++){
            numLists[i] = new ArrayList<>();
        }

        //initialize idx1
        numLists[1].add(1);

        for(int i = 2; i <= N; i++){
            for (int tmpNum : numLists[i-1]){
                if(tmpNum == 0){
                    numLists[i].add(0);
                    numLists[i].add(1);
                }else if(tmpNum == 1){
                    numLists[i].add(0);
                }
            }
        }
        for(int i = 0 ; i <= N; i++){
            System.out.println(numLists[i]);
        }

        System.out.println(numLists[N].size());
    }

=> 메모리 초과 ㅋㅋ.. primitive type으로 해결해보자
------------------------------------------------------------------------------------------
완전 다른 풀이긴 해
0 -> 2개 추가
1 -> 1개 추가
0의 개수와 1의 개수만으로 파악해보기
public class BaekJoon_2193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();

        // set inputs
        int N = Integer.parseInt(br.readLine());

        //initialize idx1
        map.put(0, 0);
        map.put(1, 1);

        //calculate by Map
        for(int i = 2; i <= N; i++){
            //save present value
            int now0Count = map.get(0); // 0
            int now1Count = map.get(1); // 1

            map.put(0, now0Count + now1Count);
            map.put(1, now0Count);
        }
        System.out.println(map.get(0) + map.get(1));
    }
}
아니 이거 왜 틀린 지 설명해줄 사람 아아아앆!!!

 */