import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_9095_extra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] dy;
        int[] targetNum = new int[testCase];

        // targetNum Array 에 구해야 할 n들 저장
        for (int i = 0; i < testCase; i++) {
            targetNum[i] = Integer.parseInt(br.readLine());
        }

        // targetNum Array 에서 구해야 할 최대값 찾기
        int max = -1;
        for (int i = 0; i < targetNum.length; i++) {
            if (targetNum[i] > max)
                max = targetNum[i];
        }

        //인덱스 에러 처리
        if (max < 3)
            max = 3;

        // 위에서 구한 최대값에 해당하는 dy 배열 생성
        dy = new int[max+1];

        // 초기값 세팅
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        // 점화식 적용
        for(int i = 4 ; i < dy.length; i++){
            dy[i] = dy[i-3] + dy[i-2] + dy[i-1];
        }

        // 출력
        for(int i = 0 ; i < targetNum.length; i++){
            System.out.println(dy[targetNum[i]]);
        }
    }
}

/*
https://www.acmicpc.net/problem/9095
 */


/*
<문제를 보자마자 DP다 할 수 없음 -> 처음엔 그리디 방식으로 생각하고 시간복잡도와 조건들 고려해서 DP로 풀 것인 지 판단>

1. 가짜 문제 정의하기
2. 가짜 문제로 진짜 문제를 해결할 수 있는 지 검증하기
3. 초기값 설정하기
4. 점화식 구해내기
5. 해결하기
 */