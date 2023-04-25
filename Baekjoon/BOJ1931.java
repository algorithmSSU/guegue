import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1931 {
    static class MeetingInfo implements Comparable<MeetingInfo> {
        int startTime;
        int endTime;

        MeetingInfo(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return "MeetingInfo{" +
                    "startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }

        @Override
        public int compareTo(MeetingInfo o) {
            if(this.endTime == o.endTime)
                return this.startTime - o.startTime;
            return this.endTime - o.endTime;
        }
    }


    private static List<MeetingInfo> meetingList;
    private static int maxCount;

    public static void main(String[] args) throws IOException {
        init();

        setMaxCount();
        System.out.println(maxCount);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        meetingList = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetingList.add(new MeetingInfo(startTime, endTime));
        }

        maxCount = 0;
    }

    private static void setMaxCount(){
        // sort
        Collections.sort(meetingList);

        int lastTime = 0;
        for(MeetingInfo meetingInfo : meetingList){
            if(meetingInfo.startTime >= lastTime){
                maxCount++;
                lastTime = meetingInfo.endTime;
            }
        }
    }
}
