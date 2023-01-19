package Search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
    static int n, m;
    static int array[];

    private static void input() throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        int left = 0;
        int right = 1000000000;
        int maxHeight = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(isAvailable(mid)){
                maxHeight = mid;
                left = mid + 1;
            }else{

                right = mid -1;
            }
        }

        System.out.println(maxHeight);
    }

    private static boolean isAvailable(int height){
        long sum = 0;
        for(int i = 0 ; i < n; i++){
            if(array[i] > height){
                sum += (array[i] - height);
            }
        }

        return sum >= m;
    }


}
























/*
static int n, m;
    static int array[];

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process() {
        int left = 0;
        int right = 1000000000;
        int answerHeight = -1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (!isAvailable(mid)) {
                right = mid - 1;
            }else{
                answerHeight = mid;
                left = mid + 1;
            }
        }

        System.out.println(answerHeight);
    }

    private static boolean isAvailable(int h) {
        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (array[i] > h)
                sum += (array[i] - h);
        }

        return sum >= m;
    }
 */