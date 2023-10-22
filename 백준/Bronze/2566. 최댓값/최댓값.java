import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[][] str = new String[9][9];
        int max = 0;
        int x = 1;
        int y = 1;


        for(int i=0; i<9; i++){
            String[] temp = bf.readLine().split(" ");
            for(int j=0; j<9; j++){
                if(max < Integer.parseInt(temp[j])){
                    max = Integer.parseInt(temp[j]);
                    y = i+1;
                    x = j+1;
                }
                str[i][j] = temp[j];
            }
        }

        System.out.println(max);
        System.out.println(y + " " + x);
    }
}
