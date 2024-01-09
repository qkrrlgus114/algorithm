import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int min = Integer.MAX_VALUE;
    static int N;
    static int M;
    static char[][] map;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");

        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] temp = bf.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp[j];
            }
        }

        for(int i=0; i<N-7; i++){
            for(int j=0; j<M-7; j++){
                check(i, j);
            }
        }


        System.out.println(min);
    }

    public static void check(int di, int dj){
        int Wcount = 0;
        int Bcount = 0;
        for(int i=di; i<di+8; i++){
            char temp = ' ';
            if(i % 2 == 0) temp = 'W';
            else temp = 'B';

            for(int j=dj; j<dj+8; j++){
                if(map[i][j] != temp) Wcount++;
                if(temp == 'W') temp = 'B';
                else temp = 'W';
            }
        }

        for(int i=di; i<di+8; i++){
            char temp = ' ';
            if(i % 2 == 0) temp = 'B';
            else temp = 'W';

            for(int j=dj; j<dj+8; j++){
                if(map[i][j] != temp) Bcount++;
                if(temp == 'W') temp = 'B';
                else temp = 'W';
            }
        }
        int tempMin = Math.min(Bcount, Wcount);
        if(min > tempMin) min = tempMin;
    }
}