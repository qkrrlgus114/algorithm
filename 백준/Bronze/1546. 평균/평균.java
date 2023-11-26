import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        float sum = 0;

        int N = Integer.parseInt(bf.readLine());

        int[] score = new int[N];

        String[] s = bf.readLine().split(" ");

        for (int i=0; i<N; i++){
            score[i] = Integer.parseInt(s[i]);
            if (score[i] > max){
                max = score[i];
            }
        }

        for(int i=0; i<N; i++){
            sum +=((float) score[i] / max * 100);
        }

        System.out.println(sum / N);


    }
}
