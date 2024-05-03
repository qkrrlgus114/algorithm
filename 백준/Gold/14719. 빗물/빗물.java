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
        int[] ground = new int[W];

        int start = 0;
        int end = W - 1;
        int maxHStart = 0;
        int maxHEnd = 0;
        int maxH = 0;

        sa = bf.readLine().split(" ");
        for(int i=0; i<sa.length; i++){
            int num = Integer.parseInt(sa[i]);
            ground[i] = num;

            if(num > maxH){
                maxHStart = i;
                maxHEnd = i;
                maxH = num;
            }else if(num == maxH){
                maxHEnd = i;
            }
        }

        int answer = 0;

        // 처음 ~ 처음 맥스값
        int nowH = 0;
        for(int i=start; i<=maxHStart; i++){
            if(ground[i] <= nowH){
                answer += nowH - ground[i];
            }else{
                nowH = ground[i];
            }
        }

        // 마지막 ~ 마지막 맥스값
        nowH = 0;
        for(int i=end; i>=maxHEnd; i--){
            if(ground[i] <= nowH){
                answer += nowH - ground[i];
            }else{
                nowH = ground[i];
            }
        }
        
        // 처음 맥스값 ~ 마지막 맥스값
        nowH = 0;
        for(int i=maxHStart; i<=maxHEnd; i++){
            if(ground[i] <= nowH){
                answer += nowH - ground[i];
            }else{
                nowH = ground[i];
            }
        }

        

        System.out.println(answer);

    }

}

