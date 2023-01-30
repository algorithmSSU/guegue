import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.StringTokenizer;

public class BOJ15991 {
    static int t;
    static long[] array;
    static List<Integer> list;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        array = new long[100001];
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        setArray();

        // print answer
        for (int i : list)
            System.out.println(array[i] % 1000000009);
    }

    private static void setArray() {
        // set init
        array[1] = 1;
        array[2] = 2;
        array[3] = 2;
        array[4] = 3;
        array[5] = 3;
        array[6] = 6;

        // set others
        for (int i = 7; i <= 100000; i++){
            array[i] = (array[i-2] + array[i-4] + array[i-6]) % 1000000009;
        }
    }
}
