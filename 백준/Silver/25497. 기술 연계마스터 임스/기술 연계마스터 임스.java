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

        char[] commands = bf.readLine().toCharArray();
        
        int LCount = 0;
        int SCount = 0;
        int result = 0;

        for(int i=0; i<N; i++){
            char command = commands[i];
            if(command >= '1' && command <= '9'){
                result++;
            }else{
                if(command == 'L'){
                    LCount++;
                }else if(command == 'S'){
                    SCount++;
                }else if(command == 'R'){
                    if(LCount == 0) break;
                    else{
                        LCount -= 1;
                        result++;
                    }
                }else if(command == 'K'){
                    if(SCount == 0) break;
                    else{
                        SCount -= 1;
                        result++;
                    }
                }
            }
        }

        System.out.println(result);

    }
}


