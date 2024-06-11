import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] sa = bf.readLine().split("-");
        int year = Integer.parseInt(sa[0]);
        int month = Integer.parseInt(sa[1]);
        int day = Integer.parseInt(sa[2]);

        int N = Integer.parseInt(bf.readLine());
        int result = 0;

        for(int i=0; i<N; i++){
            sa = bf.readLine().split("-");
            int expYear = Integer.parseInt(sa[0]);
            int expMonth = Integer.parseInt(sa[1]);
            int expDay = Integer.parseInt(sa[2]);

            if(expYear > year){
                result++;
                continue;
            }

            if(expYear == year && expMonth > month){
                result++;
                continue;
            }

            if(expYear == year && expMonth == month && expDay >= day){
                result++;
            }
        }

        System.out.println(result);
    }
}


