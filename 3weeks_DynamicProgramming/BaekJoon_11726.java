import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_11726 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // input 세팅
        int n = Integer.parseInt(br.readLine());
        int[] dy = new int[n+1];

        if(n == 1){
            System.out.println(1);
            return;
        }

        // 초기값 설정
        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i <= n; i++){
            dy[i] = (dy[i-1] + dy[i-2]) % 10007;
        }

        System.out.println(dy[n]);
    }
}



/*
1. 인덱스에 해당 하는 수 크기의 직사각형을 타일로 채우는 방법의 수 저장 (가짜문제 == 진짜문제)
2. 진짜문제 해결 가능
3. 초기값 설정
4. 점화식 구할 때 마지막 부분에 신경써서 보기!
-> 뒤가 1*2일때랑 2*1일때랑 구분해보기

 */
