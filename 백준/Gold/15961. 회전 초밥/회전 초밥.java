import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] sa = bf.readLine().split(" ");

        int N = Integer.parseInt(sa[0]);
        int d = Integer.parseInt(sa[1]);
        int k = Integer.parseInt(sa[2]);
        int c = Integer.parseInt(sa[3]);

        int[] chobab = new int[N];
        int[] count = new int[d+1];
        int answer = 0;

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            chobab[i] = Integer.parseInt(s);
        }

        for(int i=0; i<k; i++){
            count[chobab[i]]++;
            if(count[chobab[i]] == 1) answer++;
        }

        int finalAnswer = answer;

        int l = 0;
        int r = k-1;

        for(int i=0; i<N-1; i++){
            // 최대 가짓수 갱신
            if(count[c] == 0){
                finalAnswer = Math.max(finalAnswer, answer + 1);
            }else{
                finalAnswer = Math.max(finalAnswer, answer);
            }

            r++;
            if(r == N){
                r = 0;
            }
            count[chobab[r]]++;
            if(count[chobab[r]] == 1) answer++;
            l++;
            count[chobab[l-1]]--;
            if(count[chobab[l-1]] == 0) answer--;

        }

        // 최대 가짓수 갱신
        if(count[c] == 0){
            finalAnswer = Math.max(finalAnswer, answer + 1);
        }else{
            finalAnswer = Math.max(finalAnswer, answer);
        }
        System.out.println(finalAnswer);

    }
}

