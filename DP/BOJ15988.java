import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ15988 {
    static int testCase;
    static long[] answer;
    static List<Integer> list;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for(int i = 0 ; i < testCase; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        answer = new long[1000001];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        setAnswer();

        for(int i : list)
            System.out.println(answer[i] % 1000000009);
    }

    private static void setAnswer(){
        // set init
        answer[1] = 1;
        answer[2] = 2;
        answer[3] = 4;

        // set others
        for(int i = 4; i <= 1000000; i++){
            answer[i] = (answer[i-1] % 1000000009) + (answer[i-2] % 1000000009) + (answer[i-3] % 1000000009);
        }
    }
}
