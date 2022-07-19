import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String tmp = br.readLine();

        for(int i = 0; i < N; i++){
            answer += (tmp.charAt(i) - '0');
        }
        System.out.println(answer);
    }
}
