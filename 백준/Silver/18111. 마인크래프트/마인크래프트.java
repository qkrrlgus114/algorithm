import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

    static int N, M, B;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        N = Integer.parseInt(sa[0]);
        M = Integer.parseInt(sa[1]);
        B = Integer.parseInt(sa[2]);
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int answerTime = Integer.MAX_VALUE;
        int answerBlock = Integer.MIN_VALUE;

        arr = new int[N][M];
        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(sa[j]);
                maxValue = Math.max(maxValue, arr[i][j]);
                minValue = Math.min(minValue, arr[i][j]);
            }
        }

        for(int i=minValue; i<=maxValue; i++){
            int count = 0;
            int block = B;
            for(int j=0; j<N; j++){
                for(int k=0; k<M; k++){
                    if(arr[j][k] < i){
                        block -= i - arr[j][k];
                        count += i - arr[j][k];
                    }else if(arr[j][k] > i){
                        block += arr[j][k] - i;
                        count += 2 * (arr[j][k] - i);
                    }
                }
            }
            if(block < 0) continue;
            if(answerTime >= count){
                answerTime = count;
                if(answerBlock < i) answerBlock = i;
            }
        }

        System.out.println(answerTime + " " + answerBlock);
    }
}