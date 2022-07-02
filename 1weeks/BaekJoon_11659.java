import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // set N, M
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println("N, M : " + N + ", " + M);

        // set array
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        int index = 0;
        while(st.hasMoreTokens()){
            array[index++] = Integer.parseInt(st.nextToken());
            System.out.println(array[index-1]);
        }


        // set sumArray
        int[] sumArray = new int[array.length];
        sumArray[0] = array[0];
        for(int i = 1; i < array.length; i++){
            sumArray[i] = sumArray[i-1] + array[i];
        }

        //print answer
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sumInArray(sumArray, start-1, end-1);
        }

    }
    private static void sumInArray(int[] sumArray, int start, int end){
        if(start == 0){
            System.out.println(sumArray[end]);
        }else{
            System.out.println(sumArray[end] - sumArray[start-1]);
        }

    }
}

/*
N -> 개수
M -> 합을 구해야 하는 횟수
 */