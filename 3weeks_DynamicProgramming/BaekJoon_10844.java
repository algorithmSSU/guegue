import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력값 세팅
        int n = Integer.parseInt(br.readLine());
        long[][] dy = new long[n + 1][10];    //끝자리 해당하는 수의 계단 수 저장

        // 초기값 세팅
        for (int i = 1; i < 10; i++) {
            dy[1][i] = 1;
        }

        // 점화식 계산
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    dy[i][j] = dy[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    dy[i][j] = dy[i - 1][8] % 1000000000;
                } else {
                    dy[i][j] = (dy[i - 1][j - 1] + dy[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long sum = 0;
        for (int j = 0; j <= 9; j++) {
            sum += (dy[n][j]);
        }
        System.out.println(sum % 1000000000);
    }
}


/*
쉬운 계단 수
실버1
1 sec

[문제]
45656이란 수를 보자.
이 수는 인접한 모든 자리의 차이가 1이다. 이런 수를 계단 수라고 한다.
N이 주어질 때, 길이가 N인 계단 수가 총 몇 개 있는지 구해보자. 0으로 시작하는 수는 계단수가 아니다.

[입력]
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 100보다 작거나 같은 자연수이다.

[출력]
첫째 줄에 정답을 1,000,000,000으로 나눈 나머지를 출력한다.
 */

/*
[사고의 흐름]
1. 가짜문제 정의하기 -> dy[i] : 길이가 i인 계단 수 개수 (가짜문제 == 진짜문제)
2. 1활용해서 진짜문제 정의 가능
3. 초기값 -> 입력에 주어짐
4. 점화식
-> 끝자리 수에 집중
-> 끝에가 0이면 1만 붙이기 가능 1
-> 끝에가 9이면 8만 붙이기 가능 1
-> 나머지는 끝에 자리수 +-1 가능 (2개)

[반성]
아니.. 매번 값 저장하고 출력할 때 모두 %100000000해줘야함..
 */