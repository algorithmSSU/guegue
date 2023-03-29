import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ21918 {
    private static int n, m;
    private static int[] lights;
    private static int[][] instructions;

    public static void main(String[] args) throws IOException {
        init();

        processInstructions();

        printLights();
    }

    private static void printLights() {
        for (int i = 1; i < lights.length; i++) {
            System.out.print(lights[i] + " ");
        }
    }

    private static void processInstructions() {
        for(int i = 0; i < m; i++){
            doInstruct(instructions[i]);
        }
    }

    private static void doInstruct(int[] instruction){
        int instructionIdx = instruction[0];

        switch (instructionIdx){
            case 1:
                firstInstruction(instruction[1], instruction[2]);
                break;
            case 2:
                secondInstruction(instruction[1], instruction[2]);
                break;
            case 3:
                thirdInstruction(instruction[1], instruction[2]);
                break;
            case 4:
                fourInstruction(instruction[1], instruction[2]);
                break;
            default:
                System.out.println("error");
        }
    }

    private static void firstInstruction(int i, int x){
        lights[i] = x;
    }

    private static void secondInstruction(int l, int r){
        for(int i = l; i <= r; i++){
            lights[i] = (lights[i] == 1) ? 0 : 1;
        }
    }

    private static void thirdInstruction(int l, int r){
        for(int i = l; i <= r; i++){
            lights[i] = 0;
        }
    }

    private static void fourInstruction(int l, int r){
        for(int i = l; i <= r; i++){
            lights[i] = 1;
        }
    }
    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lights = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            lights[i] = Integer.parseInt(st.nextToken());
        }

        instructions = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                instructions[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
