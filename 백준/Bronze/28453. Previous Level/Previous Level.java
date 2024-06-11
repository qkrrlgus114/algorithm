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
        StringJoiner sj = new StringJoiner(" ");

        String[] sa = bf.readLine().split(" ");
        for(int i=0; i<sa.length; i++){
            int level = Integer.parseInt(sa[i]);

            if(level == 300) sj.add("1");
            else if(level >= 275) sj.add("2");
            else if(level >= 250) sj.add("3");
            else sj.add("4");
        }

        System.out.println(sj);
    }
}


