import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ1149 {
    static int n;
    static int[][] array, dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set n;
        n = Integer.parseInt(br.readLine());

        // set array
        array = new int[n + 1][3];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
            array[i][2] = Integer.parseInt(st.nextToken());
        }

        // init dp
        dp = new int[n + 1][3];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        // set dp[1]
        dp[1][0] = array[1][0];
        dp[1][1] = array[1][1];
        dp[1][2] = array[1][2];

        // set others
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + array[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + array[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + array[i][2];
        }

        // print answer
        System.out.println(Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]));
    }
}


/*
출력해야 하는 답 : n번째 집까지 페인트칠 했을 때의 최소 비용

<사고의 흐름>
처음에는 다음과 같이 접근했다.
1. int[][] dp 생성
2. dp[i][0]에 i번째까지 칠한 페인트의 최소 비용 저장, dp[i][1] i번째에 선택한 페인트 색깔
3. i-1번째에 선택하지 않은 페인트 색을 선택해서 최소 비용을 찾아나감
잘못된 접근이었음. 이전의 집에서 선택한 페인트 색만 피해서 최소를 구하면 결과적으로 최소값이 아닐 수 있음. (예제 입력5에서 잘못된 결과 출력)
잘못된 접근을 한 이유는 dp 배열에 칠한 페인트 색깔까지 저장함으로써 예외의 경우가 생겨 문제가 되려 복잡해짐.
따라서, 색깔별로 각각 최소가 되는 경우를 계산해서 n번째에 3가지의 색 중 최소값이 저장된 값 출력
=> 접근한 방법에서 처리해주어야 할 예외 사항이 많이 생기면 다른 시각으로 접근하기
=> 접근 방법을 뒤집음으로써, i번째에서 i-1, i-2번째를 보는 게 아니라 i번째에서 현재 색상과 i-1번째의 다른 색상 2개 만을 고려해주기
 */