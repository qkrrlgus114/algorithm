import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String s = bf.readLine();
        char[] ppap = s.toCharArray();
        char[] temp = new char[ppap.length];
        int index = 0;

        for(char c : ppap){
            temp[index++] = c;
            if(index >= 4 && temp[index-1] == 'P' && temp[index-2] == 'A' && temp[index-3] == 'P'
                    && temp[index-4] == 'P'){
                index -= 3;
            }
        }

        if(index == 1 && temp[0] == 'P') System.out.println("PPAP");
        else System.out.println("NP");
    }
}