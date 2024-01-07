import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String n = bf.readLine();
        int N = Integer.parseInt(n);

        int[][] map = new int[100][100];

        for(int t=0; t<N; t++){
            String[] s = bf.readLine().split(" ");
            int y = Integer.parseInt(s[0]);
            int x = Integer.parseInt(s[1]);

            for(int i=100-x; i>100-(x+10); i--){
                for(int j=y; j<10+y; j++){
                    map[i][j] = 1;
                }
            }
        }
        int count = 0;
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j] == 1) count++;
            }
        }

        System.out.println(count);
    }

}