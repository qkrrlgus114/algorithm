import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N, K = 0;
        N = Integer.parseInt(sa[0]);
        K = Integer.parseInt(sa[1]);

        int[][] monster = new int[N][3];
        for(int i=0; i<N; i++){
            sa = bf.readLine().split(" ");
            monster[i][0] = Integer.parseInt(sa[0]);
            monster[i][1] = Integer.parseInt(sa[1]);
            monster[i][2] = Integer.parseInt(sa[2]);
        }

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    int count = 0;
                    for(int n=0; n<N; n++){
                        if(monster[i][0] >= monster[n][0] && monster[j][1] >= monster[n][1] && monster[k][2] >= monster[n][2]){
                            count++;
                        }
                    }
                    if(count >= K){
                        answer = Math.min(answer, monster[i][0] + monster[j][1] + monster[k][2]);
                    }
                }
            }
        }
        System.out.println(answer);

    }
}

