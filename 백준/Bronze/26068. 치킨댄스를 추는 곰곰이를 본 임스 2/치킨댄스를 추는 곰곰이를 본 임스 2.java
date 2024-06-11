import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());
        int result = 0;

        for(int i=0; i<N; i++){
            String s = bf.readLine();
            int day = Integer.parseInt(s.substring(2));

            if(day <= 90) result++;
        }

        System.out.println(result);
    }
}


