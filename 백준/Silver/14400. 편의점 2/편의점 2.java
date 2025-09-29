import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] sortedX;
    static int[] sortedY;
    static int[] originX;
    static int[] originY;
    static long answer = 0;

    public static void main(String[] args) throws IOException {
        /*
        * 이전에 안테나 문제가 1차원의 중앙값을 구하는 문제였다면
        * 이번 편의점 문제는 2차원의 중앙값을 구하는 문제.
        *
        * X, Y축에 대해서 정렬 이후 중간값을 찾으면 그 중간 값이 최적의 좌표가 된다.
        * (왜? 중간값이라는 말은 애초에 여러 집 들 중에서 가장 좌우 편차가 적은 집이 된다.)
        * */

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        sortedY = new int[N];
        sortedX = new int[N];
        originY = new int[N];
        originX = new int[N];

        for(int i=0; i<N; i++){
            String[] sa = bf.readLine().split(" ");
            originX[i] = Integer.parseInt(sa[0]);
            originY[i] = Integer.parseInt(sa[1]);
            sortedX[i] = Integer.parseInt(sa[0]);
            sortedY[i] = Integer.parseInt(sa[1]);
        }

        Arrays.sort(sortedY);
        Arrays.sort(sortedX);

        int centerY = 0;
        int centerX = 0;

        // y축 기준 중앙값 계산
        if(N % 2 == 0){
            centerY = sortedY[(N/2) - 1];
        }else{
            centerY = sortedY[N/2];
        }
        // x축 기준 중앙값 계산
        if(N % 2 == 0){
            centerX = sortedX[(N/2) - 1];
        }else{
            centerX = sortedX[N/2];
        }

        for(int i=0; i<N; i++){
            circulator(originY[i], originX[i], centerY, centerX);
        }

        System.out.println(answer);
    }

    // 위치 계산
    public static void circulator(int y, int x, int centerY, int centerX){
        answer += Math.abs(y - centerY) + Math.abs(x - centerX);
    }
}
