import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];

        // 예외처리
        if(N == 1){
            System.out.println(0);
            return;
        }else if(N == 2){
            System.out.println(1);
            return;
        }

        dp[2] = 1;
        dp[3] = 1;

        for(int i = 4; i <= N; i++){
            int exp1 = (i % 3 == 0 && dp[i/3] != 0) ? dp[i/3] : 1000000;
            int exp2 = (i % 2 == 0 && dp[i/2] != 0) ? dp[i/2] : 1000000;
            int exp3 = (dp[i-1] != 0) ? dp[i-1] : 1000000;
            dp[i] = Math.min(Math.min(exp1, exp2), exp3) + 1;
        }
        System.out.println(dp[N]);
    }
}

/*
1로 만들기
실버3
0.15sec

[문제]
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.
    X가 3으로 나누어 떨어지면, 3으로 나눈다.
    X가 2로 나누어 떨어지면, 2로 나눈다.
    1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

[입력]
첫째 줄에 1보다 크거나 같고, 10^6보다 작거나 같은 정수 N이 주어진다.

[출력]
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */

/*
[사고의 흐름]
0.15초면 약 1500만번 수행까지 가능함 -> N은 10^6 (1백만)까지 나올 수 있으므로 유의
그냥 무식하게 divde and conquer 느낌으로 하면 시간초과 날 거 같은데 해보기 -> N이 10인 경우 그냥 답이 틀리네

1. subprogram으로 나누기 가능
2. 각 sub가 겹침
=> DP 사용

flow
0. array 하나 만들기 (크기 n+1)
1. 4~N까지 반복문 -> i
2. 각 식에 해당하는 요소 찾고 그 요소의 값이 0이면 -1 넣고 0이 아니면 그 값 그대로 넣기
3. 3개 중 -1 제외하고 최솟값 찾은 후 +1
4. array[N] 출력
 */