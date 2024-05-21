import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    static int[][] paint;
    static int[] target = new int[3];
    static int answer = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        N = Integer.parseInt(s);

        // 주어지는 물감들
        paint = new int[N][3];
        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            paint[i][0] = Integer.parseInt(sa[0]);
            paint[i][1] = Integer.parseInt(sa[1]);
            paint[i][2] = Integer.parseInt(sa[2]);
        }

        // 만들고자 하는 곰두리색
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<3; i++){
            target[i] = Integer.parseInt(sa[i]);
        }

        dfs(0, 0, 0, 0,0);

        System.out.println(answer);

    }

    private static void dfs(int depth, int R, int G, int B, int count){
        // 종료 조건
        if(count >= 2){
            int avgR = R / count;
            int avgG = G / count;
            int avgB = B / count;

            int diff = Math.abs(target[0] - avgR) + Math.abs(target[1] - avgG) + Math.abs(target[2] - avgB);
            answer = Math.min(diff, answer);

            if(count >= 7) return;
        }

        // 재귀 조건
        for(int i=depth; i<N; i++){
            int pR = paint[i][0];
            int pG = paint[i][1];
            int pB = paint[i][2];

            dfs(i + 1, R + pR, G + pG, B + pB, count + 1);
        }
    }
}

