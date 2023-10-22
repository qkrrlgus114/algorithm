import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[][] str = new String[5][15];

        for(int i=0; i<5; i++){
            String[] temp = bf.readLine().split("");
            for(int j=0; j<temp.length; j++){
                str[i][j] = temp[j];
            }
        }

        for(int i=0; i<15; i++){
            for(int j=0; j<5; j++){
                if(str[j][i] != null){
                    System.out.print(str[j][i]);
                }
            }
        }

    }
}