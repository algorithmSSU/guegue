package TwoPointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11728 {
    static int n, m;
    static int[] nArray, mArray;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nArray = new int[n];
        mArray = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            nArray[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++){
            mArray[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        input();

        process();
    }

    private static void process(){
        StringBuilder sb = new StringBuilder();
        int nArrayIdx = 0;
        int mArrayIdx = 0;

        while(nArrayIdx < n && mArrayIdx < m){
            int nNum = nArray[nArrayIdx];
            int mNum = mArray[mArrayIdx];

            if(nNum <= mNum){
                sb.append(nNum).append(" ");
                nArrayIdx++;
            }else{
                sb.append(mNum).append(" ");
                mArrayIdx++;
            }
        }

        while(nArrayIdx < n){
            sb.append(nArray[nArrayIdx++]).append(" ");
        }

        while(mArrayIdx < m){
            sb.append(mArray[mArrayIdx++]).append(" ");
        }

        // print
        System.out.println(sb.toString());
    }
}
