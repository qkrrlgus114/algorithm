import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int result = 0;
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            String s = bf.readLine();
            if(s.equals("ENTER")){
                set.clear();
            }else{
                if(!set.contains(s)){
                    result++;
                    set.add(s);
                }
            }
        }

        System.out.println(result);
    }
}

