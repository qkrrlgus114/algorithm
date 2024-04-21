import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 남규사탕 > 영훈사탕 + 2
    // 사탕 0개 안됨
    // 택희 홀수 안됨
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        for(int i=0; i<=N; i++){
            for(int j=0; j<=N; j++){
                for(int k=0; k<=N; k++){
                    if(i + j + k == N){
                        // 아무도 0개는 없어야한다.
                        if(i == 0 || j == 0 || k == 0) continue;
                        // 택히는 홀수면 안 된다
                        if(k % 2 != 0) continue;
                        // 남규는 영훈이보다 2개 이상 많아야한다.
                        if(i - j - 2 < 0) continue;
                        answer++;
                    }else continue;
                }
            }
        }

        System.out.println(answer);

    }
}