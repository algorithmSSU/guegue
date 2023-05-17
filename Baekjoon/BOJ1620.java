import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1620 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n, m;
    private static Map<String, Integer> stringToIntegerMap;
    private static Map<Integer, String> integerToStringMap;

    public static void main(String[] args) throws IOException {
        init();

        // process
        for (int i = 0; i < m; i++) {
            String thisStr = br.readLine();
            if (isInteger(thisStr)) {
                System.out.println(integerToStringMap.get(Integer.parseInt(thisStr)));
            } else {
                System.out.println(stringToIntegerMap.get(thisStr));
            }
        }
    }

    private static boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    private static void init() throws IOException {
        StringTokenizer st;

        // set n, m
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // set map
        stringToIntegerMap = new HashMap<>();
        integerToStringMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String poketmon = br.readLine();
            stringToIntegerMap.put(poketmon, i);
            integerToStringMap.put(i, poketmon);
        }
    }

}
