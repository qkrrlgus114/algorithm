import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        double coin = Double.parseDouble(bf.readLine());

        int N = Integer.parseInt(bf.readLine());

        String[] sa = bf.readLine().split(" ");
        int[] arr = new int[N];
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(sa[i]);
        }

        int maxProblems = 0;
        int coinCount = 0;
        int maxStreak = 0;
        int curStreak = 0;

        int l = 0;

        for(int r=0; r<N; r++){
            if(arr[r] == 0){
                if(coinCount < 2 && coin >= 0.99 * (coinCount + 1)){
                    coinCount++;
                }else{
                    if(coinCount >= 1){
                        while(true){
                            if(arr[l] == 0){
                                l++;
                                break;
                            }
                            l++;
                        }
                    }else{
                        l = r + 1;
                        continue;
                    }
                }
            }

            curStreak = r - l + 1;
            maxStreak = Math.max(maxStreak, curStreak);
            maxProblems = Math.max(maxProblems, arr[r]);
        }

        System.out.println(maxStreak);
        System.out.println(maxProblems);
    }
}


