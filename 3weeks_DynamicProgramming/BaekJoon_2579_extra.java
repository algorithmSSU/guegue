import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BaekJoon_2579_extra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // input 값 세팅
        int[] array = new int[n + 1];
        int[][] dy = new int[n + 1][2]; //[i][0]은 i-1번째에서, [i][1]은 i-2번째에서 넘어왔다고 두었음
        for (int i = 1; i < array.length; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(array[1]);
            return;
        }
        // 초기값 세팅
        dy[1][0] = array[1];
        dy[2][0] = array[1] + array[2];
        dy[2][1] = array[2];

        for (int i = 3; i <= n; i++) {
            dy[i][0] = dy[i-1][1] + array[i];
            dy[i][1] = Math.max(dy[i-2][0], dy[i-2][1]) + array[i];
        }

        System.out.println(Math.max(dy[n][0], dy[n][1]));
    }
}

/*
https://www.acmicpc.net/problem/2579
 */


/*
1. 가짜문제 설정 -> 진짜문제랑 같게 하되, 조건2 검사를 위해 몇 번째 칸에서 왔는 지 기록하기 위하여 2차원 배열로 설정
2. 검증 -> 쌉가능
3. 초기값 ㅇㅋ
4. 점화식
5. 값 계산

[사고의 흐름]
처음엔 가짜문제 == 진짜문제로 두고 dy[i]를 i번째 계단에 오르는 동안의 최대값으로 두고 배열을 만드려 했다.
점화식이야 세우기 쉬웠지만 연속된 3개를 못밟는다는 조건 2번을 만족시키기 위해 boolean flag를 두어 if문으로 분기를 나누는 작업을 하려 했다.
그러나 바로 직전칸을 검사할 게 아니라 전전 것까지 계산해야돼서 단순 조건문 쓰기는 빡세다는 결론!
따라서 최대값을 배열에 기록하는 동시에 전 거에서 넘어왔는지, 전전 거에서 넘어왔는 지 기록해주기 위하여 2차원배열로 설정하였음.
계단의 개수 300개, 점수는 10,000이하이므로 int형으로 기록하기에 충분함.
점화식 고려해서 바로 풀어줌.

 */

