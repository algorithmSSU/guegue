import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ1003 {
    static int n;
    static List<Integer> list;
    static int[][] fibonacci;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        // set list
        list = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        fibonacci = new int[41][2];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        setFibonacci();

        // print answer
        StringBuilder sb = new StringBuilder();
        for(int i : list)
            sb.append(fibonacci[i][0]).append(" ").append(fibonacci[i][1]).append("\n");
        System.out.println(sb.toString());
    }

    private static void setFibonacci(){
        // set init
        fibonacci[0][0] = 1;
        fibonacci[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            // set 0 count
            fibonacci[i][0] += fibonacci[i-1][0];
            fibonacci[i][0] += fibonacci[i-2][0];

            // set 1 count
            fibonacci[i][1] += fibonacci[i-1][1];
            fibonacci[i][1] += fibonacci[i-2][1];
        }
    }
}
