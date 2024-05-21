import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    private final static int SIZE = 1000001;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] player = new int[N];
        boolean[] card = new boolean[SIZE];
        int[] score = new int[SIZE];

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            player[i] = Integer.parseInt(sa[i]);
            card[player[i]] = true;
        }

        // 하나씩 비교 시작
        for(int i : player){
            // 배수만 보면 된다.
            for(int j=i*2; j<SIZE; j+=i){
                if(card[j]){
                    ++score[i];
                    --score[j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : player){
            sb.append(score[i]).append(" ");
        }

        System.out.println(sb);

    }
}

