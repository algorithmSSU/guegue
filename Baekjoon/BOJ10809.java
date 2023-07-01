import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10809 {
    private static String str;

    public static void main(String[] args) throws IOException {
        init();

        // process
        int[] array = new int[26];
        for(int i = 0 ; i < array.length; i++){
            array[i] = str.indexOf((char)(i + 'a'));
        }

        // print answer
        for(int i = 0 ; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }

}
