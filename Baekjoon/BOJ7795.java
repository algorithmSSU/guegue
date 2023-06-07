import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aNum = Integer.parseInt(st.nextToken());
            int bNum = Integer.parseInt(st.nextToken());

            int a[] = new int[aNum];
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < a.length; j++){
                a[j] = Integer.parseInt(st.nextToken());
            }

            int b[] = new int[bNum];
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < b.length; j++){
                b[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(process(a, b));
        }
    }

    private static int process(int[] a, int[] b){
        Arrays.sort(b);

        int answerCount = 0;
        for(int tmpNum : a){
            int left = 0; int right = b.length - 1;
            int count = 0;
            while(left <= right){
                int mid = (left + right) / 2;
                int midValue = b[mid];

                if(tmpNum > midValue){
                    count = mid + 1;
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            answerCount += (count);
        }


        return answerCount;
    }
}