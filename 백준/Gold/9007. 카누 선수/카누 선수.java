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
        int T = Integer.parseInt(s);

        for(int q = 0; q<T; q++){
            String[] sa = bf.readLine().split(" ");
            int k = Integer.parseInt(sa[0]);
            int n = Integer.parseInt(sa[1]);

            int[][] classRoom = new int[4][n];
            for(int i=0; i<4; i++){
                sa = bf.readLine().split(" ");
                for(int j=0; j<n; j++){
                    classRoom[i][j] = Integer.parseInt(sa[j]);
                }
            }

            int[] fi = new int[n*n];
            int[] se = new int[n*n];
            int index = 0;

            // n^2
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    fi[index] = classRoom[0][i] + classRoom[1][j];
                    se[index++] = classRoom[2][i] + classRoom[3][j];
                }
            }

            Arrays.sort(fi);
            Arrays.sort(se);

            int l = 0;
            int r = se.length - 1;
            int answer = Integer.MAX_VALUE;
            int diff = Integer.MAX_VALUE;

            while(true){
                if(l == fi.length || r < 0) break;

                int sum = fi[l] + se[r];
                if(sum < k){
                    l++;
                }else if(sum > k){
                    r--;
                }else{
                    answer = sum;
                    break;
                }

                if(diff > Math.abs(k - sum)){
                    diff = Math.abs(k - sum);
                    answer = sum;
                }else if(diff == Math.abs(k - sum)){
                    if(answer > sum) answer = sum;
                }

            }

            System.out.println(answer);

        }

    }
}

