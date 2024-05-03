import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int H = Integer.parseInt(sa[0]);
        int W = Integer.parseInt(sa[1]);
        int[][] ground = new int[H][W];

        sa = bf.readLine().split(" ");
        for(int i=0; i<W; i++){
            int num = Integer.parseInt(sa[i]);
            for(int j=H-1; j>H-1-num; j--){
                ground[j][i] = 1;
            }
        }

        int answer = 0;

        for(int i=0; i<H; i++){
            int count = 0;
            boolean check = false;
            for(int j=0; j<W; j++){
                if(ground[i][j] == 1){
                    if(!check) check = true;
                    else {
                        answer += count;
                        count = 0;
                    }
                }else{
                    if(check) count++;
                }
            }
        }

        System.out.println(answer);

    }

}

