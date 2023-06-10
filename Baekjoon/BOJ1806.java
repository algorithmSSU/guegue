import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    private static int n, s;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // process
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        for(int left = 1; left <= n; left++){
            sum -= array[left - 1];

            while(right < n && sum < s){
                right++;
                sum += array[right];
            }

            if(sum >= s){
                minLength = Math.min(minLength, (right - left) + 1);
            }
        }

        System.out.println((minLength != Integer.MAX_VALUE) ? minLength : 0);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, s
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }
}




/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1806 {
    private static int n, s;
    private static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        // process
        int left = 0;
        int right = 0;
        int sum = array[0];
        int minLength = Integer.MAX_VALUE;
        while (left < array.length && right < array.length) {
            if(sum >= s){
                minLength = Math.min(minLength, (right - left) + 1);
                sum -= array[left];
                left++;
            }else{
                right++;
                if(right < array.length)
                    sum += array[right];
            }
        }
        System.out.println((minLength != Integer.MAX_VALUE) ? minLength : 0);

    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n, s
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        // set array
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }
}

 */