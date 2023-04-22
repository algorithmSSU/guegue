import java.io.*;

public class BOJ1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder numStr = new StringBuilder(br.readLine());
        for (int i = 0; i < numStr.length() - 1; i++) {
            int thisNum = numStr.charAt(i) - '0';
            int maxValue = Integer.MIN_VALUE;
            int minIdx = -1;
            for (int j = i + 1; j < numStr.length(); j++) {
                int targetNum = numStr.charAt(j) - '0';
                if (maxValue < targetNum) {
                    maxValue = targetNum;
                    minIdx = j;
                }
            }

            if (thisNum < maxValue) {
                numStr.setCharAt(i, numStr.charAt(minIdx));
                numStr.setCharAt(minIdx, (char) (thisNum + '0'));
            }
        }

        System.out.println(numStr);
    }
}
