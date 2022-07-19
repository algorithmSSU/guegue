import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        // input setting
        int N = Integer.parseInt(br.readLine());
        int[][] meetingTime = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetingTime[i][0] = Integer.parseInt(st.nextToken());
            meetingTime[i][1] = Integer.parseInt(st.nextToken());
        }

        // sort by endTime
        Arrays.sort(meetingTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        // count++ excepting for duplicated meeting time
        int count = 0;
        int lastEndTime = -1;
        for(int i = 0 ; i < N; i++){
            int startTime = meetingTime[i][0];
            int endTime = meetingTime[i][1];

            if(startTime >= lastEndTime){
                count++;
                lastEndTime = endTime;
            }
        }

        System.out.println(count);
    }
}

