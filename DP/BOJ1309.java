import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class BOJ1309 {
    static int n;
    static int[][] dp;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        dp = new int[n + 1][3];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setDp();

        // print answer
        int sum = 0;
        for (int i : dp[n])
            sum += (i % 9901);
        System.out.println(sum % 9901);
    }

    private static void setDp() {
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % 9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1]) % 9901;
        }
    }
}


/*
문제 요약 : 2 * N 크기 형태의 우리가 주어졌을 때 인접한 가로세로에 붙지 않도록 사자를 배치하는 경우의 수 출력

<사고의 흐름>
모르겠어서 아이디어 구글링해서 검색해봤음..ㅠ 하 분하다

1. 첫 번째 접근 방법은 dp[i][0], dp[i][1]에 사자를 배치할 수 있는 경우의 수 저장하는 방법 생각해봄.
이 접근 방법이 비슷했음에도 적용하지 못한건 사자를 배치하지 않는 경우는 그냥 추후에 answer + 1해서 출력해주려고 했음..
그래서 시뮬레이션 돌려보니 예제에 나오는 결과값을 출력할 수가 없어서 아 접근 방법이 잘못됐구나 다른 방식으로 해야겠구나 느꼈음

2. 두 번째 접근 방법은 2 * N 크기 우리에 사자 i 마리를 배치하는 경우의 수
dp[1], dp[2], dp[3] 손으로 계산해보다가 너무 경우의 수가 커져서 포기함.
생각해보니 경우의 수가 손으로 계산하지 못하도록 커질 때까지 규칙을 발견하지 못하면 문제를 좀 더 작게 쪼개려는 시도를 해야할 거 같음

결론적으로 정답을 구하기 위한 접근 방법은, 첫번째 방법에 더하여 사자를 고르지 않는 경우의 수 체크해주기 위해 열을 하나 추가해주면 됨
그럼 i를 증가시키면서 모든 경우의 수를 구할 수 있음.. 이걸 왜 생각 못했을까
조금 다르게 표현하면 사자의 수가 픽스된 게 아니기 때문에 아예 사자를 배치하지 않는 경우의 수까지 고려해주기 위해서 열을 하나 추가해서 저장해주면 됨.
아무 데도 사자 안넣어도 되니까 결과값에 -1 해줄 필요도 없고! 좀 더 유연하게 유연하게 유연하게 생각하기.
 */