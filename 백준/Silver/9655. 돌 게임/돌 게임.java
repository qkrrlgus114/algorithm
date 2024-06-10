import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        dfs(N, 0);
    }

    private static void dfs(int cur, int count){
        if(cur < 0) return;

        if(cur == 0){
            if(count % 2 == 1){
                System.out.println("SK");
            }else{
                System.out.println("CY");
            }
            System.exit(0);
        }

        // 재귀 조건
        dfs(cur - 1, count + 1);
        dfs(cur - 3, count + 1);
    }

}


