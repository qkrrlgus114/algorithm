import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split(" ");
        int N = Integer.parseInt(sa[0]);
        int M = Integer.parseInt(sa[1]);

        sa = bf.readLine().split(" ");
        int[] skill1 = new int[N];
        for(int i=0; i<N; i++){
            skill1[i] = Integer.parseInt(sa[i]);
        }

        sa = bf.readLine().split(" ");
        int[] skill2 = new int[M];
        for(int i=0; i<M; i++){
            skill2[i] = Integer.parseInt(sa[i]);
        }

        Arrays.sort(skill1);
        Arrays.sort(skill2);

        // 적용 횟수
        int result1 = 0;
        int result2 = 0;

        // 스킬 딜레이
        int delay1 = -100;
        int delay2 = -360;

        // 몬스터 면역
        int register = 90;

        for(int i=0; i<skill1.length; i++){
            if(delay1 + 100 <= skill1[i] && delay1 + register <= skill1[i]){
                result1++;
                delay1 = skill1[i];
            }
        }

        for(int i=0; i<skill2.length; i++){
            if(delay2 + 360 <= skill2[i] && delay2 + register <= skill2[i]){
                result2++;
                delay2 = skill2[i];
            }
        }

        System.out.println(result1 + " " + result2);
    }
}


