import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        int[][] arr = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            sa = bf.readLine().split(" ");
            for(int j=1; j<=M; j++){
                arr[i][j] = Integer.parseInt(sa[j-1]);
            }
        }

        // 누적합 계산
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                arr[i][j] += arr[i-1][j] + arr[i][j-1] - arr[i-1][j-1];
            }
        }

        int answer = Integer.MIN_VALUE;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                for(int k=i; k<=N; k++){
                    for(int l=j; l<=M; l++){
                        int value = arr[k][l] - arr[i-1][l] - arr[k][j-1] + arr[i-1][j-1];
                        answer = Math.max(value, answer);
                    }
                }
            }
        }

        System.out.println(answer);

    }
}

