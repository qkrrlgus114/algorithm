import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int H = Integer.parseInt(sa[1]);

        int[] down = new int[H+1];
        int[] up = new int[H+1];

        for(int i=0; i<N/2; i++){
            down[Integer.parseInt(bf.readLine())]++;
            up[Integer.parseInt(bf.readLine())]++;
        }

        for(int i=H; i>0; i--){
            down[i-1] += down[i];
            up[i-1] += up[i];
        }

        // 구간의 개수
        int count = 0;
        // 최솟값
        int min = Integer.MAX_VALUE;

        for(int i=1; i<=H; i++){
            int value = down[i] + up[H-i+1];
            if(value < min){
                min = value;
                count = 1;
            }else if(value == min) count++;
        }

        System.out.println(min + " " + count);

    }

}

