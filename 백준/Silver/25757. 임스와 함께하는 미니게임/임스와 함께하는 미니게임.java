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
        String game = sa[1];
        Set<String> set = new HashSet<>();

        int result = 0;
        int participant = 0;

        for(int i=0; i<N; i++){
            String s = bf.readLine();

            if(set.contains(s)) continue;
            else{
                set.add(s);
                participant++;
            }

            if(participant == 1 && game.equals("Y")){
                result++;
                participant = 0;
            }else if(participant == 2 && game.equals("F")){
                result++;
                participant = 0;
            }else if(participant == 3 && game.equals("O")){
                result++;
                participant = 0;
            }
        }

        System.out.println(result);
    }
}


