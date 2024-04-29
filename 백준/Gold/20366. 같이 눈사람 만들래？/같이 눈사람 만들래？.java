import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        int N = Integer.parseInt(s);

        int[] snow = new int[N];
        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<N; i++){
            snow[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(snow);

        int answer = Integer.MAX_VALUE;

        // 2개는 미리 선택함
        for(int i=0; i<N-1; i++){
            for(int j=i+1; j<N; j++){
                int snowmanOne = snow[i] + snow[j];

                int l = 0;
                int r = N-1;
                while(l < r){
                    // i, j랑 안 겹치게 이동
                    while(true){
                        if(l == i || l == j){
                            l++;
                        }else if(r == i || r == j){
                            r--;
                        }else{
                            break;
                        }
                    }
                    if(l >= r) break;

                    int snowmanTwo = snow[l] + snow[r];
                    answer = Math.min(answer, Math.abs(snowmanOne - snowmanTwo));

                    if(snowmanOne > snowmanTwo){
                        l++;
                    }else if(snowmanOne < snowmanTwo){
                        r--;
                    }else{
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}

