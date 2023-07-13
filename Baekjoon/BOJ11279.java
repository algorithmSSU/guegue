import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        // process
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < size; i++){
            int thisNum = Integer.parseInt(br.readLine());

            if(thisNum == 0){
                System.out.println((!queue.isEmpty()) ? queue.poll() : 0);
            }else{
                queue.add(thisNum);
            }
        }
    }
}
