
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bf.readLine());

        int sumLevel = 0;
        int sumStatus = 0;

        List<Integer> levels = new ArrayList<>();

        for(int i=0; i<N; i++){
            int level = Integer.parseInt(bf.readLine());
            levels.add(level);
        }

        Collections.sort(levels, Collections.reverseOrder());

        for(int i=0; i<levels.size(); i++){
            if(i == 42) break;
            int level = levels.get(i);
            sumLevel += level;

            if(level >= 250) sumStatus += 5;
            else if(level >= 200) sumStatus += 4;
            else if(level >= 140) sumStatus += 3;
            else if(level >= 100) sumStatus += 2;
            else if(level >= 60) sumStatus += 1;
        }

        System.out.println(sumLevel + " " + sumStatus);
    }
}