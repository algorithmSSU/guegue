import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BaekJoon_2193_why {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Long> map = new HashMap<>();

        // set inputs
        int N = Integer.parseInt(br.readLine());

        //initialize idx1
        map.put(0, Integer.toUnsignedLong(0));
        map.put(1, Integer.toUnsignedLong(1));

        //calculate by Map
        for (int i = 2; i <= N; i++) {
            //save present value
            long last0Count = map.get(0); // 0
            long last1Count = map.get(1); // 1

            map.put(0, last0Count + last1Count);
            map.put(1, last0Count);
        }
        System.out.println(map.get(0) + map.get(1));
    }
}
